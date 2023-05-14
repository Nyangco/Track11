package command.member;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.SnackDao;

public class SnackDBdelete implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String p_code = request.getParameter("t_p_code");
		SnackDao dao = new SnackDao();
		int k = dao.deleteDB(p_code);
		String msg = "삭제 성공";
		String url = "Snack";
		String page ="list";
		if(k!=1) {
			msg = "삭제 실패";
			page = "view";
		}
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
		request.setAttribute("t_page", page);
	}

}
