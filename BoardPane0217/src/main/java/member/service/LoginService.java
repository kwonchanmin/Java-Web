package member.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import member.dao.LoginDao;
import member.vo.Member;
import mybatis.MyBatisConnectionFactory;

public class LoginService {
 
	// SqlSession 과 Dao를 필드로 선언함으로써 메소드가 실행될 때 마다 세션을 열어준다.
	SqlSession sqlSession;
	LoginDao dao;
	
	// 생성자 함수로 만들어서 선언을 해주고 sqlSession과 Dao에 연결을 해준다.
	public LoginService() {
		this.sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		this.dao = new LoginDao(this.sqlSession);
	}
	
	public List<Member> selectAll() {
	
		List<Member> list = dao.selectAll();
		
		sqlSession.close();
		return list;
	}

	public Member selectUser(Member member) {
		
		Member result = dao.selectUser(member);
		sqlSession.close();
		return result;
	}

	public Member registeUser(Member member) {
		
		int count = 0;
		
		count = dao.insertUser(member);
		
		if(count == 1) {
		  sqlSession.commit();
		}
		Member result = dao.selectUser(member);
		
		sqlSession.close();
		
		return result;
	}

	public Member selectMember(Member member) {
		
		Member result = dao.selectMember(member);
		
		sqlSession.close();
		
		return result;
		
	}

}
