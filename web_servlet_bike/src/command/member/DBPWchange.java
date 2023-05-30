package command.member;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import common.CommonUtil;
import dao.MemberDao;

public class DBPWchange implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		MemberDao dao = new MemberDao();
		String id = request.getParameter("t_id");
		String oldPW = request.getParameter("t_oldPassword");
		String newPW = request.getParameter("t_newPassword");
		int pwLength = newPW.length();
		try {
			oldPW = CommonUtil.encryptSHA256(oldPW);
			newPW = CommonUtil.encryptSHA256(newPW);
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		String msg = "변경에 실패하였습니다."; String url="Member"; String nextPage="PWchange";
		int k = dao.setMemberPW(id, oldPW, newPW,pwLength);
		if(k==1) {
			msg = "변경에 성공하였습니다.";
			nextPage = "myinfo";
		}
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
		request.setAttribute("t_nextPage", nextPage);
	}

}
