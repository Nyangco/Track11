<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	function goNewPW(){
		mem.t_newPassword.focus();
	}function goNewPWconfirm(){
		mem.t_newPassword_confirm.focus();
	}function goUpdate(){
		if(checking(mem.t_oldPassword,60,"구 비밀번호"));
		else if(checking(mem.t_newPassword,60,"새 비밀번호"));
		else if(checking(mem.t_newPassword_confirm,60,"새 비밀번호 확인"));
		else if(mem.t_newPassword.value!=mem.t_newPassword_confirm.value){
			alert("비밀번호가 일치하지 않습니다.");
			mem.t_newPassword.focus();
		}else {
			mem.method="post";
			mem.action="Member";
			mem.submit();
		}
	}
</script>
	<div id="container">
		<div id="b_right">
			<p class="n_title">
				PASSWORD UPDATE
			</p>
			<form name="mem">
			<input type="hidden" name="t_requestPage" value="DBPWchange">
			<input type="hidden" name="t_id" value="${sId }">
			<table class="boardForm">
			  <colgroup>
				<col width="200" />
				<col width="500" />
			  </colgroup>
			  <tbody>
				<tr>
				  <th>기존 비밀번호</th>
				  <td>
				  	<input name="t_oldPassword" type="password" size="13" maxlength="60" autofocus onkeypress="if(event.keyCode==13) goNewPW()">
				  </td>
				</tr>
				<tr>
				  <th>새 비밀번호</th>
				  <td>
				  	<input name="t_newPassword" type="password" size="13" maxlength="60" onkeypress="if(event.keyCode==13) goNewPWconfirm()">
				  </td>
				</tr>
				<tr>
				  <th>새 비밀번호 확인</th>
				  <td>
				  	<input name="t_newPassword_confirm" type="password" size="13" maxlength="60" onkeypress="if(event.keyCode==13) goUpdate()">
				  </td>
				</tr>
			  </tbody>
			</table>
			</form>
			<div class="buttonGroup_center">
				<a href="javascript:void()" onClick="goUpdate()" class="butt">UPDATE</a>
			</div>	
		</div>	
	</div>
<%@include file="/common_footer.jsp"%>