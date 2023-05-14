<%@page import="dto.PdsDto"%>
<%@page import="dao.PdsDao"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="common.CommonUtil"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="../common_session.jsp" %>
<%if(!sessionLevel.equals("top")) {%>
	<script>
		alert("관리자가 아닙니다.");
		location.href="../index.jsp";
	</script>
<%} 
	PdsDao dao = new PdsDao();
	String pdsDir = CommonUtil.getFile_dir("pds");
	int maxSize = 1024 * 1024 * 10;
	
	MultipartRequest mpr = new MultipartRequest(request,pdsDir,maxSize,"utf-8",new DefaultFileRenamePolicy());
	String reg_id = mpr.getParameter("t_reg_id");
	String title = mpr.getParameter("t_title");
	String content = mpr.getParameter("t_content");
	
	String attach = mpr.getFilesystemName("t_attach");
	
	String no = dao.getMaxNo();
	String reg_date = CommonUtil.getTodayTime();
	
	PdsDto dto = new PdsDto(no,title,content,attach,reg_id,reg_date,"",0);
	int k = dao.pdsSave(dto);
	String msg = "저장 실패";
	if(k==1) msg = "저장 성공";
%>
<head>
<meta charset="UTF-8">
<title>진행중..</title>
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