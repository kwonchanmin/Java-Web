package board.service;

import java.util.List;

import board.dao.LikeDao;
import board.vo.LikeBoard;

public class LikeService {

	public LikeBoard selectAll(LikeBoard likeboard) {
		LikeDao dao = new LikeDao();
		LikeBoard result = dao.selectAll(likeboard);
		return result;
	}

	public LikeBoard insertLike(LikeBoard likeboard) {
		LikeDao dao = new LikeDao();
		int count = dao.insert(likeboard);
		LikeBoard result = dao.selectCount(likeboard);
		return result;
	}

	public LikeBoard deleteLike(LikeBoard likeboard) {
		LikeDao dao = new LikeDao();
		int count = dao.delete(likeboard);
		LikeBoard result = dao.selectCount(likeboard);
		return result;
	}

}
