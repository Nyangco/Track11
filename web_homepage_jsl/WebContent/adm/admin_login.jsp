<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<script>
	function goNext(){
		if(event.keyCode==13){
			admin.t_pw.focus();
		}
	}
	function goLogin(){
		if(event.keyCode==13){
			admin_check();
		}
	}
	function admin_check() {
		if(checkValue(admin.t_id,"ID를"));
		else if(checkValue(admin.t_pw,"비밀번호를"));
		else{
			admin.method="post"
			admin.action="db_admin_check.jsp";
			admin.submit();
		}
	}
</script>
	<div class="bg_admim">
		<div class="container">
			<div class="grap">
				<form name="admin" >
					<fieldset>
						<legend class="sr-only">관리자로그인</legend>
						<label for="id" class="sr-only">아이디입력</label><input type="text" name="t_id" placeholder="아이디를 입력하세요" id="id" onkeypress="goNext()" autofocus>
						<label for="pw" class="sr-only">패스워드입력</label><input type="password" name="t_pw" placeholder="패스워드를 입력하세요" id="pw" onkeypress="goLogin()">
						<a href="javascript:void(0)" onClick="admin_check();" class="btn_admin">로그인</a>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
	<!-- end contents -->
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
	

<%@include file="../common_footer.jsp" %>









