<%@ page pageEncoding="UTF-8"%>
<%@ include file="common_session.jsp"%>
<!doctype html>
<html lang="ko">
<%
	String cf = request.getRequestURI();
	String cfn = "";
	cf=cf.substring(1);
	cf=cf.substring(cf.indexOf("/")+1);
	cf=cf.substring(0,cf.indexOf("/"));
	switch (cf) {
	case "adm":
		cfn="관리자 화면";
		break;
	case "faq":
		cfn="FAQ";
		break;
	case "login":
		cfn="로그인";
		break;
	case "member":
		cfn="계정 관리";
		break;
	case "news":
		cfn="뉴스";
		break;
	case "notice":
		cfn="공지사항";
		break;
	case "pds":
		cfn="자료실";
		break;
	case "portfolio":
		cfn="포트폴리오";
		break;
	case "qna":
		cfn="Q&A";
		break;
	default:
		cfn="JSL 인재개발원";
		break;
	}
%>
 <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="JSL">
  <meta name="Keywords" content="반응형홈페이지,  JAVA, JSP, PHP, 대전직업전문학교, 대전국비지원, 국비무료">
  <meta name="Description" content="응용SW개발자를 위한 반응형 홈페이지">
  <title>JSL인재개발원_연석모</title>
  <link href="../css/font-awesome.min.css" rel="stylesheet">
  <link href="../css/common.css" rel="stylesheet">
  <link href="../css/layout.css" rel='stylesheet'>
  <!--
  	jquery언어 사용법
	1. jquey.js을 기반으로 프로그램을 작성하기 때문에 jquery.js 파일을 다운 또는 CDN 방식으로 링크를 건다
	2. $(function() {
		실행문;
	});
  -->
  <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
  <script src="../js/jquery-3.3.1.min.js"></script>
  <script src="../js/common.js"></script>
  

 </head>
 <body>
 <!-- 
 웹문서 만들기 기본 공식
 1. 요소를 어떻게 묶을 것인가? 그룹만들기
 2. 그룹안에 적절한 태그 사용
 3. class 이름 붙이고 css 적용
 -->
	<div class="sr-only">
		<p><a href="#contents">본문 바로가기</a></p>
	</div>

	<div class="top_navigation">
	
		<header class="header">
			<nav class="top_left">
			  <ul>
			  	<li class="first"><a href="../index.jsp">HOME</a></li>
				<li><a href="">모집안내</a></li>
				<li><a href="">입학상담</a></li>
				<li><a href="">교육신청</a></li>
			  </ul>
			</nav>
			<nav class="top_right">
				<ul><li class="first">
					<%if(sessionName.equals("")){%>
						<a href="/web_homepage_jsl/login/member_login.jsp">로그인</a></li><li class="first">
						<a href="/web_homepage_jsl/member/member_join.jsp">회원가입</a></li>
					<%}else{ %>
						<%=sessionName %>님 로그인</li><li>
						<a href="/web_homepage_jsl/login/member_logout.jsp">로그아웃</a></li><li class="first">
						<a href="/web_homepage_jsl/member/member_myinfo.jsp">마이페이지</a>
					<%} %>
				</ul>
			</nav>
			
			<div class="gnb_group">
				<h1 class="logo"><a href="/web_homepage_jsl/index.jsp"><img src="/web_homepage_jsl/images/jsl_logo_f.png"></a></h1>
				<nav class="gnb">
					<ul class="nav_1depth">
						<li><a href="gratings.jsp">기업소개</a>
							<ul class="nav_2depth">
								<li><a href="../about/gratings.jsp">인사말</a></li>
								<li><a href="../about/history.jsp">연혁 및 </a></li>
								<li><a href="../about/gratings.jsp">교직원소개</a></li>
								<li><a href="../gallery/photo.jsp">대우갤러리</a></li>
								<li><a href="../about/map.jsp">찾아오시는길</a></li>
							</ul>
						</li>
						<!-- <li><a href="allclass.jsp">학과및모집안내</a>
							<ul class="nav_2depth">
								<li><a href="#">전체모집과정</a></li>
								<li><a href="#">스마트웹콘텐츠개발과정</a></li>
							</ul>
						</li> -->
						<li><a href="../portfolio/portfolio.jsp">포트폴리오</a>
							<ul class="nav_2depth">
								<li><a href="../portfolio/portfolio.jsp">포트폴리오</a></li>
							</ul>
						</li>
						<!-- <li><a href="online.jsp">온라인접수</a>
							<ul class="nav_2depth">
								<li><a href="#">온라인접수</a></li>
								<li><a href="#">취업성공패키지</a></li>
							</ul>
						</li> -->
						<li>
						<% %>
						<a href="/web_homepage_jsl/notice/notice_list_new.jsp">커뮤니티</a>
	
							<ul class="nav_2depth">
								<li><a href="/web_homepage_jsl/notice/notice_list_new.jsp">공지사항</a></li>
								<li><a href="/web_homepage_jsl/news/news_list.jsp">뉴스</a></li>
								<li><a href="/web_homepage_jsl/qna/qna_list.jsp">질문과답변</a></li>
								<li><a href="/web_homepage_jsl/faq/faq_list.jsp">FAQ</a></li>
								<li><a href="/web_homepage_jsl/pds/pds_list.jsp">자료실</a></li>
								<%if(sessionLevel.equals("top")){ %>
								<li><a href="/web_homepage_jsl/adm/admin_login.jsp">관리자</a></li>
								<%} %>
							</ul>
						</li>
					</ul>
				</nav>
			</div>
		</header>

		<div class="line">
		</div>

	</div>

	<script>
		//$(document).ready(function() {
		$(function() {
			$(".gnb>.nav_1depth>li").hover(function() {
				$(".gnb>.nav_1depth>li").removeClass();
				$(this).addClass("active");

				//$(this).children(".nav_2depth").show();
				//}, function() {
				//  $(".gnb>.nav_1depth>li").removeClass();
				//  $(this).children(".nav_2depth").hide();
				//	});

				$(this).children(".nav_2depth").stop().slideDown("fast");
				}, function() {
				  $(".gnb>.nav_1depth>li").removeClass();
				  $(this).children(".nav_2depth").stop().slideUp("fast");
					});

				/* $(this).children(".nav_2depth").fadeIn();
				}, function() {
				  $(".gnb>.nav_1depth>li").removeClass();
				  $(this).children(".nav_2depth").fadeOut();
					}); */

			});
	</script>
	
	<!-- sub contents -->
	<div class="sub_title">
		<h2><%=cfn %></h2>
		<div class="container">
		  <div class="location">
			<ul>
				<li class="btn_home">
					<a href="/web_homepage_jsl/index.jsp"><i class="fa fa-home btn_plus"></i></a>
				</li>
				<li class="dropdown">
					<a href="<%=request.getRequestURI()%>">커뮤니티<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="gratings.jsp">공지사항</a>
						<a href="allclass.jsp">학과및모집안내</a>
						<a href="portfolio.jsp">포트폴리오</a>
						<a href="online.jsp">온라인접수</a>
						<a href="/web_homepage_jsl/notice/notice_list_new.jsp">커뮤니티</a>
					</div>
				</li>
				<li class="dropdown">
					<a href="<%=request.getRequestURI()%>"><%=cfn %><i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="/web_homepage_jsl/notice/notice_list_new.jsp">공지사항</a>
						<a href="/web_homepage_jsl/news/news_list.jsp">뉴스</a>
						<a href="/web_homepage_jsl/qna/qna_list.jsp">질문과답변</a>
						<a href="/web_homepage_jsl/faq/faq_list.jsp">FAQ</a>
						<a href="/web_homepage_jsl/pds/pds_list.jsp">자료실</a>
						<%if(sessionLevel.equals("top")){ %>
						<a href="/web_homepage_jsl/adm/admin_login.jsp">관리자</a>
						<%} %>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>
	