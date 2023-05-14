<%@page import="dao.QnaDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>]
<%@ include file="../common_session.jsp" %>
<!DOCTYPE html>
<html>
<% if(!sessionLevel.equals("top")){
		%>
			<script>
				alert("비정상적인 접근입니다.");
				location.href="../index.jsp";
			</script>
		<%
	}else{
		request.setCharacterEncoding("utf-8");
		QnaDao dao = new QnaDao();

		String no = request.getParameter("t_no");
		String content = request.getParameter("t_content");
		
		int k = dao.replyDB(no,content);
		String msg = "답변 실패";
		if(k==1) msg = "답변 성공";
%>
<head>
<meta charset="UTF-8">
<title>진행중..</title>
<script>
	alert("<%=msg%>");
	<%if(k==1){%>
		location.href="qna_list.jsp";
	<%}else{%>
		window.history.back();
	<%}%>
</script>
</head>
<body>

</body>
</html>
<%}%>