<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp"%>	
<script>
	function goSearch(){
		product.method="post";
		product.action="Product";
		product.submit();
	}function goView(no){
		product.t_requestPage.value="view";
		product.t_p_no.value=no
		product.method="post";
		product.action="Product";
		product.submit();
	}function goPage(page){
		product.t_nowPage.value=page;
		product.method="post";
		product.action="Product";
		product.submit()
	}
</script>
	<div id="container">
		<div id="b_right">
			<p class="n_title">
				PRODUCT
			</p>
			<div class="record_group record_group_left">
				<p><i class="fa-solid fa-bell"></i> 총 상품 수<span> ${t_totalCount } </span>건</p>
			</div>			
			<form name="product">
			<input type="hidden" name="t_requestPage" value="list">
			<input type="hidden" name="t_p_no">
			<input type="hidden" name="t_nowPage">
			<p class="select_box select_box_right" style="width:600px;">
				<select name="t_sort" onchange="goSearch()" class="sel_box" style="width:95px;">
					<option value="5" <c:if test="${t_sort eq '5' }">selected</c:if> >5개씩 정렬</option>
					<option value="10" <c:if test="${t_sort eq '10' }">selected</c:if> >10개씩 정렬</option>
					<option value="20" <c:if test="${t_sort eq '20' }">selected</c:if> >20개씩 정렬</option>
					<option value="50" <c:if test="${t_sort eq '50' }">selected</c:if> >50개씩 정렬</option>
				</select>
				<select name="t_tag" onchange="goSearch()" class="sel_box" style="width:90px;">
					<option value="" >모든 태그</option>
					<c:forEach items="${t_tagArr }" var="str" >
						<option value="${str[0] }" <c:if test="${t_tag eq str[0] }">selected</c:if> >${str[1] }</option>
					</c:forEach>
				</select>
				<select name="t_select" class="sel_box">
					<option value="p_no" <c:if test="${t_select eq 'p_no' }">selected</c:if> >제품 번호</option>
					<option value="p_name" <c:if test="${t_select eq 'p_name' }">selected</c:if> >제품명</option>
					<option value="p_level" <c:if test="${t_select eq 'p_level' }">selected</c:if> >판촉 레벨</option>
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
						<td><c:if test="${not empty dto.getAttach()}"><a href="javascript:void()" onClick="goView('${dto.getP_no()}')"><img src="attach/product/${dto.getAttach()}" style="width:200px;"></a></c:if></td>
						<td><a href="javascript:void()" onClick="goView('${dto.getP_no()}')">${dto.getP_name() }</a></td>
						<td>${dto.getP_level()}</td>
						<td>
							<c:choose>
								<c:when test="${dto.getPrice() eq dto.getP_content() }">
									<span class="price" >${dto.getPrice() }</span>
								</c:when>
								<c:when test="${dto.getPrice() ne dto.getP_content() }">
									<span class="price" style="color:gray;text-decoration:line-through;">${dto.getPrice() }</span>
									<br><span class="discount">${dto.getP_content() }</span>
								</c:when>
							</c:choose>
						</td>
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