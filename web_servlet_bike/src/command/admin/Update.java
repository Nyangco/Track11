package command.admin;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;

public class Update implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String id = request.getParameter("t_id");
		request.setAttribute("t_id", id);
		String sLevel = request.getParameter("t_sLevel");
		request.setAttribute("t_sLevel", sLevel);
	}

}
