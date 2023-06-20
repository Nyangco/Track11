<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp"%>	
<script>
</script>
	<div id="container">
		<div id="b_right">
			<p class="n_title">
				PRODUCT
			</p>
			<div class="record_group record_group_left">
				<p><i class="fa-solid fa-bell"></i> 총 상품 수<span> ${t_totalCount } </span>건</p>
			</div>			
			<form name="news">
			<input type="hidden" name="t_requestPage" value="list">
			<input type="hidden" name="t_no">
			<input type="hidden" name="t_nowPage">
			<p class="select_box select_box_right">
				<select name="t_select" class="sel_box">
					<option value="title" <c:if test="${t_select eq 'title' }">selected</c:if> >Title</option>
					<option value="content" <c:if test="${t_select eq 'content' }">selected</c:if> >Content</option>
				</select>
				<input type="text" name="t_search" value="${t_search }" class="sel_text">
				<button type="button" class="sel_button" onclick="goSearch()"><i class="fa fa-search"></i> SEARCH</button>
			</p>			
			</form>
			<table class="boardList">
				<colgroup>
					<col width="10%">
					<col width="30%">
					<col width="30%">
					<col width="10%">
					<col width="10%">
				</colgroup>
				<thead>
					<tr>
						<th>상품 번호</th>
						<th>사진</th>
						<th>상품명</th>
						<th>우선순위</th>
						<th>가격</th>
					</tr>
				</thead>
				<tbody>
				<c:set value="${t_order }" var="number"></c:set>
				<c:forEach items="${t_arr }" var="dto">
					<tr>
						<td>${number}<c:set value="${number -1 }" var="number"></c:set></td>
						<td class="t_left"><a href="javascript:void()" onClick="goView('${dto.getNo()}')">${dto.getTitle()}</a></td>
						<td><c:if test="${not empty dto.getAttach()}"><img src="images/clip.png"></c:if></td>
						<td>${dto.getReg_name() }</td>
						<td>${dto.getReg_date()}</td>
						<td>${dto.getHit() }</td>
					</tr>	
				</c:forEach>
				</tbody>
			</table>
			<div class="paging">
				${t_paging }
				<a href="javascript:void()" onClick="goAdmin('product_write')" class="write">글쓰기</a>
			</div>
		</div>	
	</div>
<%@include file="../common_footer.jsp"%>