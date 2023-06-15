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
	function goUpdate(){
		if(checking(news.t_title,50,"제목"));
		else if(checking(news.t_content,500,"내용"));
		else if(checking(news.t_attach,25,"첨부파일"));
		else if(checkAttach(news.t_attach));
		else {
			news.method="post";
			news.action="News?t_requestPage=DBupdate";
			news.submit();
		}
	}
	function checkAttach(dir){
		var fileName = dir.value;
		if(fileName != ""){ //  C:\fakepath\img_1.png
			var pathFileName = fileName.lastIndexOf(".")+1;    //확장자 제외한 경로+파일명
			var extension = (fileName.substr(pathFileName)).toLowerCase();	//확장자명
			if(extension != "jpg" && extension != "gif" && extension != "png" && extension != "svg"){
				alert(extension +" 형식 파일은 업로드 안됩니다. jpg, gif, png, svg만 가능!");
				return true;
			}
		}
		
		var file = dir;
		var fileMaxSize  = 5; // 첨부 최대 용량 설정
		if(file.value !=""){
			// 사이즈체크
			var maxSize  = 1024 * 1024 * fileMaxSize;  
			var fileSize = 0;
			// 브라우저 확인
			var browser=navigator.appName;
			// 익스플로러일 경우
			if (browser=="Microsoft Internet Explorer"){
				var oas = new ActiveXObject("Scripting.FileSystemObject");
				fileSize = oas.getFile(file.value).size;
			}else {
			// 익스플로러가 아닐경우
				fileSize = file.files[0].size;
			}

			if(fileSize > maxSize){
				alert(" 첨부파일 사이즈는 "+fileMaxSize+"MB 이내로 등록 가능합니다. ");
				return true;
			}	
		}
		return false;
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
				NEWS
			</p>
			<form name="news" enctype="multipart/form-data">
			<input type="hidden" name="t_old_attach" value=${t_dto.getAttach() }>
			<input type="hidden" name="t_no" value=${t_dto.getNo() }>
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
						<td rowspan="2"><img src="attach/news/${t_dto.getAttach() }" id="preview-image" style="width:228px;border:1px solid gray;"></td>
						<th style="width:70px;">Title</th>
						<td ><input type="text" class="input600" style="width:230px;" name="t_title" value="${t_dto.getTitle() }"></td>
					</tr>	
					<tr>
						<th style="width:70px;">Content</th>
						<td ><textarea class="textArea_H250" style="width:228px;" name="t_content">${t_dto.getContent() }</textarea></td>
					</tr>	
					<tr>
						<th style="width:70px;">Attach</th>
						<td colspan="3"><input type="file" class="input600" name="t_attach" id="input-image"></td>
					</tr>	
					<tr>
						<th style="width:70px;">Writer</th>
						<td>${t_dto.getReg_name()}</td>
						<th style="width:70px;">RegDate</th>
						<td>${t_dto.getReg_date()}</td>
					</tr>	
					<tr>
						<th style="width:70px;">Updater</th>
						<td><input type="text" class="input100" value="${sName }" readonly style="border:none;"></td>
						<th style="width:70px;">UpdateDate</th>
						<td><input type="date" class="input130" value="${t_today }" readonly style="border:none;"></td>
					</tr>	
					

				</tbody>
			</table>
			</form>
			<div class="buttonGroup">
				<a href="javascript:void()" onClick="goUpdate()" class="butt">Save</a>
				<a href="javascript:void()" onClick="goNews('list')" class="butt">List</a>
			</div>	
		</div>	
	</div>
<%@include file="../common_footer.jsp"%>