package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.freeboard.DBsave;
import command.freeboard.DBupdate;
import command.freeboard.List;
import command.freeboard.Update;
import command.freeboard.View;
import command.freeboard.Write;
import common.CommonExcute;

/**
 * Servlet implementation class Freeboard
 */
@WebServlet("/Freeboard")
public class Freeboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Freeboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		HttpSession ss = request.getSession();
		String sLevel = (String)ss.getAttribute("sLevel");
		request.setAttribute("t_nowPage", "Freeboard");
		String requestPage = request.getParameter("t_requestPage");
		if(requestPage==null || requestPage.equals("")) requestPage = (String)request.getAttribute("t_requestPage");
		if(requestPage==null || requestPage.equals("")) requestPage = "list";
		String page = "alert.jsp";
		
		if(requestPage.equals("list")) {
			CommonExcute freeboard = new List();
			freeboard.excute(request);
			page="freeboard/freeboard_list.jsp";
		}else if(requestPage.equals("view")) {
			CommonExcute freeboard = new View();
			freeboard.excute(request);
			page="freeboard/freeboard_view.jsp";
		}
		
		if(sLevel!=null) {
			if(requestPage.equals("write")) {
				CommonExcute freeboard = new Write();
				freeboard.excute(request);
				page="freeboard/freeboard_write.jsp";
			}else if(requestPage.equals("DBsave")) {
				CommonExcute freeboard = new DBsave();
				freeboard.excute(request);
			}else if(requestPage.equals("update")) {
				CommonExcute freeboard = new Update();
				freeboard.excute(request);
				page="freeboard/freeboard_update.jsp";
			}else if(requestPage.equals("DBupdate")) {
				CommonExcute freeboard = new DBupdate();
				freeboard.excute(request);
			}
		}else {
			request.setAttribute("t_msg", "로그인 후 시도하세요");
			request.setAttribute("t_url", "Member");
			request.setAttribute("t_nextPage", "list");
		}
		
		RequestDispatcher rd= request.getRequestDispatcher(page);
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
