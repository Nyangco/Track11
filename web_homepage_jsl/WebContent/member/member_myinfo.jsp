<%@page import="dto.MemberDto"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common_header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
	MemberDao dao = new MemberDao();
	
	if(!sessionId.equals("")){
		MemberDto dto = dao.getMemberDB(sessionId);
		String mobile_1 = dto.getMobile().substring(0,3);
		String mobile_2 = dto.getMobile().substring(3,7);
		String mobile_3 = dto.getMobile().substring(7);
%>
	<div class="container">
		<div class="con_title">
            <h1>내정보(개인회원)</h1>
         <p>HOME / 마이페이지 / 내정보(개인회원)</p>
        </div>
		<div class="join_write col_989">
                <div class="list_con">
                </div>
            <form name="mem">
            <table class="table_write02" summary="회원가입을 위한 이름, 아이디, 비밀번호, 비밀번호확인, 소속, 유선전화번호, 휴대전화번호, 이메일, 주소, 본인확인질문, 본인확인답, 주활용사이트, 알림여부 정보 입력">
                <colgroup>
                    <col width="160px">
                    <col width="auto">
                </colgroup>
                <tbody id="joinDataBody">
                    <tr>
                        <th><label for="name">이름</label></th>
                        <td>
                        	<%=sessionName %>
                        </td>
                    </tr>
                    <tr>
                        <th><label for="id">아이디<span class="must"></span></label></th>
                        <td>
                            <%=sessionId %>
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
            </table>
            </form>
        </div>
	</div>
	<!-- end contents -->
	
	<div class="btnArea Acenter pt60 pb100">
        <a href="../index.jsp;" class="btn_round btn_large btn_BlueGray w180"><b>목록으로</b></a>
        <a href="member_update.jsp" class="btn_round btn_large w180" style=" background:#5882FA;color: #fff;"><b>수정</b></a>
        <a href="change_password.jsp" class="btn_round btn_large btn_pointColor w180"><b>비밀번호 변경</b></a>
        <a href="member_quit.jsp" class="btn_round btn_large w180" style=" background:#f00;color: #fff;"><b>계정 탈퇴</b></a>
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
<%} else{%>
	<script>
		alert("로그인 정보가 만료되었습니다.");
		location.href="../login/member_login.jsp";
	</script>
<%}%>
	

<%@ include file="../common_footer.jsp" %>
 









