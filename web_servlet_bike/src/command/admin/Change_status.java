package command.admin;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.AdminDao;

public class Change_status implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		AdminDao dao = new AdminDao();
		String purchase_number = request.getParameter("t_purchase_number");
		String change_status = request.getParameter("t_status_"+purchase_number);
		int k = dao.updateStatusDB(purchase_number,change_status);
		String msg = "상태 변경에 실패하였습니다."; String url="Admin"; String nextPage="purchase_list";
		if(k==1) msg = "상태 변경에 성공하였습니다.";
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
		request.setAttribute("t_nextPage", nextPage);
	}

}
