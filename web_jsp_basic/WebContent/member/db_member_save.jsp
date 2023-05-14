<%@page import="dto.*,dao.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("utf-8");
    Member_dao dao = new Member_dao();
    
    String id = request.getParameter("t_id");
    out.print("id :"+id+"<br>");
    
    String name = request.getParameter("t_name");
   	out.print("name : "+name+"<br>");
    
    String age = request.getParameter("t_age");
    if(age.equals("")) age = "0";
    int ageNumber = Integer.parseInt(age);   
    out.print("ageNumber : "+ageNumber+"<br>");
    
    String reg_date = request.getParameter("t_reg_date");
    out.print("reg_date : "+reg_date+"<br>");
   
    Member_dto dto = new Member_dto(id,name,ageNumber,reg_date);
    int result = dao.MemberSave(dto); 
   
   	String msg = "등록성공!";
   	if(result != 1) msg = "등록실패!";
   		       
%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="member_list.jsp";
</script>

<title>Insert title here</title>
</head>
<body>

</body>
</html>