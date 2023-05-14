<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*,dao.*" %>
<%
	request.setCharacterEncoding("utf-8");
	SnackDao dao = new SnackDao();
	
	String p_code = request.getParameter("t_p_code");
	String p_name = request.getParameter("t_p_name");
	String price = request.getParameter("t_price");		
	String m_code = request.getParameter("t_m_code");
	
	int checkCount = dao.checkPcode(p_code);
	
	int result = 0;
	String msg = "등록성공!";
	if(checkCount == 0){	
		SnackDto dto = new SnackDto(p_code, p_name, m_code, Integer.parseInt(price));
		result = dao.getSaveSnack(dto);
		if(result != 1) msg = "등록실패~";
	}else {
		msg = "중복된 제품코드~";
	}
	   
    
    
%>    

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	alert("<%=msg %>");
	
	<% if(result == 1){ %>	
			location.href="snack_list.jsp";
	<% } else{ %>
			location.href="snack_write.jsp";
			//window.history.back();
	<% }%>
	
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>