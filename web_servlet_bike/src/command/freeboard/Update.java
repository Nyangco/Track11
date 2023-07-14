package command.freeboard;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import common.CommonUtil;
import dao.FreeboardDao;
import dto.FreeboardDto;

public class Update implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		FreeboardDao dao = new FreeboardDao();
		
		String no = request.getParameter("t_no");
		FreeboardDto dto = dao.viewDB(no);
		request.setAttribute("t_dto", dto);
		
		request.setAttribute("t_today", CommonUtil.getToday());
		
		if(dto.getAttach()!=null) {
			String extension = dto.getAttach().substring(dto.getAttach().indexOf(".")+1);
			String[] permit = {"jpg","jpeg","png","bmp","avif","gif"};
			for(int k=0; k<permit.length; k++) {
				if(permit[k].equals(extension)) {
					request.setAttribute("t_extension", "1");
				}
			}
		}
	}

}
