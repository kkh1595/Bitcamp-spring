<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" id="deleteForm" action="">
삭제할 아이디 입력 <input type="text" id="DelId"> <input type="button" id="search" value="검색">
<div id=aaa></div>
</form>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$('#search').click(function(){
		$('#aaa').empty();
		
		if($('#DelId').val()==''){
			$('#aaa').text("먼저 아이디를 입력하세요").css('font-size', '20pt').css('color', 'red');
		}else if(confirm('정말 삭제하시겠습니까?')){
			$.ajax({
				type: 'post',
				url:'/chapter06_SpringWebMaven/user/delete',
				data: 'id='+$('#DelId').val(),
				dataType: 'text',
				success: function(data){
					alert('삭제완료')
				},
				error:function(err){
					alert(err);
				}
			});
		}
	});
</script>
</body>
</html>