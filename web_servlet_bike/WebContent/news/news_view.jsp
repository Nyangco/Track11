<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common_header.jsp"%>
<script type="text/javascript">
	$(function(){					
		function readImage(input) {
		    // 인풋 태그에 파일이 있는 경우
		    if(input.files && input.files[0]) {
		        // 이미지 파일인지 검사 (생략)
		        // FileReader 인스턴스 생성
		        const reader = new FileReader()
		        // 이미지가 로드가 된 경우
		        reader.onload = e => {
		            const previewImage = document.getElementById("preview-image")
		            previewImage.src = e.target.result;
		        }
		        // reader가 이미지 읽도록 하기
		        reader.readAsDataURL(input.files[0])
		    } else {
		    	// 이미지 안올렸으면
				$("#preview-image").attr('src','');
				$("#preview-image").css("display","none");
		    }
		}
		// input file에 change 이벤트 부여
		const inputImage = document.getElementById("input-image");
		inputImage.addEventListener("change", e => {
			$("#preview-image").css("display","block");
		    readImage(e.target)
		})	
	});	
</script>
<script>
	function goSave(){
		if(checking(news.t_title,50,"제목"));
		else if(checking(news.t_content,500,"내용"));
		else if(checking(news.t_attach,25,"첨부파일"));
		else {
			news.method="post";
			news.action="News?t_requestPage=DBsave";
			news.submit();
		}
	}
</script>
<style>
	#preview-image {
		border:1px solid gray;
	}					
</style>
	<div id="container">
		<div id="b_right">
			<p class="n_title">
				News
			</p>
			<form name="news" enctype="multipart/form-data">
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<tbody>
					<tr>
						<th rowspan="2" style="width:70px;">Image</th>
						<td rowspan="2"><img id="preview-image" style="width:228px;border:1px solid gray;"></td>
						<th style="width:70px;">Title</th>
						<td ><input type="text" class="input600" style="width:230px;" name="t_title"></td>
					</tr>	
					<tr>
						<th style="width:70px;">Content</th>
						<td ><textarea class="textArea_H250" style="width:228px;" name="t_content"></textarea></td>
					</tr>	
					<tr>
						<th style="width:70px;">Attach</th>
						<td colspan="3">※이미지 첨부 필수 230px * 230px 권장<br><input type="file" class="input600" name="t_attach" ></td>
					</tr>	
					<tr>
						<th style="width:70px;">Writer</th>
						<td><input type="text" class="input100" value="${sName }" readonly></td>
						<th style="width:70px;">RegDate</th>
						<td><input type="date" class="input130" value="${t_today }" readonly></td>
					</tr>	

				</tbody>
			</table>
			</form>
			<div class="buttonGroup">
				<a href="javascript:void()" onClick="goSave()" class="butt">Save</a>
				<a href="javascript:void()" onClick="goNews('list')" class="butt">List</a>
			</div>	
		</div>	
	</div>
<%@include file="../common_footer.jsp"%>