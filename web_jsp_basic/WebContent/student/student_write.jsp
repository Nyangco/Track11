<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>TRACK11 연석모</title>
	<link href="../css/common.css" rel="stylesheet">
	<link href="../css/layout.css" rel="stylesheet" >		
	<script type="text/javascript">					
		function goSave(){			
					
			if(stu.t_syear.value == ""){
				alert("학년선택하시오!")
				return;
			}
			if(stu.t_sno.value == ""){
				alert("번호입력!");
				stu.t_sno.focus();
				return;
			}
			if(stu.t_name.value == ""){
				alert("성명입력하시오!")
				stu.t_name.focus();
				return;
			}
			if(stu.t_kor.value == ""){			
				alert("국어점수입력!");
				stu.t_kor.focus();
				return;
			}else{
				if(isNaN(stu.t_kor.value)){
					alert("정수로입력하시오!");
					stu.t_kor.focus();
					return;
				}else{
					if(stu.t_kor.value > 100 || stu.t_kor.value < 0){
						alert("점수0~100사이입력!");
						stu.t_kor.focus();
						return;
					}
				}
			}
			if(stu.t_eng.value == ""){
				alert("영어점수입력!");
				stu.t_eng.focus();
				return;			
			}else{
				if(isNaN(stu.t_eng.value)){
					alert("정수로입력하시오!");
					stu.t_eng.focus();
					return;
				}else{
					if(stu.t_eng.value > 100 || stu.t_eng.value < 0){
						alert("점수0~100사이입력!");
						stu.t_eng.focus();
						return;
					}
				}
			}	
			if(stu.t_mat.value == ""){
				alert("수학점수입력!");
				stu.t_mat.focus();
				return;
			}else{
				if(isNaN(stu.t_mat.value)){
					alert("정수로입력하시오!");
					stu.t_mat.focus();
					return;
				}else{
					if(stu.t_mat.value > 100 || stu.t_mat.value < 0){
						alert("점수0~100사이입력!");
						stu.t_mat.focus();
						return;
					}
				}
			}
			
			stu.method="post";
			stu.action="db_student_save.jsp";
			stu.submit();
		}
	</script>
	<style>
		.inputRight{
			text-align:right;
		}				
	</style>
</head>
<body>
	<div class="container">

		<div class="leftmargin">
			<img src="../images/jsl_logo.png"><h1>TRACK11 연석모 성적관리</h1>
		</div>		
		<div class="write_wrap">
			<form name="stu">
			<div class="board_list">
				<table class="board_table">
					<colgroup>
						<col width="12%">
						<col width="*">
					</colgroup>
					<tbody>
					    <tr>
						    <th>학년</th>
							<td class="th_left">			
									<input type="radio" value="1" name="t_syear">1학년&nbsp;&nbsp;
									<input type="radio" value="2" name="t_syear">2학년&nbsp;&nbsp;
									<input type="radio" value="3" name="t_syear">3학년																								
							</td>
						</tr>
						<tr>
							<th>반</th>
							<td class="th_left">
								<select name="t_sclass" class="select" style="width:80px; height:32;">
									<option value="1">1반</option>
									<option value="2">2반</option>
									<option value="3">3반</option>
									<option value="4">4반</option>
									<option value="5">5반</option>												
								</select>								
							</td>
						</tr>
						<tr>
							<th>번호</th>
							<td class="th_left">
								<input name="t_sno"  class="input_100px" type="text">
							</td>
						</tr>
						<tr>
							<th>성명</th>
							<td class="th_left">
								<input name="t_name"  class="input_300px" type="text">
							</td>
						</tr>
						<tr>
							<th>국어</th>
							<td class="th_left">
								<input name="t_kor"  class="input_50px inputRight" type="text" value="0">
							</td>
						</tr>
						<tr>
							<th>영어</th>
							<td class="th_left">
								<input name="t_eng"  class="input_50px inputRight" type="text" value="0">
							</td>
						</tr>
						<tr>
							<th>수학</th>
							<td class="th_left">
								<input name="t_mat"  class="input_50px inputRight" type="text" value="0">
							</td>
						</tr>
						
						
					</tbody>
				</table>
			</div>
			</form>
			<div class="btn_wrap">
				<input type="button" onclick="goSave()" value="등록" class="btn_ok">&nbsp;&nbsp;
				<input type="button" value="목록" onclick="location.href='student_list.jsp'" class="btn_list">
			</div>
		</div>
	</div>
</body>
</html>



    