<%@page import="dto.MemberDto"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_session.jsp" %>
<!DOCTYPE html>
<html>
<%
	request.setCharacterEncoding("utf-8");
	MemberDao dao = new MemberDao();
	
	String id = request.getParameter("t_id");
	String password = request.getParameter("t_pw");
	if(id!=null){
	password = dao.encryptSHA256(password);
	
	MemberDto dto = dao.checkLogin(id, password);
	String msg = ""; int k = 0;
	if(sessionLevel.equals("")){
		msg="로그인 해주세요";
	}else if(dto.getName().equals("")){
		msg="id 혹은 비밀번호가 잘못 입력되었습니다.";
	}else if(!id.equals("manager")){
		msg="관리자 계정이 아닙니다";
	}else{
		msg="확인되었습니다.";
		k = 1;
		session.setAttribute("sessionAdmin", "true");
	}
%>
<head>
<meta charset="UTF-8">
<title>진행중...</title>
<script>
	alert("<%=msg%>");
	<%if(k==1){%>
		location.href="admin_list.jsp"
	<%}else{%>
		window.history.back();
	<%}%>
</script>
<%}else{ %>
<script>
	alert("비정상적인 접근입니다.");
	location.href="../index.jsp";
</script>
<%} %>
</head>
<body>

</body>
</html>