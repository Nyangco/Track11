<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<title>JSL11 연석모</title>
<link href="css/sub_c.css" rel="stylesheet">
<script src="https://kit.fontawesome.com/17da812ad5.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="js/jquery-1.8.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
<script src="js/common.js"></script>
<script type="text/javascript">
    //<![CDATA[
    $(function(){
    	$(".main_menu > li > a").mouseover(function(){
			$(".main_menu li div").hide();
			$(this).next().slideDown(500);
    	});    
    	$(".main_menu").mouseleave(function(){
			$(".main_menu li div").stop().slideUp(500);
		}) 
    });     
    //]]>
</script> 
<script>
	function goMember(page){
		goGo.t_requestPage.value=page;
		goGo.method="post";
		goGo.action="Member";
		goGo.submit();
	}function goNotice(page){
		goGo.t_requestPage.value=page;
		goGo.method="post";
		goGo.action="Notice";
		goGo.submit();
	}function goNews(page){
		goGo.t_requestPage.value=page;
		goGo.method="post";
		goGo.action="News";
		goGo.submit();
	}function goQna(page){
		goGo.t_requestPage.value=page;
		goGo.method="post";
		goGo.action="Qna";
		goGo.submit();
	}function goFreeBoard(page){
		goGo.t_requestPage.value=page;
		goGo.method="post";
		goGo.action="FreeBoard";
		goGo.submit();
	}function goEtc(page){
		goGo.t_requestPage.value=page;
		goGo.method="post";
		goGo.action="Etc";
		goGo.submit();
	}function goAdmin(page){
		goGo.t_requestPage.value=page;
		goGo.method="post";
		goGo.action="Admin";
		goGo.submit();
	}function goProduct(page){
		goGo.t_requestPage.value=page;
		goGo.method="post";
		goGo.action="Product";
		goGo.submit();
	}function goCustomer(page){
		goGo.t_requestPage.value=page;
		goGo.method="post";
		goGo.action="Customer";
		goGo.submit();
	}
</script>
</head>
<body>
<form name="goGo">
	<input type="hidden" name="t_requestPage">
