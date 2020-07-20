<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" id="writeForm" action="">
		<table border=1>
			<tr>
				<td>이름</td>
				<td><input type=text name="name" id="name" >
					<div id="nameDiv"></div></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type=text name="id" id="id" ><br>
					<div id="idDiv"></div></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type=password name="pwd" id="pwd" ><br>
					<div id="pwdDiv"></div></td>
			</tr>
			<tr>
				<td colspan=2 align=center><input type=button value="입력" id="inputBtn"></td>
			</tr>
		</table>
	</form>
	<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="/chapter06_SpringWebMaven/js/user.js"></script>
</body>
</html>