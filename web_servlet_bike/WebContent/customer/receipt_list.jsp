<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<div id="container">	
<script>
	function goPage(page){
		customer.t_nowPage.value=page;
		customer.method="post";
		customer.action="Customer";
		customer.submit();
	}
</script>
	<div id="b_right" style="float:none;width:1024px;margin:0 auto;padding:20px 0;">
		<p class="n_title" style="width:1024px;">
			구매 이력
		</p>
		<div class="record_group record_group_left">
			<p><i class="fa-solid fa-bell"></i> 총 구매 횟수 <span> ${t_totalCount} </span>건</p>
		</div>			
		<form name="customer">
		<input type="hidden" name="t_nowPage">
		<input type="hidden" name="t_requestPage" value="receipt_list">
		<input type="hidden" name="t_id">
			<p class="select_box select_box_right" style="width:500px;">
				<input type="radio" name="t_sort" value="5" onchange="goList()" <c:if test="${t_sort eq '5' }">checked</c:if>>5명 
				<input type="radio" name="t_sort" value="10" onchange="goList()" <c:if test="${t_sort eq '10' }">checked</c:if>>10명 
				<input type="radio" name="t_sort" value="20" onchange="goList()" <c:if test="${t_sort eq '20' }">checked</c:if>>20명 
				<input type="radio" name="t_sort" value="30" onchange="goList()" <c:if test="${t_sort eq '30' }">checked</c:if>>30명 
				<select name="t_select" class="sel_box" style="width:63px;">
					<option value="id">ID</option>
					<option value="name">Name</option>
					<option value="mobile_3">Mobile</option>
				</select>
				<input type="text" name="t_search" value="${t_search }" class="sel_text">
	
				<button type="button" onclick="goList()" class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
			</p>		
		</form>	
		
		<table class="boardList">
			<colgroup>
				<col width="95">
				<col width="300">
				<col width="160">
				<col width="78">
				<col width="80">
				<col width="*">
			</colgroup>
			<thead>
				<tr>
					<th>주문 번호</th>
					<th>주문 상품</th>
					<th>구매 일자</th>
					<th>주문 금액</th>
					<th>배송 상태</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${t_arr }" var="arr">
					<tr>
						<td>${arr.getPurchase_number() }</td>
						<td>${arr.getProduct_number() }</td>
						<td>${arr.getPurchase_date() }</td>
						<td>${arr.getPrice() }</td>
						<td>
							<c:choose>
								<c:when test="${arr.getStatus() eq 1}">입금 확인중</c:when>
								<c:when test="${arr.getStatus() eq 2}">결제 완료</c:when>
								<c:when test="${arr.getStatus() eq 3}">배송 준비중</c:when>
								<c:when test="${arr.getStatus() eq 4}">배송중</c:when>
								<c:when test="${arr.getStatus() eq 5}">배송완료</c:when>
								<c:when test="${arr.getStatus() eq 6}">구매 확정</c:when>
							</c:choose>						
						</td>
						<td>
						<div class="buttonGroup_center" style="margin:0;">
							<a href="javascript:void()" onClick="goView(${arr.getPurchase_number() })" class="butt">상세 보기</a>
							<c:if test="${(arr.getStatus() eq 1)or(arr.getStatus() eq 2) }">
							<a href="javascript:void()" onClick="goCancel(${arr.getPurchase_number() })" class="butt">주문 취소</a>
							</c:if>
							<c:if test="${(arr.getStatus() eq 3)or(arr.getStatus() eq 4)or(arr.getStatus() eq 5) }">
							<a href="javascript:void()" onClick="goCancel(${arr.getPurchase_number() })" class="butt">반품/교환</a>
							<a href="javascript:void()" onClick="goCancel(${arr.getPurchase_number() })" class="butt">주문 확정</a>
							</c:if>
						</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<div class="paging">
			${t_paging }
		</div>
	</div>	
</div>
<%@include file="../common_footer.jsp" %>
