package command.admin;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.AdminDao;
import dto.CustomerDto;

public class Purchase_view implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		AdminDao dao = new AdminDao();
		String purchase_number = request.getParameter("t_purchase_number");
		CustomerDto dto = dao.getPurchase_view(purchase_number);
		request.setAttribute("t_dto", dto);
		request.setAttribute("t_p_name", request.getParameter("t_p_name"));
		request.setAttribute("t_attach", request.getParameter("t_attach"));
	}

}
