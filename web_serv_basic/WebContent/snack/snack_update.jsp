<%@page import="java.text.DecimalFormat"%>
<%@page import="dto.SnackDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	SnackDto dto = (SnackDto)request.getAttribute("t_dto");
	DecimalFormat df = new DecimalFormat("###,###");
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>TRACK11 연석모</title>
	<link href="css/common.css" rel="stylesheet">
	<link href="css/layout.css" rel="stylesheet" >	
	<script type="text/javascript">
	function checkValue(dir,len){
		if(dir.value==""){
			alert("미입력한 항목이 있습니다");
			dir.focus();
			return true;
		}else if(dir.value.length>Number(len)){
			alert("해당 항목은 최대 "+len+"자 까지 입력하실 수 있습니다.");
			dir.focus();
			return true;
		}else return false;
	}function goUpdate(){
		if(checkValue(snack.t_p_code,4));
		else if(checkValue(snack.t_p_name,10));
		else if(checkValue(snack.t_m_code,2));
		else if(snack.t_price.value==""){
			alert("금액을 입력해주십시오");
			snack.t_price.focus();
		}else if(snack.t_price.value.indexOf(",")!=-1 && snack.t_price.value.length>7){
			alert("금액은 최대 6자 까지 입력하실 수 있습니다.");
			snack.t_price.focus();
		}else if(snack.t_price.value.indexOf(",")==-1 && snack.t_price.value.length>6){
			alert("금액은 최대 6자 까지 입력하실 수 있습니다.");
			snack.t_price.focus();
		}else{
			snack.t_requestPage.value="DBupdate";
			snack.method="post";
			snack.action="Snack";
			snack.submit();
		}
	} 
	</script>
</head>
<body>
	<div class="container">
		<div class="leftmargin">
			<img src="images/jsl_logo.png"><h1>TRACK11 연석모 SNACK</h1>
		</div>		
		<div class="write_wrap">
		<form name="snack">
		<input type="hidden" name="t_requestPage">
			<div class="board_list">
				<table class="board_table">
					<colgroup>
						<col width="12%">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>제품번호</th>
							<td class="th_left">
								<%=dto.getP_code() %>
								<input type="hidden" name="t_p_code" value="<%=dto.getP_code() %>">
							</td>
						</tr>
						<tr>
							<th>제품명</th>
							<td class="th_left">
								<input name="t_p_name" value="<%=dto.getP_name() %>" class="input_300px" type="text">
							</td>
						</tr>
						<tr>
							<th>가격</th>
							<td class="th_left">
								<input name="t_price" value="<%=df.format(dto.getPrice()) %>" class="input_100px" type="text" dir="rtl">
							</td>
						</tr>
						<tr>
							<th>제조사</th>
							<td class="th_left">
								<select name="t_m_code" class="select">
									<option value="10" <%if(dto.getM_code().equals("10")) out.print("selected"); %>>롯데</option>
									<option value="20" <%if(dto.getM_code().equals("20")) out.print("selected"); %>>해태</option>
									<option value="30" <%if(dto.getM_code().equals("30")) out.print("selected"); %>>농심</option>
									<option value="40" <%if(dto.getM_code().equals("40")) out.print("selected"); %>>크라운</option>
									<option value="50" <%if(dto.getM_code().equals("50")) out.print("selected"); %>>오리온</option>
								</select>								
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</form>
			<div class="btn_wrap">
				<input type="button" onClick="location.href='Snack'" value="목록" class="btn_list">
				<input type="button" onClick="goUpdate()" value="수정저장" class="btn_ok">&nbsp;&nbsp;
			</div>
		</div>
	</div>
</body>
</html>