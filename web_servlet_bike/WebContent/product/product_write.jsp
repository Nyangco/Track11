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
		
		var price = product.t_price.value;
		price = price.replaceAll(",","");
		product.t_price.value=price;
		var extensions=["jpg","gif","svg","png"];
		
		if(checking(product.t_p_name,20,"상품명"));
		else if(checking(product.t_p_tag,10,"태그"));
		else if(checking(product.t_p_level,1,"판촉 레벨"));
		else if(checking(product.t_p_content,1000,"상품 상세설명"));
		else if(checking(product.t_attach,40,"사진 첨부"));
		else if(checkAttach(product.t_attach));
		else if(checking(product.t_p_content,500,"상품 상세설명"));
		else if(checking(product.t_attach,20,"사진 첨부"));
		else if(checkAttach(product.t_attach,5,extensions));
		else if(checking(product.t_p_size_w,4,"가로 길이"));
		else if(checking(product.t_p_weight,6,"무게"));
		else if(checking(product.t_p_size_l,4,"세로 길이"));
		else if(checking(product.t_c_name,10,"제조사명"));
		else if(checking(product.t_p_size_h,4,"높이"));
		else if(checking(product.t_price,9,"가격"));
		else {
			product.method="post";
			product.action="Product?t_requestPage=DBsave";
			product.submit();
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
				PRODUCT
			</p>
			<form name="product" enctype="multipart/form-data">
			<table class="boardForm">
				<colgroup>
					<col width="10%">
					<col width="40%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<tbody>
					<tr>
						<th >상품명</th>
						<td ><input type="text" class="input300" name="t_p_name"></td>
						<th >태그/판촉</th>
						<td>
							<select name="t_p_tag">
								<option value="">태그 선택</option>
								<c:forEach items="${t_tagArr}" var="sTag">
								<option value="${sTag[0]}">${sTag[1]}</option>
								</c:forEach>
							</select>
							<select name="t_p_level">
								<option value="">판촉 레벨 선택</option>
								<option value="0">보통(0)</option>
								<option value="1">높음(1)</option>
								<option value="2">매우 높음(2)</option>
							</select>	
						</td>
						
					</tr>
					<tr>
						<th >상품 사진</th>
						<td colspan="3" style="height:400px;"><img id="preview-image" style="border:1px solid gray;display:none;height:400px;width:400px;"></td>
						<td colspan="3" style="height:400px;width:400px;"><img id="preview-image" style="border:1px solid gray;display:none;height:398px;width:398px;"></td>
					</tr>
					<tr>
						<th >사진 첨부</th>
						<td colspan="3">※이미지 첨부 필수 400px * 400px 권장<br><input type="file" class="input600" name="t_attach" id="input-image"></td>
					</tr>
					<tr>
						<th >상품 상세설명</th>
						<td colspan="3"><textarea class="textArea_H250" name="t_p_content"></textarea></td>
					</tr>	
					<tr>
						<th >가로 길이</th>
						<td><input type="text" class="input100" name="t_p_size_w">mm</td>
						<th >무게</th>
						<td><input type="text" class="input100" name="t_p_weight">kg</td>
					</tr>	
					<tr>
						<th >세로 길이</th>
						<td><input type="text" class="input100" name="t_p_size_l">mm</td>
						<th >제조사명</th>
						<td><input type="text" class="input100" name="t_c_name"></td>
					</tr>	
					<tr>
						<th >높이</th>
						<td><input type="text" class="input100" name="t_p_size_h">mm</td>
						<th >가격</th>
						<td >
							<input type="text" class="input100" name="t_price">원&nbsp;&nbsp;
						</td>
					</tr>	
					<tr>
						<th >작성자</th>
						<td>
							<input type="text" class="input100" value="${sName }" readonly>
							<input type="hidden" value="${sId }" name="t_reg_id">
						</td>
						<th >작성일자</th>
						<td>
							<input type="date" class="input130" value="${t_today }" name="t_reg_date" readonly>
						</td>
					</tr>	

				</tbody>
			</table>
			</form>
			
			
			<div class="buttonGroup">
				<a href="javascript:void()" onClick="goSave()" class="butt">저장</a>
				<a href="javascript:void()" onClick="goProduct('list')" class="butt">목록</a>
			</div>	
		</div>	
	</div>
<%@include file="../common_footer.jsp"%>