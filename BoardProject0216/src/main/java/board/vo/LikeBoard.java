package board.vo;

public class LikeBoard {

	private int likeNum;
	private int boardNum;
	private String memberId;
	private int like_check;
	
	public LikeBoard() {
		// TODO Auto-generated constructor stub
	}

	public LikeBoard(int likeNum, int boardNum, String memberId, int like_check) {
		super();
		this.likeNum = likeNum;
		this.boardNum = boardNum;
		this.memberId = memberId;
		this.like_check = like_check;
	}

	public int getLikeNum() {
		return likeNum;
	}

	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getLike_check() {
		return like_check;
	}

	public void setLike_check(int like_check) {
		this.like_check = like_check;
	}
	
}

