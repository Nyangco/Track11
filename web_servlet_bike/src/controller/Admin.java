package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.admin.Change_product;
import command.admin.Change_status;
import command.admin.DBchange_product;
import command.admin.DBdelete;
import command.admin.DBupdate;
import command.admin.List;
import command.admin.Purchase_list;
import command.admin.Purchase_view;
import command.admin.Update;
import command.admin.View;

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
			}else if(requestPage.equals("view")) {
				View admin = new View();
				admin.excute(request);
				page="admin/admin_view.jsp";
			}else if(requestPage.equals("update")) {
				Update admin = new Update();
				admin.excute(request);
				page="admin/admin_update.jsp";
			}else if(requestPage.equals("DBupdate")) {
				DBupdate admin = new DBupdate();
				admin.excute(request);
				page="alert.jsp";
			}else if(requestPage.equals("DBdelete")) {
				DBdelete admin = new DBdelete();
				admin.excute(request);
			}else if(requestPage.equals("purchase_list")) {
				Purchase_list admin = new Purchase_list();
				admin.excute(request);
				page="admin/purchase_list.jsp";
			}else if(requestPage.equals("change_status")) {
				Change_status admin = new Change_status();
				admin.excute(request);
			}else if(requestPage.equals("change_product")) {
				Change_product admin = new Change_product();
				admin.excute(request);
				page="admin/purchase_change.jsp";
			}else if(requestPage.equals("DBchange_product")) {
				DBchange_product admin = new DBchange_product();
				admin.excute(request);
			}else if(requestPage.equals("purchase_view")) {
				Purchase_view admin = new Purchase_view();
				admin.excute(request);
				page="admin/purchase_view.jsp";
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
