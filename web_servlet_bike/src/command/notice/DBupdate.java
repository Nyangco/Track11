package command.notice;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.CommonExcute;
import common.CommonUtil;
import dao.NoticeDao;
import dto.NoticeDto;

public class DBupdate implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		NoticeDao dao = new NoticeDao();
		String noticeDir = CommonUtil.getFile_dir("notice");
		int maxSize = 1024 * 1024 * 10;
		
		try {
			MultipartRequest mpr = new MultipartRequest(request,noticeDir,maxSize,"utf-8",new DefaultFileRenamePolicy());
			String no = mpr.getParameter("t_no");
			String title = mpr.getParameter("t_title");
			String content = mpr.getParameter("t_content");
			String attach = mpr.getFilesystemName("t_attach");
			String delete = mpr.getParameter("t_delete");
			if(delete != null) delete="y";
			else delete="n";
			String update_id = mpr.getParameter("t_update_id");
			String update_date = CommonUtil.getTodayTime();
			String ori_attach = mpr.getParameter("t_ori_attach");
			NoticeDto dto = new NoticeDto(no,"",title,content,attach,"",update_date,update_id,"",0);
			
			int k = dao.updateDB(dto,delete);
			String msg = "수정에 실패했습니다."; String url="Notice?t_no"+no; String nextPage="view";
			if(k==1) {
				if((attach!=null || delete.equals("y"))&&ori_attach.equals("null")) {
					File f = new File(noticeDir+ori_attach);
					boolean tf = true;
					if(f.exists()) tf = f.delete();
					if(!tf) System.out.print("파일 제거 오류");
				}
				msg = "수정에 성공하였습니다.";
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
