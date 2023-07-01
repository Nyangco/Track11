package command.customer;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.CustomerDao;
import dto.CustomerDto;

public class Receipt_view implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		CustomerDao dao = new CustomerDao();
		String purchase_number = request.getParameter("t_purchase_number");
		CustomerDto dto = dao.viewDB(purchase_number);
		request.setAttribute("t_dto", dto);
	}

}
