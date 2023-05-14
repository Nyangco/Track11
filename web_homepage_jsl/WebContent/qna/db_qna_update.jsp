<%@page import="dao.QnaDao"%>
<%@page import="dto.QnaDto"%>
<%@page import="common.CommonUtil"%>
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
				alert("Q & A를 수정하시려면 로그인 해주세요.");
				location.href="../login/member_login.jsp";
			</script>
		<%
	}else if(!sessionId.equals(id)){
		%>
			<script>
				alert("Q & A의 수정은 본인만 가능합니다.");
				location.href="qna_list.jsp";
			</script>
		<%
	}else{
		QnaDao dao = new QnaDao();
		String no = request.getParameter("t_no");
		String title = request.getParameter("t_title");
		String content = request.getParameter("t_content");
		String attach = request.getParameter("t_attach");
		String up_date = CommonUtil.getTodayTime();
		QnaDto dto = new QnaDto(no,"","",title,content,attach,"","",up_date,0);
		int k = dao.updateDB(dto);
		String msg = "수정 실패";
		if(k==1) msg = "수정 성공";
%>
<head>
<meta charset="UTF-8">
<title>진행중...</title>
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