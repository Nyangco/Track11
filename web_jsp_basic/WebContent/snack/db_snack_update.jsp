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

	SnackDto dto = new SnackDto(p_code,p_name,m_code,Integer.parseInt(price));
	int result = dao.snackUpdate(dto);
	String msg = "수정성공!";
	if(result != 1){
		msg = "수정실패!";
	}
	
	
%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="snack_list.jsp";
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>