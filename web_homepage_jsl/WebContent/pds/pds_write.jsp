<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<%if(!sessionLevel.equals("top")) {%>
	<script>
		alert("관리자가 아닙니다.");
		location.href="../index.jsp";
	</script>
<%} %>
<script>
	function goSave(){
		if(checkValue(pds.t_title,"제목을"));
		else if(checkLength(pds.t_title,50,"제목은"));
		else if(checkValue(pds.t_content,"내용을"));
		else if(checkLength(pds.t_content,1000,"내용은"));
		else{
			pds.method="post";
			pds.action="db_pds_save.jsp";
			pds.submit();
		}
	}
</script>
	<div class="container">
	  <div class="write_wrap">
	  <h2 class="sr-only">자료실 글쓰기</h2>
	  <form name="pds" enctype="multipart/form-data">
	  <!-- action을 처리하기전에 check()사용자 함수를 실행하고 되돌아 와라-->
			<table class="bord_table">
				<caption class="sr-only">공지사항 입력 표</caption>
				<colgroup>
					<col width="20%">
					<col width="*">
				</colgroup>
				<tbody>
					<tr class="first">
						<th>글쓴이</th>
						<td>
							<input type="text" value="<%=sessionName%>" disabled>
							<input type="hidden" name="t_reg_id" value="<%=sessionId%>">
						</td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" name="t_title"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="t_content"></textarea></td>
					</tr>
					<tr>
						<th>첨부</th>
						<td><input type="file" name="t_attach"></td>
					</tr>
				</tbody>
			</table>
			<div class="btn_wrap">
				<input type="button" value="저장" onclick="goSave()" class="btn_ok">&nbsp;&nbsp;
				<input type="button" value="목록" class="btn_list" onClick="location.href='pds_list.jsp';">
			</div>
		</form>
	  </div>
	  
	</div>
	<!-- end contents -->
	<script>
		function check() {
			if(notice.writer.value=="") {
				alert("글쓴이 입력");
				notice.writer.focus();
				return false;
			}
			if(notice.title.value=="") {
				alert("제목을 입력");
				notice.title.focus();
				return false;
			}
			if(notice.contents.value=="") {
				alert("내용을 입력");
				notice.contents.focus();
				return false;
			}
			return true;
		}
	</script>
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
	

<%@ include file="../common_footer.jsp" %>








