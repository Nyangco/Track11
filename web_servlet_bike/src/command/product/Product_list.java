package command.product;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import common.CommonUtil;
import dao.ProductDao;
import dto.ProductDto;

public class Product_list implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		ProductDao dao = new ProductDao();
		
		ArrayList<String[]> tagArr = dao.selectTagDB();
		request.setAttribute("t_tagArr", tagArr);
		
		request.setAttribute("t_dir", CommonUtil.getFile_dir("product"));
		
		String select = request.getParameter("t_select");
		String search = request.getParameter("t_search");
		String sSort = request.getParameter("t_sort");
		String tag = request.getParameter("t_tag");
		if(select == null) {
			select="p_no"; search="";sSort="5";
		}
		int sort = Integer.parseInt(sSort);
		request.setAttribute("t_select", select);
		request.setAttribute("t_search", search);
		request.setAttribute("t_sort", sort);
		request.setAttribute("t_tag", tag);
		
		int total_count = dao.totalCountDB(select,search,tag);
		request.setAttribute("t_totalCount", total_count);
		int list_setup_count = sort;  //한페이지당 출력 행수 
		int pageNumber_count = 3;  //한페이지당 출력 페이지 갯수
		
		String nowPage = request.getParameter("t_nowPage");
		int current_page = 0; // 현재페이지 번호
		int total_page = 0;    // 전체 페이지 수
		
		if(nowPage == null || nowPage.equals("")) current_page = 1; 
		else current_page = Integer.parseInt(nowPage);
		
		total_page = total_count / list_setup_count;  // 몫 : 2
		int rest = 	total_count % list_setup_count;   // 나머지:1
		if(rest !=0) total_page = total_page + 1;     // 3
		
		int start = (current_page -1) * list_setup_count + 1;
		int end   = current_page * list_setup_count;
		int k = total_count - (current_page -1) * list_setup_count;
		request.setAttribute("t_order", k);		
		
		String paging = CommonUtil.pageListPost(current_page, total_page, pageNumber_count);
		request.setAttribute("t_paging", paging);
		
		ArrayList<ProductDto> arr = dao.listDB(select,search,tag,start,end);
		request.setAttribute("t_arr", arr);
	}

}
