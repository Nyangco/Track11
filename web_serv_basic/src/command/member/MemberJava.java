package command.member;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import dao.MemberDao;
import dto.MemberDto;

public class MemberJava {
	
	MemberDao dao = new MemberDao();
	
	public void DBdelete(HttpServletRequest request) {
		String id = request.getParameter("t_id");
		int k = dao.deleteDB(id);
		request.setAttribute("t_url", "Member");
		String requestPage = "list";
		String msg = "삭제 성공";
		if(k!=1) {
			requestPage = "view";
			msg = "삭제 실패";
		}
		request.setAttribute("t_requestPage", requestPage);
		request.setAttribute("t_msg", msg);
	}
	
	public void DBupdate(HttpServletRequest request) {
		String id = request.getParameter("t_id");
		String name = request.getParameter("t_name");
		String age = request.getParameter("t_age");
		String reg_date = request.getParameter("t_reg_date");
		int k = dao.updateDB(id,name,age,reg_date);
		request.setAttribute("t_url", "Member");
		request.setAttribute("t_requestPage", "update");
		String msg = "수정 성공";
		if(k!=1) {
			msg="수정 실패";
		}
		request.setAttribute("t_msg", msg);
	}
	
	public void update(HttpServletRequest request) {
		String id = request.getParameter("t_id");
		MemberDto dto = dao.viewDB(id);
		request.setAttribute("t_dto", dto);
	}
	
	public void DBsave(HttpServletRequest request) {
		String id = request.getParameter("t_id");
		String name = request.getParameter("t_name");
		int age = Integer.parseInt(request.getParameter("t_age"));
		String reg_date = request.getParameter("t_reg_date");
		MemberDto dto = new MemberDto(id,name,reg_date,age);
		int k = dao.insertDB(dto);
		request.setAttribute("t_url", "Member");
		String msg = "등록 성공";
		if(k!=1) {
			request.setAttribute("t_requestPage", "write");
			msg = "등록 실패";
		}
		request.setAttribute("t_msg", msg);
	}
	
	public void list(HttpServletRequest request) {
		ArrayList<MemberDto> arr = new ArrayList<>();
		String select = request.getParameter("t_select");
		request.setAttribute("t_select", select);
		String search = request.getParameter("t_search");
		request.setAttribute("t_search", search);
		if(select==null) arr = dao.listDB();
		else arr = dao.searchDB(select,search);
		request.setAttribute("t_arr", arr);
		int count = arr.size();
		request.setAttribute("t_count", count);
	}
	
	public void view(HttpServletRequest request) {
		String id = request.getParameter("t_id");
		MemberDto dto = dao.viewDB(id);
		request.setAttribute("t_dto", dto);
	}
}
