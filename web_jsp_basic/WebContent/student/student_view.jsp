<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*" %>
<%
	StudentDao dao = new StudentDao();
	String syear = request.getParameter("t_syear");
	String sclass = request.getParameter("t_sclass");
	String sno = request.getParameter("t_sno");
	
	StudentDto dto = dao.getStudentView(syear,sclass,sno);

%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>TRACK11 연석모</title>
	<link href="../css/common.css" rel="stylesheet">
	<link href="../css/layout.css" rel="stylesheet" >	
	<script type="text/javascript">
		function goUpdateForm(){
			stu.method="post";
			stu.action="student_update.jsp";
			stu.submit();
		}
		function goDelete(){
			if(confirm("정말삭제하시겠습니까?")){
				stu.method="post";
				stu.action="db_student_delete.jsp";
				stu.submit();
			}
		}
	</script>
</head>
<body>
	<form name = "stu">
		<input type="hidden" name="t_syear" value="<%=syear%>">
		<input type="hidden" name="t_sclass" value="<%=sclass %>">
		<input type="hidden" name="t_sno" value="<%=sno %>">
	</form>
	<div class="container">
	
		<div class="leftmargin">
			<img src="../images/jsl_logo.png"><h1>TRACK11 연석모 성적관리</h1>
		</div>		
		<div class="write_wrap">
		
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
							 	<%=dto.getName() %>
							</td>
						</tr>
						<tr>
							<th>국 어</th>
							<td class="th_left">
								<%=dto.getKor() %>
							</td>
						</tr>
						<tr>
							<th>영 어</th>
							<td class="th_left">
								<%=dto.getEng() %>
							</td>
						</tr>
						<tr>
							<th>수 학</th>
							<td class="th_left">
								<%=dto.getMat() %>
							</td>
						</tr>
						<tr>
							<th>총 점</th>
							<td class="th_left">
								<%=dto.getTotal() %>
							</td>
						</tr>
						<tr>
							<th>평 균</th>
							<td class="th_left">
								<%=dto.getAve() %>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="btn_wrap">
				<input type="button" onClick="window.history.back()" value="목록" class="btn_list">
				<input type="button" onClick="goUpdateForm()" value="수정" class="btn_list">
				<input type="button" onClick="goDelete()" value="삭제" class="btn_list">
			</div>
		</div>
	</div>
</body>
</html>



    