<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dto.*,dao.*" %>
<%
	
	request.setCharacterEncoding("utf-8");
	Member_dao dao = new Member_dao();
	
	String id = request.getParameter("t_id");
	String age = request.getParameter("t_age");
	if(age.equals("")) age = "0";
	int ageNumber = Integer.parseInt(age);
	String name = request.getParameter("t_name");
	String reg_date = request.getParameter("t_reg_date");
	
	Member_dto dto = new Member_dto(id,name,ageNumber,reg_date);
	int result = dao.getUpdate(dto);
	
	String msg = "수정성공!";
	if(result != 1) msg = "수정실패!";


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