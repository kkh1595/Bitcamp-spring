<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<center><a href="#" onclick="" >
<img src="../image/smile.png" width=50 height=50/></a></center>
<%-- ${sessionScope.memName } --%> <center>[${memName}]님 접속중</center> <br>
<center>
<input type=button value=로그아웃 onclick="location.href='/springProject/member/logout'"> 
<input type=button value=회원정보수정  onclick="location.href='/springProject/member/getMemberInfo'">
</center>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">

</script>