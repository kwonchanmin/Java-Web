<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import=" board.vo.BoardName , comment.vo.Comment, java.util.List, member.vo.Member "%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=((BoardName) session.getAttribute("title")).getBoardTitle()%></title>
</head>
<body>
	<%
	BoardName boardname = (BoardName) request.getAttribute("boardtitle");
	%>
	
	<table border="1">
		<tr>
			<th>제목 :</th>
			<td><%=((BoardName)session.getAttribute("title")).getBoardTitle()%>
			</td>
		</tr>
		<tr>
			<th>작성자 :</th>
			<td><%=((BoardName)session.getAttribute("title")).getMemberName()%></td>
		</tr>
		<tr>
			<th>작성일 :</th>
			<td><%=((BoardName)session.getAttribute("title")).getBoardDate()%>
			</td>
		</tr>
		<tr>
			<th>좋아요 :</th>
			<td><%=((BoardName)session.getAttribute("title")).getBoardLike()%>
			</td>
		</tr>
		<tr>
			<th>내용 :</th>
			<td><textarea row="10" cols="60" readonly="readonly"><%=((BoardName) session.getAttribute("title")).getBoardContent()%></textarea></td>
		</tr>

	</table>
		<%
		
		String currentId = ((Member)session.getAttribute("member")).getMemberId();
		String boardAuthor = ((BoardName)session.getAttribute("title")).getBoardAuthor();
		
		
		if (currentId.equals(boardAuthor)) { %>
			
		<a href="edit?num=<%=((BoardName)session.getAttribute("title")).getBoardNum()%> & author=<%=((BoardName)session.getAttribute("title")).getBoardAuthor()%>">수정</a>
		<a href="delete?num=<%=((BoardName)session.getAttribute("title")).getBoardNum() %>">삭제</a>
		<% }%>
		<form>
		<button type="button" >좋아요</button>
		</form>	
		<br><br>
	
	<form action="comment" method="post">
		<input type="hidden" name="bNum"
			value="<%=((BoardName) session.getAttribute("title")).getBoardNum()%>">
		<input type="hidden" name="mId"
			value="<%=((Member)session.getAttribute("member")).getMemberId()%>">

		<table border="1">
			<thead>
				댓글
			</thead>
			<bt><br>
			<tbody>
			<input type="text"
				style="width: 500px; height: 50px; font-size: 15px;" name="cContent">
			<button type="submit">입력</button>
			<%
			List<Comment> list = (List<Comment>) request.getAttribute("comments");

			for (Comment comment : list) {
			%>

			<tr>
				<th><%=comment.getCommentId()%></th>
				<th><%=comment.getCommentDate()%></th>
			
			<%if (currentId.equals(boardAuthor)) {%>
				<th><a href="updateCm?cNum=<%=comment.getCommentNum() %>">수정</a></th>
				<th><a href="deleteCm?cNum=<%=comment.getCommentNum() %>">삭제</a></th>
			<% }%>
			
			</tr>
			<tr>
				<th><textarea row="10" cols="60" readonly="readonly"><%=comment.getCommentContent()%></textarea></th>
			</tr>
			<%
			}
			%>
			</tbody>
		</table>
	</form>
</body>

</html>