function test_alert(){
	alert("imported");
}

function checkValue(input,obj){
	if(input.value==""){
		alert(obj+" 확인해주세요");
		input.focus();
		return true;
	}else return false;
}
		
function checkLength(input,len,obj){
	if(input.value.length>Number(len)){
		alert(obj+" 길이는 "+len+"자리 이하로 해주세요");
		input.focus();
		return true;
	}return false;
}

function checking(input,len,obj){
	if(input.value==""){
		alert(obj+" 확인해주세요");
		input.focus();
		return true;
	}else if(Number(input.value.length)>Number(len)){
		alert(obj+" 길이는 "+len+"자리 이하로 해주세요");
		input.focus();
		return true;
	}else return false;
}

function checkingMobile(input,len,obj){
	if(input.value==""){
		alert(obj+" 확인해주세요");
		input.focus();
		return true;
	}else if(Number(input.value.length)!=Number(len)){
		alert(obj+" 길이는 "+len+"자리로 해주세요");
		input.focus();
		return true;
	}else return false;
}

/*
function checkId(){
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
				alert(data);
			}
		});				
	}
*/