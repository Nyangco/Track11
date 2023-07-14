<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common_header.jsp" %>
<script>
	function goView(no){
		freeboard.t_no.value=no;
		freeboard.t_requestPage.value="view";
		freeboard.method="post";
		freeboard.action="Freeboard";
		freeboard.submit();
	}function goUpdate(){
		freeboard.t_requestPage.value="update";
		freeboard.method="post";
		freeboard.action="Freeboard";
		freeboard.submit();
	}function goDelete(){
		freeboard.t_requestPage.value="DBdelete";
		freeboard.method="post";
		freeboard.action="Freeboard";
		freeboard.submit();
	}function goDown(){
		var count = Number($('.down_counter').val());
		$('.down_counter').val(count+1);
		down.method="post";
		down.action="Filedown";
		down.submit();
	}
</script>
<style>
	.longlong {word-break:break-all;white-space:pre-wrap;}
</style>
<form name="down">
	<input type="hidden" name="t_fileDir" value="freeboard">
	<input type="hidden" name="t_fileName" value="${t_dto.getAttach() }">
	<input type="hidden" name="t_no" value="${t_dto.getNo() }">
	<input type="hidden" name="t_Page" value="freeboard">
</form>
<form name="freeboard">
	<input type="hidden" name="t_no" value="${t_dto.getNo() }">
	<input type="hidden" name="t_requestPage" >
	<input type="hidden" name="t_attach" value="${t_dto.getAttach() }">
</form>
	<div id="container">
		<div id="b_right">
			<p class="n_title">
				Freeboard
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
						<td> 
							<i class="far fa-eye"></i> ${t_dto.getHit() }
							<c:if test="${not empty t_dto.getAttach() }">
							<i class="fa-solid fa-download"></i> <input type="text" class="down_counter" value="${t_dto.getDownload_hit() }" disabled style="border:none;width:15px;background-color:white;">
							</c:if>
						</td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3">
							<div class="longlong">${t_dto.getContent() }</div>
						</td>
					</tr>	
					<tr>
						<th>Attach</th>
						<td colspan="3">
						<a href="javascript:void()" onClick="goDown()" style="font:20px;">
							<c:if test="${t_extension eq '1' }"><img src="attach/freeboard/${t_dto.getAttach() }" width="400"><br></c:if>
							<c:if test="${t_dto.getAttach() ne null }">
								${t_dto.getAttach() }
							</c:if>
						</a>
						</td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td>${t_dto.getReg_name() }</td>
						<c:choose>
							<c:when test="${empty t_dto.getUpdate_date() }">
								<th>RegDate</th>
								<td>${t_dto.getReg_date() }</td>
							</c:when>
							<c:when test="${not empty t_dto.getUpdate_date()}" >
								<th>Update</th>
								<td>${t_dto.getUpdate_date() }</td>
							</c:when>
						</c:choose>
					</tr>	
				</tbody>
			</table>
			<div class="preNext">
				<c:if test="${t_preDto ne null }">
					<a href="javascript:void()" onClick="goView('${t_preDto.getNo()}')">
						<p class="pre"><span><i class="fa-solid fa-circle-arrow-left"></i> 이전글</span>
							<span class="preNextTitle">
								<c:choose>
									<c:when test="${fn:length(t_preDto.getTitle())>5 }">${fn:substring(t_preDto.getTitle(),0,5) }...</c:when>
									<c:otherwise>${t_preDto.getTitle()}</c:otherwise>
								</c:choose>
							</span>
						</p>
					</a>
				</c:if>
				<c:if test="${t_proDto ne null }">
					<a href="javascript:void()" onClick="goView('${t_proDto.getNo()}')">
						<p class="next"><span>다음글 <i class="fa-solid fa-circle-right"></i></span>
							<span class="preNextTitle">
								<c:choose>
									<c:when test="${fn:length(t_proDto.getTitle())>5 }">${fn:substring(t_proDto.getTitle(),0,5) }...</c:when>
									<c:otherwise>${t_proDto.getTitle()}</c:otherwise>
								</c:choose>
							</span>
						</p>
					</a>
				</c:if>
			</div>			
			<div class="buttonGroup">
				<c:if test="${sLevel>=1 or sId eq t_dto.getReg_id() }">
					<a href="javascript:void()" onClick="if(confirm('정말로 삭제하시겠습니까?')) goDelete()" class="butt">Delete</a>
					<a href="javascript:void()" onClick="goUpdate()" class="butt">Update</a>
				</c:if>
				<a href="javascript:void()" onClick="goFreeboard('list')" class="butt">List</a>
			</div>	
		</div>	
	</div>
<%@ include file="/common_footer.jsp"%>