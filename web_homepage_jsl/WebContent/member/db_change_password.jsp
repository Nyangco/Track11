<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>진행중..</title>
<%
	request.setCharacterEncoding("utf-8");
	MemberDao dao = new MemberDao();
	String id = request.getParameter("t_id");
	String password = request.getParameter("t_pw_0");
	password = dao.encryptSHA256(password);
	String cPassword = dao.getPW(id);
	if(password.equals(cPassword)){
		password = dao.encryptSHA256(request.getParameter("t_pw_1"));
		int k = dao.changePW(id,password);
		String msg = "";
		if(k==1){
			%>
			<script>
				alert("수정 성공");
				location.href="../index.jsp";
			</script>
			<%
		}else{
			%>
			<script>
				alert("수정 실패");
				window.history.back();
			</script>
			<%		
		}
	}else{%>
		<script>
			alert("기존 비밀번호가 일치하지 않습니다.");
			window.history.back();
		</script>
	<%}%>
</head>
<body>

</body>
</html>