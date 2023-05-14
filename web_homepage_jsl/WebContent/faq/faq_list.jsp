<%@page import="dto.FaqDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.FaqDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
	FaqDao dao = new FaqDao();
	String gubun = request.getParameter("t_gubun");
	String search = request.getParameter("t_search");
	ArrayList<FaqDto> arr = new ArrayList<>();
	if(gubun==null){
		arr = dao.selectDB();
		gubun="";
		search="";
	}else if(gubun.equals("")){
		arr = dao.selectDB();
		gubun = "";
		search = "";
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
	function goUpdate(no){
		faq.t_no.value=no;
		faq.method="post";
		faq.action="faq_update.jsp";
		faq.submit();
	}
	function goDelete(no){
		if(confirm("정말 삭제?")){
			faq.t_no.value=no;
			faq.method="post";
			faq.action="db_faq_delete.jsp";
			faq.submit();
		}
	}
	function goSearch(){
		if(CheckValue(search.t_search,"검색 내용을"));
		else{
			search.method="post";
			search.action="faq_list.jsp";
			search.submit();
		}
	}
	function goList(column){
		faq.t_column.value = column;
		faq.method="post";
		faq.method="faq_list.jsp";
		faq.submit();
	}
</script>
<style>
	.longlong {word-break:break-all;white-space:pre-wrap;}
</style>
<form name="faq">
	<input type="hidden" name="t_no">
	<input type="hidden" name="t_column">
	<input type="hidden" name="t_gubun" value="<%=gubun%>">
	<input type="hidden" name="t_search" value="<%=search%>">
</form>
	<div class="container">
	  <div class="search_wrap">
		<div class="record_group">
			<p>총 게시글 : <span><%=countDB %></span> 건</p>
		</div>
		<div class="search_group">
			<form name="search" >
				<select name="t_gubun" class="select">
					<option value="title" <%if(gubun.equals("title")) out.print("selected"); %>>제목</option>
					<option value="content" <%if(gubun.equals("content")) out.print("selected"); %>>내용</option>
				</select>
				<input type="text" name="t_search" class="search_word" value="<%=search%>">
				<button class="btn_search" onclick="goSearch()"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
			</form>
		</div>
	  </div> <!-- search end -->
	  <div class="bord_list">
		
		<div class="faq-group">
			<%if(column!=columnCount){
					for(int k=(column-1)*10; k<(column*10); k++){
				%>
				<div class="accordion">
					<table class="table">
						<colgroup>
							<col width="10%">
							<col width="*">
							<col width="10%">
							<col width="10%">
						</colgroup>
						<tr>
							<td><%=arr.get(k).getNo() %></td>
							<td><%=arr.get(k).getTitle() %></td>
							<td><%=arr.get(k).getName() %></td>
							<td><%=arr.get(k).getReg_date() %></td>
						</tr>	
					</table>
				</div>
				<div class="panel btn_3wrap">
					<div class="longlong"><%=arr.get(k).getContent() %></div>
					<%if(sessionLevel.equals("top")) {%>
					<a href="javascript:goUpdate('<%=arr.get(k).getNo() %>')">수정</a> 
					<a href="javascript:goDelete('<%=arr.get(k).getNo() %>')">삭제</a>
					<%} %>
				</div>
			<%}}else{ 
					for(int k=(columnCount-1)*10;k<countDB; k++){ 
				%>
				<div class="accordion">
					<table class="table">
						<colgroup>
							<col width="10%">
							<col width="*">
							<col width="10%">
							<col width="10%">
						</colgroup>
						<tr>
							<td><%=arr.get(k).getNo() %></td>
							<td><%=arr.get(k).getTitle() %></td>
							<td><%=arr.get(k).getName() %></td>
							<td><%=arr.get(k).getReg_date() %></td>
						</tr>		
						
					</table>
				</div>
				<div class="panel btn_3wrap">
					<div class="longlong"><%=arr.get(k).getContent() %></div>
					<%if(sessionLevel.equals("top")) {%>
					<a href="javascript:goUpdate('<%=arr.get(k).getNo() %>')">수정</a> 
					<a href="javascript:goDelete('<%=arr.get(k).getNo() %>')">삭제</a>
					<%} %>
				</div>
				<%}} %>
				
		</div>

		<script>
			$(function() {
/*			
				$( '.accordion' ).click( function() {
				//$(".accordion").on("click",function() {	
					//$(".panel").slideUp();
					//$(this).next().slideToggle();
					//$(this).next().slideDown();
					$(".panel").not($(this).next().slideToggle()).slideUp();
					//$(this).next().slideDown();
					

				} );
		*/			
			
				$(".accordion").on("click",function() {
					$(".panel").not($(this).next().slideToggle()).slideUp();
					$(".accordion").not($(this)).removeClass("active");
					$(this).toggleClass("active");
				});
		
			});
		</script>

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
			<%}if(sessionLevel.equals("top")) {%>
			<a href="faq_write.jsp" class="btn_write">글쓰기</a>
			<%} %>
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









