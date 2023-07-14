package command.freeboard;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExcute;
import common.CommonUtil;
import dao.FreeboardDao;
import dto.FreeboardDto;

public class DBsave implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		FreeboardDao dao = new FreeboardDao();
		try {
			MultipartRequest mpr = new MultipartRequest(request, CommonUtil.getFile_dir("freeboard"), 1024*1024*10, "utf-8", new DefaultFileRenamePolicy());
			String title = mpr.getParameter("t_title");
			String content = mpr.getParameter("t_content");
			String reg_id = mpr.getParameter("t_reg_id");
			
			String reg_date = CommonUtil.getToday();
			
			String attach = mpr.getFilesystemName("t_attach");
			String no = dao.getMaxNo();
			
			FreeboardDto dto = new FreeboardDto(no, title, content, attach, reg_id, null, reg_date, null, 0, 0, 0);
			int k = dao.insertDB(dto);
			
			String msg = "자유게시판 등록에 실패하였습니다."; String url = "Freeboard"; String nextPage="list";
			if(k==1) msg = "자유게시판 등록에 성공하였습니다.";
			
			request.setAttribute("t_msg", msg);
			request.setAttribute("t_url", url);
			request.setAttribute("t_nextPage", nextPage);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
