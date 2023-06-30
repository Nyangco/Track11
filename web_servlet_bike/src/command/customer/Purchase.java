package command.customer;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import common.CommonUtil;
import dao.CustomerDao;
import dto.CustomerDto;

public class Purchase implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		CustomerDao dao = new CustomerDao();
		String id = request.getParameter("t_id");
		String name = request.getParameter("t_name");
		String mobile_1 = request.getParameter("t_mobile_1");
		String mobile_2 = request.getParameter("t_mobile_2");
		String mobile_3 = request.getParameter("t_mobile_3");
		String email = request.getParameter("t_email");
		String shipping_method = request.getParameter("t_shipping_method");
		String address = request.getParameter("t_address");
		String comment = request.getParameter("t_comment");
		String buy_method = request.getParameter("t_buy_method");
		String credit_1 = request.getParameter("t_credit_1");
		String credit_2 = request.getParameter("t_credit_2");
		String credit_3 = request.getParameter("t_credit_3");
		String credit_4 = request.getParameter("t_credit_4");
		String cvc = request.getParameter("t_cvc");
		String transfer_name = request.getParameter("t_transfer_name");
		String p_no = request.getParameter("t_p_no");
		String price = request.getParameter("t_total_fee");
		String today = CommonUtil.getToday();
		today = today.substring(2).replaceAll("-", "").trim();
		String purchase_number = dao.getMaxNo(today);
		String purchase_date = CommonUtil.getTodayTime();
		String status = null;
		if(buy_method.equals("cash")) status="1";
		else status="2";
		
		CustomerDto dto = new CustomerDto(id, name, mobile_1, mobile_2, mobile_3, email, shipping_method, address, comment, buy_method, credit_1, credit_2, credit_3, credit_4, cvc, transfer_name, purchase_number, p_no, status, price, purchase_date);
		int k = dao.insertDB(dto);
		String msg = "상품 구매에 실패하였습니다."; String url = "Customer"; String nextPage="list";
		if(k==1) {
			msg = "상품 구매에 성공하였습니다.";
		}
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
		request.setAttribute("t_nextPage", nextPage);
		
		
	}

}
