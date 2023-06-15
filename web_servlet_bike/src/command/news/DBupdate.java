package command.news;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExcute;
import common.CommonUtil;
import dao.NewsDao;
import dto.NewsDto;

public class DBupdate implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		NewsDao dao = new NewsDao();
		HttpSession session = request.getSession();
		try {
			MultipartRequest mpr = new MultipartRequest(request, CommonUtil.getFile_dir("news"),1024*1024*10,"utf-8",new DefaultFileRenamePolicy());
			String no = mpr.getParameter("t_no");
			String title = mpr.getParameter("t_title");
			String content = mpr.getParameter("t_content");
			String attach = mpr.getFilesystemName("t_attach");
			String old_attach = mpr.getParameter("t_old_attach");
			
			String update_id = (String)session.getAttribute("sId");
			String update_date = CommonUtil.getTodayTime();
			
			if(old_attach!=null) {
				File f = new File(CommonUtil.getFile_dir("news")+old_attach);
				boolean tf = true;
				if(f.exists()) tf = f.delete();
				if(!tf) System.out.print("파일 제거 오류");
			}
			
			NewsDto dto = new NewsDto(no, title, content, attach, "", "", "", update_id, update_date, "", 0);			
			int k = dao.updateDB(dto);
			
			String msg = "수정에 실패하였습니다"; String url="News"; String nextPage="list";
			if(k==1) msg = "수정에 성공하였습니다";
			request.setAttribute("t_msg", msg);
			request.setAttribute("t_url", url);
			request.setAttribute("t_nextPage", nextPage);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
