<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	function goUpdate(){
		checking(product.t_tag_code,4,"Tag 구분");
		checking(product.t_tag_name,10,"Tag 이름");
		product.method="post";
		product.action="Product";
		product.submit();
	}
</script>
	<div id="container">
		<div id="b_right">
			<p class="n_title">
				Tag 편집 / 입력
			</p>
			<form name="product">
			<input type="hidden" name="t_requestPage" value="DBtag">
			<table class="boardForm">
			  <colgroup>
				<col width="200" />
				<col width="500" />
			  </colgroup>
			  <tbody>
				<tr>
				  <th>Tag 선택</th>
				  <td>
				  	<select name="t_tag_code">
				  		<option value="new">새 태그 입력</option>
				  		<c:forEach items="${t_arr }" var="arr">
				  			<c:if test="${arr[0] ne 'T000'}"><option value="${arr[0] }">${arr[1] }</option></c:if>
				  		</c:forEach>
				  	</select>
				  </td>
				</tr>
				<tr>
				  <th>Tag 명</th>
				  <td>
				  	<input name="t_tag_name" type="text" placeholder="삭제하시려면 0을 입력해주세요" size="25">
				  </td>
				</tr>
			  </tbody>
			</table>
			</form>
			<div class="buttonGroup_center">
				<a href="javascript:void()" onClick="goUpdate()" class="butt">확인</a>
				<a href="javascript:void()" onClick="goProduct('list')" class="butt">목록</a>
			</div>	
		</div>	
	</div>
<%@include file="/common_footer.jsp"%>