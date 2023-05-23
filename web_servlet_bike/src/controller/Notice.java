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

import command.notice.DBdelete;
import command.notice.DBsave;
import command.notice.DBupdate;
import command.notice.List;
import command.notice.Update;
import command.notice.View;
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
			DBsave notice = new DBsave();
			notice.excute(request);
			page="alert.jsp";
		//상세 조회
		}else if(requestPage.equals("view")) {
			View notice = new View();
			notice.excute(request);
			page="notice/notice_view.jsp";
		//삭제
		}else if(requestPage.equals("DBdelete")) {
			DBdelete notice = new DBdelete();
			notice.excute(request);
			page="alert.jsp";
		//수정 화면으로 이동
		}else if(requestPage.equals("update")) {
			Update notice = new Update();
			notice.excute(request);
			page="notice/notice_update.jsp";
		//수정 DB 조작
		}else if(requestPage.equals("DBupdate")) {
			DBupdate notice = new DBupdate();
			notice.excute(request);
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
