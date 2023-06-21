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
			<form name="admin">
			<input type="hidden" name="t_requestPage" value="list">
			<input type="hidden" name="t_no">
			<input type="hidden" name="t_nowPage">
			<p class="select_box select_box_right" style="width:600px;">
				<select name="t_sort">
					<option value="5">5개씩 정렬</option>
					<option value="10">10개씩 정렬</option>
					<option value="20">20개씩 정렬</option>
					<option value="50">50개씩 정렬</option>
				</select>
				<select name="t_tag">
					<option value="">모든 태그</option>
					<c:forEach items="${t_tagArr }" var="str">
						<option value="${str[0] }">${str[1] }</option>
					</c:forEach>
				</select>
				<select name="t_select" class="sel_box">
					<option value="title" <c:if test="${t_select eq 'title' }">selected</c:if> >제품 번호</option>
					<option value="title" <c:if test="${t_select eq 'title' }">selected</c:if> >제품명</option>
					<option value="title" <c:if test="${t_select eq 'title' }">selected</c:if> >판촉 레벨</option>
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
						<td ><a href="javascript:void()" onClick="goView('${dto.getP_no()}')">${dto.getP_no()}</a></td>
						<td><c:if test="${not empty dto.getAttach()}"><img src="attach/product/${dto.getAttach()}"></c:if></td>
						<td>${dto.getP_name() }</td>
						<td>${dto.getP_level()}</td>
						<td>${dto.getPrice() }</td>
					</tr>	
				</c:forEach>
				</tbody>
			</table>
			<div class="paging">
				${t_paging }
				<a href="javascript:void()" onClick="goProduct('write')" class="write">글쓰기</a>
				<a href="javascript:void()" onClick="goProduct('tag')" class="write">태그 편집</a>
			</div>
		</div>	
	</div>
<%@include file="../common_footer.jsp"%>