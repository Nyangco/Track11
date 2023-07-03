package command.customer;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.CustomerDao;

public class DBrefund implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		CustomerDao dao = new CustomerDao();
		String purchase_number = request.getParameter("t_purchase_number");
		String refund_change = request.getParameter("t_refund_change");
		String why = request.getParameter("t_why");
		String change = request.getParameter("t_change");
		int k = dao.refundDB(purchase_number,refund_change,why,change);
		String msg = "교환 / 반품에 실패했습니다."; String url = "Customer" ; String nextPage = "receipt_list";
		if(k==1) msg = "교환 / 반품에 성공했습니다.";
	}

}
