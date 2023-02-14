<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	// 입력과 로직처리는 안하고 출력만 한다.	
	// 출력은 HTML에 끼워넣기 
	%>
	<%
		String name = "홍길동"; // 지역변수
	
		for(int i=0; i<5; i++){
	%>		
		<h1>반복된다.</h1>	 
	<% 		
		}
	
	%>
	<!-- 이렇게 % % 안에 <h1></h1>이 있으면 반복문 숫자만큼 h1이 반복해서 찍히게된다.-->
	이것은 소리없는 아우성~
	사용자의 이름은 : <%= name %> 입니다.
</body>
</html>