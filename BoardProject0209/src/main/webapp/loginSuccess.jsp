
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="member.vo.Member, board.vo.BoardName, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 서어어어어엉공!</title>
</head>
<body>
	<!-- JSP에서는 나에게 할당된 session 객체를 그냥 사용 할 수 있다.
		어떤 이름을 사용해야 하는가? => session -->
	<h1><%=((Member) session.getAttribute("member")).getMemberName()%>님
		환영합니다.
	</h1>

	<h3>게시글 목록</h3>
		<a href="newBoard?memberId=<%= ((Member)session.getAttribute("member")).getMemberId() %>">글쓰기</a>

	<table border="2">
		<thead>
			<th>글 번호</th>
			<th>글 제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>댓글 수</th>
			<th>좋아요</th>
		</thead>
		<tbody>

			<%
				List<BoardName> list = (List<BoardName>)request.getAttribute("boardList");
				
				for (BoardName board : list) {
			%>
				<tr>
					<td><%= board.getBoardNum() %></td>
					<td><a href="detail?num=<%= board.getBoardNum() %>"><%= board.getBoardTitle() %></a></td>
					<td><%= board.getMemberName() %></td>
					<td><%= board.getBoardDate() %></td>
					<td>0</td>
					<td><%= board.getBoardLike() %></td>
				</tr>
			<%
				}
			%>

		</tbody>
	</table>
</body>
</html>