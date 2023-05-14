<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../common_header.jsp" %>

	<script>
  
	function checkPhone(input){
		if(input.value.length!=4){
			alert("휴대전화의 각 자릿수는 4자리 입니다.");
			input.focus();
			return true;
		}return false;
	}
	
	function removeId(){
		mem.t_idCheck.value="";
	}
	
	function memberJoin(){
		if(checkValue(mem.t_id,"아이디를"));
		else if(mem.t_idCheck.value=="" || mem.t_idCheck.value=="1"){
			alert("ID 중복검사를 해주세요");
			mem.t_id.focus();
		}else if(checkValue(mem.t_name,"성명을"));
		else if(checkLength(mem.t_name,5,"성명의"));
		else if(checkValue(mem.t_password,"비밀번호를"));
		else if(checkLength(mem.t_password,20,"비밀번호의"));
		else if(mem.t_password.value != mem.t_chk_password.value){
			alert("비밀번호가 일치하지 않습니다.");
			mem.t_chk_password.focus();
		}else if(checkValue(mem.t_job,"소속을"));
		else if(mem.t_tell_1.value!="" && (mem.t_tell_2.value==0 || mem.t_tell_3.value==0)){
			alert("유선 번호를 입력해주세요");
			if(mem.t_tell_2.value==0) mem.t_tell_2.focus();
			else mem.t_tell_3.focus();
		}else if(mem.t_tell_2.value.length!=3 && mem.t_tell_2.value.length!=0){
			alert("3자리로 입력해주세요");
			mem.t_tell_2.focus();			
		}else if(mem.t_tell_3.value.length!=4 && mem.t_tell_3.value.length!=0){
			alert("4자리로 입력해주세요");
			mem.t_tell_3.focus();			
		}else if(mem.t_tell_2.value.length==0 && mem.t_tell_2.value.length==4){
			alert("3자리로 입력해주세요");
			mem.t_tell_3.focus();			
		}else if(mem.t_tell_2.value.length==3 && mem.t_tell_2.value.length==0){
			alert("4자리로 입력해주세요");
			mem.t_tell_3.focus();			
		}else if(checkValue(mem.t_mobile_2,"휴대전화 번호를"));
		else if(checkPhone(mem.t_mobile_2));
		else if(checkValue(mem.t_mobile_3,"휴대전화 번호를"));
		else if(checkPhone(mem.t_mobile_3));
		else if(checkValue(mem.t_email,"이메일을"));
		else if(checkLength(mem.t_email,30,"이메일의"));
		else{
			mem.method="post";
			mem.action="db_member_join.jsp";
			mem.submit();
		}
	}
	
	function checkId(){
		if(mem.t_id.value==""){
			alert("ID를 입력하시오");
			mem.t_id.focus();
		}else{
			confirmId();
		}
	}
	
	function confirmId(){
		$.ajax({
		//$(jQuery)의 ajax 라는 기능을 실행한다.
			type : "POST",
			//새창에서 연다
			url : "member_checkid.jsp",
			//해당 url로 이동한다
			data: "t_id="+mem.t_id.value,
			//매개변수를 입력한다.
			dataType : "text",
			//결과를 글자로 받겠다.
			error : function(){
			//에러가 생기면 function을 실행한다.
				alert('통신실패!!!!!');
			},
			success : function(data){
			//성공하면 data를 매개변수로 하는 function을 실행시킨다.
				var result = $.trim(data);
				//data의 앞뒤 공간을 빼는 jQuery의 trim 함수를 사용해서 result에 저장한다.
				mem.t_idCheck.value=result;
				if(result==0){
					mem.t_id_show.value="사용 가능";
				}else{
					mem.t_id_show.value="중복된 id";
				}
			}
		});				
	}
	
