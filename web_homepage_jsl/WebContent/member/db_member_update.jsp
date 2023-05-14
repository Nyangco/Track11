<%@page import="common.CommonUtil"%>
<%@page import="common.DBConnection"%>
<%@page import="dao.MemberDao"%>
<%@page import="dto.MemberDto"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	MemberDao dao = new MemberDao();

	String id = request.getParameter("t_id");
	String password = request.getParameter("t_password");
	password = dao.encryptSHA256(password); //암호화
	String cPassword = dao.getPW(id);
	if(password.equals(cPassword)){
		String name = request.getParameter("t_name");
		String job = request.getParameter("t_job");
		String tell_1 = request.getParameter("t_tell_1");
		String tell_2 = request.getParameter("t_tell_2");
		String tell_3 = request.getParameter("t_tell_3");
		String mobile_1 = request.getParameter("t_mobile_1");
		String mobile_2 = request.getParameter("t_mobile_2");
		String mobile_3 = request.getParameter("t_mobile_3");
		String mobile = mobile_1+mobile_2+mobile_3;
		String email = request.getParameter("t_email");
		
		MemberDto dto = new MemberDto(name,id,"",job,tell_1,tell_2,tell_3,mobile,email,"","");
		int k = dao.updateDB(dto);
		String msg = k==1 ? "회원 정보 수정이 완료되었습니다" : "실패하였습니다";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>실행중..</title>
<script>
	alert("<%=msg%>");
	<%if(k==1){%>
		location.href="../index.jsp";
	<%}else{%>
		window.history.back();
	<%}%>
</script>
	<%}else{ %>
<script>
	alert("비밀번호가 일치하지 않습니다.");
	window.history.back();
</script>
	<%} %>
</head>
<body>

</body>
</html>