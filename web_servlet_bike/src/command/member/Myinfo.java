package command.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExcute;
import dao.MemberDao;
import dto.MemberDto;

public class Myinfo implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		MemberDao dao = new MemberDao();
		String id = (String)session.getAttribute("sId");
		if(id == null) {
			request.setAttribute("t_msg", "로그인 정보가 만료되었습니다.");
			request.setAttribute("t_url", "Member");
			request.setAttribute("t_nextPage", "login");
		}else {
			MemberDto dto = dao.myinfoDB(id);
			request.setAttribute("t_dto", dto);
		}
	}

}
