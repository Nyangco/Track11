<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common_header.jsp" %>
<script>
	function goPw(){
		mem.t_password.focus();
	}function goLogin(){
		mem.method="post";
		mem.action="Member";
		mem.submit();
	}
</script>
	<div id="container">
		<%@include file="./member_leftN.jsp" %>
		<div id="b_right">
			<p class="n_title">
				MEMBER LOGIN 
			</p>
		
			<div class="login">
				<div class="member_boxL">
					<h2>LOGIN</h2>
					<div class="login_form">
						<form name="mem">
							<input type="hidden" name="t_requestPage" value="DBlogin">
							<div class="fl_clear"><label for="mbrId">아이디</label><input type="text" name="t_id" id="mbrId"  onkeypress="if( event.keyCode==13 ){goPw()}" autofocus></div>
							<div class="fl_clear"><label for="scrtNo">비밀번호</label><input type="password" name="t_password" id="scrtNo" onkeypress="if( event.keyCode==13 ){goLogin()}"></div>
							<a class="btn_login btn_Blue" href="javascript:void()" onClick="goLogin()">로그인</a>
						</form>
					</div>
				   
				</div>		
			</div>

		</div>	
	</div>
<%@ include file="/common_footer.jsp"%>