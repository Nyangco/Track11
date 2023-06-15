<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp"%>
<script>
	function goUpdate(){
		news.t_requestPage.value="update";
		news.method="post";
		news.action="News";
		news.submit();
	}function goDelete(){
		news.t_requestPage.value="DBdelete";
		news.method="post";
		news.action="News";
		news.submit();
	}function goView(no){
		news.t_no.value=no;
		news.method="post";
		news.action="News";
		news.submit();
	}function goDown(){
		down.method="post";
		down.action="Filedown";
		down.submit();
	}
</script>
<form name="down">
	<input type="hidden" name="t_fileDir" value="news">
	<input type="hidden" name="t_fileName" value="${t_dto.getAttach() }">
</form>
<form name="news">
	<input type="hidden" name="t_requestPage" value="view">
	<input type="hidden" name="t_no" value="${t_dto.getNo() }">
	<input type="hidden" name="t_attach" value="${t_dto.getAttach() }">
</form>
	<div id="container">
		<div id="b_right">
			<p class="n_title">
				NEWS
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
						<td colspan="4" >
							<img src="attach/news/${t_dto.getAttach() }"style="width:298px;border:1px solid gray; margin-bottom:30px;">
							<textarea class="textArea_H250" style="width:390px;resize:none;border:none;" name="t_content" readonly>${t_dto.getContent() }</textarea>
						</td>
					</tr>	
					<tr>
						<th style="width:70px;">Attach</th>
						<td colspan="3"><a href="javascript:void()" onclick="goDown()">${t_dto.getAttach() }</a></td>
					</tr>	
					<tr>
						<th style="width:70px;">Writer</th>
						<td>${t_dto.getReg_name()}</td>
						<th style="width:70px;">RegDate</th>
						<td>${t_dto.getReg_date()}</td>
					</tr>	
					<tr>
						<th style="width:70px;">Updater</th>
						<td>${t_dto.getUpdate_name()}</td>
						<th style="width:70px;">UpdateDate</th>
						<td>${t_dto.getUpdate_date()}</td>
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
				<c:if test="${sLevel >= 1 }">
				<a href="javascript:void()" onClick="if(confirm('정말로 삭제하시겠습니까?')) goDelete()" class="butt">Delete</a>
				<a href="javascript:void()" onClick="goUpdate()" class="butt">Update</a>
				</c:if>
				<a href="javascript:void()" onClick="goNews('list')" class="butt">List</a>
			</div>	
		</div>	
	</div>
<%@include file="../common_footer.jsp"%>