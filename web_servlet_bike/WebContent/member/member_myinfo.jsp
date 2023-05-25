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
		mem.t_requestPage.value="update";
		mem.method="post";
		mem.action="Member";
		mem.submit();
	}function goDelete(){
		if(confirm("정말로 탈퇴 하시겠습니까?")){
			mem.t_requestPage.value="DBdelete";
			mem.method="post";
			mem.action="Member";
			mem.submit();
		}
	}function goPWchange(){
		mem.t_requestPage.value="PWchange";
		mem.method="post";
		mem.action="Member";
		mem.submit();
	}
</script>
<form name="mem">
	<input type="hidden" name="t_id" value="${t_dto.getId() }">
	<input type="hidden" name="t_requestPage">
</form>
	<div id="container">
		<div id="b_right">
			<p class="n_title">
				MEMBER MYINFO
			</p>
			<table class="boardForm">
			  <colgroup>
				<col width="200" />
				<col width="500" />
			  </colgroup>
			  <tbody>
				<tr>
				  <th><label for="id">I D</label></th>
				  <td>${t_dto.getId()}</td>
				</tr>
				<tr>
				  <th><label for="nana">성 명</label></th>
				  <td>${t_dto.getName()}</td>
				</tr>
				<tr>
				  <th>비밀번호</th>
				  <td>${t_dto.getPassword()}</td>
				</tr>
				<tr>
				  <th>이메일</th>
				  <td>${t_dto.getEmail()}</td>
				</tr>
				<tr>
				  <th>지역</th>
				  <td>${t_dto.getArea()}</td>
				</tr>
				<tr>
				  <th>주소</th>
				  <td>${t_dto.getAddress()}</td>
				</tr>
				<tr>
				  <th>연락처</th>
				  <td>${t_dto.getMobile_1()}-${t_dto.getMobile_2()}-${t_dto.getMobile_3()}</td>
				</tr>
				<tr>
				  <th>성별</th>
				  <td>
				  	<c:if test="${t_dto.getGender() eq 'm' }">남성</c:if>
				  	<c:if test="${t_dto.getGender() eq 'f' }">여성</c:if>
				  </td>
				</tr>
				<tr>
				  <th>취미</th>
				  <td>
				  	<input type="checkbox" <c:if test="${t_dto.getHobby_travel() eq 'y'}">checked</c:if> disabled>여행 &nbsp;&nbsp;&nbsp;
				  	<input type="checkbox" <c:if test="${t_dto.getHobby_reading() eq 'y'}">checked</c:if> disabled>독서&nbsp;&nbsp;&nbsp;
				  	<input type="checkbox" <c:if test="${t_dto.getHobby_sports() eq 'y'}">checked</c:if> disabled>스포츠
				  </td>
				</tr>
				<tr>
				  <th>가입일</th>
				  <td>${t_dto.getReg_date()}</td>
				</tr>
				<tr>
				  <th>회원 수정일</th>
				  <td>${t_dto.getUpdate_date()}</td>
				</tr>
				<tr>
				  <th>최근 로그인 일자</th>
				  <td>${t_dto.getLast_login_date()}</td>
				</tr>
			  </tbody>
			</table>
			<div class="buttonGroup_center">
				<a href="javascript:void()" onClick="goUpdate()" class="butt">계정 정보 변경</a>
				<a href="javascript:void()" onClick="goPWchange()" class="butt">비밀 번호 변경</a>
				<a href="javascript:void()" onClick="goDelete()" class="butt">계정 삭제</a>
			</div>	
		</div>	
	</div>
<%@include file="/common_footer.jsp"%>