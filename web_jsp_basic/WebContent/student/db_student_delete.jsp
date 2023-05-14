<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*" %>
<%
	StudentDao dao = new StudentDao();
	String syear = request.getParameter("t_syear");
	String sclass = request.getParameter("t_sclass");
	String sno = request.getParameter("t_sno");
	
	int result = dao.studentDelete(syear,sclass,sno);
	String msg = "삭제성공!";
	if(result != 1){
		msg = "삭제실패!";
	}

%>
<!DOCTYPE html>
<html>
<head>
<script>
	alert("<%=msg%>");
	location.href="student_list.jsp";

</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>