<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common_header.jsp" %>
<script>
	function goIDEmail(){
		id.t_email.focus();
	}function goIDFind(){
		if(checking(id.t_name,10,"성함"));
		else if(checking(id.t_email,50,"이메일"));
		else{
			id.method="post";
			id.action="Member";
			id.submit();
		}
	}function goPWEmail(){
		password.t_email.focus();
	}function goPWfind(){
		if(checking(password.t_id,20,"아이디"));
		else if(checking(password.t_email,50,"이메일"));
		else{
			password.method="post";
			password.action="Member";
			password.submit();
		}
	}
</script>
	<div id="container">
		<div id="b_right">
			<p class="n_title">
				PASSWORD FIND
			</p>
		
			<div class="login">
				<div class="member_boxL">
					<h2>ID FIND</h2>
					<div class="login_form">
						<form name="id">
							<input type="hidden" name="t_requestPage" value="DBidFind">
							<div class="fl_clear"><label for="mbrId">이름</label>
								<input type="text" name="t_name" class="t_id" onkeypress="if( event.keyCode==13 ){goIDEmail()}" autofocus>
							</div>
							<div class="fl_clear"><label for="mbrId">이메일</label>
								<input type="email" name="t_email" class="t_id" onkeypress="if( event.keyCode==13 ){goIDFind()}">
							</div>
							<a class="btn_login btn_Blue" href="javascript:void()" onClick="goIDFind()">아이디 찾기</a>
						</form>
					</div>
				   
				</div>	
				<div class="member_boxL">
					<h2>PASSWORD FIND</h2>
					<div class="login_form">
						<form name="password">
							<input type="hidden" name="t_requestPage" value="DBpasswordFind">
							<div class="fl_clear"><label for="mbrId">아이디</label>
								<input type="text" name="t_id" class="t_id" onkeypress="if( event.keyCode==13 ){goPWEmail()}" autofocus>
							</div>
							<div class="fl_clear"><label for="mbrId">이메일</label>
								<input type="email" name="t_email" class="t_id" onkeypress="if( event.keyCode==13 ){goPWfind()}">
							</div>
							<a class="btn_login btn_Blue" href="javascript:void()" onClick="goPWfind()">비밀번호찾기</a>
						</form>
					</div>
				   
				</div>		
			</div>

		</div>	
	</div>
<%@ include file="/common_footer.jsp"%>