package command.news;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExcute;
import common.CommonUtil;
import dao.NewsDao;
import dto.NewsDto;

public class DBsave implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub

		NewsDao dao = new NewsDao();
		HttpSession session = request.getSession();
		
		try {
			MultipartRequest mpr = new MultipartRequest(request,CommonUtil.getFile_dir("news"),1024*1024*10,"utf-8",new DefaultFileRenamePolicy());
			String title = mpr.getParameter("t_title");
			String content = mpr.getParameter("t_content");
			String attach = mpr.getFilesystemName("t_attach");
			
			String no = dao.getMaxNo();
			String reg_id = (String)session.getAttribute("sId");
			String reg_date = CommonUtil.getToday();
			
			NewsDto dto = new NewsDto(no,title,content,attach,reg_id,reg_date,"","","","",0);
			
			int k = dao.insertDB(dto);
			String msg = "등록에 실패하였습니다.";
			String url = "News";
			String nextPage = "write";
			if(k==1) {
				msg = "등록에 성공하였습니다";
				nextPage = "list";
			}
			request.setAttribute("t_msg", msg);
			request.setAttribute("t_url", url);
			request.setAttribute("t_nextPage", nextPage);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
