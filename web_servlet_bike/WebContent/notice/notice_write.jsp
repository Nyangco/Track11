<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common_header.jsp" %>
<script>
	function goSave(){
		if(checking(notice.t_title,50,"제목"));
		else if(checking(notice.t_content,2000,"내용"));
		else if(checkExtension());
		else{
			notice.method="post";
			notice.action="Notice?t_requestPage=DBsave";
			notice.submit();
		}
	}
	function checkExtension(){
		/***  첨부파일 검사 ***/
		// 1.확장자 검사
		
		/*
		
		var fileName = notice.t_attach.value;
		if(fileName != ""){ //  C:\fakepath\img_1.png
			var pathFileName = fileName.lastIndexOf(".")+1;    //확장자 제외한 경로+파일명
			var extension = (fileName.substr(pathFileName)).toLowerCase();	//확장자명
			//파일명.확장자
//			if(extension != "jpg" && extension != "gif" && extension != "png"){
			if(extension != "pdf" && extension != "hwp" && extension != "png"){
				alert(extension +" 형식 파일은 업로드 안됩니다. 한글, PDF 파일만 가능!");
				return;
			}		
		}
			
		*/
		
		
		// 2.첨부 용량 체크	
		var file = notice.t_attach;
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
			}	else return false;
		}
	}
</script>
	<div id="container">
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