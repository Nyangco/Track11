<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link href="css/index_c.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.8.1.min.js"></script>	
<title>JSL11 연석모</title>
<style>
	.main_center_img{width:101px;height:101px;border:solid 1px black;margin:1px;}
</style>
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
.b_center_middle a{
		position:relative;
		display:inline-block;
		width:105px;
		height:105px;
	}
	.b_center_middle a .over{
		position:absolute;
		top:0;
		opacity:0;
		transform:translate(0,50px);
		transition:0.5s;
		background:#E6E6E6E6;
		width:105px;
		height:75px;
		padding-top:30px;
	}
	.b_center_middle a:hover .over{
		transform:translate(0,0);
		opacity:1;
		
	}
	.over p{
		text-align:center;
		color:black;
	}
	.over .p_name{
		font-size:11px;
		font-weight:bold;		
	}
	.over .p_price{
		font-size:10px;
		color:blue;
	}
</style>
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
	}function goNoticeView(no){
		noticeView.t_no.value = no;
		noticeView.method="post";
		noticeView.action="Notice";
		noticeView.submit();
	}
</script>
</head>
<body>
<form name="goGo">
	<input type="hidden" name="t_requestPage">
</form>
<form name="noticeView">
	<input type="hidden" name="t_requestPage" value="view">
	<input type="hidden" name="t_no">
</form>
<div id="disableDiv" class="disableDiv" style="display:none"></div>
<div id="container">

	<div id="container_top">	
			<div id="b_top_menu">
				<ul class="top_menu">
					<li><a href="" class="allclick"><i class="fas fa-bars"></i></a></li>
					<c:if test="${sLevel >= 1 }">
					<li><a href="javascript:void()" onClick="goAdmin('list')">Admin</a></li>
					</c:if>
					<c:if test="${empty sId}">
					<li><a href="javascript:void()" onClick="goMember('join')">Join</a></li>
					<li><a href="javascript:void()" onClick="goMember('login')">Login</a></li>
					</c:if>
					<c:if test="${!empty sId}">
					<li><a href="javascript:void()" onClick="goMember('myinfo')">Myinfo</a></li>
					<li><a href="javascript:void()" onClick="goMember('logout')">Logout</a></li>
					</c:if>
					<li><a href="javascript:void()" onClick="goIndex()"><i class="fa fa-home" aria-hidden="true"></i> Home</a></li>
					<c:if test="${!empty sId}">
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
				<div class="menu1"><a href="javascript:void()" onClick="goNotice('list')"><span class="maintitle">Notice & News</span></a>
					<ul>
						<li><a href="javascript:void()" onClick="goNotice('list')">News</a></li>
						<li><a href="javascript:void()" onClick="goNews('list')">News</a></li>
						<li><a href="javascript:void()" onClick="goQna('list')">Q & A</a></li>
						<li><a href="javascript:void()" onClick="goFreeBoard('list')">Free Board</a></li>
						<li><a href="javascript:void()" onClick="goEtc('list')">Etc</a></li>
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
				<li><a href="Customer">Product</a></li>
				<li><a href="javascript:void()" onClick="goNotice('list')">Notice & News</a></li>
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
				<img src="images/left_top.jpg"><a href="javascript:void()" onClick="goNotice('list')"><img src="images/left_right.jpg"></a>
			</p>
			<div class="left_middle">
				<ul>
					<c:set value="7" var="t_order"></c:set>
					<c:forEach items="${t_nArr }" var="arr" begin="0" end="${t_nArr.size() }" varStatus="vs">
					<li><a href="javascript:void()" onclick="goNoticeView('${arr[0]}')"><span class="noti_t">${t_nArr.size() - vs.index} . ${arr[1] } </span><span class="noti_d">${arr[2] }</span></a></li>
					</c:forEach>
				</ul>
			</div>
		
		</div>
		<div id="b_center">
			<p class="b_center_top"><img src="images/center_top.jpg"></p>
			<div class="b_center_middle">
				<c:set var="rVar"></c:set>
				<c:forEach items="${t_pArr }" var="arr" begin="0" end="5" varStatus="vs">
					<a href="Customer"><img class="main_center_img" src="<c:if test="${not empty arr[0] }">attach/product/${arr[1] }</c:if>" <c:if test="${empty arr }">style="display:none;"</c:if>>
					<div class="over">
						<p class="p_name">${arr[2] }</p>
						<p class="p_price">₩${arr[3] }</p>
					</div></a>
					<c:set var="rVar" value="${vs.count }"></c:set>
				</c:forEach>
				<c:forEach begin="${rVar }" end="5">
					<a href=""><img class="main_center_img" src="images/ready.png">
					<div class="over">
						<p class="p_name">준비중</p>
					</div></a>
				</c:forEach>
			</div>
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















