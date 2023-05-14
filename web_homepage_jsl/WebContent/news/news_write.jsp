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
		  var k=(news.t_content.value.length+1);
		  k +="/1000 자";
		  news.length.value=k;
		}
		function goSave(){
			if(checkValue(news.t_title,"제목을"));
			else if(checkLength(news.t_title,50,"제목은"));
			else if(checkValue(news.t_content,"내용을"));
			else if(checkLength(news.t_content,1000,"내용은"));
			else{
				news.method="post";
				news.action="db_news_save.jsp";
				news.submit();
			}
		}
					
				</script>
	  <form name="news">
			<table class="bord_table">
				<caption class="sr-only">뉴스 입력 표</caption>
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
						<textarea name="t_content" onkeypress="calContent()"></textarea>
						<div style="float:right;">
						<input type="text" name="length" value ="0/1000 자" style="border:none;width:100px;display:inline;" disabled>
						</div>
						</td>
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
				<input type="button" value="목록" class="btn_list" onClick="location.href='news_list.jsp';">
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









