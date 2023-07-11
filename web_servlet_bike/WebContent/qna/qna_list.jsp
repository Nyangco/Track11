<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common_header.jsp" %>
<script>
	function goPage(page){
		qna.t_nowPage.value=page;
		qna.method="post";
		qna.action="Qna";
		qna.submit();
	}function goSearch(){
		qna.method="post";
		qna.action="Qna";
		qna.submit();
	}function goDelete(no){
		qna.t_no.value=no;
		qna.t_requestPage.value="DBdelete";
		qna.method="post";
		qna.action="Qna";
		qna.submit();
	}function goReply(no){
		qna.t_no.value=no;
		qna.t_requestPage.value="write";
		qna.method="post";
		qna.action="Qna";
		qna.submit();
	}function goWrite(){
		qna.t_no.value="";
		qna.t_requestPage.value="write";
		qna.method="post";
		qna.action="Qna";
		qna.submit();
	}function goDelete(no){
		if(confirm("정말로 삭제하시겠습니까?")){
			if(delete_ajax(no)){
				alert("답글이 달린 게시글입니다.");
			}else{
				qna.t_no.value=no;
				qna.t_requestPage.value="DBdelete";
				qna.method="post";
				qna.action="Qna";
				qna.submit();
			}
		}
	}function delete_ajax(no){
		var tf;
		$.ajax({
			//$(jQuery)의 ajax 라는 기능을 실행한다.
				type : "POST",
				//새창에서 연다
				url : "CheckDelete",
				//해당 url로 이동한다
				data: "t_no="+no,
				//매개변수를 입력한다.
				dataType : "text",
				//결과를 글자로 받겠다.
				async : false,
				//동기식으로 사용하겠다.
				error : function(){
				//에러가 생기면 function을 실행한다.
					alert('통신실패!!!!!');
				},
				success : function(data){
				//성공하면 data를 매개변수로 하는 function을 실행시킨다.
					if(data!=0) tf=true;
					else tf=false;
				}
			});
		return tf;
	}
</script>
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
<style>
	.longlong {word-break:break-all;white-space:pre-wrap;}
	.faq-group .accordion {padding:18px; width:100%; text-align:left;border:0 none; background:transparent; border-bottom:1px solid #ddd; font-size:16px; font-weight:bold; cursor:pointer;}
	.faq-group .accordion:after {content:"\f0fe";font-family:FontAwesome; float:right;}
	.faq-group .panel {padding:20px 18px; border-bottom:1px solid #ddd; line-height:1.8; display:none;}
	.faq-group .panel textarea{width:100%; height:100px;}
	.faq-group .active:after {content:"\f068";font-family:FontAwesome; float:right;}
	td {border:none;}
</style>
	<div id="container">
		<div id="b_right">
			<p class="n_title">
				Qna
			</p>
			<div class="record_group record_group_left">
				<p><i class="fa-solid fa-bell"></i> 총게시글<span> ${t_totalCount } </span>건</p>
			</div>			
			<form name="qna">
			<input type="hidden" name="t_no">
			<input type="hidden" name="t_nowPage">
			<input type="hidden" name="t_requestPage" value="list">
			<p class="select_box select_box_right">
				<select name="t_select" class="sel_box">
					<option value="content" <c:if test="${t_select eq 'content' }">selected</c:if> >Content</option>
				</select>
				<input type="text" name="t_search" value="${t_search }" class="sel_text">
				<button type="button" onClick="goSearch()" class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
			</p>			
			</form>
			<table class="boardList">
				<colgroup>
					<col width="*">
					<col width="10%">
					<col width="14%">
				</colgroup>
				<thead>
					<tr>
						<th>Content</th>
						<th>Reg Name</th>
						<th>Reg Date</th>
					</tr>
				</thead>
			</table>
			<div class="faq-group">
				<c:forEach items="${t_arr }" var="arr">
					<div class="accordion" style="padding:0px;padding-bottom:18px;">
						<table class="boardList">
							<colgroup>
								<col width="*">
								<col width="10%">
								<col width="14%">
							</colgroup>
							<tbody>
								<tr>
									<td class="t_left" style="border:none;">
										<c:forEach begin="0" end="${arr.getS_count() }">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:forEach>
										<c:choose>
											<c:when test="${arr.getNo() eq arr.getReply() }"><i class="fa-solid fa-question"></i></c:when>
											<c:when test="${arr.getNo() ne arr.getReply() }"><i class="fa-solid fa-arrow-right-long"></i></c:when>
										</c:choose>
										<c:choose>
											<c:when test="${fn:length(arr.getContent())>35-2*arr.getS_count() }">
												${fn:substring(arr.getContent(),0,35-2*arr.getS_count()) }...	
											</c:when>
											<c:otherwise>
												${arr.getContent() }
											</c:otherwise>
										</c:choose>
									</td>
									<td style="border:none;">${arr.getReg_name() }</td>
									<td style="border:none;">${arr.getReg_date() }</td>
								</tr>	
							</tbody>
						</table>
					</div>
					<div class="panel btn_3wrap">
						<div class="longlong">${arr.getContent() }</div>
						<c:if test="${sLevel>=0 }">
							<div class="buttonGroup">
								<c:if test="${arr.getReg_id() eq sId or sLevel>1 }">
									<a href="javascript:goDelete('${arr.getNo() }')" class="butt">삭제</a>
								</c:if>
								<a href="javascript:goReply('${arr.getNo() }')" class="butt">답변</a>
							</div>
						</c:if>
					</div>
				</c:forEach>
			</div>
			
			<div class="paging">
				${t_paging }
				<c:if test="${not empty sLevel }">
					<a href="javascript:void()" onClick="goWrite()" class="write" style="width:82px;">글쓰기</a>
				</c:if>
			</div>
		</div>	
	</div>
<%@ include file="/common_footer.jsp" %>