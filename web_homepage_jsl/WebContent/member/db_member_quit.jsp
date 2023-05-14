<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_session.jsp" %>
<!DOCTYPE html>
<html>
<%
	MemberDao dao = new MemberDao();
	String id = request.getParameter("t_id");
	String pw = request.getParameter("t_pw_1");
	if(!sessionId.equals(id)){
		%><script>
			alert("비정상적인 접근입니다");
			location.href="../index.jsp";
		</script><%
	}else if(dao.checkLogin(id, dao.encryptSHA256(pw))==null){
		%><script>
			alert("ID 또는 비밀번호가 일치하지 않습니다.");
			window.history.back();
		</script><%
	}else{
		int k = dao.deleteDB(id);
		String msg = "탈퇴에 실패하였습니다.";
		if(k==1) msg = "탈퇴되었습니다.";
		session.invalidate();
%>
<script>
	alert("<%=msg%>");
	<%if(k==1){%>
		location.href="../index.jsp";
	<%}else{%>
		window.history.back();
	<%}%>
</script>
<head>
<meta charset="UTF-8">
<title>실행중</title>
</head>
<body>

</body>
<%} %>
</html>