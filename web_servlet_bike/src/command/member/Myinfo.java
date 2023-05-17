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
		MemberDto dto = dao.myinfoDB(id);
		request.setAttribute("t_dto", dto);
	}

}
