package command.notice;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.NoticeDao;
import dto.NoticeDto;

public class View implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		NoticeDao dao = new NoticeDao();
		String no = request.getParameter("t_no");
		dao.getHit(no);
		NoticeDto dto = dao.viewDB(no);
		request.setAttribute("t_dto", dto);
		NoticeDto preDto = dao.getNo("pre",no);
		request.setAttribute("t_preDto", preDto);
		NoticeDto proDto = dao.getNo("pro",no);
		request.setAttribute("t_proDto", proDto);
		String extension="";
		if(dto.getAttach()!=null) {
			int len = dto.getAttach().indexOf(".");
			extension = dto.getAttach().substring(len+1);
		}
		request.setAttribute("t_extension", extension);
	}

}
