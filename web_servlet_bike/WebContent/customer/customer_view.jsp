<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp"%>
<script>
	function goUpdate(){
		customer.t_requestPage.value="update";
		customer.method="post";
		customer.action="Customer";
		customer.submit();
	}function goDelete(){
		customer.t_requestPage.value="DBdelete";
		customer.method="post";
		customer.action="Customer";
		customer.submit();
	}function goView(no){
		customer.t_p_no.value=no;
		customer.method="post";
		customer.action="Customer";
		customer.submit();
	}function goBuy(){
		customer.t_requestPage.value="buy";
		customer.method="post";
		customer.action="Customer";
		customer.submit();
	}
</script>
<form name="customer">
	<input type="hidden" name="t_requestPage" value="view">
	<input type="hidden" name="t_p_no" value="${t_dto.getP_no() }">
	<input type="hidden" name="t_attach" value="${t_dto.getAttach() }">
</form>
	<div id="container">
		<div id="b_right" style="float:none;margin:0 auto;">
			<p class="n_title">
				CUSTOMER
			</p>
			<table class="boardForm">
				<colgroup>
					<col width="10%">
					<col width="40%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<tbody>
					<tr>
						<th>상품명</th>
						<td colspan="2">${t_dto.getP_name() }</td>
						<td > <p style="float:right;"><i class="far fa-eye"></i> ${t_dto.getHit() }</p></td>
					</tr>	
					<tr>
						<th >상품 번호</th>
						<td>${t_dto.getP_no()}</td>
						<th >상품 태그</th>
						<td>${t_dto.getP_tag()}</td>
					</tr>	
					<tr>
						<td colspan="4" >
							<img src="attach/product/${t_dto.getAttach() }"style="width:298px;border:1px solid gray; margin-bottom:30px;">
							<!--<textarea class="textArea_H250" style="width:390px;resize:none;border:none;" name="t_content" readonly>${t_dto.getP_content() }</textarea>-->
							<div style="width:390px;resize:none;border:none;float:right;white-space:pre-wrap;">${t_dto.getP_content() }</div>
						</td>
					</tr>	
					<tr>
						<th >사이즈</th>
						<td>${t_dto.getP_size_w()}mm - ${t_dto.getP_size_l()}mm - ${t_dto.getP_size_h()}mm</td>
						<th >무게</th>
						<td>${t_dto.getP_weight()}kg</td>
					</tr>
					<tr>
						<th >제조사명</th>
						<td>${t_dto.getC_name()}</td>
						<th >가격</th>
						<td>${t_dto.getPrice()}</td>
					</tr>
					<tr>
						<th >작성자</th>
						<td>${t_dto.getReg_id()}</td>
						<th >작성일</th>
						<td>${t_dto.getReg_date()}</td>
					</tr>	
					<tr>
						<th >수정자</th>
						<td>${t_dto.getUpdate_id()}</td>
						<th >수정일</th>
						<td>
							<c:choose>
								<c:when test="${not empty t_dto.getUpdate_date()}">${t_dto.getUpdate_date()}</c:when>
								<c:otherwise>수정 이력 없음</c:otherwise>
							</c:choose>
						</td>
					</tr>	

				</tbody>
			</table>
			<div class="preNext">
				<c:if test="${t_preDto ne null }">
					<a href="javascript:void()" onClick="goView('${t_preDto.getP_no()}')">
						<p class="pre"><span><i class="fa-solid fa-circle-arrow-left"></i> 이전글</span>
							<span class="preNextTitle">
								<c:choose>
									<c:when test="${fn:length(t_preDto.getP_name())>5 }">${fn:substring(t_preDto.getP_name(),0,5) }...</c:when>
									<c:otherwise>${t_preDto.getP_name()}</c:otherwise>
								</c:choose>
							</span>
						</p>
					</a>
				</c:if>
				<c:if test="${t_proDto ne null }">
					<a href="javascript:void()" onClick="goView('${t_proDto.getP_no()}')">
						<p class="next"><span>다음글 <i class="fa-solid fa-circle-right"></i></span>
							<span class="preNextTitle">
								<c:choose>
									<c:when test="${fn:length(t_proDto.getP_name())>5 }">${fn:substring(t_proDto.getP_name(),0,5) }...</c:when>
									<c:otherwise>${t_proDto.getP_name()}</c:otherwise>
								</c:choose>
							</span>
						</p>
					</a>
				</c:if>
			</div>
<style>
	.buy_btn{
		margin-right:230px;
	}
</style>
			<div class="buttonGroup">
				<a href="javascript:void()" onClick="goCustomer('list')" class="butt">List</a>
				<a href="javascript:void()" onClick="goBuy()" class="butt buy_btn">Buy</a>
			</div>	
		</div>	
	</div>
<%@include file="../common_footer.jsp"%>