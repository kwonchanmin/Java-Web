package member.service;

import member.dao.MemberDAO;
import member.vo.Member;

public class MemberService {

	public Member login(Member member) {
		// 로그인 이라는 Transaction(작업) 처리 진행
		// 하지만 .. 로그인이라는 작업은 별다른 로직을 처리할게 없다.
		// Database 처리가 사실 전부다.
		// Database처리를 여기서 하나요? => 당연히 아니다. DAO에서 한다.
		MemberDAO dao= new MemberDAO();
		
		Member result = dao.select(member);
		
		return result;
	}

}
