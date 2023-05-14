package command.member;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.SnackDao;
import dto.SnackDto;

public class SnackView implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String p_code = request.getParameter("t_p_code");
		SnackDao dao = new SnackDao();
		SnackDto dto = dao.viewDB(p_code);
		request.setAttribute("t_dto", dto);
	}

}
