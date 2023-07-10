package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.qna.DBsave;
import command.qna.List;
import command.qna.Write;
import common.CommonUtil;

/**
 * Servlet implementation class Qna
 */
@WebServlet("/Qna")
public class Qna extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Qna() {
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
		request.setAttribute("t_nowPage", "Qna");
		
		String requestPage = request.getParameter("t_requestPage");
		if(requestPage==null) requestPage = (String)request.getAttribute("t_requestPage");
		if(requestPage==null) requestPage = "list";
		
		String page = "alert.jsp";
		if(requestPage.equals("list")) {
			List qna = new List();
			qna.excute(request);
			page="qna/qna_list.jsp";
		}else if(requestPage.equals("write")) {
			if(CommonUtil.checkSession(request)){
				Write qna = new Write();
				qna.excute(request);
			}
			page="qna/qna_write.jsp";
		}else if(requestPage.equals("DBsave")) {
			if(CommonUtil.checkSession(request)){
				DBsave qna = new DBsave();
				qna.excute(request);
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
