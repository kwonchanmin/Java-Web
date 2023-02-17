package board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.vo.Board;

public class BoardDao {

	SqlSession sqlSession;
	
	public BoardDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<Board> selectAll() {
		
		List<Board> list = sqlSession.selectList("");
		
		return null;
	}

}
