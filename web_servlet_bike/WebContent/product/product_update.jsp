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
		
		if(checking(product.t_p_name,20,"상품명"));
		else if(checking(product.t_p_content,1000,"상품 상세설명"));
		else if(checkAttach(product.t_attach,5));
		else if(checking(product.t_p_tag,10,"태그"));
		else if(checking(product.t_p_level,1,"판촉 레벨"));
		else if(checking(product.t_p_content,500,"상품 상세설명"));
		else if(checkLength(product.t_attach,20,"사진 첨부"));
		else if(checkAttach(product.t_attach,5));
		else if(checking(product.t_p_size_w,4,"가로 길이"));
		else if(checking(product.t_p_weight,6,"무게"));
		else if(checking(product.t_p_size_l,4,"세로 길이"));
		else if(checking(product.t_c_name,10,"제조사명"));
		else if(checking(product.t_p_size_h,4,"높이"));
		else if(checking(product.t_price,9,"가격"));
		else {
			product.method="post";
			product.action="Product?t_requestPage=DBupdate";
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
			<input type="hidden" name="t_p_no" value="${t_dto.getP_no() }">
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
						<td ><input type="text" class="input300" name="t_p_name" value=${t_dto.getP_name() }></td>
						<th >태그/판촉</th>
						<td>
							<select name="t_p_tag">
								<c:forEach items="${t_tagArr}" var="sTag">
									<option value="${sTag[0]}"<c:if test="${sTag[0] eq t_dto.getP_tag() }">selected</c:if>>${sTag[1]}</option>
								</c:forEach>
							</select>
							<select name="t_p_level">
								<option value="0" <c:if test="${t_dto.getP_level() eq '0' }">selected</c:if>>보통(0)</option>
								<option value="1" <c:if test="${t_dto.getP_level() eq '1' }">selected</c:if>>높음(1)</option>
								<option value="2" <c:if test="${t_dto.getP_level() eq '2' }">selected</c:if>>매우 높음(2)</option>
							</select>	
						</td>
						
					</tr>
					<tr>
						<th >상품 사진</th>
						<td colspan="3" style="height:400px;">
							<img src="attach/product/${t_dto.getAttach() }" id="preview-image" style="border:1px solid gray;height:400px;width:400px;">
							<input type="hidden" name="t_old_attach" value="${t_dto.getAttach() }">
						</td>
					</tr>
					<tr>
						<th >사진 첨부</th>
						<td colspan="3">※ 400px * 400px 권장<br><input type="file" class="input600" name="t_attach" id="input-image"></td>
						<td colspan="3" style="height:400px;width:400px;"><img id="preview-image" style="border:1px solid gray;display:none;height:398px;width:398px;"></td>
					</tr>
					<tr>
						<th >상품 상세설명</th>
						<td colspan="3"><textarea class="textArea_H250" name="t_p_content">${t_dto.getP_content() }</textarea></td>
					</tr>	
					<tr>
						<th >가로 길이</th>
						<td><input type="text" class="input100" name="t_p_size_w" value="${t_dto.getP_size_w() }">mm</td>
						<th >무게</th>
						<td><input type="text" class="input100" name="t_p_weight" value="${t_dto.getP_weight()}">kg</td>
					</tr>	
					<tr>
						<th >세로 길이</th>
						<td><input type="text" class="input100" name="t_p_size_l"  value="${t_dto.getP_size_l() }">mm</td>
						<th >제조사명</th>
						<td><input type="text" class="input100" name="t_c_name" value="${t_dto.getC_name() }"></td>
					</tr>	
					<tr>
						<th >높이</th>
						<td><input type="text" class="input100" name="t_p_size_h"  value="${t_dto.getP_size_h() }">mm</td>
						<th >가격</th>
						<td >
							<input type="text" class="input100" name="t_price" value="${t_dto.getPrice() }">원&nbsp;&nbsp;
							<select name="t_discount">
								<option value="100">할인율</option>
								<option value="90">10%</option>
								<option value="80">20%</option>
								<option value="50">50%</option>
								<option value="10">90%</option>
							</select>
						</td>
					</tr>	
					<tr>
						<th >작성자</th>
						<td>
							<input type="text" class="input100" value="${t_dto.getReg_id()}" readonly>
						</td>
						<th >작성일자</th>
						<td>
							<input type="date" class="input130" value="${t_dto.getReg_date() }" readonly>
						</td>
					</tr>	
					<tr>
						<th >수정자</th>
						<td>
							<input type="text" class="input100" value="${sName }" readonly>
							<input type="hidden" value="${sId }" name="t_update_id">
						</td>
						<th >수정일자</th>
						<td>
							<input type="date" class="input130" value="${t_today }" name="t_update_date" readonly>
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