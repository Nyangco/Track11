package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Filedown
 */
@WebServlet("/Filedown")
public class Filedown extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Filedown() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		//전송오는 parameter 값을 utf-8로 디코딩
		PrintWriter out = response.getWriter();
		//화면상에 javascript 등을 출력하기 위한 printwriter method를 호출
		String savePath = request.getParameter("t_fileDir"); // 첨부파일경로
	 	String fileName = request.getParameter("t_fileName");  // 다운로드 받을 첨부파일명

		//if(savePath.equals("notice")) savePath = CommonUtil.getFile_dir_notice("notice"); 
		savePath = CommonUtil.getFile_dir(savePath);
		//상대경로인 첨부파일 경로를 절대경로로 변경
	 	
	    String orgfilename = fileName ; //첨부 파일명을 String type의 다른 변수에 대입
	 
	    InputStream in = null;
	    //데이터 통신에서 데이터를 받는 InputStream에 관한 method가 있는 추상 class, InputStream을 in이라는 변수명으로 선언
	    //본래는 new 자식class(매개변수) 와 같이 와서, 해당 매개변수를 읽어온다.
	    //inputstream의 대표적인 method로는 read()가 있다 ==> 매개변수의 값을 읽는다. byte[] buffer 를 선언하고 buffer값만큼 읽으라 하면 해당 갯수만큼 한번에 읽는다
	    //skip()은 매개변수의 int 수 만큼 값을 생략한다 ==> skip(3) 후 read() 하면 4번째 값을 읽는다
	    //available()은 데이터가 얼마나 남았는지 알려준다.
	    //close()는 Stream을 종료시킬 수 있다.
	    
	    OutputStream os = null; 
	    //데이터 통신에서 데이터를 내보내는 OutputStream에 관한 method가 있는 추상 class, OutputStream을 os라는 변수명으로 선언
	    //본래는 new 자식class("내보낼 파일의 절대경로") 와 같이 온다.
	    //os.write(매개변수) 와 같이 작성하여 해당 파일을 내보낼 수 있다. ==> write(매개변수, 시작점, 길이) 와 같이 입력하여 해당 갯수만큼 write 할 수도 있다.
	    
	    
	    File file = null;
	    //File class를 file이라는 이름으로 선언한다.
	    boolean skip = false;
	    //skip 이라는 boolean형 변수를 false로 선언한다.
	    String client = "";
	    //client 라는 String 변수를 선언한다.
	    
	  
	    try{
	    //모든 예외(Exception)에 대하여 try-catch문을 실행한다.
	        try{
	        //FIleNotFoundException에 대하여 try-catch문을 시행한다.
	            file = new File(savePath, fileName);
	            //지역변수 file을 File class로 생성하고, 매개변수로 해당 파일의 경로를 입력한다.
	            in = new FileInputStream(file);
	            //InputStream in 변수에 FileInputStream 이라는 자식클래스를 생성하고, 매개변수로서 위에서 선언한 해당 파일의 경로가 포함된 File 객체를 준다.
	        }catch(FileNotFoundException fe){
	        //FileNotFoundException의 경우에 시행한다.
	            skip = true;
	            //boolean 타입의 skip 이라는 변수를 true로 바꾼다.
	        }
	         
	        client = request.getHeader("User-Agent");
	        
	        response.reset() ;
	        response.setContentType("application/octet-stream");
	        response.setHeader("Content-Description", "JSP Generated Data");
	 
	        if(!skip){
	 
	            // IE
	            if(client.indexOf("MSIE") != -1){
	                response.setHeader ("Content-Disposition", "attachment; filename="+orgfilename);
	 
	            }else{
	                // 한글 파일명 처리
	                orgfilename = new String(orgfilename.getBytes("utf-8"),"iso-8859-1");

	                response.setHeader("Content-Disposition", "attachment; filename=\"" + orgfilename + "\"");
	                response.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
	            } 
	             
	            response.setHeader ("Content-Length", ""+file.length() );
	            os = response.getOutputStream();
	            byte b[] = new byte[(int)file.length()];
	            int leng = 0;
	             
	            while( (leng = in.read(b)) > 0 ){
	                os.write(b,0,leng);
	            }
	 
	        }else{
	            response.setContentType("text/html;charset=UTF-8");
	            out.println("<script language='javascript'>alert('파일을 찾을 수 없습니다');history.back();</script>");
	        }
	        in.close();
	        os.close();
	 
	    }catch(Exception e){
	    	System.out.println("첨부 파일 다운 오류~ 파일명:"+fileName);
	    } 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
