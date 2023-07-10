<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp"%>
<style>
	#preview-image {
		border:1px solid gray;
	}					
</style>
<script>
	function goSave(){
		if(checking(qna.t_title,50,"제목")) return;
		if(checking(qna.t_content,2000,"내용")) return;
		qna.method="post";
		qna.action="Qna";
		qna.submit();
	}
</script>
	<div id="container">
		<div id="b_right">
			<p class="n_title">
				Qna
			</p>
			<form name="qna">
				<input type="hidden" name="t_requestPage" value="DBsave">
				<input type="hidden" name="t_reply" value="${t_dto.getNo() }">
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="15%">
					<col width="35%">
				</colgroup>
				<tbody>
					<c:if test="${not empty t_dto }">
						<tr>
							<th>원문 Title</th>
							<td colspan="3"><input type="text" class="input600"  value="${t_dto.getTitle() }" disabled></td>
						</tr>	
						<tr>
							<th>원문 Content</th>
							<td colspan="3"><textarea class="textArea_H250" disabled>${t_dto.getContent() }</textarea></td>
						</tr>	
					</c:if>
					<tr>
						<th>Title</th>
						<td colspan="3"><input type="text" class="input600"  name="t_title"></td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3"><textarea class="textArea_H250" name="t_content"></textarea></td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td>
							<input type="text" class="input100" value="${sName }" readonly>
							<input type="hidden" name="t_reg_id" value="${sId }" readonly>
						</td>
						<th>RegDate</th>
						<td><input type="date" class="input130" name="t_reg_date" value="${t_today }" readonly></td>
					</tr>	

				</tbody>
			</table>
			</form>
			<div class="buttonGroup">
				<a href="javascript:void()" onClick="goSave()" class="butt">Save</a>
				<a href="javascript:void()" onClick="goQna('list')" class="butt">List</a>
			</div>	
		</div>	
	</div>
<%@include file="../common_footer.jsp"%>