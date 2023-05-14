<%@page import="dto.NoticeDto"%>
<%@page import="dao.NoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<% 
	if(sessionLevel.equals("top")){
		request.setCharacterEncoding("utf-8");
		NoticeDao dao = new NoticeDao();
		String no = request.getParameter("t_no");
		NoticeDto dto = dao.viewDB(no);
%>
	<div class="container">
	  <div class="write_wrap">
	  <h2 class="sr-only">공지사항 글쓰기</h2>
	  <script>
	  function goUpdate(){
		  if(checkValue(notice.t_title,"제목을"));
		  else if(checkLength(notice.t_title,50,"제목은"));
		  else if(checkValue(notice.t_content,"내용을"));
		  else if(checkLength(notice.t_content,1000,"내용은"));
		  else{
			  notice.method="post";
			  notice.action="db_notice_update.jsp";
			  notice.submit();
		  }
	  }
	  function count(){
		  var count = notice.t_content.value.length;
		  notice.length.value=count+"/1000 자";
	  }
	  </script>
	  <form name="notice" enctype="multipart/form-data">
	  <!-- action을 처리하기전에 check()사용자 함수를 실행하고 되돌아 와라-->
	  	<input type="hidden" name="t_no" value=<%=no%>>
			<table class="bord_table">
				<caption class="sr-only">공지사항 입력 표</caption>
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="15%">
					<col width="35%">
				</colgroup>
				<tbody>
					<tr class="first">
						<th>제목</th>
						<td colspan="3"><input type="text" name="t_title" value="<%=dto.getTitle()%>"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3">
						<textarea name="t_content" onkeypress="calContent()"><%=dto.getContent()%></textarea>
						<div style="float:right;">
						<input type="text" name="length" value ="0/1000 자" style="border:none;width:100px;display:inline;" disabled>
						</div>
						</td>
					</tr>
					<tr>
						<th>첨부</th>
						<td colspan="3">
							<%if(dto.getAttach()!=null){ %>
							<p style="display:inline;"><%=dto.getAttach() %></p>
							&nbsp;&nbsp;삭제<input type="checkbox" name="t_attachDelete" value="y" style="height:15px;width:15px;">
							<input type="hidden" name="t_ori_attach" value="<%=dto.getAttach() %>">
							<%} %>		
							<input type="file" name="t_attach">					
						</td>
					</tr>
					<tr>
						<th>등록자</th>
						<td><input type="text" value="<%=dto.getReg_name()%>" readonly style="border:none;"></td>
						<th>등록일</th>
						<td><input type="text" name="t_reg_date" value="<%=dto.getReg_date()%>" readonly style="border:none;"></td>
					</tr>
				</tbody>
			</table>
			<div class="btn_wrap">
				<input type="button" value="저장" onclick="goUpdate()" class="btn_ok">&nbsp;&nbsp;
				<input type="button" value="목록" class="btn_list" onClick="location.href='notice_list.jsp';">
			</div>
		</form>
	  </div>
	  
	</div>
	<!-- end contents -->
	<script>
		$(function() {
			$(".location  .dropdown > a").on("click",function(e) {
				e.preventDefault();
				if($(this).next().is(":visible")) {
					$(".location  .dropdown > a").next().hide();
				} else {
					$(".location  .dropdown > a").next().hide();
					$(this).next().show();
				}
			});
		});
	</script>
	

<%@include file="../common_footer.jsp" %>
<%}else{ %>
	<script>
		alert("관리자 권한이 아닙니다.");
		location.href="../index.jsp";
	</script>
<%} %>









