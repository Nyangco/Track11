package common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CommonUtil {
	
	public static boolean checkSession(HttpServletRequest request) {
		boolean tf = false;
		HttpSession session = request.getSession();
		String sLevel = (String)session.getAttribute("sLevel");
		if(sLevel==null) {
			request.setAttribute("t_msg", "로그인 정보가 만료되었습니다.");
			request.setAttribute("t_url", "Member");
			request.setAttribute("t_nextPage", "login");
		}else tf = true;
		return tf;
	}
	
	//새로운 비밀번호 생성
	public static String getNewPassword(int pwLength) {
        StringBuffer temp =new StringBuffer();
        Random rnd = new Random();
        
        for(int i=0;i<pwLength;i++)
        {
            int rIndex = rnd.nextInt(3);
            switch (rIndex) {
            case 0:
                // a-z
                temp.append((char) ((int) (rnd.nextInt(26)) + 97));
                break;
            case 1:
                // A-Z
                temp.append((char) ((int) (rnd.nextInt(26)) + 65));
                break;
            case 2:
                // 0-9
                temp.append((rnd.nextInt(10)));
                break;
            }
//            System.out.println("pw :"+temp.toString());	
        }
        return temp.toString();		
	}
	
	//파일 경로 잡는 method
	public static String getFile_dir(String path) {
		String result = "C:/track11_ysm/work_project/Track11/web_servlet_bike/WebContent/attach/"+path+"/";
		//String result = "C:/Track11_ysm/work_project/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/web_servlet_bike/attach/"+path+"/";
		return result;
	}
	
	//오늘 날짜 요일까지
    public static String getToday(){
        Date time = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String today = format1.format(time);
        return today;
     }
    //오늘 날짜 시분초 
    public static String getTodayTime(){
       Date time = new Date();
       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       String today = format.format(time);
       return today;
    }
    
    //페이지 설정
 	public static String pageListPost(int current_page,int total_page, int pageNumber_count){
 		int pagenumber;    //화면에 보여질 페이지 인덱스수
 		int startpage;     //화면에 보여질 시작 페이지 번호
 		int endpage;       //화면에 보여질 마지막 페이지 번호
 		int curpage;       //이동하고자 하는 페이지 번호
 		
 		String strList=""; //리턴될 페이지 인덱스 리스트

 		pagenumber = pageNumber_count;   //한 화면의 페이지 인덱스수
 		
 		//시작 페이지 번호 구하기
 		startpage = ((current_page - 1/*컴퓨팅 수학은 0부터 시작하니까 기본값인 1에서 계산하기 위한 0으로*/)/ pagenumber) * pagenumber/*몫을 취해서 페이지당 갯수를 곱함*/ + 1/*보기 편하게 1부터 시작*/;
 		//마지막 페이지 번호 구하기
 		endpage = (((startpage -1) + pagenumber) / pagenumber)*pagenumber;
 		//총페이지수가 계산된 마지막 페이지 번호보다 작을 경우
 		//총페이지수가 마지막 페이지 번호가 됨
 		
 		if(total_page <= endpage)  endpage = total_page;
 					
 		//첫번째 페이지 인덱스 화면이 아닌경우
 		if(current_page > pagenumber){
 			curpage = startpage -1;  //시작페이지 번호보다 1적은 페이지로 이동
 			strList = strList +"<a href=javascript:goPage('"+curpage+"') ><i class='fa fa-angle-double-left'></i></a>";
 		}
 						
 		//시작페이지 번호부터 마지막 페이지 번호까지 화면에 표시
 		curpage = startpage;
 		while(curpage <= endpage){
 			if(curpage == current_page){
 				strList = strList +"<a class='active'>"+current_page+"</a>";
 			} else {
 				strList = strList +"<a href=javascript:goPage('"+curpage+"')>"+curpage+"</a>";
 			}
 			curpage++;
 		}
 		//뒤에 페이지가 더 있는 경우
 		if(total_page > endpage){
 			curpage = endpage+1;
 			strList = strList + "<a href=javascript:goPage('"+curpage+"') ><i class='fa fa-angle-double-right'></i></a>";
 		}
 		return strList;
 	}
 	
 	public static String encryptSHA256(String value) throws NoSuchAlgorithmException{
        String encryptData ="";
         
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        sha.update(value.getBytes());
 
        byte[] digest = sha.digest();
        for (int i=0; i<digest.length; i++) {
            encryptData += Integer.toHexString(digest[i] &0xFF).toUpperCase();
        }
         
        return encryptData;
    }
}


