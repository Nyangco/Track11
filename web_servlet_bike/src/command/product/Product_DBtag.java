package command.product;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.ProductDao;

public class Product_DBtag implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		ProductDao dao = new ProductDao();
		String tag_name = request.getParameter("t_tag_name");
		String tag_code = request.getParameter("t_tag_code");

		String msg="tag 수정에 실패하였습니다."; String url="Product"; String nextPage="list";
		
		int k = 0;
		if(tag_name.equals("0")) {
			k = dao.deleteTagDB(tag_code);
			if(k==1) msg="tag 삭제에 성공하였습니다.";
		}else if(tag_code.equals("new")) {
			tag_code = dao.getMaxTag();
			k = dao.insertTagDB(tag_name,tag_code);
			if(k==1) msg="tag 입력에 성공하였습니다.";
		}else {
			k = dao.updateTagDB(tag_name,tag_code);
			if(k==1) msg="tag 수정에 성공하였습니다.";
		}
		
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
		request.setAttribute("t_nextPage", nextPage);
	}

}
