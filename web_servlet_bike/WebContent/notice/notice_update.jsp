<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common_header.jsp" %>	
<script>
	function goUpdate(){
		if(checking(notice.t_title,50,"제목"));
		else if(checking(notice.t_content,2000,"내용"));
		else{
			notice.method="post";
			notice.action="Notice?t_requestPage=DBupdate";
			notice.submit();
		}
	}
</script>
	<div id="container">
		<%@ include file="notice_leftBoard.jsp" %>
		<div id="b_right">
			<p class="n_title">
				NOTICE
			</p>
			<form name="notice" enctype="multipart/form-data">
			<input type="hidden" name="t_no" value="${t_dto.getNo() }">
			<input type="hidden" name="t_ori_attach" value="${t_dto.getAttach() }">
			<input type="hidden" name="t_update_id" value="${sId }">
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<tbody>
					<tr>
						<th>Title</th>
						<td colspan="3"><input name="t_title" type="text" class="input600" value="${t_dto.getTitle() }"></td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3"><textarea name="t_content" class="textArea_H250">${t_dto.getContent() }</textarea></td>
					</tr>	
					<tr>
						<th>Attach</th>
						<td colspan="3"><c:if test="${t_dto.getAttach() ne null }">${t_dto.getAttach() }   삭제<input type="checkbox" name="t_delete"><br></c:if>
							<input type="file" class="input600" name="t_attach">
						</td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td><input type="text" value="${sName }" class="input100"></td>
						<th>RegDate</th>
						<td><input type="date" value="${t_date }" class="input130"></td>
					</tr>	
				</tbody>
			</table>
			</form>
			<div class="buttonGroup">
				
				<a href="javascript:void()" onClick="goUpdate()" class="butt">Save</a>
				<a href="javascript:void()" onClick="goNotice('list')" class="butt">List</a>
			</div>	
		</div>	
	</div>
<%@include file="/common_footer.jsp"%>