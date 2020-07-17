<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
=== ${dto.name }의 성적 === <br>
국어: ${dto.kor }<br>
영어: ${dto.eng }<br>
수학: ${dto.math }<br>
총점: ${dto.tot }<br>
평균: ${dto.avg }
</body>
</html>