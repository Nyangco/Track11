<%@page import="dto.NoticeDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.NoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<% 
	request.setCharacterEncoding("utf-8");
	NoticeDao dao = new NoticeDao();
	String select = request.getParameter("t_select");
	String search = request.getParameter("t_search");
	String columnStr = request.getParameter("t_column");
	if(columnStr == null) columnStr="1";
	int column = Integer.parseInt(columnStr);
	int countDB = dao.countDB();
	int columnCount = (countDB/10)+1;
	if(countDB%10==0) columnCount-=1;
	ArrayList<NoticeDto> arr = new ArrayList<>();
	if(search==null){
		select="";
		search="";
		arr = dao.listDB();
	}else if(select.equals("")){
		select = "";
		search = "";
		arr = dao.listDB();
	}else{
		arr = dao.searchDB(select,search);
	}
	
%>
<script>
	function goSearch(){
		notice.method="post";
		notice.action="notice_list.jsp";
		notice.submit();
	}
	function goView(no){
		viewNoti.t_no.value=no;
		viewNoti.method="post";
		viewNoti.action="notice_view.jsp";
		viewNoti.submit();
	}
	function goList(column){
		viewNoti.t_column.value = column;
		viewNoti.method="post";
		viewNoti.method="faq_list.jsp";
		viewNoti.submit();
	}
</script>
<form name="viewNoti">
	<input type="hidden" name="t_no">
	<input type="hidden" name="t_column">
	<input type="hidden" name="t_select" value="<%=select%>">
	<input type="hidden" name="t_search" value="<%=search%>">
</form>
	<div class="container">
	  <div class="search_wrap">
		<div class="record_group">
			<p>총게시글<span> <%=arr.size() %><?=$count?></span>건</p>
		</div>
		<div class="search_group">
			<form name="notice">
				<select name="t_select" class="select">
					<option value="title" <%if(select.equals("title")) out.print("selected"); %>>제목</option>
					<option value="content" <%if(select.equals("content")) out.print("selected"); %>>내용</option>
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
				<col width="*">
				<col width="10%">
				<col width="10%">
				<col width="10%">
			</colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<%if(column!=columnCount){
					for(int k=(column-1)*10; k<(column*10); k++){
				%>
				<tr>
					<td><a href="javascript:goView('<%=arr.get(k).getNo() %>')"><%=arr.get(k).getNo() %></a></td>
					<td class="title"><a href="notice_view.jsp?t_no=<%=arr.get(k).getNo()%>"><%=arr.get(k).getTitle() %></a></td>
					<td><%=arr.get(k).getReg_name() %></td>
					<td><%=arr.get(k).getReg_date() %></td>
					<td><%=arr.get(k).getHit() %></td>
				</tr>
				<%}}else{ 
					for(int k=(columnCount-1)*10;k<countDB; k++){ 
				%>
				<tr>
					<td><a href="javascript:goView('<%=arr.get(k).getNo() %>')"><%=arr.get(k).getNo() %></a></td>
					<td class="title"><a href="notice_view.jsp?t_no=<%=arr.get(k).getNo()%>"><%=arr.get(k).getTitle() %></a></td>
					<td><%=arr.get(k).getReg_name() %></td>
					<td><%=arr.get(k).getReg_date() %></td>
					<td><%=arr.get(k).getHit() %></td>
				</tr>
				<%}} %>
			</tbody>
		</table>
		<div class="paging">
			<%if(columnCount<5){%>
				<a href="javascript:goList(1)" <%if(column==1) out.print("class='active'");%>>1</a>
				<%if(columnCount>=2){ %><a href="javascript:goList(2)" <%if(column==2) out.print("class='active'");%>>2</a><%} %>
				<%if(columnCount>=3){ %><a href="javascript:goList(3)" <%if(column==3) out.print("class='active'");%>>3</a><%} %>
				<%if(columnCount>=4){ %><a href="javascript:goList(4)" <%if(column==4) out.print("class='active'");%>>4</a><%} %>
				<%if(columnCount>=5){ %><a href="javascript:goList(5)" <%if(column==5) out.print("class='active'");%>>5</a><%} %>
			
			<%} %>
			<%if(columnCount>=5){ %>
				<%if(column>=3){ %>
				<a href="javascript:goList(1)"><i class="fa  fa-angle-double-left"></i></a>
				<a href="javascript:goList(<%=column-1%>)"><i class="fa fa-angle-left"></i></a>
				<%}%>
				<%if(column>=1 && column<=2) {%>
				<a href="javascript:goList(1)" <%if(column==1) out.print("class='active'");%>>1</a>
				<a href="javascript:goList(2)" <%if(column==2) out.print("class='active'");%>>2</a>
				<a href="javascript:goList(3)" <%if(column==3) out.print("class='active'");%>>3</a>
				<a href="javascript:goList(4)" <%if(column==4) out.print("class='active'");%>>4</a>
				<a href="javascript:goList(5)" <%if(column==5) out.print("class='active'");%>>5</a>
				<%}%>
				<% 
					if(column>=3 && column<=columnCount-2){ 
						for(int k=column-2; k<=column+2; k++){	
				%>
							<a href="javascript:goList(<%=k %>)" <%if(column==k) out.print("class='active'");%>><%=k %></a>
				<%		}
					}%>
						
				<%if(column==columnCount-1 || column==columnCount){%>
							<a href="javascript:goList(<%=columnCount-4 %>)" <%if(column==columnCount-4) out.print("class='active'");%>><%=columnCount-4 %></a>
							<a href="javascript:goList(<%=columnCount-3 %>)" <%if(column==columnCount-3) out.print("class='active'");%>><%=columnCount-3 %></a>
							<a href="javascript:goList(<%=columnCount-2 %>)" <%if(column==columnCount-2) out.print("class='active'");%>><%=columnCount-2 %></a>
							<a href="javascript:goList(<%=columnCount-1 %>)" <%if(column==columnCount-1) out.print("class='active'");%>><%=columnCount-1 %></a>
							<a href="javascript:goList(<%=columnCount %>)" <%if(column==columnCount) out.print("class='active'");%>><%=columnCount %></a>
				<%		}%>
				<%if(column<=columnCount-2){ %>
				<a href="javascript:goList(<%=column+1%>)"><i class="fa fa-angle-right"></i></a>
				<a href="javascript:goList(<%=columnCount%>)"><i class="fa  fa-angle-double-right"></i></a>
				<%} %>
			<%}if(sessionLevel.equals("top")){ %>
			<a href="notice_write.jsp" class="btn_write">글쓰기</a>
			<%}%>
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
	

<%@ include file="../common_footer.jsp" %>









