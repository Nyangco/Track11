package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dto.MemberDto;

/**
 * Servlet implementation class DB_member_save
 */
@WebServlet("/DB_member_save")
public class DB_member_save extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DB_member_save() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		MemberDao dao = new MemberDao();
		String id = request.getParameter("t_id");
		String name = request.getParameter("t_name");
		int age = Integer.parseInt(request.getParameter("t_age"));
		String reg_date = request.getParameter("t_reg_date");
		MemberDto dto = new MemberDto(id,name,reg_date,age);
		int k = dao.insertDB(dto);
		String url = "Member_list";
		String msg = "등록 성공";
		if(k!=1) {
			url = "Member_write";
			msg = "등록 실패";
		}
		request.setAttribute("t_url", url);
		request.setAttribute("t_msg", msg);
		
		RequestDispatcher rd = request.getRequestDispatcher("alert.jsp");
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
