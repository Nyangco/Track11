<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link href="css/index_c.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.8.1.min.js"></script>	
<title>홍길동</title>
<script type="text/javascript">
	$(function(){
		$(".main_menu > li > a").hover(function(){
			$(this).css("font-weight","bold");
		},function(){
			$(this).css("font-weight","");
		});		
		
		$(".bu_1").mouseover(function(){
			var imgName = $(this).attr('src');
			if(imgName =="images/bu_01.jpg"){
				$(this).attr("src","images/bu_01_over.jpg");
			} else if(imgName =="images/bu_02.jpg"){
				$(this).attr("src","images/bu_02_over.jpg");
			} else if(imgName =="images/bu_03.jpg"){
				$(this).attr("src","images/bu_03_over.jpg");
			} else if(imgName =="images/bu_04.jpg"){
				$(this).attr("src","images/bu_04_over.jpg");
			} else if(imgName =="images/bu_05.jpg"){
				$(this).attr("src","images/bu_05_over.jpg");
			} else if(imgName =="images/bu_06.jpg"){
				$(this).attr("src","images/bu_06_over.jpg");
			}
		});	
		$(".bu_1").mouseout(function(){
			var imgName = $(this).attr('src');
			if(imgName =="images/bu_01_over.jpg"){
				$(this).attr("src","images/bu_01.jpg");
			} else if(imgName =="images/bu_02_over.jpg"){
				$(this).attr("src","images/bu_02.jpg");
			} else if(imgName =="images/bu_03_over.jpg"){
				$(this).attr("src","images/bu_03.jpg");
			} else if(imgName =="images/bu_04_over.jpg"){
				$(this).attr("src","images/bu_04.jpg");
			} else if(imgName =="images/bu_05_over.jpg"){
				$(this).attr("src","images/bu_05.jpg");
			} else if(imgName =="images/bu_06_over.jpg"){
				$(this).attr("src","images/bu_06.jpg");
			}			
		});				

		$(".allclick").click(function(e){
			e.preventDefault();
			$("#disableDiv").css("display","block");
			$("#b_menu_all").slideDown(500);
			$("#b_menu_all").css("z-index","999");
		});
		
		$(".closeclick").click(function(e){
			e.preventDefault();
			$("#b_menu_all").slideUp(500);
			$("#disableDiv").css("display","none");
		});

	});	
</script>
<style>
#disableDiv { position:absolute; left:0; top:0;width:100%; height:1700px; z-index:995 ; background-color:#EEEEEE; filter:Alpha(opacity=80);opacity:0.8; -moz-opaciry:0.8}
</style>
<script>
	function goWork(page){
		bike.t_requestPage.value=page;
		bike.method="post";
		bike.action="Member";
		bike.submit();
	}function goHome(){
		bike.method="post";
		bike.action="Index";
		bike.submit();
	}
</script>
</head>
<body>
<form name="bike">
	<input type="hidden" name="t_requestPage">
</form>
<div id="disableDiv" class="disableDiv" style="display:none"></div>
<div id="container">

	<div id="container_top">	
			<div id="b_top_menu">
				<ul class="top_menu">
					<li><a href="" class="allclick"><i class="fas fa-bars"></i></a></li>
					<c:if test="${sId eq null}">
					<li><a href="javascript:void()" onClick="goWork('join')">Join</a></li>
					<li><a href="javascript:void()" onClick="goWork('login')">Login</a></li>
					</c:if>
					<c:if test="${sId ne null}">
					<li><a href="javascript:void()" onClick="goWork('myinfo')">Myinfo</a></li>
					<li><a href="javascript:void()" onClick="goWork('logout')">Logout</a></li>
					</c:if>
					<li><a href="javascript:void()" onClick="goHome()"><i class="fa fa-home" aria-hidden="true"></i> Home</a></li>
					<c:if test="${sId ne null}">
					<li><a>${sName }님</a></li>
					</c:if>
				</ul>
			</div>	
	</div>
	<div id="container_bottom">			
		<div id="b_menu_all">		
			<div id="b_menu_all_top">
				<div class="menu1"><a href=""><span class="maintitle">Accessories</span></a>
					<ul>
						<li>menu1 sub1</li>
						<li>menu1 sub2</li>
						<li>menu1 sub3</li>
						<li>menu1 sub4</li>
						<li>menu1 sub5</li>
					</ul>
				</div>
				<div class="menu1"><a href=""><span class="maintitle">Bikes & Frames</span></a>
					<ul>
						<li>menu2 sub1</li>
						<li>menu2 sub2</li>
						<li>menu2 sub3</li>
						<li>menu2 sub4</li>
						<li>menu2 sub5</li>
						<li>menu2 sub6</li>
						<li>menu2 sub7</li>
					</ul>
				</div>
				<div class="menu1"><a href=""><span class="maintitle">Clothing</span></a>
					<ul>
						<li>menu3 sub1</li>
						<li>menu3 sub2</li>
						<li>menu3 sub3</li>
						<li>menu3 sub4</li>
						<li>menu3 sub5</li>
						<li>menu3 sub6</li>
						<li>menu3 sub7</li>
						<li>menu3 sub8</li>
					</ul>
				</div>
				<div class="menu1"><a href=""><span class="maintitle">Maintenance</span></a>
					<ul>
						<li>menu4 sub1</li>
						<li>menu4 sub2</li>
						<li>menu4 sub3</li>
						<li>menu4 sub4</li>
						<li>menu4 sub5</li>
					</ul>
				</div>
				<div class="menu1"><a href=""><span class="maintitle">Parts</span></a>
					<ul>
						<li>menu5 sub1</li>
						<li>menu5 sub2</li>
						<li>menu5 sub3</li>
						<li>menu5 sub4</li>
						<li>menu5 sub5</li>
					</ul>
				</div>
				<div class="menu1"><a href=""><span class="maintitle">Tires & Tubes</span></a>
					<ul>
						<li>menu6 sub1</li>
						<li>menu6 sub2</li>
						<li>menu6 sub3</li>
						<li>menu6 sub4</li>
						<li>menu6 sub5</li>
					</ul>
				</div>
				<div class="menu1"><a href="notice/notice_list.html"><span class="maintitle">Notice & News</span></a>
					<ul>
						<li><a href="notice/notice_list.html">Notice</a></li>
						<li><a href="">News</a></li>
						<li><a href="">Q & A</a></li>
						<li><a href="">Free Board</a></li>
						<li><a href="">Etc</a></li>
					</ul>
				</div>
				
			</div>
			<div class="menu_close"><a href="#" class="closeclick">[CLOSE]</a></div>
		</div>	
		
		<div id="b_top">
			<div id="b_top_back">
