package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.customer.Buy;
import command.customer.List;
import command.customer.Purchase;
import command.customer.Receipt_list;
import command.customer.Receipt_view;
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
		
		HttpSession session = request.getSession();
		String sLevel = (String)session.getAttribute("sLevel");
		
		String page = "alert.jsp";
		
		String requestPage = request.getParameter("t_requestPage");
		if(requestPage==null) requestPage = "list";
		
		if(requestPage.equals("list")) {
			List customer = new List();
			customer.excute(request);
			page="customer/customer_list.jsp";
		}else if(requestPage.equals("view")) {
			View customer = new View();
			customer.excute(request);
			page="customer/customer_view.jsp";
		}else if(requestPage.equals("buy")) {
			if(sLevel==null) {
				request.setAttribute("t_msg", "로그인 후에 다시 시도해주십시오");
				request.setAttribute("t_url", "Member");
				request.setAttribute("t_nextPage", "login");
			}else {
				Buy customer = new Buy();
				customer.excute(request);
				page="customer/customer_buy.jsp";
			}
		}else if(requestPage.equals("purchase")) {
			if(sLevel==null) {
				request.setAttribute("t_msg", "로그인 후에 다시 시도해주십시오");
				request.setAttribute("t_url", "Member");
				request.setAttribute("t_nextPage", "login");
			}else {
				Purchase customer = new Purchase();
				customer.excute(request);
			}
		}else if(requestPage.equals("receipt_list")) {
			if(sLevel==null) {
				request.setAttribute("t_msg", "로그인 후에 다시 시도해주십시오");
				request.setAttribute("t_url", "Member");
				request.setAttribute("t_nextPage", "login");
			}else {
				Receipt_list customer = new Receipt_list();
				customer.excute(request);
				page="customer/receipt_list.jsp";
			}
		}else if(requestPage.equals("receipt_view")) {
			if(sLevel==null) {
				request.setAttribute("t_msg", "로그인 후에 다시 시도해주십시오");
				request.setAttribute("t_url", "Member");
				request.setAttribute("t_nextPage", "login");
			}else {
				Receipt_view customer = new Receipt_view();
				customer.excute(request);
				page="customer/receipt_view.jsp";
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
