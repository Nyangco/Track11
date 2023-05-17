package command.member;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExcute;
import common.CommonUtil;
import common.DBConnection;
import dao.MemberDao;
import dto.MemberDto;

public class DBlogin implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		MemberDao dao = new MemberDao();
		String id = request.getParameter("t_id");
		String password = request.getParameter("t_password");
		try {
			password = CommonUtil.encryptSHA256(password);
		}catch(NoSuchAlgorithmException e) {
			System.out.println("DBlogin 에러");
			e.printStackTrace();
		}
		MemberDto dto = dao.idCheckDB(id, password);
		if(dto!=null) {
			dao.recentLogin(id);
			session.setAttribute("sLevel", dto.getsLevel());
			session.setAttribute("sName", dto.getName());
			session.setAttribute("sId", id);
			request.setAttribute("t_msg", "로그인 되었습니다");
			request.setAttribute("t_url", "Index");
			session.setMaxInactiveInterval(60*60);
		}
		
		
	}

}
