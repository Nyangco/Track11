<%@page import="dto.NewsDto"%>
<%@page import="dao.NewsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
	NewsDao dao = new NewsDao();
	String no = request.getParameter("t_no");
	NewsDto dto = dao.viewDB(no);
	dao.addHit(no);
%>
<script>
	function goUpdate(){
		notice.method="post";
		notice.action="news_update.jsp";
		notice.submit();
	}
	function goDelete(){
		var cfm = confirm('정말로 삭제하시겠습니까?');
		if(cfm){
			notice.method="post";
			notice.action="db_news_delete.jsp";
			notice.submit();
		}
	}
	function goView(no){
		viewNoti.t_no.value=no;
		viewNoti.method="post";
		viewNoti.action="news_view.jsp";
		viewNoti.submit();
	}
</script>
<form name="viewNoti">
	<input type="hidden" name="t_no">
</form>
<form name="notice">
	<input type="hidden" name="t_no" value="<%=no %>">
</form>
	<div class="container">
		<div class="board_view">
			<h2><%=dto.getTitle() %></h2>
			<p class="info"><span class="user"><%=dto.getReg_name() %></span> | <%=dto.getReg_date() %> | <i class="fa fa-eye"></i> <%=dto.getHit() %> | <%=dto.getUpdate_date() %></p> 
			<div class="board_body">
				<textarea style="resize:none;" disabled><%=dto.getContent() %></textarea>
			</div>
			<div class="prev_next">
				<%
					NewsDto preDto = dao.titleDB(no,"pre");
					NewsDto proDto = dao.titleDB(no,"pro");
					if(preDto!=null){
				%>
				<a href="javascript:goView('<%=preDto.getNo()%>')" class="btn_prev"><i class="fa fa-angle-left"></i>
				<span class="prev_wrap">
					<strong>이전글</strong><span><%=preDto.getTitle()%></span>
				</span>
				</a>
				<%}%>
				<div class="btn_3wrap">
					<a href="news_list.jsp">목록</a> 
					<%if(sessionLevel.equals("top")) {%>
					<a href="javascript:goUpdate()">수정</a> 
					<a href="javascript:goDelete()">삭제</a>
					<%} %>
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
	

<%@include file="../common_footer.jsp" %>








