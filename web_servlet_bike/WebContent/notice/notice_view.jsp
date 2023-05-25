<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common_header.jsp" %>
<script>
	function goView(no){
		notice.t_no.value=no;
		notice.t_requestPage.value="view";
		notice.method="post";
		notice.action="Notice";
		notice.submit();
	}function goUpdate(){
		notice.t_requestPage.value="update";
		notice.method="post";
		notice.action="Notice";
		notice.submit();
	}function goDelete(){
		notice.t_requestPage.value="DBdelete";
		notice.method="post";
		notice.action="Notice";
		notice.submit();
	}function goDown(){
		down.method="post";
		down.action="/web_servlet_bike/common/filedown.jsp";
		down.submit();
	}
</script>
<form name="down">
	<input type="hidden" name="t_fileDir" value="notice">
	<input type="hidden" name="t_fileName" value="${t_dto.getAttach() }">
</form>
<form name="notice">
	<input type="hidden" name="t_no" value="${t_dto.getNo() }">
	<input type="hidden" name="t_requestPage" >
	<input type="hidden" name="t_attach" value="${t_dto.getAttach() }">
</form>
	<div id="container">
		<div id="b_right">
			<p class="n_title">
				NOTICE
			</p>
			
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="55%">
					<col width="10%">
					<col width="20%">
				</colgroup>
				<tbody>
					<tr>
						<th>Title</th>
						<td colspan="2">${t_dto.getTitle() }</td>
						<td> <i class="far fa-eye"></i> ${t_dto.getHit() }</td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3">
							<textarea class="textArea_H250_noBorder" readonly>${t_dto.getContent() }</textarea>
						</td>
					</tr>	
					<tr>
						<th>Attach</th>
						<td colspan="3"><c:if test="${t_dto.getAttach() ne null }"><a href="javascript:void()" onClick="goDown()">${t_dto.getAttach() }</a></c:if></td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td>${t_dto.getReg_name() }</td>
						<th>RegDate</th>
						<td>${t_dto.getReg_date() }</td>
					</tr>	

				</tbody>
			</table>
			<div class="preNext">
				<c:if test="${t_preDto ne null }">
					<a href="javascript:void()" onClick="goView('${t_preDto.getNo()}')">
						<p class="pre"><span><i class="fa-solid fa-circle-arrow-left"></i> 이전글</span> 
							<span class="preNextTitle">
										${t_preDto.getTitle() }
							</span>
						</p>
					</a>
				</c:if>
				<c:if test="${t_proDto ne null }">
					<a href="javascript:void()" onClick="goView('${t_proDto.getNo()}')">
						<p class="next"><span>다음글 <i class="fa-solid fa-circle-right"></i></span>
							<span class="preNextTitle">
										${t_proDto.getTitle() }
							</span>
						</p>
					</a>
				</c:if>
				
			</div>			
			<div class="buttonGroup">
				<c:if test="${sLevel >= 1 }">
				<a href="javascript:void()" onClick="if(confirm('정말로 삭제하시겠습니까?')) goDelete()" class="butt">Delete</a>
				<a href="javascript:void()" onClick="goUpdate()" class="butt">Update</a>
				</c:if>
				<a href="javascript:void()" onClick="goNotice('list')" class="butt">List</a>
			</div>	
		</div>	
	</div>
<%@ include file="/common_footer.jsp"%>