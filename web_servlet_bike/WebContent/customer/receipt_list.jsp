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
	}function goView(purchase_number){
		customer.t_purchase_number.value=purchase_number;
		customer.t_requestPage.value="receipt_view";
		customer.method="post";
		customer.action="Customer";
		customer.submit();
	}function goCancel(purchase_number){
		if(confirm("정말로 취소하시겠습니까?")){
			customer.t_purchase_number.value=purchase_number;
			customer.t_requestPage.value="cancel";
			customer.method="post";
			customer.action="Customer";
			customer.submit();
		}
	}function goRefund(purchase_number){
		customer.t_purchase_number.value=purchase_number;
		customer.t_requestPage.value="refund";
		customer.method="post";
		customer.action="Customer";
		customer.submit();
	}function goConfirm(purchase_number){
		if(confirm("정말로 구매 확정하시겠습니까?")){
			customer.t_purchase_number.value=purchase_number;
			customer.t_requestPage.value="confirm";
			customer.method="post";
			customer.action="Customer";
			customer.submit();
		}
	}function goSearch(){
		if(checking(customer.t_select,30,"검색 항목"))return;
		if(customer.t_select.value=="p_no" && customer.t_search.value==""){
			alert("제품명은 공백으로 검색하실 수 없습니다.");
			customer.t_search.focus();
			return;
		}
		customer.method="post";
		customer.action="Customer";
		customer.submit();
	}function changeInput(){
		var k = customer.t_select.value;
		if(k=="status"){
			$('#input_text').hide();
			$('#input_select').show();
			$('#input_date').hide();
		}else if(k=="purchase_date"){
			$('#input_text').hide();
			$('#input_select').hide();
			$('#input_date').show();
		}else{
			$('#input_text').show();
			$('#input_select').hide();
			$('#input_date').hide();
		}
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
		<input type="hidden" name="t_purchase_number">
			<div class="select_box select_box_right" style="width:500px;">
				<select name="t_sort" class="sel_box" onchange="goSearch()">
					<option value="">정렬 개수</option>
					<option value="5" <c:if test="${t_sort eq '5'}">selected</c:if>>5건씩</option>
					<option value="10" <c:if test="${t_sort eq '10'}">selected</c:if>>10건씩</option>
					<option value="20" <c:if test="${t_sort eq '20'}">selected</c:if>>20건씩</option>
					<option value="30" <c:if test="${t_sort eq '30'}">selected</c:if>>30건씩</option>
				</select>
				<select name="t_select" class="sel_box" onchange="changeInput()">
					<option value="">검색 항목</option>
					<option value="purchase_number" <c:if test="${t_select eq 'purchase_number'}">selected</c:if>>주문 번호</option>
					<option value="p_no" <c:if test="${t_select eq 'p_no'}">selected</c:if>>제품명</option>
					<option value="status" <c:if test="${t_select eq 'status'}">selected</c:if>>배송 상태</option>
					<option value="purchase_date" <c:if test="${t_select eq 'purchase_date'}">selected</c:if>>구매일</option>
				</select>
				<button type="button" onclick="goSearch()" class="sel_button" style="float:right;margin-top:2px;margin-left:5px;"><i class="fa fa-search"></i> SEARCH</button>
				<div id="input_boxes" style="width:120px;float:right;margin-top:2px;margin-left:5px;">
					<div id="input_text" <c:if test="${t_select eq 'purchase_date' or t_select eq 'status'}">style="display:none;"</c:if>>
						<input type="text" name="t_search" value="${t_search }" class="sel_text" placeholder="검색 내용을 입력">
					</div><div id="input_select" <c:if test="${t_select ne 'status'}">style="display:none;"</c:if>>
						<select name="t_search_s" style="height:22px;width:120px;">
							<option value="1" <c:if test="${t_search eq '1' }">selected</c:if>>입금 확인중</option>
							<option value="2" <c:if test="${t_search eq '2' }">selected</c:if>>결제 완료</option>
							<option value="3" <c:if test="${t_search eq '3' }">selected</c:if>>배송 준비중</option>
							<option value="4" <c:if test="${t_search eq '4' }">selected</c:if>>배송중</option>
							<option value="5" <c:if test="${t_search eq '5' }">selected</c:if>>배송 완료</option>
							<option value="6" <c:if test="${t_search eq '6' }">selected</c:if>>구매 확정</option>
							<option value="7" <c:if test="${t_search eq '7' }">selected</c:if>>수령 대기중</option>
							<option value="8" <c:if test="${t_search eq '8' }">selected</c:if>>주문 취소됨</option>
							<option value="9" <c:if test="${t_search eq '9' }">selected</c:if>>제품 변경중</option>
						</select>
					</div><div id="input_date" <c:if test="${t_select ne 'purchase_date'}">style="display:none;"</c:if>>
						<input type="date" name="t_search_d" style="height:22px;width:120px;">
					</div>
				</div>
			</div>		
		</form>	
		
		<table class="boardList">
			<colgroup>
				<col width="95">
				<col width="300">
				<col width="160">
				<col width="95">
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
						<td>${arr.getPrice() }원</td>
						<td>
							<c:choose>
								<c:when test="${arr.getStatus() eq 1}">입금 확인중</c:when>
								<c:when test="${arr.getStatus() eq 2}">결제 완료</c:when>
								<c:when test="${arr.getStatus() eq 3}">배송 준비중</c:when>
								<c:when test="${arr.getStatus() eq 4}">배송중</c:when>
								<c:when test="${arr.getStatus() eq 5}">배송 완료</c:when>
								<c:when test="${arr.getStatus() eq 6}">구매 확정</c:when>
								<c:when test="${arr.getStatus() eq 7}">수령 대기중</c:when>
								<c:when test="${arr.getStatus() eq 8}">주문 취소됨</c:when>
								<c:when test="${arr.getStatus() eq 9}">제품 변경중</c:when>
							</c:choose>						
						</td>
						<td>
						<div class="buttonGroup_center" style="margin:0;">
							<a href="javascript:void()" onClick="goView('${arr.getPurchase_number() }')" class="butt">상세 보기</a>
							<c:if test="${arr.getStatus() eq '1' || arr.getStatus() eq '2' }">
							<a href="javascript:void()" onClick="goCancel('${arr.getPurchase_number() }')" class="butt">주문 취소</a>
							</c:if>
							<c:if test="${arr.getStatus() eq '3' || arr.getStatus() eq '4' || arr.getStatus() eq '5' || arr.getStatus() eq '7' }">
							<a href="javascript:void()" onClick="goRefund('${arr.getPurchase_number() }')" class="butt">반품/교환</a>
							<a href="javascript:void()" onClick="goConfirm('${arr.getPurchase_number() }')" class="butt">주문 확정</a>
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
