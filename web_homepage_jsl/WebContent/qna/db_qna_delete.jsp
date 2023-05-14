<%@page import="dao.QnaDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_session.jsp" %>
<!DOCTYPE html>
<html>
<%
    request.setCharacterEncoding("utf-8");
	String id = request.getParameter("t_id");
	if(sessionLevel.equals("")){
		%>
			<script>
				alert("비정상적인 접근입니다.");
				location.href="../login/member_login.jsp";
			</script>
		<%
	}else if(!sessionId.equals(id) && !sessionLevel.equals("top")){
		%>
			<script>
				alert("삭제 권한이 없습니다.");
				location.href="qna_list.jsp";
			</script>
		<%
	}else{
		QnaDao dao = new QnaDao();
		String no = request.getParameter("t_no");
		int k = dao.deleteDB(no);
		String msg="삭제 실패";
		if(k==1) msg="삭제 성공";
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
<%} %>
</html>