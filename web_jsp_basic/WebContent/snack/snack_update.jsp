<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*,dao.*,java.util.*" %>
<%
	SnackDao dao = new SnackDao();
	String p_code = request.getParameter("t_p_code");
	SnackDto dto = dao.getSnackView(p_code);
	ArrayList<SnackDto> arr = dao.getCompanyList();
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>TRACK11 연석모</title>
	<link href="../css/common.css" rel="stylesheet">
	<link href="../css/layout.css" rel="stylesheet" >	
	<script type="text/javascript">
		function goUpdate(){
			if(snack.t_p_name.value == ""){
				alert("제품명을 입력하시오!");
				snack.t_p_name.focus();
				return;
			}
			if(snack.t_price.value == ""){
				alert("가격을 입력하시오!");
				snack.t_price.focus();
				return;
			}
			
			var price = snack.t_price.value;
			var price1 = price.replaceAll(",","");
			var price2 = price1.trim();
				snack.t_price.value = price2;
			
			snack.method="post";
			snack.action="db_snack_update.jsp";
			snack.submit();
		}
	</script>
</head>
<body>
	<div class="container">
		<div class="leftmargin">
			<img src="../images/jsl_logo.png"><h1>TRACK11 연석모 SNACK</h1>
		</div>		
		<div class="write_wrap">
		<form name="snack">
		<input type="hidden" name="t_p_code" value="<%=p_code%>">
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
								<%=dto.getP_code()%>
							</td>
						</tr>
						<tr>
							<th>제품명</th>
							<td class="th_left">
								<input name="t_p_name" value="<%=dto.getP_name()%>" class="input_300px" type="text">
							</td>
						</tr>
						<tr>
							<th>가격</th>
							<td class="th_left">
								<input name="t_price" value="<%=dto.getStrprice()%>" class="input_100px" style="text-align:right" type="text">
							</td>
						</tr>
						<tr>
							<th>제조사</th>
							<td class="th_left">
								<select name="t_m_code"  class="select">
								<% for(int k = 0 ; k < arr.size() ; k++){ %>
									<option value="<%=arr.get(k).getM_code() %>" <%if(arr.get(k).getM_code().equals(dto.getM_code())) out.print("selected"); %>><%=arr.get(k).getM_name() %></option>									
								<% } %>	
								</select>								
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			</form>
			<div class="btn_wrap">
				<input type="button" onClick="location.href='snack_list.jsp'" value="목록" class="btn_list">
				<input type="button" onClick="goUpdate()" value="수정저장" class="btn_ok">&nbsp;&nbsp;
			</div>
		</div>
	</div>
</body>
</html>

    