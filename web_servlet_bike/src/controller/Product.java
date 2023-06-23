package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.product.Product_DBdelete;
import command.product.Product_DBsave;
import command.product.Product_DBtag;
import command.product.Product_DBupdate;
import command.product.Product_list;
import command.product.Product_tag;
import command.product.Product_update;
import command.product.Product_view;
import command.product.Product_write;

/**
 * Servlet implementation class Product
 */
@WebServlet("/Product")
public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Product() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		request.setAttribute("t_nowPage", "Product");
		
		String requestPage = request.getParameter("t_requestPage");
		if(requestPage == null) requestPage = (String)request.getAttribute("t_requestPage");
		if(requestPage == null) requestPage = "list";
		request.setAttribute("t_requestPage", requestPage);
		
		String page = "alert.jsp";
		
		HttpSession session = request.getSession();
		String ssLevel = (String)session.getAttribute("sLevel");
		if(ssLevel == null) ssLevel="0";
		int sLevel = Integer.parseInt(ssLevel);
		
		if(sLevel>1) {
			if(requestPage.equals("list")) {
				Product_list product = new Product_list();
				product.excute(request);
				page="product/product_list.jsp";
			}else if(requestPage.equals("write")) {
				Product_write product = new Product_write();
				product.excute(request);
				page="product/product_write.jsp";
			}else if(requestPage.equals("DBsave")) {
				Product_DBsave product = new Product_DBsave();
				product.excute(request);
			}else if(requestPage.equals("tag")) {
				Product_tag product = new Product_tag();
				product.excute(request);
				page="product/product_tag.jsp";
			}else if(requestPage.equals("DBtag")) {
				Product_DBtag product = new Product_DBtag();
				product.excute(request);
			}else if(requestPage.equals("view")) {
				Product_view product = new Product_view();
				product.excute(request);
				page="product/product_view.jsp";
			}else if(requestPage.equals("update")) {
				Product_update product = new Product_update();
				product.excute(request);
				page="product/product_update.jsp";
			}else if(requestPage.equals("DBupdate")) {
				Product_DBupdate product = new Product_DBupdate();
				product.excute(request);
			}else if(requestPage.equals("DBdelete")) {
				Product_DBdelete product = new Product_DBdelete();
				product.excute(request);
			}
		}else {
			request.setAttribute("t_msg", "접근 권한이 없습니다.");
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
