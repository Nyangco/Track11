<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common_header.jsp" %>
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
		if(checking(freeboard.t_title,50,"제목"));
		else if(checking(freeboard.t_content,2000,"내용"));
		else if(checkExtension());
		else{
			freeboard.method="post";
			freeboard.action="Freeboard?t_requestPage=DBsave";
			freeboard.submit();
		}
	}
	function checkExtension(){
		var file = freeboard.t_attach;
		var fileMaxSize  = 10; // 첨부 최대 용량 설정
		if(file.value !=""){
			var maxSize  = 1024 * 1024 * fileMaxSize;  
			var fileSize = 0;
			var browser=navigator.appName;
			if (browser=="Microsoft Internet Explorer"){
				var oas = new ActiveXObject("Scripting.FileSystemObject");
				fileSize = oas.getFile(file.value).size;
			}else {
				fileSize = file.files[0].size;
			}
			if(fileSize > maxSize){
				alert(" 첨부파일 사이즈는 "+fileMaxSize+"MB 이내로 등록 가능합니다. ");
				return true;
			}	else return false;
		}
	}
</script>
	<div id="container">
		<div id="b_right">
			<p class="n_title">
				Freeboard
			</p>
			<form name="freeboard" enctype="multipart/form-data">
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
						<th>Pict</th>
						<td colspan="3"><img id="preview-image" width="400"></td>
					</tr>	
					<tr>
						<th>Attach</th>
						<td colspan="3"><input type="file" class="input600" name="t_attach" id="input-image"></td>
					</tr>	
					
					<tr>
						<th>Writer</th>
						<td>
							<input type="text" class="input100" value="${sName }" readonly>
							<input type="hidden" value="${sId }" name="t_reg_id">
						</td>
						<th>RegDate</th>
						<td><input type="date" class="input130" value="${t_today}" readonly></td>
					</tr>	
				</tbody>
			</table>
			</form>
			<div class="buttonGroup">
				<a href="javascript:void()" onClick="goSave()" class="butt">Save</a>
				<a href="javascript:void()" onClick="goFreeboard('list')" class="butt">List</a>
			</div>	
		</div>	
	</div>
<%@ include file="/common_footer.jsp"%>