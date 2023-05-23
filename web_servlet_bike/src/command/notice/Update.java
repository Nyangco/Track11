package command.notice;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import common.CommonUtil;
import dao.NoticeDao;
import dto.NoticeDto;

public class Update implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String no = request.getParameter("t_no");
		NoticeDao dao = new NoticeDao();
		NoticeDto dto = dao.viewDB(no);
		request.setAttribute("t_dto", dto);
		String date = CommonUtil.getToday();
		request.setAttribute("t_date", date);
	}

}
