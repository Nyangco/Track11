package command.news;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.NewsDao;
import dto.NewsDto;

public class View implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		NewsDao dao = new NewsDao();
		String no = request.getParameter("t_no");
		NewsDto dto = dao.viewDB(no);
		request.setAttribute("t_dto", dto);
		dao.getHit(no);
		NewsDto preDto = dao.noTitleDB(no,"pre");
		request.setAttribute("t_preDto", preDto);
		NewsDto proDto = dao.noTitleDB(no,"pro");
		request.setAttribute("t_proDto", proDto);
	}

}
