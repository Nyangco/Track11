package command.product;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.ProductDao;
import dto.ProductDto;

public class Product_update implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		ProductDao dao = new ProductDao();
		String p_no = request.getParameter("t_p_no");
		ProductDto dto = dao.viewDB(p_no);
		request.setAttribute("t_dto", dto);
	}

}
