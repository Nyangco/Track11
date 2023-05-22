<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	function goSearch(){
		notice.method="post";
		notice.action="Notice";
		notice.submit();
	}function goPage(page){
		notice.t_nowPage.value=page;
		notice.method="post";
		notice.action="Notice";
		notice.submit();
	}function goView(no){
		notice.t_no.value=no;
		notice.t_requestPage.value="view";
		notice.method="post";
		notice.action="Notice";
		notice.submit();
	}
</script>
	<div id="container">
		<%@ include file="./notice_leftBoard.jsp" %>
		<div id="b_right">
			<p class="n_title">
				NOTICE
			</p>
			<div class="record_group record_group_left">
				<p><i class="fa-solid fa-bell"></i> 총게시글<span> ${t_arr.size() } </span>건</p>
			</div>			
			<form name="notice">
			<input type="hidden" name="t_no">
			<input type="hidden" name="t_nowPage">
			<input type="hidden" name="t_requestPage" value="list">
			<p class="select_box select_box_right">
				<select name="t_select" class="sel_box">
					<option value="title" <c:if test="${t_select eq 'title' }">selected</c:if> >Title</option>
					<option value="content" <c:if test="${t_select eq 'content' }">selected</c:if> >Content</option>
				</select>
				<input type="text" name="t_search" value="${t_search }" class="sel_text">
				<button type="button" onClick="goSearch()" class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
			</p>			
			</form>
			<table class="boardList">
				<colgroup>
					<col width="5%">
					<col width="60%">
					<col width="5%">
					<col width="10%">
					<col width="14%">
					<col width="6%">
				</colgroup>
				<thead>
					<tr>
						<th>No</th>
						<th>Title</th>
						<th>Attach</th>
						<th>Reg Name</th>
						<th>Reg Date</th>
						<th>Hit</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${t_arr }" var="arr">
					<tr>
						<td>${arr.getNo() }</td>
						<td class="t_left"><a href="javascript:void()" onClick="goView('${arr.getNo() }')">${arr.getTitle() }</a></td>
						<td><c:if test="${arr.getAttach() ne null }"><img src="images/clip.png"></c:if></td>
						<td>${arr.getReg_name() }</td>
						<td>${arr.getReg_date() }</td>
						<td>${arr.getHit() }</td>
					</tr>	
				</c:forEach>
				</tbody>
			</table>
			
			<div class="paging">
				${t_paging }
				<a href="javascript:void()" onClick="goNotice('write')" class="write">글쓰기</a>
			</div>
		</div>	
	</div>
<%@ include file="/common_footer.jsp" %>