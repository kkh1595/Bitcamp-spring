<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>회원정보수정</h3>
<form id="modifyForm">
<input type="text" name="searchId" id="searchId"> <input type="button" id="searchBtn" value="검색">
	<div id="resultDiv"></div>
	<div id="modifyFormDiv">
		<table>
			<tr>
				<td>이름</td>
				<td><input type=text name="name" id="name"></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type=text name="id" id="id" readonly></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type=password name="pwd" id="pwd"></td>
			</tr>
			<tr>
				<td><input type="button" id="modifyBtn" value="수정"></td>
			</tr>
		</table>
	</div>
	</form>
	<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		$('#modifyFormDiv').css('display','none');
		$('#searchBtn').click(function() {
			$('#resultDiv').empty();
			$('#id').val('');
			$('#name').val('');
			$('#pwd').val('');
			$.ajax({
				type:'post',
				url:'/chapter06_SpringWebMaven/user/getUser',
				data: {'id':$('#searchId').val()},
				dataType: 'json',
				success: function(data){
					if($('#searchId').val()==''){
						$('#resultDiv').text('먼저 아이디를 입력해주세요').css('color','red');
					}else if(data.userDTO==null){
						$('#resultDiv').text('없는 아이디입니다').css('color','red');
						$('#modifyFormDiv').css('display','none');
					}else{
						$('#modifyFormDiv').css('display','block').css('font-size','10pt');
						$('#id').val(data.userDTO.id);
						$('#name').val(data.userDTO.name);
						$('#modifyBtn').click(function(){
							$.ajax({
								type:'post',
								url:'/chapter06_SpringWebMaven/user/modify',
								data:$('#modifyForm').serialize(),
								success:function(data){
									alert('수정완료');
									location.href='/chapter06_SpringWebMaven/index/';
								},
								error:function(err){
									alert(err);
								}
							
							});
						});
					}
				},
				error:function(err){
					alert(err);
				}
			});
		});
	});
	</script>
</body>
</html>