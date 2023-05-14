<%@page import="dao.MemberDao"%>
<%@page import="dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<%
	if(!sessionAdmin.equals("true")){
		%><script>
			alert("비정상적인 접근입니다");
			location.href="../index.jsp";
		</script><%
	}else{
		request.setCharacterEncoding("utf-8");
		MemberDao dao = new MemberDao();
		String gubun = request.getParameter("t_gubun");
		String search = request.getParameter("t_search");
		ArrayList<MemberDto> arr = new ArrayList<>();
		if(gubun==null){
			gubun=""; search="";
			arr = dao.selectDB();
		}else{
			arr = dao.searchDB(gubun,search);
		}
		String columnStr = request.getParameter("t_column");
		if(columnStr == null) columnStr="1";
		int column = Integer.parseInt(columnStr);
		int countDB = arr.size();
		int columnCount = (countDB/10)+1;
		if(countDB%10==0) columnCount-=1;
%>
<script>
	function goDelete(id){
		admin.t_id.value=id;
		admin.method="post";
		admin.action="db_admin_delete.jsp";
		admin.submit();
	}
	function goView(id){
		admin.t_id.value=id;
		admin.method="post";
		admin.action="admin_view.jsp";
		admin.submit();
	}
	function goSearch(){
		search.method="post";
		search.action="admin_list.jsp";
		search.submit();
	}
</script>
<form name="admin">
<input type="hidden" name="t_id">
</form>
	<div class="container">
	  <div class="search_wrap">
		<div class="record_group">
			<p>총 회원 수<span> <%=arr.size() %><?=$count?></span>명</p>
		</div>
		<div class="search_group">
			<form name="search">
				<select name="t_gubun" class="select">
					<option value="id" <%if(gubun.equals("id")) out.print("selected"); %>>ID</option>
					<option value="name" <%if(gubun.equals("name")) out.print("selected"); %>>이름</option>
					<option value="mobile" <%if(gubun.equals("mobile")) out.print("selected"); %>>휴대전화</option>
					<option value="email" <%if(gubun.equals("email")) out.print("selected"); %>>email</option>
					<option value="reg_date" <%if(gubun.equals("reg_date")) out.print("selected"); %>>가입일</option>
				</select>
				<input type="text" name="t_search" class="search_word" value="<%if(search!=null) out.print(search);%>">
				<button class="btn_search" onclick="goSearch()"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
			</form>
		</div>
	  </div> <!-- search end -->
	  <div class="bord_list">
		<table class="bord_table" summary="이표는 번호,제목,글쓴이,날자,조회수로 구성되어 있습니다">
			<caption class="sr-only">공지사항 리스트</caption>
			<colgroup>
				<col width="10%">
				<col width="10%">
				<col width="20%">
				<col width="20%">
				<col width="10%">
				<col width="20%">
				<col width="10%">
			</colgroup>
			<thead>
				<tr>
					<th>ID</th>
					<th>성명</th>
					<th>휴대전화</th>
					<th>이메일</th>
					<th>가입일</th>
					<th>최종 접속일</th>
					<th>비고</th>
				</tr>
			</thead>
			<tbody>
				<%if(column!=columnCount){
					for(int k=(column-1)*10; k<=(column*10); k++){
				%>
				<tr>
					<td><a href="javascript:void()" onClick="goView('<%=arr.get(k).getId() %>');"><%=arr.get(k).getId() %></a></td>
					<td><a href="javascript:void()" onClick="goView('<%=arr.get(k).getId() %>');"><%=arr.get(k).getName() %></a></td>
					<td><%
						String mobile = arr.get(k).getMobile() ;
						out.print(mobile.substring(0,3)+"-"+mobile.substring(3,7)+"-"+mobile.substring(7,11));
					%></td>
					<td><%=arr.get(k).getEmail() %></td>
					<td><%=arr.get(k).getReg_date() %></td>
					<td><%
						if(arr.get(k).getLogin_date()==null) out.print("로그인 이력 없음");
						else out.print(arr.get(k).getLogin_date());
					%></td>
					<td><%
						if(arr.get(k).getPwlength()==1) out.print("탈퇴한 계정");
					%></td>
				</tr>
				<%}}else{ 
					for(int k=(columnCount-1)*10;k<countDB; k++){ 
				%>
				<tr>
					<td><a href="javascript:void()" onClick="goView('<%=arr.get(k).getId() %>');"><%=arr.get(k).getId() %></a></td>
					<td><a href="javascript:void()" onClick="goView('<%=arr.get(k).getId() %>');"><%=arr.get(k).getName() %></a></td>
					<td><%
						String mobile = arr.get(k).getMobile() ;
					out.print(mobile.substring(0,3)+"-"+mobile.substring(3,7)+"-"+mobile.substring(7,11));
					%></td>
					<td><%=arr.get(k).getEmail() %></td>
					<td><%=arr.get(k).getReg_date() %></td>
					<td><%
						if(arr.get(k).getLogin_date()==null) out.print("로그인 이력 없음");
						else out.print(arr.get(k).getLogin_date());
					%></td>
					<td><%
						if(arr.get(k).getPwlength()==1) out.print("탈퇴한 계정");
					%></td>
				</tr>
				<%}} %>
			</tbody>
		</table>
		<div class="paging">
			<%if(columnCount<5){%>
				<a href="admin_list.jsp?t_column=1" <%if(column==1) out.print("class='active'");%>>1</a>
				<%if(columnCount>=2){ %><a href="admin_list.jsp?t_column=2" <%if(column==2) out.print("class='active'");%>>2</a><%} %>
				<%if(columnCount>=3){ %><a href="admin_list.jsp?t_column=3" <%if(column==3) out.print("class='active'");%>>3</a><%} %>
				<%if(columnCount>=4){ %><a href="admin_list.jsp?t_column=4" <%if(column==4) out.print("class='active'");%>>4</a><%} %>
				<%if(columnCount>=5){ %><a href="admin_list.jsp?t_column=5" <%if(column==5) out.print("class='active'");%>>5</a><%} %>
			
			<%} %>
			<%if(columnCount>=5){ %>
				<%if(column>=3){ %>
				<a href="admin_list.jsp?t_column=1"><i class="fa  fa-angle-double-left"></i></a>
				<a href="admin_list.jsp?t_column=<%=column-1%>"><i class="fa fa-angle-left"></i></a>
				<%}%>
				<%if(column>=1 && column<=2) {%>
				<a href="admin_list.jsp?t_column=1" <%if(column==1) out.print("class='active'");%>>1</a>
				<a href="admin_list.jsp?t_column=2" <%if(column==2) out.print("class='active'");%>>2</a>
				<a href="admin_list.jsp?t_column=3" <%if(column==3) out.print("class='active'");%>>3</a>
				<a href="admin_list.jsp?t_column=4" <%if(column==4) out.print("class='active'");%>>4</a>
				<a href="admin_list.jsp?t_column=5" <%if(column==5) out.print("class='active'");%>>5</a>
				<%}%>
				<% 
					if(column>=3 && column<=columnCount-2){ 
						for(int k=column-2; k<=column+2; k++){	
				%>
							<a href="admin_list.jsp?t_column=<%=k %>" <%if(column==k) out.print("class='active'");%>><%=k %></a>
				<%		}
					}%>
						
				<%if(column==columnCount-1 || column==columnCount){%>
							<a href="admin_list.jsp?t_column=<%=columnCount-4 %>" <%if(column==columnCount-4) out.print("class='active'");%>><%=columnCount-4 %></a>
							<a href="admin_list.jsp?t_column=<%=columnCount-3 %>" <%if(column==columnCount-3) out.print("class='active'");%>><%=columnCount-3 %></a>
							<a href="admin_list.jsp?t_column=<%=columnCount-2 %>" <%if(column==columnCount-2) out.print("class='active'");%>><%=columnCount-2 %></a>
							<a href="admin_list.jsp?t_column=<%=columnCount-1 %>" <%if(column==columnCount-1) out.print("class='active'");%>><%=columnCount-1 %></a>
							<a href="admin_list.jsp?t_column=<%=columnCount %>" <%if(column==columnCount) out.print("class='active'");%>><%=columnCount %></a>
				<%		}%>
				<%if(column<=columnCount-2){ %>
				<a href="admin_list.jsp?t_column=<%=column+1%>"><i class="fa fa-angle-right"></i></a>
				<a href="admin_list.jsp?t_column=<%=columnCount%>"><i class="fa  fa-angle-double-right"></i></a>
				<%} %>
			<% }%>
		</div>
	  </div>
	</div>
	<!-- end contents -->
	
	<script>
		$(function() {
			$(".location  .dropdown > a").on("click",function(e) {
				e.preventDefault();
				if($(this).next().is(":visible")) {
					$(".location  .dropdown > a").next().hide();
				} else {
					$(".location  .dropdown > a").next().hide();
					$(this).next().show();
				}
			});
		});
	</script>
	
<%} %>
<%@ include file="../common_footer.jsp" %>









