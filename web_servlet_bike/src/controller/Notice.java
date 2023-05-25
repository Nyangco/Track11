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
		request.setAttribute("t_nowPage", "Notice");
		HttpSession session = request.getSession();
		String ssLevel = (String)session.getAttribute("sLevel");
		if(ssLevel==null) ssLevel="0";
		int sLevel = Integer.parseInt(ssLevel);
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
			if(sLevel>=1) {
				Write notice = new Write();
				notice.excute(request);
				page="notice/notice_write.jsp";
			}else {
				request.setAttribute("t_msg", "접근 권한이 존재하지 않습니다.");
				request.setAttribute("t_url", "Notice");
				request.setAttribute("t_nextPage", "list");
			}
		//notice DB 저장
		}else if(requestPage.equals("DBsave")) {
			if(sLevel>=1) {
				DBsave notice = new DBsave();
				notice.excute(request);
				page="alert.jsp";
			}else {
				request.setAttribute("t_msg", "접근 권한이 존재하지 않습니다.");
				request.setAttribute("t_url", "Notice");
				request.setAttribute("t_nextPage", "list");
			}
		//상세 조회
		}else if(requestPage.equals("view")) {
			View notice = new View();
			notice.excute(request);
			page="notice/notice_view.jsp";
		//삭제
		}else if(requestPage.equals("DBdelete")) {
			if(sLevel>=1) {
				DBdelete notice = new DBdelete();
				notice.excute(request);
				page="alert.jsp";
			}else {
				request.setAttribute("t_msg", "접근 권한이 존재하지 않습니다.");
				request.setAttribute("t_url", "Notice");
				request.setAttribute("t_nextPage", "list");
			}
		//수정 화면으로 이동
		}else if(requestPage.equals("update")) {
			if(sLevel>=1) {
				Update notice = new Update();
				notice.excute(request);
				page="notice/notice_update.jsp";
			}else {
				request.setAttribute("t_msg", "접근 권한이 존재하지 않습니다.");
				request.setAttribute("t_url", "Notice");
				request.setAttribute("t_nextPage", "list");
			}
		//수정 DB 조작
		}else if(requestPage.equals("DBupdate")) {
			if(sLevel>=1) {
			DBupdate notice = new DBupdate();
			notice.excute(request);
			page="alert.jsp";
			}else {
				request.setAttribute("t_msg", "접근 권한이 존재하지 않습니다.");
				request.setAttribute("t_url", "Notice");
				request.setAttribute("t_nextPage", "list");
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
