<%@page import="common.CommonUtil"%>
<%@page import="dto.PdsDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.PdsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common_header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
	PdsDao dao = new PdsDao();
	
	String select = request.getParameter("t_select");
	String search = request.getParameter("t_search");
	String sCount = request.getParameter("t_count");
	ArrayList<PdsDto> arr = new ArrayList<>();
	if(search==null){
		select="title";
		search="";
		sCount="5";
	}
	int count = Integer.parseInt(sCount);
	
	int totalCount = dao.getTotalCount(select,search);
	int list_setup_count = count;  //한페이지당 출력 행수 
	int pageNumber_count = 3;  //한페이지당 출력 페이지 갯수
	
	String nowPage = request.getParameter("t_nowPage");
	int current_page = 0; // 현재페이지 번호
	int total_page = 0;    // 전체 페이지 수
	
	if(nowPage == null || nowPage.equals("")) current_page = 1; 
	else current_page = Integer.parseInt(nowPage);
	
	total_page = totalCount / list_setup_count;  // 몫 : 2
	int rest = 	totalCount % list_setup_count;   // 나머지:1
	if(rest !=0) total_page = total_page + 1;     // 3
	
	int start = (current_page -1) * list_setup_count + 1;
	int end   = current_page * list_setup_count;
	
	arr = dao.searchDB(select,search,start,end);
	
	int number = totalCount-((current_page-1)*list_setup_count);
%>
<script>
	function goView(no){
		view.t_no.value=no;
		view.method="post";
		view.action="pds_view.jsp";
		view.submit();
	}
</script>
<form name="view">
	<input type="hidden" name="t_no">
</form>
	<div class="container">
	  <div class="search_wrap">
		<div class="record_group">
			<p>총게시글 : <span><%=totalCount %></span>건</p>
		</div>
		<div class="search_group">
			<form name="pds">
				<select name="sel" class="select">
					<option value="1">제목</option>
					<option value="2">내용</option>
				</select>
				<input type="text" name="search" class="search_word">
				<button class="btn_search" type="submit"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
			</form>
		</div>
	  </div> <!-- search end -->
	  <div class="bord_list">
		<table class="bord_table" summary="이표는 번호,제목,글쓴이,날자,조회수로 구성되어 있습니다">
			<caption class="sr-only">공지사항 리스트</caption>
			<colgroup>
				<col width="10%">
				<col width="*">
				<col width="5%">
				<col width="10%">
				<col width="10%">
				<col width="5%">
			</colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>첨부파일</th>
					<th>글쓴이</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<%for(PdsDto dto : arr){%>
				<tr>
					<td><%=dto.getNo()%></td>
					<td class="title"><a href="javascript:void()" onclick="goView('<%=dto.getNo()%>')"><%=dto.getTitle() %></a></td>
					<td>
					<%if(!dto.getAttach().equals("")){ %>
					<img src="../images/file.png">
					<%} %>
					</td>
					<td><%=dto.getReg_name() %></td>
					<td><%=dto.getReg_date() %></td>
					<td><%=dto.getHit() %></td>
				</tr>
				<%} %>
			</tbody>
		</table>
		<div class="paging">
			<%
				String paging = CommonUtil.pageListPost(current_page, total_page, pageNumber_count);
				out.print(paging);
			%>
			<%if(sessionLevel.equals("top")) {%>
				<a href="pds_write.jsp" class="btn_write">글쓰기</a>
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
	

<%@ include file = "../common_footer.jsp" %>









