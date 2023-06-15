package command.news;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import common.CommonUtil;
import dao.NewsDao;

public class DBdelete implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String no = request.getParameter("t_no");
		String attach = request.getParameter("t_attach");
		NewsDao dao = new NewsDao();
		
		File f = new File(CommonUtil.getFile_dir("news"),attach);
		if(f.exists()) {
			boolean tf = f.delete();
			if(!tf) System.out.println("글 삭제시 파일 삭제 실패");
		}
		int k = dao.deleteDB(no);
		String msg = "삭제에 실패하였습니다."; String url="News"; String nextPage="list";
		if(k==1) msg = "삭제에 성공하였습니다.";
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
	}

}
