package datail.service;

import java.util.List;

import board.vo.BoardName;
import datail.dao.DeleteDao;

public class DeleteService {

	public List<BoardName> deleteBoard(BoardName boardname) {
		
		DeleteDao dao = new DeleteDao();
		
		int count = dao.delete(boardname);
		
		List<BoardName> list = dao.select(boardname);
		return list;
	}

}
