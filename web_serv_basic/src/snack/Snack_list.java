package snack;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SnackDao;
import dto.SnackDto;

/**
 * Servlet implementation class Snack_list
 */
@WebServlet("/Snack_list")
public class Snack_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Snack_list() {
        super();
        // TODO Auto-generated constructor stub
    }

	/** 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SnackDao dao = new SnackDao();
		
		String select = request.getParameter("t_select");
		String ori_search = request.getParameter("t_search");
		String search="";
		if(select!=null) {
			if(select.equals("m_name")) {
				switch (ori_search) {
				case"롯데":
					search="10";
					break;
				case"해태":
					search="20";
					break;
				case"농심":
					search="30";
					break;
				case"크라운":
					search="40";
					break;
				case"오리온":
					search="50";
					break;
				default:
					search="0";
					break;
				}
				select = "m_code";
			}else search = ori_search;
		}
		request.setAttribute("t_select", select);
		request.setAttribute("t_search", ori_search);
		
		ArrayList<SnackDto> arr = new ArrayList<>();
		if(select!=null) arr = dao.searchDB(select,search,"");
		else arr = dao.listDB();
		
		request.setAttribute("t_arr", arr);
		RequestDispatcher rd = request.getRequestDispatcher("snack/snack_list.jsp");
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
