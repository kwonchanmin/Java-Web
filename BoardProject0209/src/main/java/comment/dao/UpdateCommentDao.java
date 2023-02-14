package comment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import comment.vo.Comment;
import common.mybatis.MyBatisConnectionFactory;

public class UpdateCommentDao {

	public int update(Comment comment) {
		int count = 0;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();

		count = sqlSession.update("myComment.UpdateComment", comment);

		if(count == 1) {
			sqlSession.commit();
			sqlSession.close();
		}
		return count;
	}

	public List<Comment> select(Comment comment) {
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();

		List<Comment> list = sqlSession.selectList("myComment.Comments", comment);

		sqlSession.close();
		
		return list;
	}

}
