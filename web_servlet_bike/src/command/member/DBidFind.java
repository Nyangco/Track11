package command.member;

import javax.servlet.http.HttpServletRequest;

import common.CommonExcute;
import common.MailContentSend;
import dao.MemberDao;

public class DBidFind implements CommonExcute {

	@Override
	public void excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		MemberDao dao = new MemberDao();
		String name = request.getParameter("t_name");
		String email = request.getParameter("t_email");
		
		String id = dao.checkMemberID(name,email);
		
		String msg="해당하는 계정이 없습니다. 다시 확인해주세요"; String url="Member"; String nextPage="passwordFind";
		if(id!=null) {
			String mailSet_Server="smtp.mail.nate.com"; // 보내는 메일 server
			String mailSet_ID="ysm951204";        // 보내는 메일 ID
			String mailSet_PW="tjrah124";        // 보내는 메일 비밀번호
			
			
			
			String mailFromName ="JSL인재개발원";            // 보내는 사람 이름
			String mailFromAddress ="ysm951204@nate.com"; // 보내는 메일 주소
			
			String mailTo    = email;           // 받는  메일 주소
			String mailTitle =" JSL에서 아이디를 재발송 합니다.";   // 메일 제목
			String content = 	                             // 메일내용
			" <table width='400' height='200' border='0' > "+
			" <tr> "+
			" 	<td colspan='2' height='100' align='center'>고객님 ID 안내</td> "+
			" </tr> "+
			" <tr>"+
			" 	<td width='120' align='center'>ID</td> "+
			" 	<td width='280' align='left'>"+id+
			"        <font size='5' color='red'></font> 입니다</td> "+
			" </tr> "+
			" </table> ";

			msg = name+"님 해당하는 이메일 주소로 새 비밀번호를 발송하였습니다.";
			try {
				MailContentSend mail = new MailContentSend();
				mail.setMail(mailSet_Server, mailSet_ID, mailSet_PW);
				mail.sendMail(mailFromName, mailFromAddress, mailTo, mailTitle, content);
				nextPage = "login";
			}catch(Exception e) {
				e.printStackTrace();
				msg = "오류가 발생했습니다.";
			}
			
		}
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
		request.setAttribute("t_nextPage", nextPage);
	}

}
