<%@page import="dto.MemberDto"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	MemberDao dao = new MemberDao();
	
	String id = request.getParameter("t_id");
	String password = request.getParameter("t_password");
	password = dao.encryptSHA256(password);
	
	MemberDto dto = dao.checkLogin(id, password);
	String msg = "", url="";
	if(dto==null){
		msg="id 혹은 비밀번호가 잘못 입력되었습니다.";
		url="member_login.jsp";
	}else if(dto.getTell_1().equals("1")){
		msg="탈퇴한 회원입니다";
		url="member_login.jsp";
	}else{
		msg=dto.getName()+"님 환영합니다!";
		url="../index.jsp";
		dao.updateLogin(id);
		session.setAttribute("sessionName", dto.getName());
		session.setAttribute("sessionId", id);
		if(id.equals("manager")){
			session.setAttribute("sessionLevel","top");
		}else{
			session.setAttribute("sessionLevel","member");
		}
		session.setMaxInactiveInterval(60*60);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>
</head>
<body>

</body>
</html>