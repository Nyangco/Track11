package command.product;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import common.CommonUtil;
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
		request.setAttribute("t_discount", dao.getDiscount(p_no));
		ArrayList<String[]> tagArr = dao.selectTagDB();
		request.setAttribute("t_tagArr", tagArr);
		request.setAttribute("t_today", CommonUtil.getToday());
	}

}
