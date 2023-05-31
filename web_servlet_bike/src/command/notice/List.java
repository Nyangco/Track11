package command.notice;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import common.CommonUtil;
import dao.NoticeDao;
import dto.NoticeDto;

public class List implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		NoticeDao dao = new NoticeDao();
		String select = request.getParameter("t_select");
		String search = request.getParameter("t_search");
		if(select == null) {
			select = "title";
			search = "";
		}
		request.setAttribute("t_select", select);
		request.setAttribute("t_search", search);
		
		
		int total_count = dao.totalCountDB(select,search);
		request.setAttribute("t_totalCount", total_count);
		int list_setup_count = 5;  //한페이지당 출력 행수 
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
		
		ArrayList<NoticeDto> arr = dao.listDB(select,search,start,end);
		request.setAttribute("t_arr", arr);
		
		int k = total_count - (current_page -1) * list_setup_count;
		request.setAttribute("t_order", k);
		
	}

}
