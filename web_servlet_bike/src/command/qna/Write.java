package command.qna;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import common.CommonUtil;
import dao.QnaDao;
import dto.QnaDto;

public class Write implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		QnaDao dao = new QnaDao();
		request.setAttribute("t_today", CommonUtil.getToday());
		
		String no = request.getParameter("t_no");
		if(no!=null) {
			QnaDto dto = dao.getReplyContent(no);
			request.setAttribute("t_dto", dto);
		}
	}

}
