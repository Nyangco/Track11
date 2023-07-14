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

import dao.FreeboardDao;

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
	 	String fromPage = request.getParameter("t_Page");
	 	String no = request.getParameter("t_no");
	 	
	 	if(fromPage!=null && fromPage.equals("freeboard")) {
        	FreeboardDao dao = new FreeboardDao();
        	dao.getDownloadHit(no);
        }

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
	        //client 변수에 Header값중 User-Agent(어떤 브라우저로 보고있는가)를 저장
	        
	        response.reset() ;
	        //response 객체를 초기화
	        response.setContentType("application/octet-stream");
	        //response 객체의 형식을 application/octet-stream으로 설정
	        //이를 Content-type의 MIME형식 이라고도 하는데, IIS를 기준으로
	        //.mov ==> video/quicktime   .one ==> application/onenote
	        //.ppt ==> application/vnd.ms-pwerpoint   .txt ==> text/plain
	        //.tif ==> image/tiff   .ini ==> application/octet-stream
	        //등으로, 서버에서 다루는 확장자명이 어떤 형식의 자료인지 알려주는 것
	        //ini는 8비트로 된 데이터로서, 다룰 특별한 프로그램이 필요치 않음을 알려주기도 한다.
	        response.setHeader("Content-Description", "JSP Generated Data");
	        //Header정보에 JSP로부터 생성된 Data임을 알려주는 설명을 첨부한다.
	 
	        if(!skip){
	        //File이 있고, InputStream이 제대로 생성되었으면 실행한다
	 
	            // IE
	            if(client.indexOf("MSIE") != -1){
	            //만약 헤더의 User-Agent값이 MSIE이면 실행한다 ( MSIE의 위치가 -1이 아니다 ==> 어딘가에 존재한다 )
	                response.setHeader ("Content-Disposition", "attachment; filename="+orgfilename);
	                //response 객체의 Header 정보에 Content-Disposition 정보를 첨부한다
	                //Content-Disposition은 크게 inline과 attachment가 있는데, inline은 해당 브라우저에서 인식할 수 있는
	                //확장자의 경우 파일을 자동으로 보여주게끔 하는 기능 ( jpg 파일 다운로드를 클릭하면 페이지에 해당 파일을 뿌려주는 기능 )이 있고
	                //attachment는 상관없이 바로 다운로드 창으로 보내버린다.
	 
	            }else{
	                // 한글 파일명 처리
	                orgfilename = new String(orgfilename.getBytes("utf-8"),"iso-8859-1");
	                //String class의 생성자 중 인코딩 방식을 변경하는 방법이 있는데, String(Byte[],String)이 바로 그것이다.
	                //앞의 Byte[]에는 Byte의 배열이 들어가는데, 이는 String의 근간을 이루는 char을 byte로 변환해야할 필요성이
	                //있음을 암시한다. 이를 위한 명령어가 String class의 getBytes 이다. 이 method는 특정 String의
	                //값을 Byte 배열로 변환해주는 method이다. 뒤의 String값은 변경하고자 하는 charset 이름이다.

	                response.setHeader("Content-Disposition", "attachment; filename=\"" + orgfilename + "\"");
	                response.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
	            } 
	             
	            response.setHeader ("Content-Length", ""+file.length() );
	            //response 객체의 헤더에 Content-Length, 즉 데이터셋의 길이를 첨부한다.
	            os = response.getOutputStream();
	            //OutputStream으로 생성된 os에 response 객체의 getOutputStream method를 통해 FileOutputStream을 연동시킨다.
	            byte b[] = new byte[(int)file.length()];
	            //file의 내용물의 길이를 int로 형변환하여 byte 타입의 배열에 저장한다.
	            
	            
	            int leng = 0;
	            //길이를 표시할 leng이라는 int 변수를 선언한다
	             
	            while( (leng = in.read(b)) > 0 ){
	            //leng에 InputStream의 read method를 통해 b를 읽은 값을 대입하고, 해당 값이 0보다 클때 반복한다.
	                os.write(b,0,leng);
	                //b를 0부터 길이까지 파일로서 내보낸다.
	            }
	 
	        }else{
	        //파일이 없으면 실행한다
	            response.setContentType("text/html;charset=UTF-8");
	            //response의 ContentTpye을 txt파일로, charset을 utf-8로 지정한다.
	            out.println("<script language='javascript'>alert('파일을 찾을 수 없습니다');history.back();</script>");
	            //본문에 alert를 띄우기 위한 스크립트를 출력하고, 뒷 페이지로 이동시킨다.
	        }
	        in.close();
	        //InputStream을 닫는다
	        os.close();
	        //OutputStream을 닫는다
	    }catch(Exception e){
	    //모든 경우의 예외에 대하여 동작하낟
	    	System.out.println("첨부 파일 다운 오류~ 파일명:"+fileName);
	    	//다음과 같이 출력한다.
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
