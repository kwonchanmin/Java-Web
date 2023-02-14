package comment.service;

import java.util.List;

import comment.dao.DeleteCommentDao;
import comment.vo.Comment;

public class DeleteCommentService {

	public List<Comment> deleteComment(Comment comment) {
		DeleteCommentDao dao = new DeleteCommentDao();
		int count = dao.delete(comment);
		List<Comment> list = dao.select(comment);
		return list;
	}

}
