<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<link href="css/common.css" rel="stylesheet">
	<link href="css/layout.css" rel="stylesheet" >	
	<script>
		function goView(id){
			mem.t_requestPage.value="view";
			mem.t_id.value=id;
			mem.method="post";
			mem.action="Member";
			mem.submit();
		}function goSave(){
			mem.t_requestPage.value="write";
			mem.method="post";
			mem.action="Member";
			mem.submit();
		}function goSearch(){
			search.method="post";
			search.action="Member";
			search.submit();
		}
		
	</script>
</head>
<body>
<form name="mem">
	<input type="hidden" name="t_requestPage">
	<input type="hidden" name="t_id">
</form>
	<div class="container">

		<div class="leftmargin">
			<img src="images/jsl_logo.png"><h1>TRACK11 연석모회원관리</h1>
		</div>		
		<div class="search_wrap">
			<div class="record_group">
				<p>총게시글 : <span>${t_arr.size() }</span>건</p>
			</div>
			<form name="search">
			<div class="search_group">
				<select class="select" name="t_select">
					<option value="id" <c:if test="${t_select eq 'id'}">selected</c:if>>ID</option>
					<option value="name" <c:if test="${t_select eq 'name'}">selected</c:if>>성명</option>
				</select>
				<input type="text" class="search_word" name="t_search" value="${t_search }">
				<button class="btn_search" onClick="goSearch()"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
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
			<c:forEach items="${t_arr }" var="dto">
				<tr>
					<td><a href="javascript:void()" onClick="goView('${dto.getId() }')">${dto.getId() }</a></td>
					<td><a href="javascript:void()" onClick="goView('${dto.getId() }')">${dto.getName() }</a></td>
					<td>${dto.getAge() }</td>
					<td>${dto.getReg_date() }</td>
				</tr>	
			</c:forEach>
			</tbody>
		</table>
		<div class="paging">
			<a href="javascript:void()" onClick="goSave()" class="write">회원등록</a>
		</div>
	</div>
 </body>
</html>







