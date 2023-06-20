package command.admin;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.AdminDao;
import dto.AdminDto;

public class View implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		AdminDao dao = new AdminDao();
		String id = request.getParameter("t_id");
		AdminDto dto = dao.ViewDB(id);
		request.setAttribute("t_dto", dto);
		int k = dto.getPwLen();
		String str = "";
		for(int i = 0; i<k; i++) {
			str+="*";
		}
		request.setAttribute("t_pw", str);
	}

}
