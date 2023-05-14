<%@page import="dto.QnaDto"%>
<%@page import="dao.QnaDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
	QnaDao dao = new QnaDao();
	String no = request.getParameter("t_no");
	if(no==null){
		%><script>
		alert("정상적인 경로로 접근해주세요");
		window.history.back();
		</script><%
	}else{
		dao.addHit(no);
		QnaDto dto = dao.viewDB(no);
	
%>
<script>
	function goReply(){
		qna.method="post";
		qna.action="qna_reply.jsp";
		qna.submit();
	}
	function goUpdate(){
		qna.method="post";
		qna.action="qna_update.jsp";
		qna.submit();
	}
	function goView(no){
		qna.t_no.value=no;
		qna.method="post";
		qna.action="qna_view.jsp";
		qna.submit();
	}
	function goDelete(){
		var cfm = confirm("정말 삭제하시겠어요?");
		if(cfm){
			qna.method="post";
			qna.action="db_qna_delete.jsp";
			qna.submit();
		}
	}
</script>
<form name = "qna">
	<input type="hidden" name="t_no" value="<%=no %>">
	<input type="hidden" name="t_content" value="<%=dto.getContent() %>">
	<input type="hidden" name="t_id" value="<%=dto.getId() %>">
	<input type="hidden" name="t_reply" value="<%=dto.getReply()%>">
	<input type="hidden" name="t_title" value="<%=dto.getTitle() %>">
</form>
	<div class="container">
		<div class="board_view">
			<h2><%=dto.getTitle() %></h2>
			<p class="info"><span class="user"><%=dto.getName() %></span> | <%=dto.getReg_date() %> | <i class="fa fa-eye"></i> <%=dto.getHit() %>
			<%if(dto.getUp_date()!=null) out.print(" | "+dto.getUp_date()); %></p>
			<div class="board_body">
				<textarea style="resize:none" disabled><%=dto.getContent() %></textarea>
				<%if(dto.getReply()!=null){ %>
				<p style="font-weight:bold">답변</p>
				<textarea style="resize:none" disabled><%=dto.getReply() %></textarea>
				<%} %>

<script type="text/javascript">
//<![CDATA[
$(document).ready(function(){
	$(".answerButt").toggle(function(){
		$(".answerArea").slideDown(500);	
	}, function(){
		$(".answerArea").slideUp(500);
	})
});
//]]>
</script>
<style>
	.answerArea{display:none} 
	.btn_3wrap span {
		padding: 12px 18px;
		display: inline-block;
		border: 1px solid #878787;
	}
	.answerArea .textArea_H120{
		padding:5px;
		width:700px;
		height:120px;
	}	
	.answerArea .saveButt{
		float:right;
		padding: 12px 18px;
		display: inline-block;
		border: 1px solid #878787;
	}	
</style>
				
			<!-- 답변 -->
			<form name="answer">
				<div class="answerArea">
					<input type="hidden" name="t_no" value="">
					<textarea name="t_answer" class="textArea_H120"></textarea>
					<a href="javascript:goAnswerSave()" class="saveButt">Answer Save</a>
				</div>
			</form>					
			</div>
			
			<div class="prev_next">
				<%
					QnaDto preDto = dao.titleDB(no,"pre");
					QnaDto proDto = dao.titleDB(no,"pro");
					if(preDto!=null){
				%>
				<a href="javascript:goView('<%=preDto.getNo()%>')" class="btn_prev"><i class="fa fa-angle-left"></i>
				<span class="prev_wrap">
					<strong>이전글</strong><span><%=preDto.getTitle()%></span>
				</span>
				</a>
				<%}%>
				<div class="btn_3wrap">
					<a href="qna_list.jsp">목록</a> 
					<%if(sessionId.equals(dto.getId())&&dto.getReply()==null){ %>
					<a href="javascript:goUpdate()">수정</a> 
					<%}if(sessionLevel.equals("top") || (sessionId.equals(dto.getId())&&dto.getReply()==null)){ %>
					<a href="javascript:goDelete()">삭제</a> 
					<%}if(sessionLevel.equals("top")){ %>
					<a href="javascript:goReply()">답변 달기</a>
					<%} %>
					<span class="answerButt" style="cursor:pointer">Answer</span>
					
				</div>
				<%	if(proDto!=null){ %>
				<a href="javascript:goView('<%=proDto.getNo()%>')" class="btn_next">
				<span class="next_wrap">
					<strong>다음글</strong><span><%=proDto.getTitle()%></span>
				</span>
				<i class="fa fa-angle-right"></i></a>
				<%	} %>
			</div>
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









