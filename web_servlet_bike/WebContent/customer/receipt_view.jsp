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
</script>
<form name="customer">
</form>
	<div id="container">
		<div id="b_right" style="float:none; margin=0 auto;">
			<p class="n_title">
				상세 구매이력
			</p>
			<table class="boardForm">
			  <colgroup>
				<col width="200" />
				<col width="500" />
			  </colgroup>
			  <tbody>
				<tr>
				  <th>주문 번호</th>
				  <td>${t_dto.getPurchase_number() }</td>
				</tr>
				<tr>
				  <th>배송 상황</th>
				  <td>
				  	<c:choose>
						<c:when test="${t_dto.getStatus() eq 1}">입금 확인중</c:when>
						<c:when test="${t_dto.getStatus() eq 2}">결제 완료</c:when>
						<c:when test="${t_dto.getStatus() eq 3}">배송 준비중</c:when>
						<c:when test="${t_dto.getStatus() eq 4}">배송중</c:when>
						<c:when test="${t_dto.getStatus() eq 5}">배송 완료</c:when>
						<c:when test="${t_dto.getStatus() eq 6}">구매 확정</c:when>
						<c:when test="${t_dto.getStatus() eq 7}">수령 대기중</c:when>
						<c:when test="${t_dto.getStatus() eq 8}">주문 취소됨</c:when>
						<c:when test="${t_dto.getStatus() eq 9}">주문 변경중</c:when>
					</c:choose>	
				  </td>
				</tr>
				<tr>
				  <th>주문 상품</th>
				  <td>${t_dto.getProduct_number() }</td>
				</tr>
				<tr>
				  <th>구매일자</th>
				  <td>${t_dto.getPurchase_date() }</td>
				</tr>
				<tr>
				  <th>가격</th>
				  <td>${t_dto.getPrice() }</td>
				</tr>
				<tr>
				  <th>배송 방법</th>
				  <td>
				  	<c:choose>
				  		<c:when test="${t_dto.getShipping_method() eq 'byhand' }">직접 수령</c:when>
				  		<c:when test="${t_dto.getShipping_method() eq 'shipping' }">택배 배송</c:when>
				  	</c:choose>
				  </td>
				</tr>
				<c:if test="${t_dto.getShipping_method() eq 'shipping' }">
					<tr>
					  <th>받는분 성함</th>
					  <td>${t_dto.getName() }</td>
					</tr>
					<tr>
					  <th>받는분 이메일</th>
					  <td>${t_dto.getEmail() }</td>
					</tr>
					<tr>
					  <th>받는분 전화번호</th>
					  <td>${t_dto.getMobile_1() }-${t_dto.getMobile_2() }-${t_dto.getMobile_3() }</td>
					</tr>
					<tr>
					  <th>배송지 주소</th>
					  <td>${t_dto.getAddress() }</td>
					</tr>
				</c:if>
				<tr>
				  <th>요청 사항</th>
				  <td>${t_dto.getComment() }</td>
				</tr>
				<tr>
				  <th>결제 수단</th>
				  <td>
				  	<c:choose>
				  		<c:when test="${t_dto.getBuy_method() eq 'cash' }">무통장 입금</c:when>
				  		<c:when test="${t_dto.getBuy_method() eq 'card' }">카드 결제</c:when>
				  	</c:choose>
				  </td>
				</tr>
				<c:if test="${t_dto.getBuy_method() eq 'cash' }">
					<tr>
					  <th>입금자명</th>
					  <td>${t_dto.getTransfer_name() }</td>
					</tr>
				</c:if>
			  </tbody>
			</table>
			<div class="buttonGroup_center">
				<a href="javascript:void()" onClick="goCustomer('receipt_list')" class="butt">목록으로</a>
			</div>	
		</div>	
	</div>
<%@include file="/common_footer.jsp"%>