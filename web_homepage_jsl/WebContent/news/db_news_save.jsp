<%@page import="dto.NewsDto"%>
<%@page import="dao.NewsDao"%>
<%@page import="common.CommonUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_session.jsp" %>
<%
	if(sessionLevel.equals("top")){
		request.setCharacterEncoding("utf-8");
		NewsDao dao = new NewsDao();
		String no = dao.getMaxNo();
		String title = request.getParameter("t_title");
		String content = request.getParameter("t_content");
		String reg_id = (String)session.getAttribute("sessionId");
		String reg_date = CommonUtil.getTodayTime();
		NewsDto dto = new NewsDto(no,title,content,reg_id,reg_date);
		int k = dao.insertDB(dto);
		String msg = "작성 실패";
		if(k==1) msg = "작성 성공";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>진행중..</title>
<script>
	alert("<%=msg%>")
	<%if(k==1){%>
		location.href="news_list.jsp";
	<%}else{%>
		window.history.back();
	<%}%>
</script>
</head>
<body>

</body>
<%}else{ %>
	<script>
		alert("관리자 계정이 아닙니다.");
		location.href="../index.jsp";
	</script>
<%} %>
</html>