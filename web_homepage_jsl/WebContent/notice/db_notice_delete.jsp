<%@page import="common.CommonUtil"%>
<%@page import="java.io.File"%>
<%@page import="dao.NoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String no = request.getParameter("t_no");
	String attach = request.getParameter("t_attach");
	if(attach==null) attach="";
	String noticeDir = CommonUtil.getFile_dir("notice");
	NoticeDao dao = new NoticeDao();
	if(!attach.equals("")){
		File f = new File(noticeDir+attach);
		boolean tf = f.delete();
		
		System.out.print(tf);
		if(!tf) System.out.print("공지 첨부 삭제 실패:");
	}
	System.out.print(noticeDir+attach);
	int k = dao.deleteDB(no);
	String msg="삭제 실패";
	if(k==1) msg="삭제 성공";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	alert("<%=msg%>");
	<%if(k==1){%>
		location.href="notice_list.jsp";
	<%}else{%>
		window.history.back();
	<%}%>
</script>
</head>
<body>

</body>
</html>