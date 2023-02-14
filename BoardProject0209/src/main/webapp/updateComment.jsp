<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page
	import="comment.vo.Comment"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="updateCom" method="post">
		
		<table border="1">
	
			<%
			Comment comment = (Comment)request.getAttribute("comments");

			%>
			<input type="hidden" name="cNum" value="<%= ((Comment)session.getAttribute("comment")).getCommentNum() %>">

			<tr>
				<th><%=comment.getCommentId()%></th>
				<th><%=comment.getCommentDate()%></th>
			</tr>
			<tr>
				<th><textarea row="10" cols="60" name="cContent" ><%=comment.getCommentContent()%></textarea></th>
			</tr>
			<button type="submit">수정</button>
			
			</tbody>
		</table>
	</form>
</body>
</html>