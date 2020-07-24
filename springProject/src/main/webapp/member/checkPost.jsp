<%@page import="member.bean.ZipcodeDTO"%>
<%@page import="java.util.List"%>
<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소검색</title>
<!-- <link rel="stylesheet" href="../css/member.css"> -->
</head>
<body>
<form method="post" action="" id="checkPost">
<table border=2 cellspacing=0 cellpadding=3 width=100%>
<tr align=center>
<th>시도</th>
<td><select id="sido" name=sido style=width:100px>
<option value="">직접입력</option>
<option value="서울">서울</option>
<option value="인천">인천</option> 
<option value="대전">대전</option>
<option value="대구">대구</option>
<option value="울산">울산</option>
<option value="세종">세종</option>
<option value="광주">광주</option>
<option value="경기">경기</option>
<option value="강원">강원</option>
<option value="전남">전남</option>
<option value="전북">전북</option>
<option value="경남">경남</option>
<option value="경북">경북</option>
<option value="충남">충남</option>
<option value="충북">충북</option>
<option value="부산">부산</option>
<option value="제주">제주</option>
</select></td>
<th>시.군.구</th>
<td><input type=text name=sigungu id="sigungu" style=width:200px></td>
</tr>
<tr>
<th>도로명</th>
<td colspan=3><input type=text name=roadname id="roadname"> <input type=button id="searchAddr"value=검색></td>
</tr>
<tr>
<th>우편번호</th>
<td colspan=3 align=center>주소</td>
</tr>
<c:if test="${list!=null}">
<c:forEach var="zipcodeDTO" items="${list }">
<c:set var="address">
${zipcodeDTO.sido 
} ${zipcodeDTO.sigungu 
} ${zipcodeDTO.yubmyundong
} ${zipcodeDTO.roadname 
} ${zipcodeDTO.buildingname}
</c:set>
<tr >
	<td align=center>${zipcodeDTO.zipcode}</td>
	<td colspan=3><a id="addressA" href="#" onclick="checkPostClose('${zipcodeDTO.zipcode }','${address}')">${address}</a></td>
</tr>
</c:forEach>
</c:if>
</table>
</form>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#searchAddr').click(function(){
		$.ajax({
			type:'post',
			url:'/springProject/member/addrList',
			data:$('#checkPost').serialize(),
			success:function(data){
			},
			error:function(){
				alert('error');
			}
		});
	});
});
function checkPostClose(zipcode,address){
	opener.document.forms[0].zipcode.value=zipcode;
	opener.document.forms[0].addr1.value=address;
	window.close()
	opener.document.forms[0].addr2.focus()
}
</script>
</body>
</html>