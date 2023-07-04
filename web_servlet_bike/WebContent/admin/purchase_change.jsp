<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	function goView(pn){
		admin.t_requestPage.value="view";
		admin.method="post";
		admin.action="Product";
		admin.submit();
	}
	function goUpdate(){
		admin.method="post";
		admin.action="Admin";
		admin.submit();
	}
</script>
	<div id="container">
		<div id="b_right">
			<p class="n_title">
				ADMIN
			</p>
			<form name="admin">
			<input type="hidden" name="t_requestPage" value="DBchange_product">
			<input type="hidden" name="t_p_no" value="${t_product_number}">
			<input type="hidden" name="t_purchase_number" value="${t_purchase_number }">
			<table class="boardForm">
			  <colgroup>
				<col width="200" />
				<col width="500" />
			  </colgroup>
			  <tbody>
				<tr>
				  <th>해당 상품</th>
				  <td>
				  	<a href="javascript:void()" onclick="goView()">${t_product_name }</a>
				  </td>
				</tr>
				<tr>
				  <th>교환 요청 내용</th>
				  <td>
				  	${t_refund }
				  </td>
				</tr>
				<tr>
				  <th>제품 변경</th>
				  <td>
				  	<input type="text" name="t_product_number" placeholder="제품 번호를 정확하게 입력해주세요">
				  </td>
				</tr>
			  </tbody>
			</table>
			</form>
			<div class="buttonGroup_center">
				<a href="javascript:void()" onClick="goUpdate()" class="butt">진행</a>
				<a href="javascript:void()" onClick="goAdmin('purchase_list')" class="butt">목록으로</a>
			</div>	
		</div>	
	</div>
<%@include file="/common_footer.jsp"%>