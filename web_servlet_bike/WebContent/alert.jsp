<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = (String)request.getAttribute("t_msg");
	if(msg==null) msg=request.getParameter("t_msg");
	if(msg==null) msg="잘못된 접근입니다";
	String url = (String)request.getAttribute("t_url");
	if(url==null) url=request.getParameter("t_url");
	if(url==null) url="Index";
	request.setAttribute("t_requestPage", (String)request.getAttribute("t_nextPage"));
	
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