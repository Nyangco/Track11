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

	String name = request.getParameter("t_name");
	String id = request.getParameter("t_id");
	String password = request.getParameter("t_password");
	int pwlength = password.length();
	password = dao.encryptSHA256(password); //암호화
	String job = request.getParameter("t_job");
	String tell_1 = request.getParameter("t_tell_1");
	String tell_2 = request.getParameter("t_tell_2");
	String tell_3 = request.getParameter("t_tell_3");
	String mobile_1 = request.getParameter("t_mobile_1");
	String mobile_2 = request.getParameter("t_mobile_2");
	String mobile_3 = request.getParameter("t_mobile_3");
	String mobile = mobile_1+mobile_2+mobile_3;
	String email = request.getParameter("t_email");
	String reg_date = CommonUtil.getToday();
	MemberDto dto = new MemberDto(name,id,password,job,tell_1,tell_2,tell_3,mobile,email,reg_date,pwlength);
	int k = dao.insertDB(dto);
	String msg = k==1 ? name+"님 환영합니다!" : "회원 가입 실패";
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
</head>
<body>

</body>
</html>