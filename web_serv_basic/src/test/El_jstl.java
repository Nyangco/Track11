package test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Tdto;

/**
 * Servlet implementation class El_jstl
 */
@WebServlet("/El_jstl")
public class El_jstl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public El_jstl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name= "홍길동";
		int age= 25;
		ArrayList<String> arr= new ArrayList<String>();
		arr.add("대전");
		arr.add("서울");
		arr.add("대구");
		arr.add("부산");
		
		request.setAttribute("t_name", name);
		request.setAttribute("t_age", age);
		request.setAttribute("t_arr", arr);
		
		ArrayList<Tdto> dtos = new ArrayList<>();
		dtos.add(new Tdto("홍길동","대전",25));
		dtos.add(new Tdto("김길동","서울",30));
		dtos.add(new Tdto("이길동","부산",35));
		request.setAttribute("t_dtos", dtos);
		
		RequestDispatcher rd= request.getRequestDispatcher("el_jstl.jsp");
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
