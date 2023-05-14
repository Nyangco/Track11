<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<%
	if(!sessionLevel.equals("top")){
		%>
			<script>
				alert("답변은 관리자만 작성 가능합니다.");
				location.href="qna_list.jsp";
			</script>
		<%
	}else{
		request.setCharacterEncoding("utf-8");
		String no = request.getParameter("t_no");
		String sContent = request.getParameter("t_content");
		String title = request.getParameter("t_title");
		String reply = request.getParameter("t_reply");
%>
<script>
  	function goSave(){
  		if(checkValue(qna.t_content,"답변을"));
  		else if(checkLength(qna.t_content,1000,"답변은"));
  		else{
  			qna.method="post";
  			qna.action="db_qna_reply.jsp";
  			qna.submit();
  		}
  	}
</script>
	<div class="container">
	  <div class="write_wrap">
	  <h2 class="sr-only">질문과 답변 글쓰기</h2>
	  <form name="qna">
	  <input type="hidden" value="<%=no%>" name="t_no">
	  <!-- action을 처리하기전에 check()사용자 함수를 실행하고 되돌아 와라-->
			<table class="bord_table">
				<caption class="sr-only">공지사항 입력 표</caption>
				<colgroup>
					<col width="20%">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>원문 제목</th>
						<td><input type="text" value="<%=title%>" readonly></td>
					</tr>
					<tr>
						<th>원문</th>
						<td><textarea readonly style="resize:none;"><%=sContent%></textarea></td>
					</tr>
					<tr>
						<th>답변</th>
						<td><textarea name="t_content"><%=reply %></textarea></td>
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