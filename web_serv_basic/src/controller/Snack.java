package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.member.SnackDBdelete;
import command.member.SnackDBsave;
import command.member.SnackDBupdate;
import command.member.SnackList;
import command.member.SnackUpdate;
import command.member.SnackView;

/**
 * Servlet implementation class Snack
 */
@WebServlet("/Snack")
public class Snack extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Snack() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String requestPage = request.getParameter("t_requestPage");
		if(requestPage==null) requestPage="list";
		
		//목록
		if(requestPage.equals("list")) {
			SnackList snack = new SnackList();
			snack.excute(request);
			requestPage="snack/snack_list.jsp";
		//작성
		}else if(requestPage.equals("write")) {
			requestPage="snack/snack_write.jsp";
		//DB 저장
		}else if(requestPage.equals("DBsave")) {
			SnackDBsave snack = new SnackDBsave();
			snack.excute(request);
			requestPage="alert.jsp";
		//상세 보기
		}else if(requestPage.equals("view")) {
			SnackView snack = new SnackView();
			snack.excute(request);
			requestPage="snack/snack_view.jsp";
		//수정
		}else if(requestPage.equals("update")) {
			SnackUpdate snack = new SnackUpdate();
			snack.excute(request);
			requestPage="snack/snack_update.jsp";
		//DB 수정
		}else if(requestPage.equals("DBupdate")) {
			SnackDBupdate snack = new SnackDBupdate();
			snack.excute(request);
			requestPage="alert.jsp";
		//DB 삭제
		}else if(requestPage.equals("DBdelete")) {
			SnackDBdelete snack = new SnackDBdelete();
			snack.excute(request);
			requestPage="alert.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(requestPage);
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
