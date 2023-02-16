package comment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import comment.vo.Comment;
import common.mybatis.MyBatisConnectionFactory;

public class CommentDao {

	public List<Comment> select(Comment comment) {

		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();

		List<Comment> list = sqlSession.selectList("myComment.Comments", comment);

		sqlSession.close();
		return list;
	}

	public int insert(Comment comment) {
		
		int count = 0;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();

		count = sqlSession.insert("myComment.createComment", comment);

		if(count == 1) {
			sqlSession.commit();
			sqlSession.close();
		}
		
		return count;
	}

	public Comment select1(Comment comment) {
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();

		Comment result = sqlSession.selectOne("myComment.OneComment", comment);

		sqlSession.close();
		return result;
	}

	

}
