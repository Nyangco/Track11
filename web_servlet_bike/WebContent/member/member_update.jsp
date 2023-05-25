<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	function ajax(){
		$.ajax({
			type : "POST",
			url : "PwCheck",
			async : false,
			data: "t_password="+mem.t_password.value+"&t_id="+mem.t_id.value,
			dataType : "text",
			error : function(){
				alert('통신실패!!!!!');
			},
			success : function(data){
				var result= $.trim(data);
				mem.t_pwCheck.value= result;
			}
		});	
	}
</script>
<script>
	function goUpdate(){
		ajax();
		if(checking(mem.t_name,10,"이름"));
		else if(checking(mem.t_area,5,"지역"));
		else if(checking(mem.t_address,40,"주소"));
		else if(checkingMobile(mem.t_mobile_1,3,"전화번호"));
		else if(checkingMobile(mem.t_mobile_2,4,"전화번호"));
		else if(checkingMobile(mem.t_mobile_3,4,"전화번호"));
		else if(checking(mem.t_gender,1,"성별"));
		else {
			if(mem.t_pwCheck.value==2){
				alert("비밀번호 확인을 입력해주세요.");
				mem.t_password.focus();
			}else if(mem.t_pwCheck.value==3){
				alert("비밀번호가 일치하지 않습니다.");
				mem.t_password.focus();
			}else if(mem.t_pwCheck.value==1){
				if(mem.t_hobby_travel.checked) mem.t_hobby_travel_c.value="y";
				else mem.t_hobby_travel_c.value="n";
				if(mem.t_hobby_reading.checked) mem.t_hobby_reading_c.value="y";
				else mem.t_hobby_reading_c.value="n";
				if(mem.t_hobby_sports.checked) mem.t_hobby_sports_c.value="y";
				else mem.t_hobby_sports_c.value="n";
				mem.t_requestPage.value="DBupdate";
				mem.method="post";
				mem.action="Member";
				mem.submit();
			}
		}
	}
</script>
	<div id="container">
		<div id="b_right">
			<p class="n_title">
				MEMBER UPDATE
			</p>
			<form name="mem">
			<input type="hidden" name="t_requestPage">
			<table class="boardForm">
			  <colgroup>
				<col width="200" />
				<col width="500" />
			  </colgroup>
			  <tbody>
				<tr>
				  <th><label for="id">I D</label></th>
				  <td>
					<input name="t_id" type="text" size="10" id="id" value="${t_dto.getId() }" readonly>
				  </td>
				</tr>
				<tr>
				  <th><label for="nana">성 명</label></th>
				  <td><input name="t_name" type="text" size="8" id="nana" value="${t_dto.getName() }" ></td>
				</tr>
				<tr>
				  <th>이메일</th>
				  <td><input name="t_email" type="text" size="40" value="${t_dto.getEmail() }"></td>
				</tr>
				<tr>
				  <th>지역</th>
				  <td>
					<select name="t_area">
						<option value="서울" <c:if test="${t_dto.getArea() eq '서울' }">selected</c:if>>서울</option>
						<option value="대전" <c:if test="${t_dto.getArea() eq '대전' }">selected</c:if>>대전</option>
						<option value="부산" <c:if test="${t_dto.getArea() eq '부산' }">selected</c:if>>부산</option>
						<option value="대구" <c:if test="${t_dto.getArea() eq '대구' }">selected</c:if>>대구</option>        
					</select>	  
				  </td>
				</tr>	
				<tr>
				  <th>주소</th>
				  <td><input name="t_address" type="text" size="40" value="${t_dto.getAddress() }"></td>
				</tr>
				<tr>
				  <th>연락처</th>
				  <td>
					<input name="t_mobile_1" type="text" size="3" value="${t_dto.getMobile_1() }"> -
					<input name="t_mobile_2" type="text" size="4" value="${t_dto.getMobile_2() }"> -
					<input name="t_mobile_3" type="text" size="4" value="${t_dto.getMobile_3() }">
				  </td>
				</tr>
				<tr>
				  <th>남여구분</th>
				  <td>
					  <input type="radio" value="f" name="t_gender" class="middleCheck" <c:if test="${t_dto.getGender() eq 'f'}">checked</c:if>/> 여&nbsp;&nbsp;        
					  <input type="radio" value="m" name="t_gender" class="middleCheck" <c:if test="${t_dto.getGender() eq 'm'}">checked</c:if>/> 남        
				  </td>
				</tr>
				<tr>
				  <th>취미</th>
				  <td>
					  <input type="checkbox" value="y" name="t_hobby_travel" class="middleCheck" <c:if test="${t_dto.getHobby_travel() eq 'y'}">checked</c:if>/> 여행&nbsp;&nbsp; 
					  <input type="hidden" value="y" name="t_hobby_travel_c" class="middleCheck" />
					  <input type="checkbox" value="y" name="t_hobby_reading" class="middleCheck" <c:if test="${t_dto.getHobby_reading() eq 'y'}">checked</c:if>/> 독서&nbsp;&nbsp; 
					  <input type="hidden" value="y" name="t_hobby_reading_c" class="middleCheck" />
					  <input type="checkbox" value="y" name="t_hobby_sports" class="middleCheck" <c:if test="${t_dto.getHobby_sports() eq 'y'}">checked</c:if>/> 운동
					  <input type="hidden" value="y" name="t_hobby_sports_c" class="middleCheck" />
				  </td>
				</tr>
				<tr>
				  <th>비밀번호 확인</th>
				  <td>
				  	<input name="t_password" type="password" size="13" maxlength="60" onkeypress="mem.t_pwCheck.value='0'">
				  	<input name="t_pwCheck" type="hidden" value="0">
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