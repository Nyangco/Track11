<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<%
	if(sessionLevel.equals("")){
		%>
			<script>
				alert("Q & A를 작성하시려면 로그인 해주세요.");
				location.href="../login/member_login.jsp";
			</script>
		<%
	}else if(sessionLevel.equals("top")){
		%>
			<script>
				alert("Q & A는 일반 회원만 작성 가능합니다.");
				location.href="qna_list.jsp";
			</script>
		<%
	}else{
%>
<script>
  	function goSave(){
  		if(checkValue(qna.t_title,"제목을"));
  		else if(checkLength(qna.t_title,50,"제목은"));
  		else if(checkValue(qna.t_content,"내용을"));
  		else if(checkLength(qna.t_content,1000,"내용은"));
  		else{
  			qna.method="post";
  			qna.action="db_qna_save.jsp";
  			qna.submit();
  		}
  	}
</script>
	<div class="container">
	  <div class="write_wrap">
	  <h2 class="sr-only">질문과 답변 글쓰기</h2>
	  <form name="qna">
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
						<td><input type="text" value="<%=sessionName%>" readonly></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" name="t_title"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="t_content"></textarea></td>
					</tr>
				</tbody>
			</table>
			<div class="btn_wrap">
				<input type="button" value="저장" class="btn_ok" onclick="goSave()">&nbsp;&nbsp;
				<input type="reset" value="다시쓰기" class="btn_reset">&nbsp;&nbsp;
				<input type="button" value="목록" class="btn_list" onClick="location.href='qna_list.jsp';">
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
<%} %>









