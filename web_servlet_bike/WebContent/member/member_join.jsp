<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common_header.jsp" %>
<script>
	function ajax(){
		$.ajax({
			type : "POST",
			url : "IdCheck",
			data: "t_id="+mem.t_id.value,
			dataType : "text",
			error : function(){
				alert('통신실패!!!!!');
			},
			success : function(data){
				var result= $.trim(data);
				mem.t_idCheck.value= result;
				if(result == "0"){
					mem.t_idCheckValue.value = "사용 가능";
				} else{
					mem.t_idCheckValue.value = "중복된 id";
				}
			}
		});	
	}
</script>
<script>
	function checkId(){
		if(mem.t_id.value==""){
			alert("id를 입력해주세요");
			mem.t_id.focus();
		}else {
			ajax();
		}
	}function goSave(){
		if(checking(mem.t_id,10,"ID"));
		else if(mem.t_idCheck.value!=0){
			alert("아이디 중복검사를 해주세요");
			mem.t_id.focus();
		}
		else if(checking(mem.t_name,10,"이름"));
		else if(checking(mem.t_password,64,"비밀번호"));
		else if(checking(mem.t_password_confirm,64,"비밀번호 확인"));
		else if(mem.t_password.value!=mem.t_password_confirm.value){
			alert("비밀번호가 일치하지 않습니다");
			mem.t_password.focus();
		}
		else if(checking(mem.t_email,50,"이메일"));
		else if(mem.t_email.value.indexOf("@")==-1){
			alert("이메일 주소가 정상적이지 않습니다.");
			mem.t_email.focus();
		}
		else if(checking(mem.t_area,5,"지역"));
		else if(checking(mem.t_address,40,"주소"));
		else if(checkingMobile(mem.t_mobile_1,3,"전화번호"));
		else if(checkingMobile(mem.t_mobile_2,4,"전화번호"));
		else if(checkingMobile(mem.t_mobile_3,4,"전화번호"));
		else if(checking(mem.t_gender,1,"성별"));
		else {
			if(mem.t_hobby_travel.checked) mem.t_hobby_travel_c.value="y";
			else mem.t_hobby_travel_c.value="n";
			if(mem.t_hobby_reading.checked) mem.t_hobby_reading_c.value="y";
			else mem.t_hobby_reading_c.value="n";
			if(mem.t_hobby_sports.checked) mem.t_hobby_sports_c.value="y";
			else mem.t_hobby_sports_c.value="n";
			mem.t_requestPage.value="DBsave";
			mem.method="post";
			mem.action="Member";
			mem.submit();
		}
	}
</script>
	<div id="container">
		<div id="b_right">
			<p class="n_title">
				MEMBER JOIN
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
					<input name="t_id" type="text" size="10" id="id" title="id입력하세요" onkeypress="mem.t_idCheck.value='2'" maxlength="10">
					<input type="button" onClick="checkId()" value="ID중복검사" class="checkB" >
					<input type="hidden" name="t_idCheck" value="2">
					<input type="text" name="t_idCheckValue" disabled style="border:none;">
				  </td>
				</tr>
				<tr>
				  <th><label for="nana">성 명</label></th>
				  <td><input name="t_name" type="text" size="8" id="nana" maxlength="10"></td>
				</tr>
				<tr>
				  <th>비밀번호</th>
				  <td><input name="t_password" type="password" size="13" maxlength="60"></td>
				</tr>
				<tr>
				  <th>비밀번호확인</th>
				  <td><input name="t_password_confirm" type="password" size="13" maxlength="60"></td>
				</tr>
				<tr>
				  <th>이메일</th>
				  <td><input name="t_email" type="email" size="40" maxlength="50"></td>
				</tr>
				<tr>
				  <th>지역</th>
				  <td>
					<select name="t_area">
						<option value="서울">서울</option>
						<option value="대전">대전</option>
						<option value="부산">부산</option>
						<option value="대구">대구</option>        
					</select>	  
				  </td>
				</tr>	
				<tr>
				  <th>주소</th>
				  <td><input name="t_address" type="text" size="40" maxlength="40"></td>
				</tr>
				<tr>
				  <th>연락처</th>
				  <td>
					<input name="t_mobile_1" type="text" size="3" maxlength="3"> -
					<input name="t_mobile_2" type="text" size="4" maxlength="4"> -
					<input name="t_mobile_3" type="text" size="4" maxlength="4">
				  </td>
				</tr>
				<tr>
				  <th>남여구분</th>
				  <td>
					  <input type="radio" value="f" name="t_gender" class="middleCheck" /> 여&nbsp;&nbsp;        
					  <input type="radio" value="m" name="t_gender" class="middleCheck" /> 남        
				  </td>
				</tr>
				<tr>
				  <th>취미</th>
				  <td>
					  <input type="checkbox" value="y" name="t_hobby_travel" class="middleCheck" /> 여행&nbsp;&nbsp; 
					  <input type="hidden" value="y" name="t_hobby_travel_c" class="middleCheck" />
					  <input type="checkbox" value="y" name="t_hobby_reading" class="middleCheck" /> 독서&nbsp;&nbsp; 
					  <input type="hidden" value="y" name="t_hobby_reading_c" class="middleCheck" />
					  <input type="checkbox" value="y" name="t_hobby_sports" class="middleCheck" /> 운동
					  <input type="hidden" value="y" name="t_hobby_sports_c" class="middleCheck" />
				  </td>
				</tr>
			  </tbody>
			</table>
			</form>
			<div class="buttonGroup_center">
				<a href="javascript:void()" onClick="goSave()" class="butt">JOIN</a>
			</div>	
		</div>	
	</div>
<%@include file="/common_footer.jsp"%>