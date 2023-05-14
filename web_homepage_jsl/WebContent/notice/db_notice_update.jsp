<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="common.CommonUtil"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="dao.NoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_session.jsp" %>
<%
	if(sessionLevel.equals("top")){
		request.setCharacterEncoding("utf-8");
		
		NoticeDao dao = new NoticeDao();
		
		String noticeDir = CommonUtil.getFile_dir("notice");
		int maxSize = 1024 * 1024 * 10;
		
		MultipartRequest mpr = new MultipartRequest(request,noticeDir,maxSize,"utf-8",new DefaultFileRenamePolicy());
		String no = mpr.getParameter("t_no");
		String title = mpr.getParameter("t_title");
		String content = mpr.getParameter("t_content");
		String attachDelete = mpr.getParameter("t_attachDelete");
		String oriAttach = mpr.getParameter("t_ori_attach");
		String deleteAttach = "n";
		String attach = mpr.getFilesystemName("t_attach");
		
		if(attachDelete!=null){
			File f = new File(noticeDir+oriAttach);
			boolean tf = f.delete();
			deleteAttach = "y";
			if(!tf) System.out.print("공지 첨부 삭제 실패:");
		}
		if(attach!=null){
			File f = new File(noticeDir+oriAttach);
			boolean tf = f.delete();
		}
		
		int k = dao.updateDB(no,title,content,attach,deleteAttach,oriAttach);
		
		String msg = "수정 실패";
		if(k==1) msg = "수정 완료";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>진행중..</title>
<script>
	alert("<%=msg%>");
	<%if(k==1){%>
		location.href="notice_list_new.jsp";
	<%}else{%>
		window.history.back();
	<%}%>
</script>
<%}else{ %>
<script>
	alert("접근 권한이 없습니다.");
	location.href="../index.jsp";
</script>
<%} %>
</head>
<body>

</body>
</html>