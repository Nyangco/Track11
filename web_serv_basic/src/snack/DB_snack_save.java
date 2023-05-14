package snack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SnackDao;
import dto.SnackDto;

/**
 * Servlet implementation class DB_snack_save
 */
@WebServlet("/DB_snack_save")
public class DB_snack_save extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DB_snack_save() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SnackDao dao = new SnackDao();
		request.setCharacterEncoding("utf-8");
		String p_code = request.getParameter("t_p_code");
		String p_name = request.getParameter("t_p_name");
		String m_code = request.getParameter("t_m_code");
		String price = request.getParameter("t_price");
		String msg="작성 성공";
		String url="Snack_list";
		int k = 0;
		SnackDto dto = new SnackDto(p_code, p_name, m_code, "", Integer.parseInt(price));
		if(dao.duplicateDB(p_code)==1) msg="중복된 상품 코드";
		else {
			k = dao.insertDB(dto);
			if(k!=1) {
				msg="작성 실패";
				url="Snack_write";
			}
		}
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
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
