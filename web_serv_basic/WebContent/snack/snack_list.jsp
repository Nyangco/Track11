<%@page import="java.text.DecimalFormat"%>
<%@page import="dto.SnackDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<SnackDto> arr = (ArrayList<SnackDto>)request.getAttribute("t_arr");
	String select = (String)request.getAttribute("t_select");
	String search = (String)request.getAttribute("t_search");
	String m_code = (String)request.getAttribute("t_m_code");
	if(select==null){
		select="";search="";
	}
	DecimalFormat df = new DecimalFormat("###,###");
	ArrayList<SnackDto> maker = (ArrayList<SnackDto>)request.getAttribute("t_maker");
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
	<title>TRACK11 연석모</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">	
	<link href="/web_serv_basic/css/common.css" rel="stylesheet">
	<link href="/web_serv_basic/css/layout.css" rel="stylesheet" >	
	<script>
		function goView(no){
			snack.t_requestPage.value="view";
			snack.t_p_code.value=no;
			snack.method="post";
			snack.action="Snack";
			snack.submit();
		}function goSearch(){
			snack.t_requestPage.value="list";
			snack.method="post";
			snack.action="Snack";
			snack.submit();
		}function goWrite(){
			snack.t_requestPage.value="write";
			snack.method="post";
			snack.action="Snack";
			snack.submit();
		}
	</script>
</head>
<body>
	<div class="container">

		<div class="leftmargin">
			<img src="/web_serv_basic/images/jsl_logo.png"><h1>TRACK11 연석모 SNACK</h1>
		</div>		
		<div class="search_wrap">
			<div class="record_group">
				<p>총게시글 : <span><%=arr.size() %></span>건</p>
			</div>
			<form name="snack">
			<input type="hidden" name="t_p_code" >
			<input type="hidden" name="t_requestPage">
			<div class="search_group">
				<select class="select" name="t_select">
					<option value="p_code" <%if(select.equals("p_code"))out.print("selected"); %>>제품번호</option>
					<option value="p_name" <%if(select.equals("p_name"))out.print("selected"); %>>제품명</option>
				</select>
				<input type="text" class="search_word" name="t_search" value="<%=search%>">
				<button class="btn_search" onClick="goSearch()"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
				<br>
				<div style="margin-top:10px;">
				<input type="radio" name="t_m_code" value="0" <%if(m_code.equals("0")) out.print("checked"); %> onChange="goSearch()" >전체
				<%for(SnackDto dto:maker){%>
				&nbsp;&nbsp;<input type="radio" name="t_m_code" value="<%=dto.getM_code()%>"<%if(m_code.equals(dto.getM_code())) out.print("checked"); %> onChange="goSearch()"><%=dto.getM_name() %>				
				<%} %>
				</div>
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
					<th>제품번호</th>
					<th>제품명</th>
					<th>제조사명</th>
					<th>가격</th>
				</tr>
			</thead>
			<tbody>
			<%for(SnackDto dto:arr){ %>
				<tr>
					<td><a href="javascript:void()" onClick="goView('<%=dto.getP_code()%>')"><%=dto.getP_code()%></a></td>
					<td><a href="javascript:void()" onClick="goView('<%=dto.getP_code()%>')"><%=dto.getP_name()%></a></td>
					<td><%=dto.getM_name()%></td>
					<td><%=df.format(dto.getPrice())%></td>
				</tr>	
			<%} %>
			</tbody>
		</table>
		<div class="paging">
			<a href="javascript:void()" onClick="goWrite()" class="write">제품등록</a>
		</div>
	</div>
 </body>
</html>







