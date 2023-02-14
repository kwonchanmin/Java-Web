<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import=" board.vo.BoardName"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=((BoardName) session.getAttribute("title")).getBoardTitle()%></title>
</head>
<body>
	<% 
		BoardName boardname = (BoardName)request.getAttribute("boardtitle");
	%>
	
	<form action="editcontent" method="post">
	<input type="hidden" name="bNum" value="<%=((BoardName) session.getAttribute("title")).getBoardNum() %>">
	<table border="1">
		<tr>
			<th>제목 :</th>
			<td> <input name="btitle" value="<%=((BoardName) session.getAttribute("title")).getBoardTitle()%>" type="text">
			</td>
		</tr>
		<tr>
			<th>작성자 :</th>
			<td name="mName"><%=((BoardName) session.getAttribute("title")).getMemberName()%>
			</td>
		</tr>
		<tr>
			<th>작성일 :</th>
			<td name="bDate"><%=((BoardName) session.getAttribute("title")).getBoardDate()%>
			</td>
		</tr>
		<tr>
			<th>내용 :</th>
			<td><textarea row="10" cols="60" name="bContents"><%=((BoardName) session.getAttribute("title")).getBoardContent()%></textarea></td>
		</tr>
	</table>
		<button type="submit">수정</button>	
	</form>
</body>
</html>