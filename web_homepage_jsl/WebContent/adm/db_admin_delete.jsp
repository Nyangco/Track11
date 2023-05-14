<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_session.jsp" %>
<!DOCTYPE html>
<html>
<%
	if(!sessionAdmin.equals("true")){
		%><script>
			alert("비정상적인 접근입니다");
			window.history.back();
		</script><%
	}else{
		MemberDao dao = new MemberDao();
		String id = request.getParameter("t_id");
		int k = dao.deleteDB(id);
		String msg = "탈퇴 실패";
		if(k==1) msg = "탈퇴 성공";
%>
<script>
	alert("<%=msg%>");
	<%if(k==1){%>
		location.href="admin_list.jsp";
	<%}else{%>
		window.history.back();
	<%}%>
</script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
<%} %>
</html>