<%@page import="dto.MemberDto"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
	MemberDao dao = new MemberDao();
	
	
	if(!sessionAdmin.equals("true")){
		%><script>
			alert("비정상적인 접근입니다");
			location.href="../index.jsp";
		</script><%
	}else{
		String id = request.getParameter("t_id");
		MemberDto dto = dao.viewDB(id);
		String mobile_1 = dto.getMobile().substring(0,3);
		String mobile_2 = dto.getMobile().substring(3,7);
		String mobile_3 = dto.getMobile().substring(7);
%>
<script>
	function goDelete(){
		admin.method="post";
		admin.action="db_admin_delete.jsp";
		admin.submit();
	}
</script>
	
	<!-- sub contents -->
	<div class="container">
		<div class="join_write col_989">
                <div class="list_con">
                </div>
            <form name="admin">
            <input type="hidden" name="t_id" value="<%=dto.getId() %>">
            <table class="table_write02" summary="회원가입을 위한 이름, 아이디, 비밀번호, 비밀번호확인, 소속, 유선전화번호, 휴대전화번호, 이메일, 주소, 본인확인질문, 본인확인답, 주활용사이트, 알림여부 정보 입력">
                <colgroup>
                    <col width="160px">
                    <col width="auto">
                </colgroup>
                <tbody id="joinDataBody">
               		<tr>
                        <th><label for="id">아이디<span class="must"></span></label></th>
                        <td>
                            <%=dto.getId()%>
						</td>
                    </tr>
                    <tr>
                        <th><label for="name">이름</label></th>
                        <td>
                        	<%=dto.getName()%>
                        </td>
                    </tr>
                    <tr>
                        <th>비밀번호</th>
                        <td>
                        	<%
                        		for(int k=0; k<dto.getPwlength(); k++){
                        			out.print("*");
                        		}
                        	%>
                        </td>
                    </tr>
                    <tr>
                        <th>소속</th>
                        <td>
                        	<%=dto.getJob() %>
                        </td>
                    </tr>
                    <tr>
                        <th>유선전화</th>
                        <td>
                        	<%if(dto.getTell_1()==null) out.print("부재");
                        		else out.print(dto.getTell_1()+"-"+dto.getTell_2()+"-"+dto.getTell_3());%>
                        </td>
                    </tr>
                    <tr>
                        <th>휴대전화</th>
                        <td>
                            <%=mobile_1%>-<%=mobile_2%>-<%=mobile_3%>
                        </td>
                    </tr> 
                    <tr>
                        <th><label for="email">이메일</label></th>
                        <td>
                            <%=dto.getEmail() %>
                        </td>
                    </tr>
                    <tr>
                        <th>회원 가입일</th>
                        <td>
                            <%=dto.getReg_date()%>
                        </td>
                    </tr> 
                    <tr>
                        <th>최종 로그인</th>
                        <td>
                            <%
                            if(dto.getLogin_date()==null) out.print("접속 이력 없음");
                            else out.print(dto.getLogin_date());
                            %>
                        </td>
                    </tr> 
            </table>
            </form>
        </div>
	</div>
	<!-- end contents -->
	
	<div class="btnArea Acenter pt60 pb100">
        <a href="admin_list.jsp" class="btn_round btn_large btn_BlueGray w180"><b>목록으로</b></a>
        <a href="javascript:goDelete()" class="btn_round btn_large w180" style=" background:#5882FA;color: #fff;"><b>회원 탈퇴</b></a>
    </div>
	
	
	<script>
		$(function() {
			$(".location  .dropdown > a").on("click",function(e) {
				e.preventDefault();
				if($(this).next().is(":visible")) {
					$(".location  .dropdown > a").next().hide();
				} else {
					$(".location  .dropdown > a").next().hide();
					$(this).next().show();
				}
			});
		});
	</script>
<%} %>
<%@ include file="../common_footer.jsp" %>
 









