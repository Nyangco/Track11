<%@page import="common.CommonUtil"%>
<%@page import="dto.PdsDto"%>
<%@page import="dao.PdsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
	PdsDao dao = new PdsDao();
	String no = request.getParameter("t_no");
	PdsDto dto = dao.viewDB(no);
	dao.addHit(no);
	PdsDto preDto = dao.titleDB(no,"pre");
	PdsDto proDto = dao.titleDB(no,"pro");
	String pdsDir = CommonUtil.getFile_dir("pds");
%>
<script>
	function goView(no){
		view.t_no=no;
		view.method="post";
		view.action="";
		view.submit();
	}
	function goDelete(){
		if(confirm("정말로 삭제하시겠습니까?")){
			view.method="post";
			view.action="db_pds_delete.jsp";
			view.submit();
		}
	}
	function goUpdate(){
		view.method="post";
		view.action="pds_update.jsp";
		view.submit();
	}
	function goDown(){
		down.method="post";
		down.action="../common/filedown.jsp";
		down.submit();
	}
</script>
<form name="down">
	<input type="hidden" name="t_fileDir" value="pds">
	<input type="hidden" name="t_fileName" value="<%=dto.getAttach()%>">
</form>
<form name="view">
	<input type="hidden" name="t_no" value="<%=no %>">
	<input type="hidden" name="t_attach" value="<%=dto.getAttach() %>">
</form>
	<div class="container">
		<div class="board_view">
			<h2><%=dto.getTitle() %></h2>
			<p class="info"><span class="user"><%=dto.getReg_name() %></span> | <%=dto.getReg_date() %> | <i class="fa fa-eye"></i> <%=dto.getHit() %></p>
			<div class="board_pds">
			첨부파일 : 
			<%if(dto.getAttach()!=null){%>
				<a href="javascript:void()" onClick="goDown()"><%=dto.getAttach() %></a>
			<%}else{ %>
				<p style="display:inline">첨부 파일 없음</p>
			<%} %>
			</div>
			<div class="board_body" style="word-break:break-all;white-space:pre-wrap;">
				<textarea readonly><%=dto.getContent() %></textarea>
			</div>
			<div class="prev_next">
			<%if(preDto!=null){ %>
				<a href="javascript:void()" onclick="goView('<%=preDto.getNo() %>')" class="btn_prev"><i class="fa fa-angle-left"></i>
				<span class="prev_wrap">
					<strong>이전글</strong><span><%=preDto.getTitle() %></span>
				</span>
				</a>
			<%} %>
				<div class="btn_3wrap">
					<a href="pds_list.jsp">목록</a> 
					<%if(sessionLevel.equals("top")){ %>
					<a href="javascript:void()" onClick="goUpdate()">수정</a> 
					<a href="javascript:void()" onClick="goDelete()">삭제</a>
					<%} %>
				</div>
			<%if(proDto!=null){ %>
				<a href="javascript:void()" onclick="goView('<%=proDto.getNo() %>')" class="btn_next">
				<span class="next_wrap">
					<strong>다음글</strong><span><%=proDto.getTitle() %></span>
				</span>
				<i class="fa fa-angle-right"></i></a>
			<%} %>
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








