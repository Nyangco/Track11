package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.customer.List;
import command.customer.View;


/**
 * Servlet implementation class Customer
 */
@WebServlet("/Customer")
public class Customer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Customer() {
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
		if(requestPage==null) requestPage = "list";
		
		if(requestPage.equals("list")) {
			List customer = new List();
			customer.excute(request);
			page="customer/customer_list.jsp";
		}if(requestPage.equals("view")) {
			View customer = new View();
			customer.excute(request);
			page="customer/customer_view.jsp";
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
