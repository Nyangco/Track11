package command.product;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.ProductDao;

public class Product_DBdelete implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		ProductDao dao = new ProductDao();
		String p_no = request.getParameter("t_p_no");
		int k = dao.deleteDB(p_no);
		String msg = "삭제에 실패하였습니다"; String url = "Product"; String nextPage="list";
		if(k==1) msg = "삭제에 성공하였습니다";
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
		request.setAttribute("t_nextPage", nextPage);
	}

}
