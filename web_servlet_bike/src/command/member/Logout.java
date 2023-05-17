package command.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExcute;

public class Logout implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.invalidate();
		request.setAttribute("t_msg", "로그아웃 되셨습니다.");
		request.setAttribute("t_url", "Index");
	}

}
