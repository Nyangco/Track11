<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
input:disabled {
    background: red;
}
</style>
<script>
	function goMemberView(id){
		admin.method="post";
		admin.action="Admin";
		admin.submit();
	}function goProductView(p_no){
		admin.method="post";
		admin.action="Product";
		admin.submit();
	}
</script>
<form name="admin">
	<input type="hidden" name="t_requestPage" value="view">
	<input type="hidden" name="t_id" value="${t_dto.getId() }">
	<input type="hidden" name="t_p_no" value="${t_dto.getProduct_number() }">
</form>
	<div id="container">
		<div id="b_right">
			<p class="n_title">
				PURCHASE
			</p>
			<table class="boardForm">
			  <colgroup>
				<col width="200" />
				<col width="500" />
			  </colgroup>
			  <tbody>
			  	<tr>
			  		<th>주문 번호</th>
			  		<td>
			  			${t_dto.getPurchase_number() }
			  		</td>
			  	</tr>
			  	<tr>
			  		<th>주문자 ID</th>
			  		<td>
			  			<a href="javascript:void()" onclick="goMemberView('${t_dto.getId() }')">${t_dto.getId() }</a>
			  		</td>
			  	</tr>
			  	<tr>
			  		<th>제품 번호</th>
			  		<td>
			  			<a href="javascript:void()" onclick="goProductView('${t_dto.getProduct_number() }')">${t_dto.getProduct_number() }</a>
			  		</td>
			  	</tr>
			  	<tr>
			  		<th>배송 상황</th>
			  		<td>
			  			${t_dto.getStatus() }
			  		</td>
			  	</tr>
			  	<tr>
			  		<th>주문 일자</th>
			  		<td>
			  			${t_dto.getPurchase_date() }
			  		</td>
			  	</tr>
			  	<tr>
			  		<th>배송비 포함 매출액</th>
			  		<td>
			  			${t_dto.getPrice() }
			  		</td>
			  	</tr>
			  	<tr>
			  		<th>배송 방법</th>
			  		<td>
			  			<c:choose>
			  				<c:when test="${t_dto.getShipping_method() eq 'byhand'}">직접 수령</c:when>
			  				<c:when test="${t_dto.getShipping_method() eq 'shipping'}">택배 배송</c:when>
			  			</c:choose>
			  		</td>
			  	</tr>
		  	<c:if test="${t_dto.getShipping_method() eq 'shipping' }">
			  	<tr>
			  		<th>받는분 성함</th>
			  		<td>
			  			${t_dto.getName() }
			  		</td>
			  	</tr>
			  	<tr>
			  		<th>받는분 연락처</th>
			  		<td>
			  			${t_dto.getMobile_1() }-${t_dto.getMobile_2() }-${t_dto.getMobile_3() }
			  		</td>
			  	</tr>
			  	<tr>
			  		<th>받는분 주소</th>
			  		<td>
			  			${t_dto.getAddress() }
			  		</td>
			  	</tr>
			  	<tr>
			  		<th>받는분 email</th>
			  		<td>
			  			${t_dto.getEmail() }
			  		</td>
			  	</tr>
		  	</c:if>
			  	<tr>
			  		<th>요청 사항</th>
			  		<td>
			  			${t_dto.getComment() }
			  		</td>
			  	</tr>
			  	<tr>
			  		<th>결제 방법</th>
			  		<td>
			  			<c:choose>
			  				<c:when test="${t_dto.getBuy_method() eq 'cash'}">무통장 입금</c:when>
			  				<c:when test="${t_dto.getBuy_method() eq 'card'}">카드 결제</c:when>
			  			</c:choose>
			  		</td>
			  	</tr>
		  	<c:if test="${t_dto.getBuy_method() eq 'card' }">
			  	<tr>
			  		<th>신용카드 정보</th>
			  		<td>
			  			${t_dto.getCrecit_1() }-${t_dto.getCrecit_2() }-${t_dto.getCrecit_3() }-${t_dto.getCrecit_4() }<br>
			  			CVC : ${t_dto.getCvc() }
			  		</td>
			  	</tr>
		  	</c:if><c:if test="${t_dto.getBuy_method() eq 'cash' }">
			  	<tr>
			  		<th>입금자명</th>
			  		<td>
			  			${t_dto.getTransfer_name() }
			  		</td>
			  	</tr>
		  	</c:if><c:if test="${t_dto.getStatus() eq '8' }">
			  	<tr>
			  		<th>환불 사유</th>
			  		<td>
			  			${t_dto.getRefund() }
			  		</td>
			  	</tr>
		  	</c:if>
			  </tbody>
			</table>
			<div class="buttonGroup_center">
				<a href="javascript:void()" onClick="goAdmin('purchase_list')" class="butt">목록</a>
			</div>	
		</div>	
	</div>
<%@include file="/common_footer.jsp"%>