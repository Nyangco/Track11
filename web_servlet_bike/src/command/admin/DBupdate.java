package command.admin;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.AdminDao;

public class DBupdate implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		AdminDao dao = new AdminDao();
		String id = request.getParameter("t_id");
		String sLevel = request.getParameter("t_sLevel");
		int k = dao.updateDB(id,sLevel);
		String msg = "권한 변경에 실패하였습니다.";
		String url = "Admin";
		String nextPage = "list";
		if(k==1) msg = "권한 변경에 성공하였습니다.";
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
		request.setAttribute("t_nextPage", nextPage);
		
	}

}
