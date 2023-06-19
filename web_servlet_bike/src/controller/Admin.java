package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.admin.List;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		request.setAttribute("t_nowPage", "Admin");
		
		String requestPage = request.getParameter("t_requestPage");
		if(requestPage == null) requestPage = (String)request.getAttribute("t_requestPage");
		if(requestPage == null) requestPage = "list";
		request.setAttribute("t_requestPage", requestPage);
		
		String page = "alert.jsp";
		
		HttpSession session = request.getSession();
		String ssLevel = (String)session.getAttribute("sLevel");
		if(ssLevel == null) ssLevel="0";
		int sLevel = Integer.parseInt(ssLevel);
		
		if(sLevel!=0) {
			if(requestPage.equals("list")) {
				List admin = new List();
				admin.excute(request);
				page="admin/admin_list.jsp";
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
