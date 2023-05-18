package command.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExcute;
import dao.MemberDao;

public class DBdelete implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		MemberDao dao = new MemberDao();
		HttpSession ses = request.getSession();
		String id = request.getParameter("t_id");
		int k = dao.deleteDB(id);
		String msg="탈퇴에 실패했습니다."; String url="Member"; String nextPage="myinfo";
		if(k==1) {
			msg="탈퇴되었습니다.";
			url="Index";
			nextPage="";
			ses.invalidate();
		}
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
		request.setAttribute("t_nextPage", nextPage);
	}

}
