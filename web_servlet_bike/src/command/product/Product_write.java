package command.product;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import common.CommonUtil;
import dao.ProductDao;

public class Product_write implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		ProductDao dao = new ProductDao();
		request.setAttribute("t_today", CommonUtil.getToday());
		ArrayList<String[]> tagArr = dao.selectTagDB();
		request.setAttribute("t_tagArr", tagArr);
	}

}
