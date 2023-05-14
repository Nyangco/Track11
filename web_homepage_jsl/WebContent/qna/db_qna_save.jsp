<%@page import="dto.QnaDto"%>
<%@page import="common.CommonUtil"%>
<%@page import="dao.QnaDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_session.jsp" %>
<!DOCTYPE html>
<html>
<%
	if(!sessionLevel.equals("member")){
		%>
			<script>
				alert("비정상적인 접근입니다.");
				location.href="../index.jsp";
			</script>
		<%
	}else{
		request.setCharacterEncoding("utf-8");
		QnaDao dao = new QnaDao();
		
		String title = request.getParameter("t_title");
		String content = request.getParameter("t_content");
		String attach = request.getParameter("t_attach");
		
		String no = dao.getMaxNo();
		String id = sessionId;
		String reg_date = CommonUtil.getTodayTime();
		
		QnaDto dto = new QnaDto(no,id,title,content,attach,reg_date);
		int k = dao.insertDB(dto);
		String msg = "작성 실패";
		if(k==1) msg = "작성 성공";
%>
<head>
<meta charset="UTF-8">
<title>진행중</title>
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
<%	}%>