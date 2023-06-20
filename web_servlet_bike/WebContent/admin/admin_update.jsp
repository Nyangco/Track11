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
	function goUpdate(){
		admin.method="post";
		admin.action="Admin";
		admin.submit();
	}
</script>
	<div id="container">
		<div id="b_right">
			<p class="n_title">
				MEMBER
			</p>
			<form name="admin">
			<input type="hidden" name="t_id" value="${t_id}">
			<input type="hidden" name="t_requestPage" value="DBupdate">
				<table class="boardForm">
				  <colgroup>
					<col width="200" />
					<col width="500" />
				  </colgroup>
				  <tbody>
					<tr>
					  <th>관리 권한</th>
					  <td>
					  	<select name="t_sLevel">
					  		<c:forEach begin="0" end="${sLevel }" var="count">
					  			<option value="${count }"<c:if test="${t_sLevel eq count }">selected</c:if>>${count }</option>
					  		</c:forEach>
					  	</select>
					  </td>
					</tr>
				  </tbody>
				</table>
			</form>
			<div class="buttonGroup_center">
				<a href="javascript:void()" onClick="goAdmin('list')" class="butt">목록</a>
				<a href="javascript:void()" onClick="goUpdate()" class="butt">관리 권한 설정</a>
			</div>	
		</div>	
	</div>
<%@include file="/common_footer.jsp"%>