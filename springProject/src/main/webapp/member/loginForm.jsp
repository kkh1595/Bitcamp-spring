<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로긴</title>
</head>
<body>
 <form name="loginForm" method="post" action="">
 <table border="2" cellspacing=0 cellpadding=5>
		<tr>
			<td align=center width=100><font size=2>ID</font></td>
			<td><input type=text name="id" id="id"  placeholder="아이디입력" width=100></td>
		</tr>
		<tr>
		<tr>
			<td align=center><font size=2>PW</font></td>
			<td><input type=password name="pwd" id="pwd" placeholder="비밀번호 입력"></td>
		</tr>
		<tr>
			<td align=center colspan=2><input type=button value=로그인 id="loginBtn">
			 <input type=button value=회원가입 onclick="location.href='/springProject/member/writeForm'"></td>
		</tr>
	</table>
	<div align=center id="loginCheck"></div>	
	</form>
</body>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$('#loginBtn').click(function(){
	$('#id').on('change keyup paste',function(){
	$('#loginCheck').empty();
	});
	$('#pwd').on('change keyup paste',function(){
		$('#loginCheck').empty();
	});
	if(document.loginForm.id.value==""){
		$('#loginCheck').text('아이디를 입력하세요').css('color','red').css('font-size','9pt');
		document.loginForm.id.focus();
	}else if(document.loginForm.pwd.value==""){
		$('#loginCheck').text('비밀번호를 입력하세요').css('color','red').css('font-size','9pt');
		document.loginForm.pwd.focus();
	}else{
		$.ajax({
			type:'post',
			url:'/springProject/member/login',
			data:JSON.stringify({'id':$('#id').val(),'pwd':$('#pwd').val()}),
			dataType:'json',
			contentType:'application/json;charset=UTF-8',
			success:function(data){
				if(data.result=='fail'){
					$('#loginCheck').text('아이디 혹은 비밀번호를 잘못입력하셨습니다.').css('font-size','9pt').css('color','red');
				}else{
					location.href='/springProject/main/index'
				}
			},
			error:function(err){
				alert('error')
			}
		});
	}
});




</script>
</html>