</script>
	<div class="container">
		<div class="con_title">
            <h1>내정보(개인회원)</h1>
         <p>HOME / 마이페이지 / 내정보(개인회원)</p>
        </div>
		<div class="join_write col_989">
                <div class="list_con">
                    <ul class="icon_type1">
                        <li>회원정보는 개인정보 취급방침에 따라 안전하게 보호되며 회원님의 명백한 동의 없이 공개 또는 제3자에게 제공되지 않습니다.</li>
                    </ul>
                </div>
            <form name="mem">
            <table class="table_write02" summary="회원가입을 위한 이름, 아이디, 비밀번호, 비밀번호확인, 소속, 유선전화번호, 휴대전화번호, 이메일, 주소, 본인확인질문, 본인확인답, 주활용사이트, 알림여부 정보 입력">
                <caption>회원가입을 위한 정보입력표</caption>
                <colgroup>
                    <col width="160px">
                    <col width="auto">
                </colgroup>
                <tbody id="joinDataBody"> 
                	<tr>
                        <th><label for="id">아이디<span class="must"></span></label></th>
                        <td>
                            <input type="text" name="t_id" id="mbrId" class="w300" autofocus onkeypress="removeId()">
							<a href="javascript:checkId()" class="btn_write"><b>ID중복검사</b></a>
							<input type="text" name="t_id_show" readonly style="border:none;">
							<input type="hidden" name="t_idCheck">
						</td>
                    </tr>
                    <tr>
                        <th><label for="name">이름</label></th>
                        <td>
                            <input type="text" name="t_name" id="mbrName" class="w300">
                        </td>
                    </tr>
                   
                    <tr>
                        <th><label for="pw">비밀번호<!-- <span class="must"><b>필수입력</b></span> --></label></th>
                        <td>
                            <input type="password" name="t_password" id="scrtNo" class="w300">
                            <p class="guideTxt"><span class="tc_point"></p>
                        </td>
                    </tr>
                    <tr>
                        <th><label for="pw_confirm">비밀번호확인<!-- <span class="must"><b>필수입력</b></span> --></label></th>
                        <td>
                            <input type="password" name="t_chk_password" id="scrtNoConfirm" class="w300">
                            <p class="guideTxt"></p>
                        </td>
                    </tr>
                    <tr>
                        <th>소속<span class="must"><b>필수입력</b></span></th>
                        <td>
                            <label for="mbrClCd" class="blind">소속1차 카테고리 선택</label>
                            <select name="t_job" id="mbrClCd">
                               		<option value="">선택</option>
                                    <option value="기업">기업</option>
                                    <option value="교수자">교수자</option>
                                    <option value="미취업자">미취업자</option>
                                    <option value="기타">기타</option>
                            </select>
							<!--
                            <ul id="posCdData" style="display: none;">
                            
                                <li id="posCdVal" poscd="10" posname="협회" postype="01">
                            
                                </li><li id="posCdVal" poscd="11" posname="단체" postype="01">
                            
                                </li><li id="posCdVal" poscd="12" posname="일반기업" postype="01">
                            
                                </li><li id="posCdVal" poscd="20" posname="전문대학" postype="02">
                            
                                </li><li id="posCdVal" poscd="21" posname="폴리텍대학" postype="02">
                            
                                </li><li id="posCdVal" poscd="22" posname="4년제대학" postype="02">
                            
                                </li><li id="posCdVal" poscd="23" posname="일반고" postype="02">
                            
                                </li><li id="posCdVal" poscd="24" posname="마이스터고" postype="02">
                            
                                </li><li id="posCdVal" poscd="25" posname="특성화고" postype="02">
                            
                                </li><li id="posCdVal" poscd="26" posname="직업훈련기관" postype="02">
                            
                                </li><li id="posCdVal" poscd="30" posname="학생" postype="03">
                            
                                </li><li id="posCdVal" poscd="31" posname="일반인" postype="03">
                            
                                </li><li id="posCdVal" poscd="40" posname="공공기관" postype="04">
                            
                                </li><li id="posCdVal" poscd="41" posname="공공단체" postype="04">
                            
                                </li><li id="posCdVal" poscd="42" posname="소속기관" postype="04">
                            
                            </li></ul>
                            <label for="posCd" class="blind">소속2차 카테고리 선택</label>
                            <select name="posCd" id="posCd">
                                
                            <option value="">선택</option><option value="10">협회</option><option value="11">단체</option><option value="12">일반기업</option></select>
                            <input type="text" name="posName" id="posName" class="w200" value=""><label for="belong" class="blind">소속입력</label>
							-->
                            <p class="guideTxt">학생 신분은 '미취업자' 소속으로 선택해주십시오.</p>
                        </td>
                    </tr>
                    <tr>
                        <th>유선전화</th>
                        <td>
                            <label for="phone_number1" class="blind">유선전화 앞번호 선택</label>
                            <select name="t_tell_1" id="telNo1" class="w95">
                                <option value="" selected>선택</option>
                                    <option value="02">02</option>
                                    <option value="031">031</option>
                                    <option value="032">032</option>
                                    <option value="033">033</option>
                                    <option value="041">041</option>
                                    <option value="042">042</option>
                                    <option value="043">043</option>
                                    <option value="044">044</option>
                                    <option value="051">051</option>
                                    <option value="052">052</option>
                                    <option value="053">053</option>
                                    <option value="054">054</option>
                                    <option value="055">055</option>
                                    <option value="061">061</option>
                                    <option value="062">062</option>
                                    <option value="063">063</option>
                                    <option value="064">064</option>
                            </select>
                            <input type="text" name="t_tell_2" id="telNo2" class="w95" value="" maxlength="3"><label for="phone_number2" class="blind">중간번호</label>
                            <input type="text" name="t_tell_3" id="telNo3" class="w95" value="" maxlength="4"><label for="phone_number3" class="blind">마지막번호</label>
                            <p class="guideTxt">유선 전화가 없을 경우 국번의 '선택'을 선택해 주십시오.</p>
                        </td>
                    </tr>
                    <tr>
                        <th>휴대전화<span class="must"></th>
                        <td>
                            <label for="mphonNo1" class="blind">휴대전화 앞번호 선택</label>
                            <select name="t_mobile_1" id="mphonNo1" class="w95">
                                    <option value="010">010</option>
                                    <option value="011">011</option>
                            </select>
                            <input type="text" name="t_mobile_2" id="mphonNo2" class="w95" maxlength="4"><label for="mphonNo2" class="blind">중간번호</label>
                            <input type="text" name="t_mobile_3" id="mphonNo3" class="w95" maxlength="4"><label for="mphonNo3" class="blind">마직막번호</label>
                        </td>
                    </tr> 
                    <tr>
                        <th><label for="email">이메일</label></th>
                        <td>
                            <input type="email" name="t_email" id="email" class="w300" >
                        </td>
                    </tr>
                    <!-- <tr>
                        <th>주소<span class="must"><b>필수입력</b></span></th>
                        <td>
                            <input type="text" name="zipNo" id="zipNo" disabled="disabled" placeholder="우편번호" class="w120" value="34839"><label for="zipNo" class="blind">우편번호</label>
                            <a id="btn_findJuso" href="javascript:gfn_com_openJusoPopup('fn_jusoCallBack');" class="btn_form btn_DeepGray">주소검색</a>
                            <hr>
                            <input type="text" name="addr" id="addr" disabled="disabled" placeholder="주소" class="w550" value="대전 중구 선화동 1∼66"><label for="addr" class="blind">주소</label>
                            <hr>
                            <input type="text" name="detlAddr" id="detlAddr" placeholder="상세주소" class="w550" value="32-5 대우직업전문학교"><label for="detlAddr" class="blind">상세주소</label>
                        </td>
                    </tr>
                    <tr>
                        <th><label for="myslfConfQuest">본인확인질문</label></th>
                        <td>
                            <select name="myslfConfQuest" id="myslfConfQuest">
                                <option value="">선택</option>
                                
                                    <option value="01">가장 기억에 남는 장소는?</option>
                                
                                    <option value="02">나의 좌우명은?</option>
                                
                                    <option value="03">나의 보물 제1호는?</option>
                                
                                    <option value="06">오래도록 기억하고 싶은 날짜는?</option>
                                
                                    <option value="11">내가 존경하는 인물은?</option>
                                
                                    <option value="12">다시 태어나면 되고 싶은 것은?</option>
                                
                                    <option value="15">내 휴대폰 1번에 등록된 사람은?</option>
                                
                                    <option value="16">나의 출신 초등학교는?</option>
                                
                                    <option value="17">우리집 애완동물의 이름은?</option>
                                
                                    <option value="20">좋아하는 스포츠 팀 이름은?</option>
                                
                                    <option value="21">본인의 출생지는 ?</option>
                                
                            </select>
                        </td>
                    </tr>
                    <tr> 
                        <th><label for="myslfConfAns">본인확인답</label></th>
                        <td>
                            <input type="text" name="myslfConfAns" id="myslfConfAns" class="w300" value="예수님">
                        </td>
                    </tr>
                    <tr>
                        <th>SNS계정연동</th>
                        <td>
	                    	<ul class="join_sns">
			                   <li class="naver">
			                    	<input type="hidden" id="naverYn" value="">
			                        <div id="naver_id_login" class="blind"><a href="https://nid.naver.com/oauth2.0/authorize?response_type=token&amp;client_id=KHOG8V_PSvFjJoo7WpGL&amp;redirect_uri=https%3A%2F%2Fwww.ncs.go.kr%2Flogin%2FloginNaverCallBack.do&amp;state=" onclick="window.open(this.href, 'naverloginpop', 'titlebar=1, resizable=1, scrollbars=yes, width=600, height=550'); return false" id="naver_id_login_anchor"><img src="https://static.nid.naver.com/oauth/button_g.PNG" title="네이버 아이디로 로그인" width="40" height="40" border="0"></a> </div>
			                    	<button onclick="fn_loginNaver()" class="btnGet">네이버 연동</button> <!-- ◀ 연동된 계정은 class에 On 추가해주세요 
			                    	  ◀ 연동된 계정에만 연동해제 버튼이 생겨요 
			                    </li>
			                    <li class="kakao">
			                    	<input type="hidden" id="kakaoYn" value="">
			                        <a id="kakao_id_login" class="blind" href="javascript:;"></a>
			                    	<button onclick="fn_kakaoLogin()" class="btnGet">카카오톡 연동</button>
			                    	 
		                    	</li>
			                    <li class="face">
			                    	<input type="hidden" id="faceYn" value="">
			                    	<button onclick="fn_facebookLogin()" class="btnGet">페이스북 연동</button>
			                    	 
		                    	</li>
			                </ul>
                        </td>
                    </tr>
                    <tr>
                        <th>주활용사이트</th>
                        <td>
                        <input type="hidden" name="siteGbn" id="siteGbn" value="">
                        
                            <input type="radio" name="siteGbnChk" id="siteGbn01" chkvalue="01"><label for="siteGbn01">능력중심채용</label>
                        
                            <input type="radio" name="siteGbnChk" id="siteGbn02" chkvalue="02"><label for="siteGbn02">기업활용</label>
                        
                            <input type="radio" name="siteGbnChk" id="siteGbn03" chkvalue="03"><label for="siteGbn03">교육·훈련설계</label>
                        
                        </td>
                    </tr>
                    <tr>
                        <th>알림여부</th>
                        <td>
                            <input type="hidden" name="alarmAgreeYn" id="alarmAgreeYn" value="N">
                            <input type="checkbox" name="alarmAgree" id="alarmAgree"><label for="alarmAgree">NCS 홈페이지에서 제공하는 SMS, 카톡알림 등의 서비스 이용에 동의합니다.</label>
                        </td>
                    </tr>
                </tbody> -->
            </table>
            </form>
        </div>
	</div>
	<!-- end contents -->
	
	<div class="btnArea Acenter pt60 pb100">
        <a href="javascript:history.go(-1);" class="btn_round btn_large btn_BlueGray w180"><b>취소</b></a>
        <a href="javascript:memberJoin();" class="btn_round btn_large btn_pointColor w180"><b>확인</b></a>
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
	

<%@ include file="../common_footer.jsp" %>








