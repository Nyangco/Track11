package member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dto.MemberDto;

/**
 * Servlet implementation class Member_list
 */
@WebServlet("/Member_list")
public class Member_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Member_list() {
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
		ArrayList<MemberDto> arr = new ArrayList<>();
		String select = request.getParameter("t_select");
		request.setAttribute("t_select", select);
		String search = request.getParameter("t_search");
		request.setAttribute("t_search", search);
		if(select==null) arr = dao.listDB();
		else arr = dao.searchDB(select,search);
		request.setAttribute("t_arr", arr);
		int count = arr.size();
		request.setAttribute("t_count", count);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("member/member_list.jsp");
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
