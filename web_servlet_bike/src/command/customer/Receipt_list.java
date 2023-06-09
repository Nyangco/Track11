package command.customer;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExcute;
import common.CommonUtil;
import dao.CustomerDao;
import dto.CustomerDto;

public class Receipt_list implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		CustomerDao dao = new CustomerDao();
		HttpSession session = request.getSession();
		String select = request.getParameter("t_select");
		String search = request.getParameter("t_search");
		String sSort = request.getParameter("t_sort");
		if(select == null || select.equals("")) {
			select = "purchase_number";
			search = "";
		}if(sSort==null || sSort.equals(""))sSort = "5";
		int sort = Integer.parseInt(sSort);
		search = search.trim();
		String sId = (String)session.getAttribute("sId");
		request.setAttribute("t_select", select);
		request.setAttribute("t_search", search);
		request.setAttribute("t_sort", sort);
		
		if(select.equals("p_no")) {
			String p_no = dao.getP_no(search);
			if(p_no.equals("error")){
				request.setAttribute("t_search", "더 정확하게 입력해주세요.");
				search="";
			}else {
				search=p_no;
			}
		}

		
		
		int total_count = dao.totalCountDB(select,search,sId);
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
		
		String paging = CommonUtil.pageListPost(current_page, total_page, pageNumber_count);
		request.setAttribute("t_paging", paging);
		
		select="s."+select;
		ArrayList<CustomerDto> arr = dao.listDB(select,search,start,end,sId);
		request.setAttribute("t_arr", arr);
	}

}
