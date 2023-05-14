<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="dto.NoticeDto"%>
<%@page import="common.CommonUtil"%>
<%@page import="dao.NoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_session.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
	NoticeDao dao = new NoticeDao();
	int k = -1;
	String msg = "";
	String kkk = "";
	
	if(sessionLevel.equals("top")){
		String noticeDir = CommonUtil.getFile_dir("notice");
		int maxSize = 1024 * 1024 * 10;
		
		MultipartRequest mpr = new MultipartRequest(request,noticeDir,maxSize,"utf-8",new DefaultFileRenamePolicy());
		String no 		= dao.getMaxNo();
		String title 	= mpr.getParameter("t_title");
		String content 	= mpr.getParameter("t_contents");
		String attach 	= mpr.getFilesystemName("t_attach");
		String reg_id 	= sessionId;
		String reg_date = CommonUtil.getTodayTime();
		//String reg_date = CommonUtil.getToday();
		
		NoticeDto dto = new NoticeDto(no,title,content,attach,reg_id,reg_date);
		k = dao.noticeSave(dto);
		kkk = attach;
	}
	
	switch(k){
	case 1:
		msg="등록 성공";
		break;
	case -1:
		msg="로그인 정보가 만료되었거나 관리자가 아닙니다.";
		break;
	default:
		msg="등록 실패";
		break;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>진행중..</title>
<script>
	alert("<%=msg%>")
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