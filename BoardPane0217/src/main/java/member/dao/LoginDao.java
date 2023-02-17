package member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import member.vo.Member;
import mybatis.MyBatisConnectionFactory;

public class LoginDao {
	
	SqlSession sqlSession;
	
	public LoginDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}


	public List<Member> selectAll() {
		

		List<Member> list = sqlSession.selectList("myMember.SearchMember");

		
		
		return list;
	}

	public Member selectUser(Member member) {
		
		Member result = sqlSession.selectOne("myMember.ConfirmUser",member);
		
	
		return result;
	}

	public int insertUser(Member member) {
		
	
		
		int count = sqlSession.insert("myMember.RegisterMember",member);
		
		
		return count;
	}


	public Member selectMember(Member member) {
		
		Member result = sqlSession.selectOne("myMember.ConfirmUser",member);
		
		return result;
	}

}
