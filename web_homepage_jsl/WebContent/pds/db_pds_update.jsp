<%@page import="java.io.File"%>
<%@page import="dao.PdsDao"%>
<%@page import="dto.PdsDto"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="common.CommonUtil"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_session.jsp" %>
<!DOCTYPE html>
<html>
<%
	request.setCharacterEncoding("utf-8");
	PdsDao dao = new PdsDao();

	String pdsDir = CommonUtil.getFile_dir("pds");
	int maxSize = 1024 * 1024 * 10 ;
	
	MultipartRequest mpr = new MultipartRequest(request,pdsDir,maxSize,"utf-8",new DefaultFileRenamePolicy());
	String no = mpr.getParameter("t_no");
	String title = mpr.getParameter("t_title");
	String content = mpr.getParameter("t_content");
	String check = mpr.getParameter("t_check");
	String oriAttach = mpr.getParameter("t_ori_attach");
	String attach = mpr.getFilesystemName("t_attach");
	
	String id = sessionId;
	
	int k = dao.updateDB(no, title, content, attach, check);
	String msg = "수정 실패";
	if(k==1) msg = "수정 완료";
	
	if(!(check==null && attach==null)){
		File f = new File(pdsDir+oriAttach);
		boolean tf = true;
		if(f.exists()) tf = f.delete();
		if(!tf) System.out.print("파일 제거 오류");
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