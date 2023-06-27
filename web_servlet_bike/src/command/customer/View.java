package command.customer;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.ProductDao;
import dto.ProductDto;

public class View implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		ProductDao dao = new ProductDao();
		String p_no = request.getParameter("t_p_no");
		dao.getHit(p_no);
		ProductDto dto = dao.viewDB(p_no);
		request.setAttribute("t_dto", dto);
		ProductDto preDto = dao.anotherViewDB(p_no,"pre");
		request.setAttribute("t_preDto", preDto);
		ProductDto proDto = dao.anotherViewDB(p_no,"pro");
		request.setAttribute("t_proDto", proDto);
	}

}
