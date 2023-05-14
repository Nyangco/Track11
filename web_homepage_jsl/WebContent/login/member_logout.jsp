<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sessionName = (String)session.getAttribute("sessionName");
	String msg = "";
	if(sessionName==null){
		msg = "로그아웃 되었습니다.";
	}else{
		msg = sessionName+"님 로그아웃 되었습니다.";
	}
	session.invalidate();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>진행중...</title>
<script>
	alert("<%=msg%>");
	location.href="../index.jsp";
</script>
</head>
<body>

</body>
</html>