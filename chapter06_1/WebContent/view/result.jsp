<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
// int x = Integer.parseInt(request.getParameter("x")); 

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- ${x } + ${y } = ${x+y } --%>
${dto.x } + ${dto.x } = ${dto.x + dto.y }
</body>
</html>