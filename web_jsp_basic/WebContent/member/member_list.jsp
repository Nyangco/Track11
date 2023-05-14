<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dto.*,dao.*,java.util.*" %>  
<%
    request.setCharacterEncoding("utf-8");

	Member_dao dao = new Member_dao();

	String gubun = request.getParameter("t_gubun");
	String search = request.getParameter("t_search");
	
	if(gubun == null){
		gubun = "id";
		search = "";
	}

	ArrayList<Member_dto> arr = dao.getMemberList(gubun,search);
	
	



%>  
<!DOCTYPE html>
<html> 
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--
	******************************************** 
		title : 풀스텍 연석모
	******************************************** 
 -->	
	<title>TRACK11 연석모</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">	
	<link href="../css/common.css" rel="stylesheet">
	<link href="../css/layout.css" rel="stylesheet" >	
	
<script>
	function goSearch(){
		mem.method="post";
		mem.action="member_list.jsp";
		mem.submit();
		
	}
	function goView(id){		
		view.t_id.value=id;
		view.method="post";
		view.action="member_view.jsp";
		view.submit();
	}
		
	


</script>
</head>
<body>
<form name="view">
	<input type="hidden" name="t_id">
</form>

	<div class="container">

		<div class="leftmargin">
			<img src="../images/jsl_logo.png"><h1>TRACK11 연석모 회원관리</h1>
		</div>		
		<div class="search_wrap">
			<div class="record_group">
				<p>총회원수 : <span><%=arr.size()%></span>명</p>
		</div>
			<form name = "mem">
			<div class="search_group">
				<select name="t_gubun" class="select">
					<option value="id"<% if(gubun.equals("id")) out.print("selected"); %>>ID</option>
					<option value="name"<% if(gubun.equals("name")) out.print("selected"); %>>성명</option>
				</select>
				<input name="t_search" value="<%=search %>" type="text" class="search_word">
				<button onclick="goSearch();" class="btn_search"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
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
<% 				for(int k = 0 ; k <arr.size() ; k++){%>																				
					<tr>
						<td><a href="member_view.jsp?t_id=<%=arr.get(k).getId() %>"><%=arr.get(k).getId() %></a></td>
						<td><a href="javascript:goView('<%=arr.get(k).getId() %>')"><%=arr.get(k).getName() %></a></td>
						<td><%=arr.get(k).getAge() %></td>
						<td><%=arr.get(k).getReg_date() %></td>
					</tr>	
<%				}%>
			</tbody>
		</table>
		<div class="paging">
			<a href="member_write.jsp" class="write">회원등록</a>
		</div>
	</div>
 </body>
</html>







    