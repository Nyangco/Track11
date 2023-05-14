<%@page import="dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	ArrayList<MemberDto> arr = (ArrayList<MemberDto>)request.getAttribute("t_arr");
	int count = (int)request.getAttribute("t_count");
	String select = (String)request.getAttribute("t_select");
	String search = (String)request.getAttribute("t_search");
	if(select==null){
		select=""; search="";
	}
%>
<!DOCTYPE html>
<html> 
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--
	******************************************** 
		title : 풀스텍 홍길동
	******************************************** 
 -->	
	<title>TRACK11 홍길동</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">	
	<link href="/web_serv_basic/css/common.css" rel="stylesheet">
	<link href="/web_serv_basic/css/layout.css" rel="stylesheet" >	
</head>
<script>
	function goSearch(){
		search.method="post";
		search.action="Member";
		search.submit();
	}function goView(id){
		mem.t_id.value=id;
		mem.t_requestPage.value="view";
		mem.method="post";
		mem.action="Member";
		mem.submit();
	}function goWrite(){
		mem.t_requestPage.value="write";
		mem.method="post";
		mem.action="Member";
		mem.submit();
	}
</script>
<body>
<form name="mem">
	<input type="hidden" name="t_id">
	<input type="hidden" name="t_requestPage">
</form>
	<div class="container">

		<div class="leftmargin">
			<img src="images/jsl_logo.png"><h1>TRACK11 홍길동 회원관리</h1>
		</div>		
		<div class="search_wrap">
			<div class="record_group">
				<p>총게시글 : <span><%=count %></span>건</p>
			</div>
			<form name="search">
			<div class="search_group">
				<select class="select" name="t_select">
					<option value="id" <%if(select.equals("id")) out.print("selected"); %>>ID</option>
					<option value="name" <%if(select.equals("name")) out.print("selected"); %>>성명</option>
				</select>
				<input type="text" class="search_word" name="t_search" value="<%=search%>">
				<button class="btn_search" onclick="goSearch()"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
			</div>
			</form>
		</div>
	</div>
	<div class="board_list">
		<table class="board_table">
			<colgroup>
				<col width="25%">
				<col width="25%">
				<col width="25%">
				<col width="25%">
			</colgroup>
			<thead>
				<tr>
					<th>ID</th>
					<th>성명</th>
					<th>나이</th>
					<th>가입일</th>
				</tr>
			</thead>
			<tbody>
			<%for(MemberDto dto : arr){ %>
				<tr>
					<td><a href="javascript:void()" onClick="goView('<%=dto.getId()%>')"><%=dto.getId() %></a></td>
					<td><a href="Member_view?t_id=<%=dto.getId()%>"><%=dto.getName() %></a></td>
					<td><%=dto.getAge() %></td>
					<td><%=dto.getReg_date() %></td>
				</tr>	
			<%} %>
			</tbody>
		</table>
		<div class="paging">
			<a href="javascript:void()" onClick="goWrite()" class="write">회원등록</a>
		</div>
	</div>
 </body>
</html>







