<%@page import="dao.PdsDao"%>
<%@page import="java.io.File"%>
<%@page import="common.CommonUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_session.jsp" %>
<!DOCTYPE html>
<html>
<%
	PdsDao dao = new PdsDao();
	String no = request.getParameter("t_no");
	String attach = request.getParameter("t_attach");
	
	int k = dao.deleteDB(no);
	String msg = "삭제 실패";
	if(k==1) msg = "삭제 성공";
	
	if(attach!=null){
		String pdsDir = CommonUtil.getFile_dir("pds");
		File f = new File(pdsDir+attach);
		if(!f.delete()) System.out.print("파일 제거 오류");
	}
%>
<head>
<meta charset="UTF-8">
<title>진행중</title>
<script>
	alert("<%=msg%>");
	<%if(k==1){%>
		location.href="pds_list.jsp";
	<%}else{%>
		window.history.back();
	<%}%>
</script>
</head>
<body>

</body>
</html>