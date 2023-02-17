package board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.dao.BoardDao;
import board.vo.Board;
import member.dao.LoginDao;
import mybatis.MyBatisConnectionFactory;

public class BoardService {

	SqlSession sqlSession;
	BoardDao dao;
	
	
	
	public BoardService() {
		super();
		this.sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		this.dao = new BoardDao(this.sqlSession);
	}

	public List<Board> selectAll() {
		
		List<Board> list = dao.selectAll();
		
		sqlSession.close();
		
		return list;
	}

}
