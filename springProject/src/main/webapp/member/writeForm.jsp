<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입2</title>
</head>
<body>
	<form name="writeForm" id="writeForm" method="post" action="">
	<table border="2" cellspacing=0 cellpadding=5>
		<tr>
			<td align=center>이름</td>
			<td><input type=text name="name" id="writreName" placeholder="이름입력" >
			<div id="divName"></div></td>
		</tr>
		<tr>
			<td align=center>아이디</td>
			<td><input type=text name="id" id="writeId" placeholder="아이디입력">
<!-- 			<input type=button value=중복체크  id="checkId"> -->
			<div id="divId"></div>
			<input type=hidden name=check value="" id="check">
			</td>
		</tr>
		<tr>
			<td align=center>비밀번호</td>
			<td><input type=password name="pwd" id="WritePwd"><div id="divPwd"></div></td>
		</tr>
		<tr>
			<td align=center>재확인</td>
			<td><input type=password name="repwd" id="repwd"><div id="divRepwd"></div></td>
		</tr>
		<tr >
			<td align=center>성별</td>
			<td><input type="radio" name="gender" value=0 checked>남
			 <input type="radio" name=gender value=1>여</td>
		</tr>
		<tr>
			<td align=center>이메일</td>
			<td><input type=text name="email1"> @
			<input type=text name="email2" list=defaultEmails placeholder="직접입력" size=15>	
			<datalist id=defaultEmails>
			 <option value="naver.com"></option>
			 <option value="gmail.com"></option>
 			 <option value="hanmail.net"></option>
 			 </datalist>
			</td>
		</tr>
		<tr>
			<td align=center>휴대폰</td>
			<td colspan=3>
			<select name="tel1">
			 <option value="010">010</option>
			 <option value="019">019</option>
 			 <option value="017">017</option>
			 <option value="011">011</option>
			 </select>-
		 	 <input type=text  name=tel2 style="width:50px">-
			 <input type=text  name=tel3 style="width:50px">
			</td>
		</tr>
		<tr >
			<td align=center  >주소</td>
			<td><input type=text name="zipcode" id="zipcode" size=7 readonly>&nbsp;
			<input type=button value=우편번호검색 id="searchPostBtn"><br>
			<input type=text name=addr1 id="addr1" placeholder="주소" size=40 readonly><br>
			<input type=text name=addr2 id="addr2" placeholder="상세주소 입력" size=40><br></td>
		</tr>
		<tr align=center>
			<td colspan=2><input type=button value=회원가입 id="writeBtn"> 
<!-- 			<td colspan=2><input type=button value=회원가입 onclick="reject()">  -->
			<input type=reset value=다시작성></td>
		</tr>
	</table>
	</form>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$('#writeBtn').click(function(){
	$('#divName').empty();
	$('#divId').empty();
	$('#divPwd').empty();
	$('#divRepwd').empty();
	if(document.writeForm.name.value==""){
		$('#divName').text('이름을 입력하세요').css('color','red').css('font-size','8pt').css('font-weight','bold');
		$('#name').focus();
	}else if(document.writeForm.id.value==""){
		$('#divId').text('아이디를 입력하세요').css('color','red').css('font-size','8pt').css('font-weight','bold');
		$('#writeId').focus();
	}else if(document.writeForm.pwd.value==""){
		$('#divPwd').text('비밀번호를 입력하세요').css('color','red').css('font-size','8pt').css('font-weight','bold');
		$('#WritePwd').focus();
	}else if($('#WritePwd').val()!=$('#repwd').val()){
		$('#divRepwd').text('비밀번호가 일치하지 않습니다').css('color','red').css('font-size','8pt').css('font-weight','bold');
		$('#repwd').focus();
	}else if($('#check').val()!=$('#writeId').val()){
		$('#divId').text('중복체크는 필수입니다').css('color','red').css('font-size','8pt').css('font-weight','bold');
	}else {
		$.ajax({
			type:'post',
			url:'/springProject/member/write',
			data:$('#writeForm').serialize(),
			success:function(){
				alert('가입을 축하합니다');
			},
			error:function(){
				alert('error');
			}
		});
	}
});
//중복체크
$('#writeId').focusout(function(){
	$('#divId').empty();
	
	let id = $('#writeId').val();
	if(id == ''){
		$('#divId').text('먼저 아이디를 입력하세요')
        $('#divId').css('color', 'magenta')
        $('#divId').css('font-size', '8pt')
        $('#divId').css('font-weight', 'bold')
        $('#writeId').focus();		
	} else{
	 	$.ajax({
	 		type: 'post',
	 		url: '/springProject/member/checkId',
	 		data: 'id='+id,
	 		dataType: 'text',
	 		success : function(data){
	 			if(data=='사용가능'){
	 				$('#divId').text('사용가능한 아이디 입니다').css('color','blue').css('font-size','8pt');
	 				$('#check').val($('#writeId').val());
	 			}else if(data=='사용불가능'){
	 				$('#divId').text('이미 사용중인 아이디입니다').css('color','red').css('font-size','8pt');
	 			}
	 		},
	 		error: function(e){
	 			console.log(e);
	 		}
	 	});
	}	
});

</script>
</body>
</html>