</form>
	<div id="container">
		<div id="b_top_menu">
			<ul class="top_menu">
				<li><a href="" class="allclick"><i class="fas fa-bars"></i></a></li>
					<c:if test="${not empty sLevel }">
					<li><a href="javascript:void()" onClick="goCustomer('receipt_list')">구매이력</a></li>
					</c:if>
					<c:if test="${sLevel >= 1 }">
					<li><a href="javascript:void()" onClick="goAdmin('list')">Admin</a></li>
					</c:if>
					<c:if test="${empty sId }">
					<li><a href="javascript:void()" onClick="goMember('join')">Join</a></li>
					<li><a href="javascript:void()" onClick="goMember('login')">Login</a></li>
					</c:if>
					<c:if test="${!empty sId }">
					<li><a href="javascript:void()" onClick="goMember('myinfo')">Myinfo</a></li>
					<li><a href="javascript:void()" onClick="goMember('logout')">Logout</a></li>
					</c:if>
					<li><a href="javascript:void()" onClick="location.href='Index'"><i class="fa fa-home" aria-hidden="true"></i> Home</a></li>
					<c:if test="${!empty sId}">
					<li><a>${sName }님</a></li>
					</c:if>
			</ul>
		</div>	

		<div id="b_top">
			<ul class="main_menu">
				<li><a href="">Accessories</a>
					<div>
						<ul>
							<li><a href="">Bells</a></li>
							<li><a href="">Camping</a></li>
							<li><a href="">Embrocation</a></li>
							<li><a href="">Fenders</a></li>
							<li><a href="">Kickstands</a></li>
							<li><a href="">Horns</a></li>
						</ul>
					</div>
				</li>
				<li><a href="">Bikes & Frames</a>
					<div>
						<ul>
							<li><a href="">BMX</a></li>
							<li><a href="">Cyclocross</a></li>
							<li><a href="">Forks</a></li>
							<li><a href="">Frames</a></li>
						</ul>
					</div>
				
				</li>
				<li><a href="">Clothing</a>
					<div class="div3">
						<ul>
							<li><a href="">3sub menu 1</a></li>
							<li><a href="">3sub menu 2</a></li>
							<li><a href="">3sub menu 3</a></li>
						</ul>
					</div>				
				</li>
				<li><a href="">Maintenance</a>
					<div class="div4">
						<ul>
							<li><a href="">4sub menu 1</a></li>
							<li><a href="">4sub menu 2</a></li>
							<li><a href="">4sub menu 3</a></li>
							<li><a href="">4sub menu 4</a></li>
							<li><a href="">4sub menu 5</a></li>
						</ul>
					</div>					
				</li>
				<li><a href="">Parts</a>
					<div class="div5">
						<ul>
							<li><a href="">5sub menu 1</a></li>
							<li><a href="">5sub menu 2</a></li>
							<li><a href="">5sub menu 3</a></li>
							<li><a href="">5sub menu 4</a></li>
							<li><a href="">5sub menu 5</a></li>
						</ul>
					</div>					
				</li>
				<li><a href="Customer">Product</a></li>
				<li><a href="javascript:void()" onClick="goNotice('list')">Notice & News</a>
					<div class="div7">
						<ul>
							<li><a href="javascript:void()" onClick="goNotice('list')">NOTICE</a></li>
							<li><a href="javascript:void()" onClick="goNews('list')">NEWS</a></li>
							<li><a href="javascript:void()" onClick="goQna('list')">Q & A</a></li>
							<li><a href="javascript:void()" onClick="goFreeBoard('list')">FREE BOARD</a></li>
							<li><a href="javascript:void()" onClick="goEtc('list')">ETC</a></li>
						</ul>
					</div>					
				</li>
			</ul>		
		</div>	
		<c:if test="${t_nowPage ne 'Member' && t_nowPage ne 'Admin' && t_nowPage ne 'Product' && not empty t_nowPage}">
			<div id="b_left">
			<P>${t_nowPage }</P>
			<ul>
				<li><a href="javascript:void()" onClick="goNotice('list')"><c:if test="${t_nowPage eq 'Notice' }"><span class="fnt"><i class="fas fa-apple-alt"></i></span></c:if> NOTICE</a></li>
				<li><a href="javascript:void()" onClick="goNews('list')"><c:if test="${t_nowPage eq 'News' }"><span class="fnt"><i class="fas fa-apple-alt"></i></span></c:if> NEWS</a></li>
				<li><a href="javascript:void()" onClick="goQna('list')"><c:if test="${t_nowPage eq 'Qna' }"><span class="fnt"><i class="fas fa-apple-alt"></i></span></c:if> Q & A</a></li>
				<li><a href="javascript:void()" onClick="goFreeBoard('list')"><c:if test="${t_nowPage eq 'FreeBoard' }"><span class="fnt"><i class="fas fa-apple-alt"></i></span></c:if> FREE BOARD</a></li>
				<li><a href="javascript:void()" onClick="goEtc('list')"><c:if test="${t_nowPage eq 'Etc' }"><span class="fnt"><i class="fas fa-apple-alt"></i></span></c:if> ETC</a></li>
			</ul>
			</div>
		</c:if>
		<c:if test="${t_nowPage eq 'Admin' || t_nowPage eq 'Product' }">
			<div id="b_left">
			<P>Admin</P>
			<ul>
				<li><a href="javascript:void()" onClick="goAdmin('list')"><c:if test="${t_nowPage eq 'Admin' and (t_requestPage ne 'purchase_list' and t_requestPage ne 'purchase_view' and t_requestPage ne 'change_product' and t_requestPage ne 'statics_list')}"><span class="fnt"><i class="fas fa-apple-alt"></i></span></c:if> MEMBER</a></li>
				<li><a href="javascript:void()" onClick="goProduct('list')"><c:if test="${t_nowPage eq 'Product'}"><span class="fnt"><i class="fas fa-apple-alt"></i></span></c:if> PRODUCT</a></li>
				<li><a href="javascript:void()" onClick="goAdmin('purchase_list')"><c:if test="${t_nowPage eq 'Admin' and (t_requestPage eq 'purchase_list' or t_requestPage eq 'purchase_view' or t_requestPage eq 'change_product' or t_requestPage eq 'statics_list')}"><span class="fnt"><i class="fas fa-apple-alt"></i></span></c:if> PURCHASE</a></li>
			</ul>
			</div>
		</c:if>
		<c:if test="${t_nowPage eq 'Member' && empty sLevel}">
			<div id="b_left">
				<P>MEMBER</P>
				<ul>
					<li><a href="javascript:void()" onClick="goMember('login')"><c:if test="${t_requestPage eq 'login' }"><span class="fnt"><i class="fas fa-apple-alt"></i></span></c:if> LOGIN</a></li>
					<li><a href="javascript:void()" onClick="goMember('passwordFind')"><c:if test="${t_requestPage eq 'passwordFind' }"><span class="fnt"><i class="fas fa-apple-alt"></i></span></c:if> ID / PASSWORD</a></li>
					<li><a href="javascript:void()" onClick="goMember('join')"><c:if test="${t_requestPage eq 'join' }"><span class="fnt"><i class="fas fa-apple-alt"></i></span></c:if> JOIN</a></li>
				</ul>
			</div>
		</c:if>
		<c:if test="${t_nowPage eq 'Member' && not empty sLevel}">
			<div id="b_left">
				<P>MEMBER</P>
				<ul>
					<li><a href="javascript:void()" onClick="goMember('myinfo')"><c:if test="${t_requestPage eq 'myinfo' }"><span class="fnt"><i class="fas fa-apple-alt"></i></span></c:if> MYINFO</a></li>
				</ul>
			</div>
		</c:if>
	</div>
