<%@page import="dao.NewsDao"%>
<%@page import="dto.NewsDto"%>
<%@page import="common.CommonUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_session.jsp" %>
<%
	if(sessionLevel.equals("top")){
		NewsDao dao = new NewsDao();
		String no = request.getParameter("t_no");
		int k = dao.deleteDB(no);
		String msg = "삭제 실패";
		if(k==1) msg = "삭제 성공";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>진행중</title>
<script>
	alert("<%=msg%>");
	<%if(k==1){%>
		location.href="news_list.jsp";
	<%}else{%>
		window.history.back();
	<%}%>
</script>
</head>
<body>

</body>
<%} else{ %>
	<script>
		alert("관리자 권한이 아닙니다.");
		window.history.back();
	</script>
<%} %>
</html>