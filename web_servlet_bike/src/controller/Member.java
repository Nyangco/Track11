package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.member.DBlogin;
import command.member.Join;

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
		String page = "alert.jsp";
		String requestPage = request.getParameter("t_requestPage");
		if(requestPage == null) requestPage="login"; // session 작업 완료 후 로그인 상태에서 들어올 시 마이페이지로 변경하기
		if(requestPage.equals("")) requestPage="login";
		
		//로그인
		if(requestPage.equals("login")) {
			page="member/member_login.jsp";
		}else if(requestPage.equals("DBlogin")) {
			DBlogin member = new DBlogin();
			member.excute(request);
			page="alert.jsp";
		//신규 가입
		}else if(requestPage.equals("join")) {
			page="member/member_join.jsp";
		//신규 가입 DB 저장
		}else if(requestPage.equals("DBsave")) {
			Join member = new Join();
			member.excute(request);
			page="alert.jsp";
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
