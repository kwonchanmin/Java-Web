<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page
	import=" member.vo.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 글 작성</title>
</head>
<body>
	<%
	   	Member member = (Member)request.getAttribute("newboard");	
	
	%>
	<form action="createBoard" method="post">
	<input type="hidden" name="memId"
			value="<%= member.getMemberId() %>">
	<h1>제목: <input type="text" name="title"> </h1>
	<h1>작성자: <%=member.getMemberName()%></h1>
	<h1>내용: <input type="text" name="content"></h1>
	<button type="submit">등록</button>
	</form>
</body>
</html>