package command.customer;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.CustomerDao;

public class Confirm implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		CustomerDao dao = new CustomerDao();
		String purchase_number = request.getParameter("t_purchase_number");
		int k = dao.confirmDB(purchase_number);
		String msg="주문 확정에 실패하였습니다"; String url="Customer"; String nextPage="receipt_list";
		if(k==1) msg = "주문이 확정되었습니다.";
	}

}