<!--			
				<p class="b_top_text">aaaa</p>
				<p class="b_top_line"></p>
-->				
			</div>
			<ul class="main_menu">
				<li><a href="">Accessories</a></li>
				<li><a href="">Bikes & Frames</a></li>
				<li><a href="">Clothing</a></li>
				<li><a href="">Maintenance</a></li>
				<li><a href="">Parts</a></li>
				<li><a href="">Tires & Tubes</a></li>
				<li><a href="notice/notice_list.html">Notice & News</a></li>
			</ul>
		</div>
		
		
		<div id="b_top_2">
			<ul class="b_top_menu">
				<li><a href=""><img src="images/bu_01.jpg" class="bu_1"></a></li>
				<li><a href=""><img src="images/bu_02.jpg" class="bu_1"></a></li>
				<li><a href=""><img src="images/bu_03.jpg" class="bu_1"></a></li>
				<li><a href=""><img src="images/bu_04.jpg" class="bu_1"></a></li>
				<li><a href=""><img src="images/bu_05.jpg" class="bu_1"></a></li>
				<li><a href=""><img src="images/bu_06.jpg" class="bu_1"></a></li>
			</ul>
		</div>		
		<hr><br>
		<div id="b_left">
			<p class="left_top">
				<img src="images/left_top.jpg"><a href="notice/notice_list.html"><img src="images/left_right.jpg"></a>
			</p>
			<div class="left_middle">
				<ul>
					<li><a href=""><span class="noti_t">7.Convert between </span><span class="noti_d">22-08-25</span></a></li>
					<li><a href=""><span class="noti_t">6.회원운영정책 변경안내 </span><span class="noti_d">22-08-21</span></a></li>
					<li><a href=""><span class="noti_t">5.회원운영정책 변경안내 </span><span class="noti_d">22-07-15</span></a></li>
					<li><a href=""><span class="noti_t">4.회원운영정책 변경안내 </span><span class="noti_d">22-07-10</span></a></li>
					<li><a href=""><span class="noti_t">3.회원운영정책 변경안내 </span><span class="noti_d">22-07-08</span></a></li>
					<li><a href=""><span class="noti_t">2.회원운영정책 변경안내 </span><span class="noti_d">22-07-02</span></a></li>
					<li><a href=""><span class="noti_t">1.회원운영정책 변경안내 </span><span class="noti_d">22-07-01</span></a></li>
				</ul>
			</div>
		
		</div>
		<div id="b_center">
			<p class="b_center_top"><img src="images/center_top.jpg"></p>
			<p class="b_center_middle">
				<a href=""><img src="images/center_middle_1.jpg"><a href=""><img src="images/center_middle_2.jpg"><a href=""><img src="images/center_middle_3.jpg"></a>
			</p>
			<p class="b_center_bottom">
				<a href=""><img src="images/center_middle_4.jpg"><a href=""><img src="images/center_middle_5.jpg"><a href=""><img src="images/center_middle_6.jpg"></a>
			</p>
		</div>
		<div id="b_right">
			<img src="images/center_right.jpg">
		</div>
		<div id="b_bottom_2">
			<a href=""><img src="images/cello.png"></a>
		</div>		
	</div>
</div>	
<%@ include file="common_footer.jsp" %>















