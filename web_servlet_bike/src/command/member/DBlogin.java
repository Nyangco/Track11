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
		String msg = "ID나 비밀번호가 맞지 않습니다.";
		String url = "Member";
		String nextPage = "login";
		try {
			password = CommonUtil.encryptSHA256(password);
		}catch(NoSuchAlgorithmException e) {
			System.out.println("DBlogin 에러");
			e.printStackTrace();
		}
		MemberDto dto = dao.idCheckDB(id, password);
		if(dto!=null) {
			if(dto.getExit_date()==null) {
				session.setAttribute("sLevel", dto.getsLevel());
				session.setAttribute("sName", dto.getName());
				session.setAttribute("sId", id);
				session.setMaxInactiveInterval(60 * 60);
				msg = "로그인 되었습니다. 최근 로그인 시간 : "+dto.getLast_login_date();
				url = "Index";
				dao.recentLogin(id);
			}else {
				msg = "탈퇴한 사용자입니다.";
			}
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
		request.setAttribute("t_nextPage", nextPage);
		
		
	}

}
