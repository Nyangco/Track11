<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	function changeDisplay_e(){
		if(customer.t_why.value == "etc"){
			$('#etc').show();
		}else{
			$('#etc').hide();
		}
	}
	function changeDisplay_c(){
		if(customer.t_refund_change.value == "change"){
			$('#change').show();
		}else{
			$('#change').hide();
		}
	}
	function goUpdate(){
		if(customer.t_refund_change.value == "refund") customer.t_change.value="";
		customer.t_why.value = customer.t_why_t.value;
		customer.method="post";
		customer.action="Customer";
		customer.submit();
	}
</script>
	<div id="container">
		<div id="b_right">
			<p class="n_title">
				CUSTOMER
			</p>
			<form name="customer">
			<input type="hidden" name="t_requestPage" value="DBrefund">
			<input type="hidden" name="t_purchase_number" value="${t_purchase_number }">
			<table class="boardForm">
			  <colgroup>
				<col width="200" />
				<col width="500" />
			  </colgroup>
			  <tbody>
				<tr>
				  <th>교환여부</th>
				  <td>
				  	<select name="t_refund_change" onchange="changeDisplay_c()">
				  		<option value="change">교환</option>
				  		<option value="refund">반품</option>
				  	</select>
				  	<div id="change" style="display:inline"><input type="text" name="t_change" maxlength="40" size="35" placeholder="바꾸고자 하는 제품의 제품명을 입력해주세요"></div>
				  </td>
				</tr>
				<tr>
				  <th>사유</th>
				  <td>
				  	<select name="t_why" onchange="changeDisplay_e()">
				  		<option value="no">단순 변심</option>
				  		<option value="miss">주문 실수</option>
				  		<option value="broken">파손 및 불량</option>
				  		<option value="shipping">오배송 및 지연</option>
				  		<option value="etc">기타</option>
				  	</select>
				  	<div id="etc" style="display:none;"><input type="text" name="t_why_t" maxlength="40" size="35" placeholder="사유를 작성해주세요"></div>
				  </td>
				</tr>
			  </tbody>
			</table>
			</form>
			<div class="buttonGroup_center">
				<a href="javascript:void()" onClick="goUpdate()" class="butt">진행</a>
				<a href="javascript:void()" onClick="goCustomer('receipt_list')" class="butt">목록으로</a>
			</div>	
		</div>	
	</div>
<%@include file="/common_footer.jsp"%>