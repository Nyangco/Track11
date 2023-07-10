package command.qna;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.QnaDao;
import dto.QnaDto;

public class DBsave implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		QnaDao dao = new QnaDao();
		String title = request.getParameter("t_title");
		String content = request.getParameter("t_content");
		String reg_id = request.getParameter("t_reg_id");
		String reg_date = request.getParameter("t_reg_date");
		String reply = request.getParameter("t_reply");
		if(reply==null || reply.equals("")) reply="Q000";
		
		String no = dao.getMaxNo();
		
		QnaDto dto = new QnaDto(no, title, reg_id, reg_date, content, reply);
		int k = dao.insertDB(dto);
		String msg="Qna 등록에 실패했습니다"; String url="Qna"; String nextPage="list";
		if(k==1) msg="Qna 등록에 성공했습니다";
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
		request.setAttribute("t_nextPage", nextPage);
	}

}
