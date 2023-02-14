package comment.service;

import java.util.List;

import comment.dao.CommentDao;
import comment.vo.Comment;

public class CommentService {

	public List<Comment> searchComment(Comment comment) {
		CommentDao dao = new CommentDao();
		List<Comment> list = dao.select(comment);
		return list;
	}

	public List<Comment> reflash(Comment comment) {
		CommentDao dao = new CommentDao();
		int count = dao.insert(comment);
		List<Comment> list = dao.select(comment);
		return list;
	}

	public Comment amendComment(Comment comment) {
		CommentDao dao = new CommentDao();
		Comment result = dao.select1(comment);
		return result;
	}

}
