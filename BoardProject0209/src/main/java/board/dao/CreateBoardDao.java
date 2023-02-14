package board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.vo.BoardName;
import common.mybatis.MyBatisConnectionFactory;
import member.vo.Member;

public class CreateBoardDao {

	public int insert(BoardName boardname) {
		int count =0;
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();

		count = sqlSession.insert("myBoardName.InsertBoard",boardname);
		
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

	public Member select2(Member member) {
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();

		Member result = sqlSession.selectOne("myMember.NewBoard",member);	
			
		sqlSession.close();
		
		return result;
	}

}
