<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>TRACK11 홍길동</title>
	<link href="css/common.css" rel="stylesheet">
	<link href="css/layout.css" rel="stylesheet" >		
	<script type="text/javascript">
		function checkValue(dir,name){
			if(dir.value==""){
				alert(name+"을/를 입력해주세요");
				dir.focus();
				return true;
			}
			else return false;
		}
		function checkLength(dir,len,name){
			var lengt = Number(len);
			var leng = Number(dir.value.length);
			if(leng>lengt){
				alert(name+"의 길이는"+len+"자 까지 입니다.");
				dir.focus();
				return true;
			}
			else return false;
		}
		function goSave(){
			if(checkValue(mem.t_id,"아이디"));
			else if(checkLength(mem.t_id,5,"아이디"));
			else if(checkValue(mem.t_name,"이름"));
			else if(checkLength(mem.t_name,5,"이름"));
			else if(checkValue(mem.t_reg_date,"가입일"));
			else{
				mem.t_requestPage.value="DBsave";
				mem.method="post";
				mem.action="Member";
				mem.submit();
			}
		}
	</script>
</head>
<body>
	<div class="container">

		<div class="leftmargin">
			<img src="images/jsl_logo.png"><h1>TRACK11 홍길동 회원관리</h1>
		</div>		
		<div class="write_wrap">
			<form name="mem">
			<input type="hidden" name="t_requestPage">
			<div class="board_list">
				<table class="board_table">
					<colgroup>
						<col width="12%">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>ID</th>
							<td class="th_left">
								<input name="t_id"  class="input_100px" type="text">
							</td>
						</tr>
						<tr>
							<th>성명</th>
							<td class="th_left">
								<input name="t_name"  class="input_300px" type="text">
							</td>
						</tr>
						<tr>
							<th>나이</th>
							<td class="th_left">
								<input name="t_age"  class="input_100px" type="text">
							</td>
						</tr>
						<tr>
							<th>가입일</th>
							<td class="th_left">
								<input name="t_reg_date"  class="input_200px" type="date">							
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			</form>
			<div class="btn_wrap">
				<input type="button" value="등록" onClick="goSave()" class="btn_ok">&nbsp;&nbsp;
				<input type="button" value="목록" onclick="location.href='Member'" class="btn_list">
			</div>
		</div>
	</div>
</body>
</html>