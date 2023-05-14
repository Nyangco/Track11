package command.member;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.SnackDao;
import dto.SnackDto;

public class SnackList implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		SnackDao dao = new SnackDao();
		
		String select = request.getParameter("t_select");
		String search = request.getParameter("t_search");
		String m_code = request.getParameter("t_m_code");
		if(m_code==null) m_code="0";
		request.setAttribute("t_select", select);
		request.setAttribute("t_search", search);
		request.setAttribute("t_m_code", m_code);
		
		ArrayList<SnackDto> arr = new ArrayList<>();
		if(select!=null) arr = dao.searchDB(select,search,m_code);
		else arr = dao.listDB();
		
		request.setAttribute("t_arr", arr);
		
		ArrayList<SnackDto> maker = dao.makerDB();
		request.setAttribute("t_maker", maker);
		
	}

}
