package board.service;

import java.util.List;

import board.dao.BoardDao;
import board.vo.BoardName;

public class BoardService {

	public List<BoardName> getAllBoard() {
		// 로직처리를 해야한다.
		// 데이터베이스 처리만 해서 모든 글에 대한 글 목록을 가져오면 된다.
		// DAO가 있어야 한다.
		BoardDao dao = new BoardDao();
		List<BoardName> list = dao.selectAll();
		return list;
	}

}
