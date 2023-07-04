<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common_header.jsp" %>
<script>
	function goSearch(){
		customer.method="post";
		customer.action="Customer";
		customer.submit();
	}function goPage(page){
		customer.t_nowPage.value=page;
		customer.method="post";
		customer.action="Customer";
		customer.submit();
	}function goView(no){
		customer.t_p_no.value=no;
		customer.t_requestPage.value="view";
		customer.method="post";
		customer.action="Customer";
		customer.submit();
	}
</script>
<style>
	.product_image{
		width:251px;
		height:251px;
	}
	.product_image img{
		width:249px;
		height:249px;
		border:solid black 1px;
	}
	.product_price{
		color:red;
	}
	.product_hit{
		color:gray;
	}
</style>
	<div id="container">
		<div id="b_right" style="width:1024px;float:left;">
			<p class="n_title" style="width:1024px;">
				PRODUCT
			</p>
			<div class="record_group record_group_left">
				<p><i class="fa-solid fa-bell"></i> 총 상품 수<span> ${t_totalCount } </span>건</p>
			</div>			
			<form name="customer">
			<input type="hidden" name="t_p_no">
			<input type="hidden" name="t_nowPage">
			<input type="hidden" name="t_requestPage" value="list">
			<p class="select_box select_box_right" style="width:600px;">
				<select name="t_sort" onchange="goSearch()" class="sel_box" style="width:100px;">
					<option value="20" <c:if test="${t_sort eq '20' }">selected</c:if> >20개씩 정렬</option>
					<option value="100" <c:if test="${t_sort eq '100' }">selected</c:if> >100개씩 정렬</option>
				</select>
				<select name="t_tag" onchange="goSearch()" class="sel_box">
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
			<table class="boardList" style="border-top:solid black 1px;">
				<colgroup>
					<col width="25%">
					<col width="25%">
					<col width="25%">
					<col width="25%">
				</colgroup>
				<c:set var="sVar"></c:set>
				<c:forEach items="${t_arr }" var="rArr" step="4" varStatus="rs">
				<c:set var="sVar" value="${rs.index }"></c:set>
				
				<tr>
					<c:forEach items="${t_arr }" var="arr" begin="${sVar }" end="${sVar+3 }">
						<td>
							<div class="product_total" onclick="goView('${arr.getP_no()}')">
								<div class="product_image">
									<img src="attach/product/${arr.getAttach() }" >
								</div>
								<div class="product_content">
									<p class="product_name">${arr.getP_name() }</p>
									<c:choose>
										<c:when test="${arr.getPrice() eq arr.getP_content() }">
											<p class="product_price">${arr.getPrice() }원</p>
										</c:when>
										<c:when test="${arr.getPrice() ne arr.getP_content() }">
											<p class="product_price" >
												<span style="color:gray;text-decoration:line-through;">${arr.getPrice() }원</span>
												${arr.getP_content() }원
											</p>
										</c:when>
									</c:choose>
									
									<p class="product_hit"><i class="fa-solid fa-eye"></i>${arr.getHit() }</p>
								</div>
							</div>
						</td>
					</c:forEach>				
				</tr>
				</c:forEach>
				<tr>
					<td>
					</td>
					<td>
					</td>
					<td>
					</td>
					<td>
					</td>
				</tr>
			</table>
			
			<div class="paging">
				${t_paging }
			</div>
		</div>	
	</div>
<%@ include file="/common_footer.jsp" %>