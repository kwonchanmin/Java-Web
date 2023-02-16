package board.service;

import java.util.List;

import board.dao.CreateBoardDao;
import board.vo.BoardName;
import member.vo.Member;

public class CreateBoardService {

	public List<BoardName> createBoard(BoardName boardname) {
		CreateBoardDao dao = new CreateBoardDao();
		
		int count = dao.insert(boardname);
		
		List<BoardName> list = dao.select(boardname);
		return list;
	}

	public Member searchBoard(Member member) {
		CreateBoardDao dao = new CreateBoardDao();
		
		Member result = dao.select2(member);
		return result;
	}

}
