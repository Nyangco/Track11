<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String url = (String)request.getAttribute("t_url");
	String msg = (String)request.getAttribute("t_msg");
	String requestPage = (String)request.getAttribute("t_page");
	request.setAttribute("t_requestPage", requestPage);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>진행중</title>
<script>
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>
</head>
<body>

</body>
</html>