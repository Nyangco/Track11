<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,java.util.*,dto.*" %>
<%
	request.setCharacterEncoding("utf-8");
	StudentDao dao = new StudentDao();
	
	String grade = request.getParameter("t_grade");
	String gubun = request.getParameter("t_gubun");
	String search = request.getParameter("t_search");
	if(gubun == null){
		grade = "all";
		gubun = "sno";
		search = "";
	}
	ArrayList<StudentDto> arr = dao.getStudentList(grade,gubun,search);

	

%>
<!DOCTYPE html>
<html> 
<head>
<script>
	function goSearch(){
		stu.method="post";
		stu.action="student_list.jsp";
		stu.submit();
	}
	
	function goView(syear,sclass,sno){
		view.t_syear.value=syear;
		view.t_sclass.value=sclass;
		view.t_sno.value=sno;
		view.method="post";
		view.action="student_view.jsp";
		view.submit();
	}
</script>
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
</head>
<body>
	<form name="view">
		<input type="hidden" name="t_syear">
		<input type="hidden" name="t_sclass">
		<input type="hidden" name="t_sno">
	</form>
	<div class="container">

		<div class="leftmargin">
			<img src="../images/jsl_logo.png"><h1>TRACK11 연석모 성적관리</h1>
		</div>		
		<div class="search_wrap">		    		
			<div class="record_group">
				<p>총 : <span><%=arr.size() %></span>명</p>
			</div>
			<form name="stu">
			<div class="search_group">
				<input type="radio" name="t_grade" onchange="goSearch()" value="all" <%if(grade.equals("all")) out.print("checked"); %>>전체&nbsp;&nbsp;
				<input type="radio" name="t_grade" onchange="goSearch()" value="1" <%if(grade.equals("1")) out.print("checked"); %>>1학년&nbsp;&nbsp;
				<input type="radio" name="t_grade" onchange="goSearch()" value="2" <%if(grade.equals("2")) out.print("checked"); %>>2학년&nbsp;&nbsp;
				<input type="radio" name="t_grade" onchange="goSearch()" value="3" <%if(grade.equals("3")) out.print("checked"); %>>3학년
				    <select name="t_gubun" class="select">
						<option value="sno" <%if(gubun.equals("sno")) out.print("selected"); %>>번 호</option>
						<option value="name" <%if(gubun.equals("name")) out.print("selected"); %>>성 명</option>
					</select>
					  	<input name="t_search" value="<%=search %>" type="text" class="search_word">
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
					<th>학 년</th>
					<th>반</th>
					<th>번 호</th>
					<th>성 명</th>
				</tr>
			</thead>		
			<tbody>
			<% for(int k = 0 ; k < arr.size() ; k++){ %>
				<tr>				
					<td><%=arr.get(k).getSyear() %></td>
					<td><%=arr.get(k).getSclass() %></td>
					<td><%=arr.get(k).getSno() %></td>
					<td><a href="javascript:goView('<%=arr.get(k).getSyear() %>','<%=arr.get(k).getSclass() %>','<%=arr.get(k).getSno() %>')"><%=arr.get(k).getName() %></a></td>					
				</tr>	
			<%} %>
			</tbody>
		</table>
		<div class="paging">
			<a href="student_write.jsp" class="write">성적등록</a>
		</div>
	</div>
 </body>
</html>

    