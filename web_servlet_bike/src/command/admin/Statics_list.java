package command.admin;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.AdminDao;
import dto.CustomerDto;

public class Statics_list implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		AdminDao dao = new AdminDao();
		ArrayList<String> arr_1 = dao.getTC_TS();
		ArrayList<ArrayList<String>> arr_2 = dao.getPC();
		ArrayList<ArrayList<String>> arr_3 = dao.getCC();
		String t_count = arr_1.get(0);
		request.setAttribute("t_t_count", t_count);
		String t_sell = arr_1.get(1);
		request.setAttribute("t_t_sell", t_sell);
		
		String p_count_label = "\"";
		String p_count_value = "";
		for(int k=0; k<arr_2.size(); k++) {
			p_count_label+=(arr_2.get(k).get(0)+"\",\"");
			p_count_value+=(arr_2.get(k).get(1)+", ");
		}
		p_count_label = p_count_label.substring(0,p_count_label.length()-2);
		p_count_value = p_count_value.substring(0,p_count_value.length()-2);
		request.setAttribute("t_p_count_label", p_count_label);
		request.setAttribute("t_p_count_value", p_count_value);
		
		String c_cell_label = "\"";
		String c_cell_value = "";
		for(int k=0; k<arr_2.size(); k++) {
			c_cell_label+=(arr_2.get(k).get(0)+"\",\"");
			c_cell_value+=(arr_2.get(k).get(1)+", ");
		}
		c_cell_label = c_cell_label.substring(0,c_cell_label.length()-2);
		c_cell_value = c_cell_value.substring(0,c_cell_value.length()-2);
		request.setAttribute("t_c_cell_label", c_cell_label);
		request.setAttribute("t_c_cell_value", c_cell_value);
	}

}
