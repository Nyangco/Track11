package command.news;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import common.CommonUtil;
import dao.NewsDao;
import dto.NewsDto;

public class Update implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		NewsDao dao = new NewsDao();
		String no = request.getParameter("t_no");
		NewsDto dto = dao.viewDB(no);
		request.setAttribute("t_dto", dto);
		request.setAttribute("t_today", CommonUtil.getToday());
	}

}
