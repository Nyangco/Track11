<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*" %>
<%
	request.setCharacterEncoding("utf-8");
	Member_dao dao = new Member_dao();
	
	String id = request.getParameter("t_id");
	
	int result = dao.getDelete(id);
	String msg = "삭제성공!";
	if(result != 1) msg = "삭제실패!";
%>


<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="member_list.jsp";

</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>