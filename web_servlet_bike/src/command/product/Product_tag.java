package command.product;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.ProductDao;

public class Product_tag implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		ProductDao dao = new ProductDao();
		ArrayList<String[]> arr = dao.selectTagDB();
		request.setAttribute("t_arr", arr);
	}

}
