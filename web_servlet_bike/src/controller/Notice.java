package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import command.notice.DBsave;
import command.notice.List;
import command.notice.Write;

/**
 * Servlet implementation class Notice
 */
@WebServlet("/Notice")
public class Notice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Notice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("2");
		request.setCharacterEncoding("utf-8");
		String page="alert.jsp";
		String requestPage = request.getParameter("t_requestPage");
		if(requestPage==null || requestPage.equals("")) requestPage = "list";
		
		//리스트
		if(requestPage.equals("list")) {
			List notice = new List();
			notice.excute(request);
			page="notice/notice_list.jsp";
		//notice 작성
		}else if(requestPage.equals("write")) {
			Write notice = new Write();
			notice.excute(request);
			page="notice/notice_write.jsp";
		//notice DB 저장
		}else if(requestPage.equals("DBsave")) {
			System.out.print("l");
			DBsave member = new DBsave();
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
