<%@page import="dao.MemberDao"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
	MemberDao dao = new MemberDao();
	String[] fTell = {"02","031","032","033","041","042","043","044","051","052","053","054","055","061","062","063","064"};
	
	
	if(!sessionId.equals("")){
	MemberDto dto = dao.getMemberDB(sessionId);
	String mobile_1 = dto.getMobile().substring(0,3);
	String mobile_2 = dto.getMobile().substring(3,7);
	String mobile_3 = dto.getMobile().substring(7);
%>
<script>
	function checkPhone(input){
		if(input.value.length!=4){
			alert("휴대전화의 각 자릿수는 4자리 입니다.");
			input.focus();
			return true;
		}return false;
	}
	
	function memberUpdate(){
		if(checkValue(mem.t_password,"비밀번호를"));
		else if(checkValue(mem.t_name,"성명을"));
		else if(checkLength(mem.t_name,5,"성명의"));
		else if(mem.t_tell_1.value!="" && (mem.t_tell_2.value==0 || mem.t_tell_3.value==0)){
			alert("유선 번호를 입력해주세요");
			if(mem.t_tell_2.value==0) mem.t_tell_2.focus();
			else mem.t_tell_3.focus();
		}
		else if(mem.t_tell_2.value.length!=3 && mem.t_tell_2.value.length!=0){
			alert("3자리로 입력해주세요");
			mem.t_tell_2.focus();			
		}else if(mem.t_tell_3.value.length!=4 && mem.t_tell_3.value.length!=0){
			alert("4자리로 입력해주세요");
			mem.t_tell_3.focus();			
		}else if(mem.t_tell_2.value.length==0 && mem.t_tell_2.value.length==4){
			alert("3자리로 입력해주세요");
			mem.t_tell_3.focus();			
		}else if(mem.t_tell_2.value.length==3 && mem.t_tell_2.value.length==0){
			alert("4자리로 입력해주세요");
			mem.t_tell_3.focus();			
		}else if(checkValue(mem.t_mobile_2,"휴대전화 번호를"));
		else if(checkPhone(mem.t_mobile_2));
		else if(checkValue(mem.t_mobile_3,"휴대전화 번호를"));
		else if(checkPhone(mem.t_mobile_3));
		else if(checkValue(mem.t_email,"이메일을"));
		else if(checkLength(mem.t_email,30,"이메일의"));
		else{
			mem.method="post";
			mem.action="db_member_update.jsp";
			mem.submit();
		}
	}
</script>
	<div class="container">
		<div class="con_title">
            <h1>내정보(개인회원)</h1>
         <p>HOME / 마이페이지 / 내정보(개인회원)</p>
        </div>
		<div class="join_write col_989">
                <div class="list_con">
                    <ul class="icon_type1">
                        <li>회원정보는 개인정보 취급방침에 따라 안전하게 보호되며 회원님의 명백한 동의 없이 공개 또는 제3자에게 제공되지 않습니다.</li>
                    </ul>
                </div>
            <form name="mem">
            <table class="table_write02" summary="회원가입을 위한 이름, 아이디, 비밀번호, 비밀번호확인, 소속, 유선전화번호, 휴대전화번호, 이메일, 주소, 본인확인질문, 본인확인답, 주활용사이트, 알림여부 정보 입력">
                <caption>회원가입을 위한 정보입력표</caption>
                <colgroup>
                    <col width="160px">
                    <col width="auto">
                </colgroup>
                <tbody id="joinDataBody">
                	<tr>
                        <th><label for="id">아이디<span class="must"></span></label></th>
                        <td>
                            <input type="text" value="<%=sessionId %>" disabled style="border:none" class="w300">
                            <input type="hidden" name="t_id" value="<%=sessionId %>">
						</td>
                    </tr>
                    <tr>
                        <th><label for="pw">비밀번호 <span class="must"><b>확인</b></span></label></th>
                        <td>
                            <input type="password" name="t_password" id="scrtNo" class="w300">
                            <p class="guideTxt"></p>
                        </td>
                    </tr>
                    <tr>
                        <th><label for="name">이름</label></th>
                        <td>
                        	<input type="text" name="t_name" value="<%=dto.getName() %>">
                        </td>
                    </tr>
                    <tr>
                        <th>소속<span class="must"><b>필수입력</b></span></th>
                        <td>
                            <label for="mbrClCd" class="blind">소속1차 카테고리 선택</label>
                            <select name="t_job" id="mbrClCd">
                                    <option value="기업" <%if(dto.getJob().equals("기업"))out.print("selected");%>>기업</option>
                                    <option value="교수자" <%if(dto.getJob().equals("교수자"))out.print("selected");%>>교수자</option>
                                    <option value="미취업자" <%if(dto.getJob().equals("미취업자"))out.print("selected");%>>미취업자</option>
                                    <option value="기타" <%if(dto.getJob().equals("기타"))out.print("selected");%>>기타</option>
                            </select>
                            <p class="guideTxt">학생 신분은 '미취업자' 소속으로 선택해주십시오.</p>
                        </td>
                    </tr>
                    <tr>
                        <th>유선전화</th>
                        <td>
                            <label for="phone_number1" class="blind">유선전화 앞번호 선택</label>
                            <select name="t_tell_1" id="telNo1" class="w95">
                                <option value="" >부재</option>
                                	<%
                                	String tell_1 = dto.getTell_1()==null ? "" : dto.getTell_1();
                                	for(int k=0; k<fTell.length; k++){%>
									<option value="<%=fTell[k] %>" <%if(tell_1.equals(fTell[k])) out.print("selected");%>><%=fTell[k] %></option>                              
                                	<% }%>
                            </select>
                            <input type="text" name="t_tell_2" id="telNo2" class="w95" value="<%=dto.getTell_2()==null ? "" : dto.getTell_2() %>" maxlength="3"><label for="phone_number2" class="blind">중간번호</label>
                            <input type="text" name="t_tell_3" id="telNo3" class="w95" value="<%=dto.getTell_3()==null ? "" : dto.getTell_3() %>" maxlength="4"><label for="phone_number3" class="blind">마지막번호</label>
                            <p class="guideTxt">유선 전화가 없을 경우 국번의 '부재'를 선택해 주십시오.</p>
                        </td>
                    </tr>
                    <tr>
                        <th>휴대전화<span class="must"></th>
                        <td>
                            <label for="mphonNo1" class="blind">휴대전화 앞번호 선택</label>
                            <select name="t_mobile_1" id="mphonNo1" class="w95">
                                    <option value="010" <%if(mobile_1.equals("010")) out.print("selected"); %>>010</option>
                                    <option value="011" <%if(mobile_1.equals("011")) out.print("selected"); %>>011</option>
                            </select>
                            <input type="text" name="t_mobile_2" id="mphonNo2" class="w95" maxlength="4" value="<%=mobile_2%>"><label for="mphonNo2" class="blind">중간번호</label>
                            <input type="text" name="t_mobile_3" id="mphonNo3" class="w95" maxlength="4" value="<%=mobile_3%>"><label for="mphonNo3" class="blind">마지막번호</label>
                        </td>
                    </tr> 
                    <tr>
                        <th><label for="email">이메일</label></th>
                        <td>
                            <input type="email" name="t_email" id="email" class="w300" value="<%=dto.getEmail()%>">
                        </td>
                    </tr>
            </table>
            </form>
        </div>
	</div>
	<!-- end contents -->
	
	<div class="btnArea Acenter pt60 pb100">
        <a href="javascript:history.go(-1);" class="btn_round btn_large btn_BlueGray w180"><b>취소</b></a>
        <a href="javascript:memberUpdate();" class="btn_round btn_large btn_pointColor w180"><b>확인</b></a>
    </div>
	
	
	<script>
		$(function() {
			$(".location  .dropdown > a").on("click",function(e) {
				e.preventDefault();
				if($(this).next().is(":visible")) {
					$(".location  .dropdown > a").next().hide();
				} else {
					$(".location  .dropdown > a").next().hide();
					$(this).next().show();
				}
			});
		});
	</script>
	<%} else{ %>
 <script>
	alert("로그인 정보가 만료되었습니다.");
	location.href="../login/member_login.jsp";
</script>
<%} %>

<%@ include file="../common_footer.jsp" %>










