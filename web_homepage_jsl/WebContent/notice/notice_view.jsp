<%@page import="dto.NoticeDto"%>
<%@page import="dao.NoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
	NoticeDao dao = new NoticeDao();
	String no = request.getParameter("t_no");
	NoticeDto dto = dao.viewDB(no);
	dao.addHit(no);
	String dir = request.getRequestURI();
	dir = dir.substring(1);
	dir = dir.substring(dir.indexOf("/")+1);
	dir = dir.substring(0,dir.indexOf("/"));
%>
<script>
	function goUpdate(){
		notice.method="post";
		notice.action="notice_update.jsp";
		notice.submit();
	}
	function goDelete(){
		var cfm = confirm('정말로 삭제하시겠습니까?');
		if(cfm){
			notice.method="post";
			notice.action="db_notice_delete.jsp";
			notice.submit();
		}
	}
	function goView(no){
		viewNoti.t_no.value=no;
		viewNoti.method="post";
		viewNoti.action="notice_view.jsp";
		viewNoti.submit();
	}
	function goDown(){
		
	}
</script>
<form name="down">
	<input type="hidden" name="t_fileDir" value="<%=dir%>">
	<input type="hidden" name="t_fileName" value="<%=dto.getAttach() %>">
</form>
<form name="viewNoti">
	<input type="hidden" name="t_no">
</form>
<form name="notice">
	<input type="hidden" name="t_no" value="<%=no %>">
	<input type="hidden" name="t_attach" value="<%=dto.getAttach()%>">
</form>
	<div class="container">
		<div class="board_view">
			<h2><%=dto.getTitle() %></h2>
			<p class="info"><span class="user"><%=dto.getReg_name() %></span> | <%=dto.getReg_date() %> | <i class="fa fa-eye"></i> <%=dto.getHit() %></p>
			<div class="board_body">
				<textarea style="resize:none;" disabled><%=dto.getContent() %></textarea>
				<%
					if(!dto.getAttach().equals("")){
						if(dto.getAttach().indexOf("jpg")!=-1 || dto.getAttach().indexOf("png")!=-1){ 
				%>
					<img src="../attach/notice/<%=dto.getAttach() %>">
					
				<%} %>
					<p><img src="../images/attach.png"><a href="javascript:goDown()"><%=dto.getAttach() %></a></p>
				<%} %>
				
				
			</div>
			<div class="prev_next">
				<%
					NoticeDto preDto = dao.titleDB(no,"pre");
					NoticeDto proDto = dao.titleDB(no,"pro");
					if(preDto!=null){
				%>
				<a href="javascript:goView('<%=preDto.getNo()%>')" class="btn_prev"><i class="fa fa-angle-left"></i>
				<span class="prev_wrap">
					<strong>이전글</strong><span><%=preDto.getTitle()%></span>
				</span>
				</a>
				<%}%>
				<div class="btn_3wrap">
					<a href="notice_list.jsp">목록</a> 
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








