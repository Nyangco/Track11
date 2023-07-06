<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<script>
	function goProductView(product_number){
		admin.t_p_no.value=product_number;
		admin.t_requestPage.value="view";
		admin.method="post";
		admin.action="Product";
		admin.submit();
	}function goPage(page){
		if(admin.t_search_s.value!="") admin.t_search.value=admin.t_search_s.value;
		else if(admin.t_search_d.value!="") admin.t_search.value=admin.t_search_d.value;
		else if(admin.t_search_t.value!="") admin.t_search.value=admin.t_search_t.value;
		admin.t_nowPage.value=page;
		admin.method="post";
		admin.action="Admin";
		admin.submit();
	}function goStatus(purchase_number){
		admin.t_purchase_number.value=purchase_number;
		admin.t_requestPage.value = "change_status";
		admin.method="post";
		admin.action="Admin";
		admin.submit();
	}function change_search(){
		if(admin.t_select.value=="status"){
			$('#search_t').hide();
			$('#search_d').hide();
			$('#search_s').show();
		}else if(admin.t_select.value=="purchase_date"){
			$('#search_t').hide();
			$('#search_d').show();
			$('#search_s').hide();
		}else{
			$('#search_t').show();
			$('#search_d').hide();
			$('#search_s').hide();
		}
	}function goSearch(){
		if(admin.t_search_s.value!="") admin.t_search.value=admin.t_search_s.value;
		else if(admin.t_search_d.value!="") admin.t_search.value=admin.t_search_d.value;
		else if(admin.t_search_t.value!="") admin.t_search.value=admin.t_search_t.value;
		admin.method="post";
		admin.action="Admin";
		admin.submit();
	}function goChange(pn){
		admin.t_purchase_number.value=pn;
		admin.t_requestPage.value="change_product";
		admin.method="post";
		admin.action="Admin";
		admin.submit();
	}function goView(product_number,product_name,attach){
		admin.t_purchase_number.value=product_number;
		admin.t_requestPage.value="purchase_view";
		admin.t_p_name.value=product_name;
		admin.t_attach.value=attach;
		admin.method="post";
		admin.action="Admin";
		admin.submit();
	}function goStatus(pn,pValue){
        
		$.ajax({
			type : 'POST',
			url : 'Change_status_ajax',
			data: 't_purchase_number='+pn+'&t_status_number='+pValue,
			dataType : 'text',
			error : function(){
				alert('통신 실패');
			},
			success : function(data){
				if(data=='1') alert('수정 성공');
				else alert('수정 실패');
			}
		});				
	}function goStatics(){
		admin.t_requestPage.value="statics_list";
		admin.method="post";
		admin.action="Admin";
		admin.submit();
	}
</script>
<style>
	#search_t, #search_d, #search_s{width:120px;}
	.btn {float:right;
		width:60px;
		text-align:center;
		padding:5px 10px;
		background:#D8D8D8;
		margin-left:5px;}
