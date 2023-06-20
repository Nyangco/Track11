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
	}function goDelete(){
		if(confirm("정말로 탈퇴시키겠습니까?")){
			admin.t_requestPage.value="DBdelete";
			admin.method="post";
			admin.action="Admin";
			admin.submit();
		}
	}
</script>
<form name="admin">
	<input type="hidden" name="t_id" value="${t_dto.getId() }">
	<input type="hidden" name="t_requestPage" value="update">
	<input type="hidden" name="t_sLevel" value="${t_dto.getsLevel() }">
</form>
	<div id="container">
		<div id="b_right">
			<p class="n_title">
				MEMBER
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
				  <th>비밀번호</th>
				  <td>${t_pw}</td>
				</tr>
				<tr>
				  <th>관리 권한</th>
				  <td>
				  	<c:choose>
				  		<c:when test="${sLevel>=t_dto.getsLevel() }">${t_dto.getsLevel() }</c:when>
				  		<c:otherwise>접근 권한이 없습니다</c:otherwise>
				  	</c:choose>
				  </td>
				</tr>
				<tr>
				  <th><label for="nana">성 명</label></th>
				  <td>${t_dto.getName()}</td>
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
				  <td>
				  	<c:choose>
				  		<c:when test="${t_dto.getUpdate_date()}">${t_dto.getUpdate_date()}</c:when>
				  		<c:otherwise>회원 수정 이력 없음</c:otherwise>
				  	</c:choose>
				  </td>
				</tr>
				<tr>
				  <th>최근 로그인 일자</th>
				  <td>
					  <c:choose>
				  		<c:when test="${t_dto.getLast_login_date()}">${t_dto.getLast_login_date()}</c:when>
				  		<c:otherwise>최근 로그인 이력 없음</c:otherwise>
				  	  </c:choose>
				  </td>
				</tr>
				<tr>
				  <th>탈퇴 여부</th>
				  <td>
				  	<c:choose>
				  		<c:when test="${empty t_dto.getExit_date() }">활동중</c:when>
				  		<c:otherwise>탈퇴 일자 : ${t_dto.getExit_date() }</c:otherwise>
				  	</c:choose>
				  </td>
				</tr>
			  </tbody>
			</table>
			<div class="buttonGroup_center">
				<a href="javascript:void()" onClick="goAdmin('list')" class="butt">목록</a>
				<a href="javascript:void()" onClick="goUpdate()" class="butt">관리 권한 변경</a>
				<a href="javascript:void()" onClick="goDelete()" class="butt">계정 탈퇴</a>
			</div>	
		</div>	
	</div>
<%@include file="/common_footer.jsp"%>