package command.member;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.MemberDao;
import dto.MemberDto;

public class DBupdate implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		MemberDao dao = new MemberDao();
		String id = request.getParameter("t_id");
		String name = request.getParameter("t_name");
		String email = request.getParameter("t_email");
		String area = request.getParameter("t_area");
		String address = request.getParameter("t_address");
		String mobile_1 = request.getParameter("t_mobile_1");
		String mobile_2 = request.getParameter("t_mobile_2");
		String mobile_3 = request.getParameter("t_mobile_3");
		String gender = request.getParameter("t_gender");
		String hobby_travel = request.getParameter("t_hobby_travel_c");
		String hobby_reading = request.getParameter("t_hobby_reading_c");
		String hobby_sports = request.getParameter("t_hobby_sports_c");
		MemberDto dto = new MemberDto(id,"",name,"",area,address,mobile_1,mobile_2,mobile_3,gender,hobby_travel,hobby_reading,hobby_sports,"","","","",0);
		int k = dao.updateDB(dto,email);
		String msg = "수정에 실패하였습니다."; String url="Member"; String nextPage="update";
		if(k==1) {
			msg="수정에 성공하였습니다.";
			nextPage="myinfo";
		}
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
		request.setAttribute("t_nextPage", nextPage);
	}

}
