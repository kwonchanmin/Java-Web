package datail.dao;

import org.apache.ibatis.session.SqlSession;

import board.vo.BoardName;
import common.mybatis.MyBatisConnectionFactory;

public class DetailDao {

	public BoardName select(BoardName boardname) {
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();

		BoardName result = sqlSession.selectOne("myBoardName.TitleName", boardname);

		sqlSession.close();
		
		return result;
	}

}
