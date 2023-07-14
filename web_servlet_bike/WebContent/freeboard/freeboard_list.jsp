<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common_header.jsp" %>
<script>
	function goSearch(){
		freeboard.method="post";
		freeboard.action="Freeboard";
		freeboard.submit();
	}function goPage(page){
		freeboard.t_nowPage.value=page;
		freeboard.method="post";
		freeboard.action="Freeboard";
		freeboard.submit();
	}function goView(no){
		freeboard.t_no.value=no;
		freeboard.t_requestPage.value="view";
		freeboard.method="post";
		freeboard.action="Freeboard";
		freeboard.submit();
	}
</script>
	<div id="container">
		<div id="b_right">
			<p class="n_title">
				Freeboard
			</p>
			<div class="record_group record_group_left">
				<p><i class="fa-solid fa-bell"></i> 총게시글<span> ${t_totalCount } </span>건</p>
			</div>			
			<form name="freeboard">
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
				<c:set var="number" value="${ t_order}"></c:set>
					<c:forEach items="${t_arr }" var="arr">
						<tr>
							<td>${number}<c:set value="${number -1 }" var="number"></c:set></td>
							<td class="t_left"><a href="javascript:void()" onClick="goView('${arr.getNo() }')">${arr.getTitle() }</a>&nbsp;&nbsp;&nbsp;&nbsp;<i class="fa-solid fa-comment"></i>${arr.getC_count() }</td>
							<td><c:if test="${not empty arr.getAttach() }"><img src="images/clip.png"></c:if></td>
							<td>${arr.getReg_name() }</td>
							<td>${arr.getReg_date() }</td>
							<td>${arr.getHit() }</td>
						</tr>	
					</c:forEach>
				</tbody>
			</table>
			
			<div class="paging">
				${t_paging }
				<c:if test="${sLevel>=0 }">
					<a href="javascript:void()" onClick="goFreeboard('write')" class="write">글쓰기</a>
				</c:if>
			</div>
		</div>	
	</div>
<%@ include file="/common_footer.jsp" %>