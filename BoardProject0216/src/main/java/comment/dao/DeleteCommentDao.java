package comment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import comment.vo.Comment;
import common.mybatis.MyBatisConnectionFactory;

public class DeleteCommentDao {

	public int delete(Comment comment) {
		int count =0;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();

		count = sqlSession.insert("myComment.deleteComment", comment);

		if(count == 1) {
			sqlSession.commit();
			sqlSession.close();
		}
		
		return count;
	}

	public List<Comment> select(Comment comment) {
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();

		System.out.println("sfsda"+comment.getBoardNum());
		List<Comment> list = sqlSession.selectList("myComment.Comments", comment);

		
		return list;
	}

}
