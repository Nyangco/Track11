<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String msg = (String)request.getAttribute("t_msg");
	if(msg==null) msg=request.getParameter("t_msg");
	if(msg==null) msg="잘못된 접근입니다";
	String url = (String)request.getAttribute("t_url");
	if(url==null) url=request.getParameter("t_url");
	if(url==null) url="Index";
	String requestPage = (String)request.getAttribute("t_nextPage");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>진행중</title>

</head>
<body>
<form name="t_alert">
	<input type="hidden" name="t_requestPage" value="<%=requestPage%>">
</form>
<script>
	alert("<%=msg%>");
	t_alert.method="post";
	t_alert.action="<%=url%>";
	t_alert.submit();
</script>
</body>
</html>