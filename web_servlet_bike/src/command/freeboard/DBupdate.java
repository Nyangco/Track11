package command.freeboard;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExcute;
import common.CommonUtil;
import dao.FreeboardDao;
import dto.FreeboardDto;

public class DBupdate implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		FreeboardDao dao = new FreeboardDao();
		try {
			MultipartRequest mpr = new MultipartRequest(request, CommonUtil.getFile_dir("freeboard"), 1024*1024*10, "utf-8", new DefaultFileRenamePolicy());
			String no = mpr.getParameter("t_no");
			String title = mpr.getParameter("t_title");
			String content = mpr.getParameter("t_content");
			String delete = mpr.getParameter("t_delete");
			System.out.println(delete);
			String ori_attach = mpr.getParameter("t_ori_attach");
			
			String attach = mpr.getFilesystemName("t_attach");
			if(attach==null && delete==null) attach = ori_attach;
			else if(attach==null && delete !=null) attach="";
			
			String update_date = CommonUtil.getToday();
			
			FreeboardDto dto = new FreeboardDto(no, title, content, attach, null, null, null, update_date, 0, 0, 0);
			int k = dao.updateDB(dto);
			String msg = "자유게시판 변경에 실패했습니다."; String url = "Freeboard"; String nextPage = "list";
			if(k==1) {
				msg = "자유게시판 변경에 성공했습니다.";
				if(ori_attach!=null && (delete!=null || attach!=null)) {
					File f = new File(CommonUtil.getFile_dir("freeboard"),ori_attach);
					boolean tf = false;
					if(f.exists()) tf = f.delete();
					if(!tf) System.out.println("파일 제거 오류");
					dao.clearDown(no);
				}
			}
			request.setAttribute("t_msg", msg);
			request.setAttribute("t_url", url);
			request.setAttribute("t_nextPage", nextPage);
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
