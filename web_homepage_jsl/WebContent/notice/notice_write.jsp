<%@page import="common.CommonUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<% 
	if(!sessionLevel.equals("top")){
		%>
			<script>
				alert("접근 권한이 없습니다.");
				location.href="../index.jsp";
			</script>
		<%}
%>
	<div class="container">
	  <div class="write_wrap">
	  <h2 class="sr-only">공지사항 글쓰기</h2>
	  <script>
	  function calContent(){
		  var k=(notice.t_contents.value.length+1);
		  k +="/1000 자";
		  notice.length.value=k;
		}
					function goSave(){
						if(checkValue(notice.t_title,"제목을"));
						else if(checkLength(notice.t_title,50,"제목은"));
						else if(checkValue(notice.t_contents,"내용을"));
						else if(checkLength(notice.t_title,1000,"내용은"));
						else{
							notice.method="post";
							notice.action="db_notice_save.jsp";
							notice.submit();
						}
					}
					
				</script>
	  <form name="notice" enctype="multipart/form-data">
	  <!-- 
	  <form name="notice" method="post" action="db_notice_save.jsp" onsubmit="return check()">
	  	action을 처리하기전에 check()사용자 함수를 실행하고 되돌아 와라
	  	onsubmit : ""가 true이면 전송된다.
	  -->
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
						<td colspan="3"><input type="text" name="t_title"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3">
						<textarea name="t_contents" onkeypress="calContent()"></textarea>
						<div style="float:right;">
						<input type="text" name="length" value ="0/1000 자" style="border:none;width:100px;display:inline;" disabled>
						</div>
						</td>
					</tr>
					<tr>
						<th>첨부</th>
						<td colspan="3"><input type="file" name="t_attach"></td>
					</tr>
					<tr>
						<th>등록자</th>
						<td><input type="text" value="<%=sessionName %>" readonly style="border:none;"></td>
						<th>등록일</th>
						<td><input type="text" name="t_reg_date" value="<%=CommonUtil.getToday()%>" readonly style="border:none;"></td>
					</tr>
				</tbody>
			</table>
			<div class="btn_wrap">
				<input type="button" value="저장" class="btn_ok" onClick="javascript:goSave()">&nbsp;&nbsp;
				<input type="reset" value="다시쓰기" class="btn_reset">&nbsp;&nbsp;
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









