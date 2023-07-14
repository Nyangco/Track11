package command.freeboard;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import common.CommonUtil;
import dao.FreeboardDao;

public class DBdelete implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String no = request.getParameter("t_no");
		String attach = request.getParameter("t_attach");
		FreeboardDao dao = new FreeboardDao();
		int k = dao.deleteDB(no);
		String msg = "삭제에 실패했습니다"; String url = "Freeboard"; String nextPage="list";
		if(k==1) {
			msg = "삭제에 성공하였습니다";
			if(attach!=null) {
				File f = new File(CommonUtil.getFile_dir("freeboard"),attach);
				boolean tf = false;
				if(f.exists()) tf = f.delete();
				if(!tf) System.out.println("파일 제거 오류");
				dao.clearDown(no);
			}
		}
		
	}

}
