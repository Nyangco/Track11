<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*" %>
<%
	StudentDao dao = new StudentDao();
	String syear = request.getParameter("t_syear");
	String sclass = request.getParameter("t_sclass");
	String sno = request.getParameter("t_sno");
	
	StudentDto dto = dao.getStudentView(syear, sclass, sno);
			
			



%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>TRACK11 연석모</title>
	<link href="../css/common.css" rel="stylesheet">
	<link href="../css/layout.css" rel="stylesheet" >	
	<script type="text/javascript">	
		function changeValue(){								
			var kor = stu.t_kor.value;
			var eng = stu.t_eng.value;
			var mat = stu.t_mat.value;
			
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
			var total = Number(kor) + Number(eng) + Number(mat);
			stu.t_total.value = total;
		
			var ave = total / 3;
			ave = ave.toFixed(2);			
			stu.t_ave.value = ave;	
		}				
		function goUpdate(){			
			if(stu.t_name.value == ""){
				alert("성명입력하시오");
				stu.t_name.focus();
				return;
			}	
			stu.method="post";
			stu.action="db_student_update.jsp";
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
			<input type="hidden" name="t_syear" value="<%=syear%>">
			<input type="hidden" name="t_sclass" value="<%=sclass %>">
			<input type="hidden" name="t_sno" value="<%=sno %>">
			<div class="board_list">
				<table class="board_table">
					<colgroup>
						<col width="12%">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>학 년</th>
							<td class="th_left">
								<%=dto.getSyear() %>
							</td>
						</tr>
						<tr>
							<th>반</th>
							<td class="th_left">
								<%=dto.getSclass() %>
							</td>
						</tr>
						<tr>
							<th>번 호</th>
							<td class="th_left">
								<%=dto.getSno() %>
							</td>
						</tr>
						<tr>
							<th>성 명</th>
							<td class="th_left">
								<input name="t_name" value="<%=dto.getName() %>" class="input_100px" type="text">
							</td>
						</tr>
		
						<tr>
							<th>국 어</th>
							<td class="th_left">
								<input name="t_kor" onchange="changeValue()" value="<%=dto.getKor() %>" class="input_50px inputRight" type="text">
							</td>
						</tr>
						<tr>
							<th>영 어</th>
							<td class="th_left">
								<input name="t_eng" onchange="changeValue()" value="<%=dto.getEng() %>" class="input_50px inputRight" type="text">
							</td>
						</tr>
						<tr>
							<th>수 학</th>
							<td class="th_left">
								<input name="t_mat" onchange="changeValue()" value="<%=dto.getMat() %>" class="input_50px inputRight" type="text">
							</td>
						</tr>
						<tr>
							<th>총 점</th>
							<td class="th_left">
								<input style="border:0" name="t_total" readonly value="<%=dto.getTotal() %>" class="input_50px inputRight" type="text" >
							</td>
						</tr>		
						<tr>
							<th>평 균</th>
							<td class="th_left">
								<input style="border:0" name="t_ave" readonly value="<%=dto.getAve() %>" class="input_50px inputRight" type="text" >
							</td>
						</tr>							
					</tbody>
				</table>
			</div>
			</form>
			<div class="btn_wrap">
				<input type="button" onClick="location.href='student_list.jsp'" value="목록" class="btn_list">
				<input type="button" onClick="goUpdate()" value="수정저장" class="btn_ok">&nbsp;&nbsp;
			</div>
		</div>
	</div>
</body>
</html>



    