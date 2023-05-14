<%@page import="dto.MemberDto"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
	MemberDao dao = new MemberDao();
	MemberDto dto = dao.getMemberDB(sessionId);
	String mobile_1 = dto.getMobile().substring(0,3);
	String mobile_2 = dto.getMobile().substring(3,7);
	String mobile_3 = dto.getMobile().substring(7);
%>

	
	<!-- sub contents -->
	
	<script>
  	function first(){
		if(event.keyCode==13){
			if(checkValue(mem.t_pw_1,"기존 비밀번호를"));
			else{
				mem.t_pw_1.focus();
			}
		}
	}
  	
  	function next(){
  		if(event.keyCode==13){
			if(checkValue(mem.t_pw_1,"새 비밀번호를"));
			else{
				mem.t_pw_2.focus();
			}
		}
  	}
  	
  	function confirm(){
  		if(event.keyCode==13){
			if(checkValue(mem.t_pw_2,"새 비밀번호 확인을"));
			else{
				save();
			}
		}
  	}
  
  	function save(){
		if(mem.t_pw_1.value!=mem.t_pw_2.value){
  			alert("비밀번호가 일치하지 않습니다.");
  			mem.t_pw_1.focus();
  		}else{
  			mem.method="post";
  			mem.action="db_change_password.jsp";
  			mem.submit();
  		}
  	}
  </script>
	
	<div class="sub_title">
		<h2>마이 페이지</h2>
		
	</div>

	<div class="container">
		<div class="con_title">
            <h1>비밀번호 변경</h1>
        </div>
		<div class="join_write col_989">
                <div class="list_con">
                </div>
            <form name="mem">
            <table class="table_write02" summary="회원가입을 위한 이름, 아이디, 비밀번호, 비밀번호확인, 소속, 유선전화번호, 휴대전화번호, 이메일, 주소, 본인확인질문, 본인확인답, 주활용사이트, 알림여부 정보 입력">
                <colgroup>
                    <col width="160px">
                    <col width="auto">
                </colgroup>
                <tbody id="joinDataBody">
                    <tr>
                        <th><label for="id">아이디</label></th>
                        <td>
                            <input type="text" value="<%=sessionId %>" disabled style="border:none">
                            <input type="hidden" value="<%=sessionId %>" name="t_id">
						</td>
                    </tr>
                    <tr>
                        <th>기존 비밀번호</th>
                        <td>
                        	<input type="password" name="t_pw_0" autofocus onkeypress="next();">
                        </td>
                    </tr>
                    <tr>
                        <th>새 비밀번호</th>
                        <td>
                        	<input type="password" name="t_pw_1" autofocus onkeypress="next();">
                        </td>
                    </tr>
                    <tr>
                        <th>새 비밀번호 확인</th>
                        <td>
                            <input type="password" name="t_pw_2" onkeypress="confirm();">
                        </td>
                    </tr>
            </table>
            </form>
        </div>
	</div>
	<!-- end contents -->
	
	<div class="btnArea Acenter pt60 pb100">
        <a href="javascript:history.go(-1);" class="btn_round btn_large btn_BlueGray w180"><b>취소</b></a>
        <a href="javascript:save();" class="btn_round btn_large btn_pointColor w180"><b>확인</b></a>
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
	

<%@ include file="../common_footer.jsp" %>









