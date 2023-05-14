<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>TRACK11 연석모</title>
	<link href="css/common.css" rel="stylesheet">
	<link href="css/layout.css" rel="stylesheet" >	
	<script type="text/javascript">
		function checking(dir,len,name){
			var lengt = Number(len);
			var leng = Number(dir.value.length);
			if(dir.value==""){
				alert(name+"을/를 입력해주세요");
				dir.focus();
				return true;
			}else if(leng>lengt){
				alert(name+"의 길이는"+len+"자 까지 입니다.");
				dir.focus();
				return true;
			}
			else return false;
		}function goUpdate(){
			if(checking(mem.t_name,5,"이름"));
			else if(checking(mem.t_age,3,"나이"));
			else if(checking(mem.t_reg_date,99,"가입일"));
			else{
				mem.method="post";
				mem.action="Member";
				mem.submit();
			};
		}
	</script>
</head>
<body>
	<div class="container">
		<div class="leftmargin">
			<img src="images/jsl_logo.png"><h1>TRACK11 연석모 회원관리</h1>
		</div>		
		<div class="write_wrap">
		<form name="mem">
		<input type="hidden" name="t_requestPage" value="DBupdate">
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
								${t_dto.getId() }
								<input type="hidden" name="t_id" value="${t_dto.getId() }">
							</td>
						</tr>
						<tr>
							<th>성명</th>
							<td class="th_left">
								<input name="t_name" value="${t_dto.getName() }" class="input_300px" type="text">
							</td>
						</tr>
						<tr>
							<th>나이</th>
							<td class="th_left">
								<input name="t_age" value="${t_dto.getAge() }" class="input_100px" type="text">
							</td>
						</tr>
						<tr>
							<th>가입일</th>
							<td class="th_left">
								<input name="t_reg_date" value="${t_dto.getReg_date() }" class="input_200px" type="date">							
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			</form>
			<div class="btn_wrap">
				<input type="button" onClick="location.href='Member'" value="목록" class="btn_list">
				<input type="button" onClick="goUpdate()" value="수정저장" class="btn_ok">&nbsp;&nbsp;
			</div>
		</div>
	</div>
</body>
</html>



















