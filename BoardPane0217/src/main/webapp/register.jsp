<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="member.vo.Member, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="style.css">
<script>
	function checkmember() {
		$.ajax({
			url : 'registermember',
			type : 'POST',
			dataType : 'json',
			data : {
				userid : $('#userid').val(),
				username : $('#username').val(),
				password : $('#password').val()
			},
			success : function(result) {

				if (result.msg == '성공') {
					alert('회원가입에 성공했습니다.');
					let url = '/boardpane/Login.html';
					location.replace(url);
				} else if (result.msg == '실패') {
					alert('이미 가입된 정보가 있습니다.');
				}

			},
			error : function() {
				alert('망했습니다.');
			}

		});
	}
</script>
</head>
<body>
	<div class="container">
		<h1>회원가입</h1>
		<label for="userid">아이디:</label> 
		<input type="text" id="userid" name="userid" required>
		<label for="username">이름:</label>
		<input type="text" id="username" name="username" required> 
		<label for="password">비밀번호:</label> 
		<input type="password" id="password" name="password" required>
		<button type="button" onclick="checkmember()">가입하기</button>
	</div>
</body>

</html>





