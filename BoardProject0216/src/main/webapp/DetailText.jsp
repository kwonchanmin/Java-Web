<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import=" board.vo.BoardName , comment.vo.Comment, java.util.List, member.vo.Member "%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=((BoardName) session.getAttribute("title")).getBoardTitle()%></title>
<script src="/webjars/jquery/dist/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
</head>
<body>
	<%
	BoardName boardname = (BoardName)request.getAttribute("boardtitle");
 	Member currentMember = (Member)session.getAttribute("member");
	%>
	
	<table border="1">
		<tr>
			<th>제목 :</th>
			<td><%=boardname.getBoardTitle()%>
			</td>
		</tr>
		<tr>
			<th>작성자 :</th>
			<td><%=boardname.getMemberName()%></td>
		</tr>
		<tr>
			<th>작성일 :</th>
			<td><%=boardname.getBoardDate()%>
			</td>
		</tr>
		<tr>
			<th>좋아요 :</th>
			<td><span id="like"><%=boardname.getBoardLike()%></span>
			</td>
		</tr>
		<tr>
			<th>내용 :</th>
			<td><textarea row="10" cols="60" readonly="readonly"><%=boardname.getBoardContent()%></textarea></td>
		</tr>

	</table>
		<%
		
		String currentId = ((Member)session.getAttribute("member")).getMemberId();
		String boardAuthor = ((BoardName)session.getAttribute("title")).getBoardAuthor();
	
		if (currentId.equals(boardAuthor)) { %>
			
		<a href="edit?num=<%=((BoardName)session.getAttribute("title")).getBoardNum()%>&author=<%=((BoardName)session.getAttribute("title")).getBoardAuthor()%>">수정</a>
		<a href="delete?num=<%=((BoardName)session.getAttribute("title")).getBoardNum() %>">삭제</a>
		<% }%>
		
		
		<button type="button" onclick="likeCheck('<%=boardname.getBoardNum()%>','<%=currentMember.getMemberId() %>' )" id="likeBtn" >좋아요</button>
		
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
				<th><a href="updateCm?cNum=<%=comment.getCommentNum() %>&bNum=<%=comment.getBoardNum()%>">수정</a></th>
				<th><a href="deleteCm?cNum=<%=comment.getCommentNum() %>&bNum=<%=comment.getBoardNum()%>">삭제</a></th>
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
<script>
function likeCheck(bNum,mId) {
	$.ajax({
		url:'likeboard',
		type:'POST',
		dataType:'json',
		contentType:"application/x-www-form-urlencoded; charset=UTF-8",
		data: {
			bNum : bNum,
			mId : mId
		},
		success :function(data) {
		
			/* if(data.like_check == 1) {
				$('#likeBtn').css('background-color','red');
				$('#like').text(data.like_check);
			}else if (data.like_check == 0) {
				$('#likeBtn').css('background-color','gray');
				$('#like').text(data.like_check);
			}
			console.log(data.like_check); */

			$('#like').text(data.like_check);
		
			
		},
		error : function() {
			
		}
		
	});
}
</script>
</html>