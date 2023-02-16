package member.dao;

import org.apache.ibatis.session.SqlSession;

import common.mybatis.MyBatisConnectionFactory;
import member.vo.Member;

public class MemberDAO {

	public Member select(Member member) {
		// 데이터베이스 처리를 하면 된다.
		// myBatis를 이용해서 Database처리를 할꺼다.
		
		// SqlSession이라는게 있어야한다.  => 이걸 가지고 XML에 있는 Query를 실행할 수 있다.
		// SqlSession는 누가 만들어 주는가? => SqlSessionFactory가 만들어준다. 
		// SqlSessionFactory가 있어야 한다.  => 이 공장을 만들려면 데이터베이스 연결정보와 같은 
		// XML 정보를 줘서 이 공장을 만들어야 한다. 
		// 이 공장 짓는 코드는 이미 어느정도 정해져있다.
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		
		Member result = sqlSession.selectOne("myMember.login",member);
		
		sqlSession.close();
		
		return result;
	}

}
