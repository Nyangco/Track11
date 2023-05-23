<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common_header.jsp" %>
<script>
	function goSave(){
		if(checking(notice.t_title,50,"제목"));
		else if(checking(notice.t_content,2000,"내용"));
		else{
			notice.method="post";
			notice.action="Notice?t_requestPage=DBsave";
			notice.submit();
		}
	}
</script>
	<div id="container">
		<%@ include file="./notice_leftBoard.jsp" %>
		<div id="b_right">
			<p class="n_title">
				NOTICE
			</p>
			<form name="notice" enctype="multipart/form-data">
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
						<td colspan="3"><input type="text" class="input600" name="t_title"></td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3"><textarea class="textArea_H250" name="t_content"></textarea></td>
					</tr>	
					<tr>
						<th>Attach</th>
						<td colspan="3"><input type="file" class="input600" name="t_attach"></td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td>
							<input type="text" class="input100" value="${sName }" readonly>
							<input type="hidden" value="${sId }" name="t_reg_id">
						</td>
						<th>RegDate</th>
						<td><input type="date" class="input130" value="${t_today}" name="t_reg_date" readonly></td>
					</tr>	
				</tbody>
			</table>
			</form>
			<div class="buttonGroup">
				<a href="javascript:void()" onClick="goSave()" class="butt">Save</a>
				<a href="javascript:void()" onClick="goNotice('list')" class="butt">List</a>
			</div>	
		</div>	
	</div>
<%@ include file="/common_footer.jsp"%>