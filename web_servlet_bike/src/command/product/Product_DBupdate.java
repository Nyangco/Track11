package command.product;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExcute;
import common.CommonUtil;
import dao.ProductDao;
import dto.ProductDto;

public class Product_DBupdate implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		ProductDao dao = new ProductDao();
		
		try {
			MultipartRequest mpr = new MultipartRequest(request, CommonUtil.getFile_dir("product"), 1024*1024*10, "utf-8", new DefaultFileRenamePolicy());
			String p_no = mpr.getParameter("t_p_no");
			String p_name = mpr.getParameter("t_p_name");
			String p_content = mpr.getParameter("t_p_content");
			String p_tag = mpr.getParameter("t_p_tag");
			String old_attach = mpr.getParameter("t_old_attach");
			String attach = mpr.getFilesystemName("t_attach");
			if(attach!=null) {
				File f = new File(CommonUtil.getFile_dir("product"),old_attach);
				boolean tf = f.delete();
				if(!tf) System.out.println("파일 삭제 실패");
			};
			if(attach==null) attach=old_attach;
			String p_size_w = mpr.getParameter("t_p_size_w");
			String p_size_l = mpr.getParameter("t_p_size_l");
			String p_size_h = mpr.getParameter("t_p_size_h");
			String p_weight = mpr.getParameter("t_p_weight");
			String price = mpr.getParameter("t_price");
			String discount = mpr.getParameter("t_discount");
			String p_level = mpr.getParameter("t_p_level");
			String c_name = mpr.getParameter("t_c_name");
			String update_date = CommonUtil.getTodayTime();
			String update_id = mpr.getParameter("t_update_id");
			ProductDto dto = new ProductDto(p_no, p_name, p_content, p_tag, attach, p_size_w, p_size_l, p_size_h, p_weight, price, p_level, c_name, 0, discount, "", update_id, update_date);
			int k = dao.updateDB(dto);
			String msg = "상품 수정에 실패하였습니다."; String url="Product"; String nextPage="list";
			if(k==1) msg = "상품 수정에 성공하였습니다.";
			request.setAttribute("t_msg", msg);
			request.setAttribute("t_url", url);
			request.setAttribute("t_nextPage", nextPage);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
