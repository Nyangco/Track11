package command.qna;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.QnaDao;

public class DBdelete implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		QnaDao dao = new QnaDao();
		String no = request.getParameter("t_no");
		int k = dao.deleteDB(no);
		String msg = "삭제에 실패하였습니다."; String url = "Qna"; String nextPage="list";
		if(k==1) msg = "삭제에 성공하였습니다.";
		request.setAttribute("t_msg",msg);
		request.setAttribute("t_url",url);
		request.setAttribute("t_nextPage",nextPage);
	}

}
