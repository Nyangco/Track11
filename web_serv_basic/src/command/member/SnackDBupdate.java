package command.member;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.SnackDao;
import dto.SnackDto;

public class SnackDBupdate implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		SnackDao dao = new SnackDao();
		
		String p_code = request.getParameter("t_p_code");
		String p_name = request.getParameter("t_p_name");
		String m_code = request.getParameter("t_m_code");
		String price = request.getParameter("t_price");
		price = price.replace(",", "");
		SnackDto dto = new SnackDto(p_code,p_name,m_code,"",Integer.parseInt(price));
		int k = dao.updateDB(dto);
		String msg="수정 성공";
		String url="Snack";
		String page="view";
		if(k!=1) msg="수정 실패";
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
		request.setAttribute("t_page", page);
	}

}
