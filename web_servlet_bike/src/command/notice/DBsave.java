package command.notice;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExcute;
import common.CommonUtil;
import dao.NoticeDao;
import dto.NoticeDto;

public class DBsave implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		NoticeDao dao = new NoticeDao();
		
		String noticeDir = CommonUtil.getFile_dir("notice");
		int maxSize = 1024 * 1024 * 10;
		
		try {
			MultipartRequest mpr = new MultipartRequest(request,noticeDir,maxSize,"utf-8",new DefaultFileRenamePolicy());
			String no = dao.getMaxNo();
			String reg_id = mpr.getParameter("t_reg_id");
			String title = mpr.getParameter("t_title");
			String content = mpr.getParameter("t_content");
			String attach = mpr.getFilesystemName("t_attach");
			String reg_date = mpr.getParameter("t_reg_date");
			NoticeDto dto = new NoticeDto(no,reg_id,title,content,attach,reg_date,"","",0);
			int k = dao.insertDB(dto);
			String msg = "저장에 실패하였습니다"; String url="Notice"; String nextPage="write";
			if(k==1) {
				msg = "저장에 성공하였습니다.";
				nextPage = "list";
			}
			request.setAttribute("t_msg", msg);
			request.setAttribute("t_url", url);
			request.setAttribute("t_nextPage", nextPage);
		}catch(IOException e) {
			System.out.println("mpr 오류 ");
			e.printStackTrace();
		}
		
	}

}
