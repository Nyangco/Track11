package command.admin;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.AdminDao;

public class Change_product implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		AdminDao dao = new AdminDao();
		String purchase_number = request.getParameter("t_purchase_number");
		request.setAttribute("t_purchase_number", purchase_number);
		ArrayList<String> str = dao.purchase_change(purchase_number);
		request.setAttribute("t_product_number", str.get(0));
		request.setAttribute("t_product_name", str.get(1));
		request.setAttribute("t_refund", str.get(2));
		
		
	}

}