</style>
<div id="container">	
	<div id="b_right">
		<p class="n_title">
			PURCHASE <span><a href="javascript:void()" onclick="goStatics()" class="btn">월별 통계</a></span>
		</p>
		<div class="record_group record_group_left">
			<p><i class="fa-solid fa-bell"></i> 총 구매건 수<span> ${t_totalCount} </span>건</p>
		</div>			
		<form name="admin" id="admin">
		<input type="hidden" name="t_requestPage" value="purchase_list">
		<input type="hidden" name="t_nowPage">
		<input type="hidden" name="t_purchase_number">
		<input type="hidden" name="t_change_status">
		<input type="hidden" name="t_search">
		<input type="hidden" name="t_p_no">
		<input type="hidden" name="t_p_name">
		<input type="hidden" name="t_attach">
			<p class="select_box select_box_right" style="width:500px;">
				<input type="radio" name="t_sort" value="5" onchange="goSearch()" <c:if test="${t_sort eq '5' }">checked</c:if>>5건 
				<input type="radio" name="t_sort" value="10" onchange="goSearch()" <c:if test="${t_sort eq '10' }">checked</c:if>>10건 
				<input type="radio" name="t_sort" value="20" onchange="goSearch()" <c:if test="${t_sort eq '20' }">checked</c:if>>20건 
				<input type="radio" name="t_sort" value="30" onchange="goSearch()" <c:if test="${t_sort eq '30' }">checked</c:if>>30건 
				<select name="t_select" class="sel_box" onchange="change_search()" >
					<option value="purchase_number" <c:if test="${t_select eq 'purchase_number' }">selected</c:if>>주문 번호</option>
					<option value="id" <c:if test="${t_select eq 'id' }">selected</c:if>>주문자 ID</option>
					<option value="p_no" <c:if test="${t_select eq 'p_no' }">selected</c:if>>상품 번호</option>
					<option value="status" <c:if test="${t_select eq 'status' }">selected</c:if>>배송 상태</option>
					<option value="purchase_date" <c:if test="${t_select eq 'purchase_date' }">selected</c:if>>주문 일자</option>
				</select>
				<button type="button" onclick="goSearch()" class="sel_button" style="float:right;margin-top:2px;margin-left:2px;"><i class="fa fa-search"></i> SEARCH</button>
					<input type="text" name="t_search_t" value="${t_search }" class="sel_text" id="search_t" <c:if test="${t_select eq 'status' or t_select eq 'purchase_date' }">style="display:none"</c:if>>
					<input type="date" name="t_search_d" value="${t_search }" class="sel_text" id="search_d" <c:if test="${t_select ne 'purchase_date' }">style="display:none"</c:if>>
					<select name="t_search_s" id="search_s" <c:if test="${t_select ne 'status' }">style="display:none"</c:if>>
						<option value="" >배송 상태 선택</option>
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
				</p>		
		<table class="boardList">
			<colgroup>
				<col width="104px">
				<col width="126px">
				<col width="70px">
				<col width="70px">
				<col width="174px">
				<col width="*">
			</colgroup>
			<thead>
				<tr>
					<th>주문 번호</th>
					<th>배송 상황</th>
					<th>제품 번호</th>
					<th>배송 방법</th>
					<th>구매 일자</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${t_arr}" var="dto">
					<tr>
						<td>${dto.getPurchase_number() }</td>
						<td>
							<select name="t_status_${dto.getPurchase_number() }" onchange="goStatus('${dto.getPurchase_number() }',this.value)">
								<option value="1" <c:if test="${dto.getStatus() eq '1' }">selected</c:if>>입금 확인중</option>
								<option value="2" <c:if test="${dto.getStatus() eq '2' }">selected</c:if>>결제 완료</option>
								<option value="3" <c:if test="${dto.getStatus() eq '3' }">selected</c:if>>배송 준비중</option>
								<option value="4" <c:if test="${dto.getStatus() eq '4' }">selected</c:if>>배송중</option>
								<option value="5" <c:if test="${dto.getStatus() eq '5' }">selected</c:if>>배송 완료</option>
								<option value="6" <c:if test="${dto.getStatus() eq '6' }">selected</c:if>>구매 확정</option>
								<option value="7" <c:if test="${dto.getStatus() eq '7' }">selected</c:if>>수령 대기중</option>
								<option value="8" <c:if test="${dto.getStatus() eq '8' }">selected</c:if>>주문 취소됨</option>
								<option value="9" <c:if test="${dto.getStatus() eq '9' }">selected</c:if>>제품 변경중</option>
							</select>
						</td>
						<td><a href="javascript:void()" onclick="goProductView('${dto.getProduct_number() }')">${dto.getProduct_number() }</a></td>
						<td>
							<c:choose>
								<c:when test="${dto.getShipping_method() eq 'byhand' }">직접 수령</c:when>
								<c:when test="${dto.getShipping_method() eq 'shipping' }">택배 배송</c:when>
							</c:choose>
						</td>
						<td>${dto.getPurchase_date() }</td>
						<td> 
							<a href="javascript:void()" onClick="goView('${dto.getPurchase_number()}','${dto.getPrice() }','${dto.getId() }')" class="butt" style="border:solid black 1px; background-color:#F2F2F2;">상세 보기</a>
							<c:if test="${dto.getStatus() eq '9' }">
							<a href="javascript:void()" onClick="goChange('${dto.getPurchase_number()}')" class="butt" style="border:solid black 1px; background-color:#F2F2F2;">제품 변경</a>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</form>
		
		<div class="paging">
			${t_paging }
		</div>
	</div>	
</div>
<%@include file="../common_footer.jsp" %>
