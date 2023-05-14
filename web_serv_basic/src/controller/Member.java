package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.member.MemberJava;

/**
 * Servlet implementation class Member
 */
@WebServlet("/Member")
public class Member extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Member() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		MemberJava memberjava = new MemberJava();
		String requestPage = request.getParameter("t_requestPage");
		String page = "";
		if(requestPage==null) requestPage="list";
		//목록
		if(requestPage.equals("list")) {
			memberjava.list(request);
//			page="member/member_list.jsp";
			page="member/member_list_jstl_1.jsp";
		//등록
		}else if(requestPage.equals("write")) {
//			page="member/member_write.jsp";
			page="member/member_write_jstl.jsp";
		//등록 DB작업
		}else if(requestPage.equals("DBsave")) {
			memberjava.DBsave(request);
//			page="alert.jsp";
			page="alert.jsp";
		//상세보기
		}else if(requestPage.equals("view")) {
			memberjava.view(request);
//			page="member/member_view.jsp";
			page="member/member_view_jstl_1.jsp";
		//수정
		}else if(requestPage.equals("update")) {
			memberjava.update(request);
//			page="member/member_update.jsp";
			page="member/member_update_jstl_1.jsp";
		//수정 DB작업
		}else if(requestPage.equals("DBupdate")) {
			memberjava.DBupdate(request);
//			page="alert.jsp";
			page="alert.jsp";
		//삭제 DB작업
		}else if(requestPage.equals("DBdelete")) {
			memberjava.DBdelete(request);
//			page="alert.jsp";
			page="alert.jsp";
		}
		

		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
