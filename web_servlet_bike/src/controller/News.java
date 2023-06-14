package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.news.DBdelete;
import command.news.DBsave;
import command.news.DBupdate;
import command.news.List;
import command.news.Update;
import command.news.View;
import command.news.Write;

/**
 * Servlet implementation class News
 */
@WebServlet("/News")
public class News extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public News() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		request.setAttribute("t_nowPage", "News");
		
		HttpSession session = request.getSession();
		int sLevel = 0;
		String ssLevel = (String)session.getAttribute("sLevel");
		if(ssLevel!=null) sLevel=Integer.parseInt(ssLevel);
		
		String requestPage = request.getParameter("t_requestPage"); 
		if(requestPage == null) requestPage = (String)request.getAttribute("t_requestPage");
		if(requestPage == null) requestPage = "list";
		
		String page="alert.jsp";
		
		if(requestPage.equals("list")) {
			List news = new List();
			news.excute(request);
			page="news/news_list.jsp";
		}if(requestPage.equals("write")) {
			if(sLevel>0) {
				Write news = new Write();
				news.excute(request);
				page="news/news_write.jsp";
			}else {
				request.setAttribute("t_msg", "접근 권한이 없습니다.");
				request.setAttribute("t_url", "News");
			}
		}if(requestPage.equals("DBsave")) {
			if(sLevel>0) {
				DBsave news = new DBsave();
				news.excute(request);
				page="alert.jsp";
			}else {
				request.setAttribute("t_msg", "접근 권한이 없습니다.");
				request.setAttribute("t_url", "News");
			}
		}if(requestPage.equals("view")) {
			View news = new View();
			
		}if(requestPage.equals("update")) {
			if(sLevel>0) {
				Update news = new Update();
			}else {
				request.setAttribute("t_msg", "접근 권한이 없습니다.");
				request.setAttribute("t_url", "News");
			}
		}if(requestPage.equals("DBupdate")) {
			if(sLevel>0) {
				DBupdate news = new DBupdate();
			}else {
				request.setAttribute("t_msg", "접근 권한이 없습니다.");
				request.setAttribute("t_url", "News");
			}
		}if(requestPage.equals("DBdelete")) {
			if(sLevel>0) {
				DBdelete news = new DBdelete();
			}else {
				request.setAttribute("t_msg", "접근 권한이 없습니다.");
				request.setAttribute("t_url", "News");
			}
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
