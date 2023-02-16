package board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.vo.BoardName;
import board.vo.LikeBoard;
import common.mybatis.MyBatisConnectionFactory;

public class LikeDao {

	public LikeBoard selectAll(LikeBoard likeboard) {
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();

		LikeBoard result = sqlSession.selectOne("myLikeBoard.LikeBoard",likeboard);

		sqlSession.close();
		
		return result;
	}

	public int insert(LikeBoard likeboard) {
		
		int count = 0;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();

		count = sqlSession.update("myLikeBoard.LikePlus", likeboard);

		if(count == 1) {
			sqlSession.commit();
			sqlSession.close();
		}
		return count;
	}

	public int delete(LikeBoard likeboard) {
			
		int count = 0;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();

		count = sqlSession.update("myLikeBoard.LikeMinus", likeboard);

		if(count == 1) {
			sqlSession.commit();
			sqlSession.close();
		}
		return count;
	}

	public LikeBoard selectCount(LikeBoard likeboard) {
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();

		LikeBoard result = sqlSession.selectOne("myLikeBoard.CountLike",likeboard);

		sqlSession.close();
		
		return result;
	}

}
