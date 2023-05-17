package command.member;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import common.CommonUtil;
import dao.MemberDao;
import dto.MemberDto;

public class DBsave implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		MemberDao dao = new MemberDao();
		String msg = "회원가입에 성공하였습니다. 가입일 : "; String url = "Index"; String nextPage="list";
		
		String id = request.getParameter("t_id");
		if(dao.idCheckDB(id)==0){
			String name = request.getParameter("t_name");
			String password = request.getParameter("t_password");
			int password_len = password.length(); 
			try {
				password = CommonUtil.encryptSHA256(password);
			}catch(NoSuchAlgorithmException e) {
				System.out.println("Join 에러");
				e.printStackTrace();
			}
			String area = request.getParameter("t_area");
			String address = request.getParameter("t_address");
			String mobile_1 = request.getParameter("t_mobile_1");
			String mobile_2 = request.getParameter("t_mobile_2");
			String mobile_3 = request.getParameter("t_mobile_3");
			String gender = request.getParameter("t_gender");
			String hobby_travel_c = request.getParameter("t_hobby_travel_c");
			String hobby_reading_c = request.getParameter("t_hobby_reading_c");
			String hobby_sports_c = request.getParameter("t_hobby_sports_c");
			String reg_date = CommonUtil.getToday();
			msg+=reg_date;
			MemberDto dto = new MemberDto(id,"",name,password,area,address,mobile_1,mobile_2,mobile_3,gender,hobby_travel_c,hobby_reading_c,hobby_sports_c,reg_date,"","","",password_len);
			int k = dao.saveDB(dto);
			
			if(k!=1) {
				msg = "회원가입에 실패했습니다. 다시 작성해주세요.";
				url = "Member";
				nextPage="join";
			}
		}else {
			msg="중복된 id입니다. 다른 id를 사용해주세요.";
			url="Member";
			nextPage="join";
		}
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
		request.setAttribute("t_nextPage", nextPage);
		
		
	}

}
