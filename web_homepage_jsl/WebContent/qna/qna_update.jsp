<%@page import="dto.QnaDto"%>
<%@page import="dao.QnaDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
	String no = request.getParameter("t_no");
	String id = request.getParameter("t_id");
	String reply = request.getParameter("t_reply");
	if(sessionLevel.equals("")){
		%>
			<script>
				alert("Q & A를 수정하시려면 로그인 해주세요.");
				location.href="../login/member_login.jsp";
			</script>
		<%
	}else if(!sessionId.equals(id)){
		%><script>
				alert("Q & A의 수정은 본인만 가능합니다.");
				location.href="qna_list.jsp";
		</script><%
	}else if(!reply.equals("null")){
		%><script>
			alert("답변이 달린 Q & A 는 수정이 불가능합니다.");
			location.href="qna_list.jsp";
		</script><%
	}else{
		QnaDao dao = new QnaDao();
		QnaDto dto = dao.updateListDB(no);
		String up_date="";
		if(dto.getUp_date()==null) up_date="수정 기록 없음";
		else up_date=dto.getUp_date();
%>
<script>
  	function goUpdate(){
  		if(checkValue(qna.t_title,"제목을"));
  		else if(checkLength(qna.t_title,50,"제목은"));
  		else if(checkValue(qna.t_content,"내용을"));
  		else if(checkLength(qna.t_content,1000,"내용은"));
  		else{
  			qna.method="post";
  			qna.action="db_qna_update.jsp";
  			qna.submit();
  		}
  	}
</script>
	<div class="container">
	  <div class="write_wrap">
	  <h2 class="sr-only">질문과 답변 글쓰기</h2>
	  <form name="qna">
	<input type="hidden" name="t_no" value="<%=no%>">
	<input type="hidden" name="t_id" value="<%=id%>">
		  <!-- action을 처리하기전에 check()사용자 함수를 실행하고 되돌아 와라-->
			<table class="bord_table">
				<caption class="sr-only">공지사항 입력 표</caption>
				<colgroup>
					<col width="20%">
					<col width="30%">
					<col width="20%">
					<col width="30%">
				</colgroup>
				<tbody>
					<tr class="first">
						<th>글쓴이</th>
						<td colspan="3"><input type="text" value="<%=dto.getName()%>" readonly></td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="3"><input type="text" name="t_title" value="<%=dto.getTitle()%>"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3"><textarea name="t_content"><%=dto.getContent() %></textarea></td>
					</tr>
					<tr>
						<th>작성일</th>
						<td><input type="text" value="<%=dto.getReg_date()%>" disabled style="border:none;"></td>
						<th>최종 수정일</th>
						<td><input type="text" value="<%=up_date%>" disabled style="border:none;"></td>
					</tr>
				</tbody>
			</table>
			<div class="btn_wrap">
				<input type="button" value="저장" class="btn_ok" onclick="goUpdate()">&nbsp;&nbsp;
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