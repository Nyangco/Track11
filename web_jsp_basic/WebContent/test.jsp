<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*,dao.*,java.util.*" %>
    
<%
    	TestDto dto = new TestDto("홍길동","대전",26);
            TestDao dao = new TestDao();
         	int total = dao.getTotal(50, 60);
            ArrayList<TestDto> arr = dao.getList();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
성명 : <%=dto.getName() %><br>
지역 : <%=dto.getArea() %><br>
나이 : <%=dto.getAge() %><br>
총점 : <%=total %><hr>
<%	
	for(int k = 0 ; k < arr.size() ; k++){
		out.print(arr.get(k).getName());
	 	out.print(arr.get(k).getArea());
	 	out.print(arr.get(k).getAge());
	 	out.print("<br>");
	}				
%>
<br><br><hr>
<%
	for(int k = 0 ; k < arr.size() ; k++){
%>		
		성명 : <%=arr.get(k).getName() %>
		지역 : <%=arr.get(k).getArea()%>
		나이 : <%=arr.get(k).getAge() %>
		<br>
<% 		
	}
%>
</body>
</html>