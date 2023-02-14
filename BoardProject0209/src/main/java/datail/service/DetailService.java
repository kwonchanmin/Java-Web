package datail.service;

import board.vo.BoardName;
import datail.dao.DetailDao;

public class DetailService {

	public BoardName detail(BoardName boardname) {
		
		DetailDao dao = new DetailDao();
		
		BoardName result = dao.select(boardname);
		
		return result;
	}

}
