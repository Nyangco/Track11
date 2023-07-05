package command.customer;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.CustomerDao;

public class Cancel implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		CustomerDao dao = new CustomerDao();
		String purchase_number = request.getParameter("t_purchase_number");
		int k = dao.cancelDB(purchase_number);
		String msg="주문 취소에 실패하였습니다"; String url="Customer"; String nextPage="receipt_list";
		if(k==1) msg = "주문이 취소되었습니다.";
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
		request.setAttribute("t_nextPage", nextPage);
	}

}
