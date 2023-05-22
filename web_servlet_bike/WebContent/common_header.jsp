<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>JSL11 연석모</title>
<link href="css/sub_c.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.8.1.min.js"></script>
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
		goPage.t_requestPage.value=page;
		goPage.method="post";
		goPage.action="Member";
		goPage.submit();
	}function goNotice(page){
		goPage.t_requestPage.value=page;
		goPage.method="post";
		goPage.action="Notice";
		goPage.submit();
	}
</script>
</head>
<body>
<form name="goPage">
	<input type="hidden" name="t_requestPage">
</form>
	<div id="container">
		<div id="b_top_menu">
			<ul class="top_menu">
				<li><a href="" class="allclick"><i class="fas fa-bars"></i></a></li>
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
				<li><a href="">Tires & Tubes</a>
					<div class="div6">
						<ul>
							<li><a href="">6sub menu 1</a></li>
							<li><a href="">6sub menu 2</a></li>
							<li><a href="">6sub menu 3</a></li>
							<li><a href="">6sub menu 4</a></li>
							<li><a href="">6sub menu 5</a></li>
						</ul>
					</div>					
				</li>
				<li><a href="javascript:void()" onClick="goNotice('list')">Notice & News</a>
					<div class="div7">
						<ul>
							<li><a href="javascript:void()" onClick="goNotice('list')">NOTICE</a></li>
							<li><a href="">NEWS</a></li>
							<li><a href="">Q AND A</a></li>
							<li><a href="">FREE BOARD</a></li>
							<li><a href="">ETC</a></li>
						</ul>
					</div>					
				</li>
			</ul>		
		</div>	
	</div>
