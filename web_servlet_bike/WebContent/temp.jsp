<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=request.getParameter("t_id") %><br>
<%=request.getParameter("t_name") %><br>
<%=request.getParameter("t_password") %><br>
<%=request.getParameter("t_area") %><br>
<%=request.getParameter("t_address") %><br>
<%=request.getParameter("t_tell_1") %><br>
<%=request.getParameter("t_tell_2") %><br>
<%=request.getParameter("t_tell_3") %><br>
<%=request.getParameter("t_gender") %><br>
<%=request.getParameter("t_hobby_travel_c") %><br>
<%=request.getParameter("t_hobby_reading_c") %><br>
<%=request.getParameter("t_hobby_sports_c") %><br>
</body>
</html>