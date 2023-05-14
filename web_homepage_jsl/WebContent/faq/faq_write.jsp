<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<% 
	if(!sessionLevel.equals("top")){
		%>
			<script>
				alert("접근 권한이 없습니다.");
				location.href="../index.jsp";
			</script>
		<%}
%>
	<!-- sub contents -->
	<div class="sub_title">
		<h2>자주하는 질문(FAQ)</h2>
		<div class="container">
		  <div class="location">
			<ul>
				<li class="btn_home">
					<a href="../index.jsp"><i class="fa fa-home btn_plus"></i></a>
				</li>
				<li class="dropdown">
					<a href="">커뮤니티<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="gratings.jsp">공지사항</a>
						<a href="allclass.jsp">학과및모집안내</a>
						<a href="portfolio.jsp">포트폴리오</a>
						<a href="online.jsp">온라인접수</a>
						<a href="../notice/notice_list.jsp">커뮤니티</a>
					</div>
				</li>
				<li class="dropdown">
					<a href="">자주하는질문<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="../notice/notice_list.jsp">공지사항</a>
						<a href="../qna/qna_list.jsp">질문과답변</a>
						<a href="faq_list.jsp">자주하는질문</a>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>
<script>
	function goSave(){
		if(checkValue(faq.t_title,"제목을"));
		else if(checkLength(faq.t_title,50,"제목은"));
		else if(checkValue(faq.t_content,"내용을"));
		else if(checkLength(faq.t_content,1000,"내용은"));
		else{
			faq.method="post";
			faq.action="db_faq_save.jsp";
			faq.submit();
		}
	}
	function calContent(){
	  var k=(faq.t_content.value.length+1);
	  k +="/1000 자";
	  faq.length.value=k;
	}
</script>
	<div class="container">
	  <div class="write_wrap">
	  <h2 class="sr-only">글쓰기</h2>
	  <form name="faq">
			<table class="bord_table">
				<caption class="sr-only">자주하는 질문 입력 표</caption>
				<colgroup>
					<col width="20%">
					<col width="*">
				</colgroup>
				<tbody>
					
					<tr>
						<th>제목</th>
						<td><input type="text" name="t_title"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
						<textarea name="t_content" onkeypress="calContent()"></textarea>
							<div style="float:right;">
							<input type="text" name="length" value ="0/1000 자" style="border:none;width:100px;display:inline;" disabled>
							</div>
						</td>
					</tr>
					
				</tbody>
			</table>
			<div class="btn_wrap">
				<input type="button" value="저장" class="btn_ok" onclick="goSave()">&nbsp;&nbsp;
				<input type="button" value="목록" class="btn_list" onClick="location.href='faq_list.jsp';">
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
	

<%@ include file="../common_footer.jsp" %>









