<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common_header.jsp" %>
<script>
	function showCard(){
		$('#cash').hide();
		$('#card').show();
	}function showCash(){
		$('#card').hide();
		$('#cash').show();
	}function goBuy(){
		if(checking(customer.t_name,10,"받는분"));
		else if(checking(customer.t_mobile_1,3,"연락처"));
		else if(checking(customer.t_mobile_2,4,"연락처"));
		else if(checking(customer.t_mobile_3,4,"연락처"));
		else if(checking(customer.t_email,50,"이메일 주소"));
		else if(checking(customer.t_address,40,"연락처"));
		else if(checking(custmoer.t_comment,80,"배송 요청사항"));
		else if(checking())
	}
</script>
<style>
	#b_buy{
		float:left;
		width:290px;
		height:420px;
		padding:20px;
		margin-bottom:10px;
	}
</style>
	<div id="container">
	<form name="customer">
		<div id="b_right" style="float:left;width:650px;height:420px;">
			<p class="n_title" style="width:650px;">
				구매 페이지
			</p>
			<table class="boardForm">
			  <colgroup>
				<col width="200" />
				<col width="500" />
			  </colgroup>
			  <tbody>
			  	<tr>
			  		<th>받는분</th>
			  		<td>
			  			<input type="text" name="t_name" value="${t_mDto.getName() }" style="width:140px">
			  		</td>
			  	</tr>
			  	<tr>
			  		<th>연락처</th>
			  		<td>
			  			<input type="text" name="t_mobile_1" value="${t_mDto.getMobile_1() }" style="width:27px">&nbsp;&nbsp;-&nbsp;
			  			<input type="text" name="t_mobile_1" value="${t_mDto.getMobile_2() }" style="width:35px">&nbsp;&nbsp;-&nbsp;
			  			<input type="text" name="t_mobile_1" value="${t_mDto.getMobile_3() }" style="width:35px">
			  		</td>
			  	</tr>
			  	<tr>
			  		<th>이메일 주소</th>
			  		<td>
			  			<input type="text" name="t_email" value="${t_mDto.getEmail() }" style="width:340px">
			  		</td>
			  	</tr>
			  	<tr>
			  		<th>배송지 주소</th>
			  		<td>
			  			<input type="text" name="t_address" value="${t_mDto.getAddress() }" style="width:400px"><br>
			  		</td>
			  	</tr>
		  		<tr>
			  		<th>배송 요청사항</th>
			  		<td>
			  			<input type="text" name="t_comment" style="width:340px">
			  		</td>
			  	</tr>
			  	<tr>
			  		<th>구매 방법</th>
			  		<td>
			  			<input type="radio" name="t_buy_method" value="card" onchange="showCard()">카드
			  			<input type="radio" name="t_buy_method" value="cash" onchange="showCash()">무통장입금
			  			<div id="card" style="display:none;">
			  				카드 번호 입력
			  				<input type="text" name="t_credit_1" style="width:35px"> -
			  				<input type="text" name="t_credit_2" style="width:35px"> -
			  				<input type="text" name="t_credit_3" style="width:35px"> -
			  				<input type="text" name="t_credit_4" style="width:35px"> &nbsp;&nbsp;
			  				CVC 입력
			  				<input type="text" name="t_cvc" style="width:27px"> 
			  			</div>
			  			<div id="cash" style="display:none;">
			  				입금자명 입력
			  				<input type="text" name="t_transfer_name" style="width:140px">
			  			</div>
			  		</td>
			  	</tr>
			  </tbody>
			</table>
			<div class="buttonGroup_center">
				<a href="javascript:void()" onClick="goBuy()" class="butt">구매</a>
			</div>	
		</div>
		<div id="b_buy">
			<p class="n_title" style="width:286px;">
				제품 정보
			</p>
			<table class="boardForm">
			  <colgroup>
				<col width="50" />
				<col width="250" />
			  </colgroup>
			  <tbody>
				<tr>
			  		<td colspan="2">
			  			<img src="attach/product/${t_pDto.getAttach() }" style="width:277px;height:277px;">
			  		</td>
			  	</tr>
			  	<tr>
			  		<th>제품명</th>
			  		<td>
			  			<input type="text" value="${t_pDto.getP_name() }" readonly style="border:none;">
			  			<input type="hidden" name="t_p_no" value="${t_pDto.getP_no() }">
			  		</td>
			  	</tr>
			  	<tr>
			  		<th>가격</th>
			  		<td>
			  			<input type="text" name="t_price" value="${t_pDto.getPrice() }" readonly style="border:none;"> 
			  		</td>
			  	</tr>
			  	</tbody>
		  	</table>
		</div>
	</form>
	</div>
<%@include file="/common_footer.jsp"%>