package command.product;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExcute;
import common.CommonUtil;
import dao.ProductDao;
import dto.ProductDto;

public class Product_DBsave implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		ProductDao dao = new ProductDao();
		
		try {
			MultipartRequest mpr = new MultipartRequest(request, CommonUtil.getFile_dir("product"), 1024*1024*10, "utf-8", new DefaultFileRenamePolicy());
			String p_no = dao.getMaxNo();
			String p_name = mpr.getParameter("t_p_name");
			String p_content = mpr.getParameter("t_p_content");
			String p_tag = mpr.getParameter("t_p_tag");
			String attach = mpr.getFilesystemName("t_attach");
			String p_size_w = mpr.getParameter("t_p_size_w");
			String p_size_l = mpr.getParameter("t_p_size_l");
			String p_size_h = mpr.getParameter("t_p_size_h");
			String p_weight = mpr.getParameter("t_p_weight");
			String price = mpr.getParameter("t_price");
			String p_level = mpr.getParameter("t_p_level");
			String c_name = mpr.getParameter("t_c_name");
			String reg_date = mpr.getParameter("t_reg_date");
			String reg_id = mpr.getParameter("t_reg_id");
			ProductDto dto = new ProductDto(p_no, p_name, p_content, p_tag, attach, p_size_w, p_size_l, p_size_h, p_weight, price, p_level, c_name, 0, reg_date, reg_id, "", "");
			int k = dao.insertDB(dto);
			String msg = "상품 등록에 실패하였습니다."; String url="Product"; String nextPage="list";
			if(k==1) msg = "상품 등록에 성공하였습니다.";
			request.setAttribute("t_msg", msg);
			request.setAttribute("t_url", url);
			request.setAttribute("t_nextPage", nextPage);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
