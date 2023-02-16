package datail.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.vo.BoardName;
import common.mybatis.MyBatisConnectionFactory;

public class DeleteDao {

	public int delete(BoardName boardname) {
		int count = 0;
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();

		count = sqlSession.delete("myBoardName.DeleteBoard",boardname);

		if(count==1) {
			sqlSession.commit();
			sqlSession.close();
		}
		
		return count;
	}

	public List<BoardName> select(BoardName boardname) {
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();

		List<BoardName> list = sqlSession.selectList("myBoardName.NameBoards",boardname);

		sqlSession.close();
		
		return list;
	}

}
