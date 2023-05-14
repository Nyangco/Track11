package command.member;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.SnackDao;
import dto.SnackDto;

public class SnackDBsave implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		SnackDao dao = new SnackDao();
		String p_code = request.getParameter("t_p_code");
		String p_name = request.getParameter("t_p_name");
		String m_code = request.getParameter("t_m_code");
		String price = request.getParameter("t_price");
		String msg="작성 성공";
		String url="Snack";
		String page="list";
		int k = 0;
		SnackDto dto = new SnackDto(p_code, p_name, m_code, "", Integer.parseInt(price));
		if(dao.duplicateDB(p_code)==1) msg="중복된 상품 코드";
		else {
			k = dao.insertDB(dto);
			if(k!=1) {
				msg="작성 실패";
				page="write";
			}
		}
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
		request.setAttribute("t_page", page);
	}

}
