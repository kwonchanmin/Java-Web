package board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.vo.BoardName;
import common.mybatis.MyBatisConnectionFactory;


public class BoardDao {

	public List<BoardName> selectAll() {

		// Database 처리만 하면 된다.
		// MyBatis 이용

		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();

		List<BoardName> result = sqlSession.selectList("myBoardName.NameBoards");

		sqlSession.close();
		
		return result;
	}

}
