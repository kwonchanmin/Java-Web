package comment.service;

import java.util.List;

import comment.dao.UpdateCommentDao;
import comment.vo.Comment;

public class UpdateCommentService {

	public List<Comment> updateComment(Comment comment) {
		
		UpdateCommentDao dao = new UpdateCommentDao();
		
		int count = dao.update(comment);
		
		List<Comment> list = dao.select(comment);
		
		return list;
	}

}
