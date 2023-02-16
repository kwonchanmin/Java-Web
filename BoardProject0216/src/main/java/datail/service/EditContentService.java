package datail.service;

import board.vo.BoardName;
import datail.dao.EditContentDao;

public class EditContentService {

	public int edit(BoardName boardname) {
		EditContentDao dao = new EditContentDao();
		int count = dao.update(boardname);
	
		//	 result 값이 1 이라면 update한 값을 DAO 에서 select로 불러와서 정보값을 준다. 
		
		return count;
	}

	public BoardName editContent(BoardName boardname) {
		EditContentDao dao = new EditContentDao();
		int count = dao.update(boardname);
		BoardName result = dao.select(boardname);
		return result;
	}

}
