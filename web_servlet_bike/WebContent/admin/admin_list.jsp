<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp" %>
<div id="container">	
<script>
	function goPage(page){
		admin.t_nowPage.value=page;
		admin.t_requestPage.value="list";
		admin.method="post";
		admin.action="Admin";
		admin.submit();
	}function goList(){
		admin.t_requestPage.value="list";
		admin.method="post";
		admin.action="Admin";
		admin.submit();
	}
</script>
	<div id="b_right">
		<p class="n_title">
			Member
		</p>
		<div class="record_group record_group_left">
			<p><i class="fa-solid fa-bell"></i> 총 회원수<span> ${t_totalCount} </span>건</p>
		</div>			
		<form name="admin">
		<input type="hidden" name="t_nowPage">
		<input type="hidden" name="t_requestPage">
			<p class="select_box select_box_right" style="width:500px;">
				<input type="radio" name="t_sort" value="5" onchange="goList()" <c:if test="${t_sort eq '5' }">checked</c:if>>5명 
				<input type="radio" name="t_sort" value="10" onchange="goList()" <c:if test="${t_sort eq '10' }">checked</c:if>>10명 
				<input type="radio" name="t_sort" value="20" onchange="goList()" <c:if test="${t_sort eq '20' }">checked</c:if>>20명 
				<input type="radio" name="t_sort" value="30" onchange="goList()" <c:if test="${t_sort eq '30' }">checked</c:if>>30명 
				<select name="t_select" class="sel_box" style="width:63px;">
					<option value="id">ID</option>
					<option value="name">Name</option>
					<option value="mobile_3">Mobile</option>
				</select>
				<input type="text" name="t_search" value="${t_search }" class="sel_text">
	
				<button type="button" onclick="goList()" class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
			</p>		
		</form>	
		
		<table class="boardList">
			<colgroup>
				<col width="5%">
				<col width="12%">
				<col width="5%">
				<col width="8%">
				<col width="10%">
				<col width="7%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="3%">
			</colgroup>
			<thead>
				<tr>
					<th>No</th>
					<th>ID</th>
					<th>레벨</th>
					<th>성명</th>
					<th>이메일</th>
					<th>지역</th>
					<th>전화번호</th>
					<th>가입일자</th>
					<th>로그인정보</th>
					<th>탈퇴여부</th>
				</tr>
			</thead>
			<tbody>
				<c:set value="${t_order }" var="order"></c:set>
				<c:forEach items="${t_arr}" var="dto">
				<tr>
					<td>${order}<c:set value="${order -1 }" var="order"></c:set></td>
					<td>${dto.getId() }</td>
					<td>${dto.getsLevel() }</td>
					<td>${dto.getName() }</td>
					<td>${fn:substringBefore(dto.getEmail(),'@')}@<br>${fn:substringAfter(dto.getEmail(),'@')}</td>
					<td>${dto.getArea() }</td>
					<td>${dto.getMobile_1() }-{dto.getMobile_2() }-{dto.getMobile_3() }</td>
					<td>${dto.getReg_date() }</td>
					<td>${dto.getLast_login_date() }</td>
					<td><c:choose>
						<c:when test="${empty dto.getExit_date() }">N</c:when>
						<c:otherwise>Y</c:otherwise>
					</c:choose></td>
				</tr>	
				</c:forEach>
			</tbody>
		</table>
		
		<div class="paging">
			${t_paging }
		</div>
	</div>	
</div>
<%@include file="../common_footer.jsp" %>
