package command.notice;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import dao.NoticeDao;

public class DBdelete implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		NoticeDao dao = new NoticeDao();
		String no = request.getParameter("t_no");
		int k = dao.deleteDB(no);
		String msg="삭제에 실패하였습니다."; String url="Notice?t_no="+no; String nextPage="view";
		if(k==1) {
			String attach = request.getParameter("t_attach");
			File f = new File("C:/track11_ysm/work_project/Track11/web_servlet_bike/WebContent/attach/notice/"+attach);
			boolean tf = true;
			if(f.exists()) tf = f.delete();
			if(!tf) System.out.print("파일 제거 오류");
			msg = "삭제에 성공하였습니다.";
			url = "Notice";
			nextPage = "list";
		}
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
		request.setAttribute("t_nextPage", nextPage);
	}

}
