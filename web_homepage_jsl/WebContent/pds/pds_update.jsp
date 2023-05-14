<%@page import="dto.PdsDto"%>
<%@page import="dao.PdsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<%
	if(!sessionLevel.equals("top")){
		%><script>
			alert("관리자만이 접근할 수 있습니다.");
			location.href="../index.jsp";
		</script><%
	}

	request.setCharacterEncoding("utf-8");
	PdsDao dao = new PdsDao();
	String no = request.getParameter("t_no");
	PdsDto dto = dao.viewDB(no);
%>
<script>
	function goUpdate(){
		if(checkValue(pds.t_title,"제목을"));
		else if(checkLength(pds.t_title,50,"제목은"));
		else if(checkValue(pds.t_content,"내용을"));
		else if(checkValue(pds.t_content,1000,"내용은"));
		else{
			pds.method="post";
			pds.action="db_pds_update.jsp";
			pds.submit();
		}
	}
</script>
	<div class="container">
	  <div class="write_wrap">
	  <h2 class="sr-only">자료실 글쓰기</h2>
	  <form name="pds" enctype="multipart/form-data">
	  <input type="hidden" name="t_no" value="<%=no %>">
	  <input type="hidden" name="t_ori_attach" value="<%=dto.getAttach() %>">
	  <!-- action을 처리하기전에 check()사용자 함수를 실행하고 되돌아 와라-->
			<table class="bord_table">
				<caption class="sr-only">자료실 입력 표</caption>
				<colgroup>
					<col width="20%">
					<col width="*">
				</colgroup>
				<tbody>
					<tr class="first">
						<th>글쓴이</th>
						<td><input type="text" value="<%=dto.getReg_name()%>" disabled></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" name="t_title" value="<%=dto.getTitle()%>"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="t_content"><%=dto.getContent() %></textarea></td>
					</tr>
					<tr>
						<th>첨부</th>
						<td>
							
							<%if(dto.getAttach()!=null){out.print(dto.getAttach()); %>&nbsp;&nbsp;
							삭제<input type="checkbox" name="t_check" style="width:15px;height:15px;">
							<%} %>
							<input type="file" name="t_attach">
						</td>
					</tr>
				</tbody>
			</table>
			<div class="btn_wrap">
				<input type="button" value="저장" onClick="goUpdate()" class="btn_ok">&nbsp;&nbsp;
				<input type="button" value="목록" class="btn_list" onClick="location.href='pds_list.jsp';">
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





