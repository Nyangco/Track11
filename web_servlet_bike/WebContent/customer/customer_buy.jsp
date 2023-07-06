<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common_header.jsp"%>
<link href="css/addrlinkSample.css" rel="stylesheet">
<script>
	function showCard() {
		$('#cash').hide();
		$('#card').show();
	}
	function showCash() {
		$('#card').hide();
		$('#cash').show();
	}
	function showShipping(){
		$('#shipping').show();
		customer.t_shipping_fee.value="5,000";
		var k = Number(5000)+Number("${t_pnc}");
		customer.t_total_fee.value= comma(k);
	}
	function hideShipping(){
		$('#shipping').hide();
		customer.t_shipping_fee.value="0";
		customer.t_total_fee.value="${t_pDto.getP_content()}";
	}
	function goBuy() {
		if (checking(customer.t_name, 10, "받는분"))
			return;
		if (checking(customer.t_mobile_1, 4, "연락처"))
			return;
		if (checking(customer.t_mobile_2, 5, "연락처"))
			return;
		if (checking(customer.t_mobile_3, 4, "연락처"))
			return;
		if (checking(customer.t_email, 50, "이메일 주소"))
			return;
		if(checking(customer.t_shipping_method,10,"수령 방법"))return;
		if(customer.t_shipping_method.value=="shipping"){
			if (customer.t_address.value == "해당하는 주소가 없습니다. 다시 검색해주세요" || customer.t_address.value ==""){
				alert("주소를 다시한번 확인해주세요");
				customer.t_address_s.focus();
				return;
			}
		}
		if (checkLength(customer.t_comment, 160, "배송 요청사항"))
			return;
		if (checking(customer.t_buy_method, 5, "결제 수단"))
			return;
		if (customer.t_buy_method.value == "card") {
			if (checking(customer.t_credit_1, 4, "카드 번호"))
				return;
			if (checking(customer.t_credit_2, 4, "카드 번호"))
				return;
			if (checking(customer.t_credit_3, 4, "카드 번호"))
				return;
			if (checking(customer.t_credit_4, 4, "카드 번호"))
				return;
			if (checking(customer.t_cvc, 4, "cvc 번호"))
				return;
		} else if (customer.t_buy_method.value == "cash") {
			if (checking(customer.t_transfer_name, 5, "입금자명"))
				return;
		}
		customer.method = "post";
		customer.action = "Customer";
		customer.submit();

	}function searchAddress(){
		var q = customer.t_address_s.value; //검색 내용
	    //ajax 시작
		$.ajax({
			url : 'https://dapi.kakao.com/v2/local/search/address.json',
			headers : { 'Authorization' : 'KakaoAK a33297a5e59da7171ed69198dc906fa1'	},
			type: 'GET',
			data : { 'query' : q },
			success : function(data){
				//호출 성공하면 작성할 내용
	            if(data.documents.length != 0 ){ // 값이 있으면
	            	console.log(data.documents[0].address.address_name);
					customer.t_address.value = data.documents[0].address.address_name;
				}else{
            		customer.t_address.value = "해당하는 주소가 없습니다. 다시 검색해주세요";
            	}
			}, 
			error:function(request,status,error){
			    alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
		}).done(function(data){console.log(data);});	
	}
</script>
<style>
#b_buy {
	float: left;
	width: 290px;
	height: 420px;
	padding: 20px;
	margin-bottom: 10px;
}
input {
	height:22px;
}
</style>
<div id="container">
	<form name="customer">
		<input type="hidden" name="t_requestPage" value="purchase"> <input
			type="hidden" name="t_id" value="${t_mDto.getId() }">
		<div id="b_right" style="float: left; width: 650px;">
			<p class="n_title" style="width: 650px;">제품 구매</p>
			<table class="boardForm">
				<colgroup>
					<col width="200" />
					<col width="500" />
				</colgroup>
				<tbody>
					<tr>
						<th>받는분</th>
						<td><input type="text" name="t_name"
							value="${t_mDto.getName() }" style="width: 140px"
							placeholder="받는분의 성함을 입력해주세요"> <input type="hidden"
							name="t_id" value="${sId }"></td>
					</tr>
					<tr>
						<th>연락처</th>
						<td><input type="text" name="t_mobile_1"
							value="${t_mDto.getMobile_1() }" style="width: 27px"
							maxlength="3">&nbsp;&nbsp;-&nbsp; <input type="text"
							name="t_mobile_2" value="${t_mDto.getMobile_2() }"
							style="width: 35px" maxlength="4">&nbsp;&nbsp;-&nbsp; <input
							type="text" name="t_mobile_3" value="${t_mDto.getMobile_3() }"
							style="width: 35px" maxlength="4"></td>
					</tr>
					<tr>
						<th>이메일 주소</th>
						<td><input type="text" name="t_email"
							value="${t_mDto.getEmail() }" style="width: 340px"></td>
					</tr>
					<tr>
						<th>수령 방법 선택</th>
						<td><input type="radio" name="t_shipping_method"
							value="shipping" onchange="showShipping()" >택배 배송 &nbsp;
							&nbsp; <input type="radio" name="t_shipping_method"
							value="byhand" onchange="hideShipping()" >직접 수령
							<div id="shipping" style="display: none;">
								<br>배송지 주소&nbsp;&nbsp;<input type="text" name="t_address_s" id="roadAddrPart1"
									value="${t_mDto.getAddress() }" style="width: 264px;" placeholder="검색할 주소를 입력해주세요";>
									<input type="button" onClick="searchAddress()" value="주소 검색"/><br>
									<input type="text" name="t_address" style="width: 400px;margin-top:5px;" readonly placeholder="검색 결과가 이곳에 표시됩니다.">
							</div></td>
					</tr>
					<tr>
						<th>요청사항</th>
						<td><input type="text" name="t_comment" style="width: 340px">
						</td>
					</tr>
					<tr>
						<th>결제 수단</th>
						<td><input type="radio" name="t_buy_method" value="card"
							onchange="showCard()">카드&nbsp;&nbsp; <input type="radio"
							name="t_buy_method" value="cash" onchange="showCash()">무통장입금
							<div id="card" style="display: none;">
								카드 번호 입력 <input type="text" name="t_credit_1"
									style="width: 35px" maxlength="4"> - <input type="text"
									name="t_credit_2" style="width: 35px" maxlength="4"> -
								<input type="text" name="t_credit_3" style="width: 35px"
									maxlength="4"> - <input type="text" name="t_credit_4"
									style="width: 35px" maxlength="4"> &nbsp;&nbsp; CVC 입력
								<input type="text" name="t_cvc" style="width: 27px"
									maxlength="3">
							</div>
							<div id="cash" style="display: none;">
								입금자명 입력 <input type="text" name="t_transfer_name"
									style="width: 140px">
							</div></td>
					</tr>
					<tr>
						<th>영수증 이메일 발송</th>
						<td>
							<input type="checkbox" name="t_mailing" value="y">발송
						</td>
					</tr>
				</tbody>
			</table>
			<div class="buttonGroup_center">
				<a href="javascript:void()" onClick="goBuy()" class="butt">구매</a>
			</div>
		</div>
		<div id="b_buy">
			<p class="n_title" style="width: 286px; margin-bottom: 10px;">제품
				정보</p>
			<table class="boardForm">
				<colgroup>
					<col width="80" />
					<col width="220" />
				</colgroup>
				<tbody>
					<tr>
						<td colspan="2"><img
							src="attach/product/${t_pDto.getAttach() }"
							style="width: 150px; height: 150px;"></td>
					</tr>
					<tr>
						<th>제품명</th>
						<td><input type="text" value="${t_pDto.getP_name() }"
							readonly style="border: none;" name="t_p_name"> <input type="hidden"
							name="t_p_no" value="${t_pDto.getP_no() }"></td>
					</tr>
					<tr>
						<th>제품 가격</th>
						<td><input type="text" name="t_price" value="${t_pDto.getP_content() }"
							readonly style="border: none;"></td>
					</tr>
					<tr>
						<th>배송료</th>
						<td><input type="text" name="t_shipping_fee" value="0"
							readonly style="border: none;"></td>
					</tr>
					<tr>
						<th>합계</th>
						<td><input type="text" name="t_total_fee" value="${t_pDto.getP_content() }"
							readonly style="border: none;"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</form>
</div>
<%@include file="/common_footer.jsp"%>