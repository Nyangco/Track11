<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../common_header.jsp" %>


<script>
	function fn_login(){
		if(checkValue(mem.t_id,"id를"));
		else if(checkValue(mem.t_password,"비밀번호를"));
		else{
			mem.method="post";
			mem.action="db_member_login.jsp";
			mem.submit();
		}
	}
	
	function idCheck(){
		if(event.keyCode==13){
			if(checkValue(mem.t_id,"id를"));
			mem.t_password.focus();
		}
	}
	
	function pwCheck(){
		if(event.keyCode==13){
			if(checkValue(mem.t_password,"비밀번호를"));
			fn_login();
		}
	}
</script>
	<div class="container">
		<div class="member_boxL">
               <h2>개인회원</h2>
               <div class="login_form">
                   <form name="mem" id="frmLogin">
                   <div class="fl_clear"><label for="mbrId">아이디</label><input name="t_id" id="mbrId" type="text" autofocus onkeypress="idCheck()"></div>
                   <div class="fl_clear"><label for="scrtNo">비밀번호</label><input name="t_password" id="scrtNo" type="password" onkeypress="pwCheck()"></div>
                   <a class="btn_login btn_Blue" href="javascript:fn_login();">로그인</a>
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
	

<%@ include file="../common_footer.jsp" %>









