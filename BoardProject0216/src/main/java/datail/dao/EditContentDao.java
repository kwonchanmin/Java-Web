package datail.dao;

import org.apache.ibatis.session.SqlSession;

import board.vo.BoardName;
import common.mybatis.MyBatisConnectionFactory;

public class EditContentDao {

	public int update(BoardName boardname) {
		
		int count = 0 ;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();

		count = sqlSession.update("myBoardName.UpdateContent", boardname);
		
		if(count == 1) {
			sqlSession.commit();
			sqlSession.close();
		}
		
		
		return count;
	}

	public BoardName select(BoardName boardname) {
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();

		BoardName result = sqlSession.selectOne("myBoardName.TitleName", boardname);
		
		sqlSession.close();
		
		
		return result;
	}

}
