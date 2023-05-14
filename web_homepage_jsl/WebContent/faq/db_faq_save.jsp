<%@page import="dto.FaqDto"%>
<%@page import="dao.FaqDao"%>
<%@page import="common.CommonUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_session.jsp" %>
<!DOCTYPE html>
<html>
<% 
	if(!sessionLevel.equals("top")){
		%>
			<script>
				alert("접근 권한이 없습니다.");
				location.href="../index.jsp";
			</script>
		<%}
%>
<%
	request.setCharacterEncoding("utf-8");
	FaqDao dao = new FaqDao();

	String title = request.getParameter("t_title");
	String content = request.getParameter("t_content");
	
	String no = dao.getNo();
	String id = sessionId;
	String reg_date = CommonUtil.getTodayTime();
	
	FaqDto dto = new FaqDto(no,title,id,reg_date,content);
	int k = dao.insertDB(dto);
	String msg = "작성 실패";
	if(k==1) msg = "작성 성공";
%>
<head>
<meta charset="UTF-8">
<title>진행중..</title>
<script>
	alert("<%=msg%>");
	<%if(k==1){%>
		location.href="faq_list.jsp";
	<%}else{%>
		window.history.back();
	<%}%>
</script>
</head>
<body>

</body>
</html>