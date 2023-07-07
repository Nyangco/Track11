package command.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import dao.AdminDao;

/**
 * Servlet implementation class Statics_month
 */
@WebServlet("/Statics_month")
public class Statics_month extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Statics_month() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");
		PrintWriter out = response.getWriter();
		AdminDao dao = new AdminDao();
		
		String month = request.getParameter("t_month");
		
		ArrayList<String> arr_1 = dao.getTC_TS(month);
		ArrayList<ArrayList<String>> arr_2 = dao.getPC(month);
		ArrayList<ArrayList<String>> arr_3 = dao.getCC(month);
		String t_count = arr_1.get(0);
		String t_sell = arr_1.get(1);
		
		HashMap<String, Object> hM = new HashMap<String, Object>();
		JSONObject jsob1 = new JSONObject();
		JSONObject jsob2 = new JSONObject();
		JSONArray jsar1 = new JSONArray();
		JSONArray jsar2 = new JSONArray();
		JSONObject finaljsob = new JSONObject();
		
		//hM.put("t_t_count_m", t_count);
		//hM.put("t_t_sell_m", t_sell);
		
		
		
		
		
		for(int k=0; k<arr_2.size(); k++) {
			hM = new HashMap<String, Object>();
			hM.put("label",arr_2.get(k).get(0));
			hM.put("value",arr_2.get(k).get(1));
			jsob1 = new JSONObject(hM);
			jsar1.add(jsob1);
		}for(int k=arr_2.size();k<5;k++) {
			hM = new HashMap<String, Object>();
			hM.put("label","");
			hM.put("value","");
			jsob1 = new JSONObject(hM);
			jsar1.add(jsob1);
		}
		
		
		for(int k=0; k<arr_3.size(); k++) {
			hM = new HashMap<String, Object>();
			hM.put("label",arr_2.get(k).get(0));
			hM.put("value",arr_2.get(k).get(1));
			jsob2 = new JSONObject(hM);
			jsar2.add(jsob2);
		}for(int k=arr_3.size();k<5;k++) {
			hM = new HashMap<String, Object>();
			hM.put("label","");
			hM.put("value","");
			jsob2 = new JSONObject(hM);
			jsar2.add(jsob2);
		}
		
		finaljsob.put("t_t_count_m", t_count);
		finaljsob.put("t_t_sell_m", t_sell);
		finaljsob.put("t_p_count_m",jsar1);
		finaljsob.put("t_c_cell_m",jsar2);
		
		out.print(finaljsob);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
