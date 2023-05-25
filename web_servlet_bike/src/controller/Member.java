package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.member.DBPWchange;
import command.member.DBPasswordFind;
import command.member.DBdelete;
import command.member.DBidFind;
import command.member.DBlogin;
import command.member.DBsave;
import command.member.DBupdate;
import command.member.Logout;
import command.member.Myinfo;
import command.member.Update;

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
		request.setAttribute("t_nowPage", "Member");
		String page = "alert.jsp";
		String requestPage = request.getParameter("t_requestPage");
		if(requestPage == null) requestPage=(String)request.getAttribute("t_requestPage");
		if(requestPage == null) requestPage="login"; // session 작업 완료 후 로그인 상태에서 들어올 시 마이페이지로 변경하기
		if(requestPage.equals("")) requestPage="login";
		request.setAttribute("t_requestPage", requestPage);
		
		//로그인
		if(requestPage.equals("login")) {
			page="member/member_login.jsp";
		//DB 로그인
		}else if(requestPage.equals("DBlogin")) {
			DBlogin member = new DBlogin();
			member.excute(request);
			page="alert.jsp";
		//신규 가입
		}else if(requestPage.equals("join")) {
			page="member/member_join.jsp";
		//DB 가입
		}else if(requestPage.equals("DBsave")) {
			DBsave member = new DBsave();
			member.excute(request);
			page="alert.jsp";
		//로그아웃
		}else if(requestPage.equals("logout")) {
			Logout member = new Logout();
			member.excute(request);
			page="alert.jsp";
		//내 정보
		}else if(requestPage.equals("myinfo")) {
			Myinfo member = new Myinfo();
			member.excute(request);
			String msg = (String)request.getAttribute("t_msg");
			if(msg!=null) page="alert.jsp";
			else page="member/member_myinfo.jsp";
		//계정 삭제
		}else if(requestPage.equals("DBdelete")) {
			DBdelete member = new DBdelete();
			member.excute(request);
			page="alert.jsp";
		//계정 정보 변경
		}else if(requestPage.equals("update")) {
			Update member = new Update();
			member.excute(request);
			page="member/member_update.jsp";
		//DB 수정
		}else if(requestPage.equals("DBupdate")) {
			DBupdate member = new DBupdate();
			member.excute(request);
			page="alert.jsp";
		//ID/비밀번호 찾기
		}else if(requestPage.equals("passwordFind")) {
			page="member/member_passwordFind.jsp";
		//ID 찾기 DB 작업
		}else if(requestPage.equals("DBidFind")) {
			DBidFind member = new DBidFind();
			member.excute(request);
			page="alert.jsp";
		//비밀번호 찾기 DB 작업
		}else if(requestPage.equals("DBpasswordFind")) {
			DBPasswordFind member = new DBPasswordFind();
			member.excute(request);
			page="alert.jsp";
		//비밀번호 변경
		}else if(requestPage.equals("PWchange")) {
			page="member/member_PWchange.jsp";
		//비밀번호 변경 DB 작업
		}else if(requestPage.equals("DBPWchange")) {
			DBPWchange member = new DBPWchange();
			member.excute(request);
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
