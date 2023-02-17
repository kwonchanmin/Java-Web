package board.vo;

public class Board {

	private int boardNum;
	private String boardTitle;
	private String boardAuthor;
	private String boardContent;
	private String memberName;
	private String boardDate;
	private int comment_count;
	private int boardLike;

	public Board() {
		// TODO Auto-generated constructor stub
	}

	public Board(int boardNum, String boardTitle, String boardAuthor, String boardContent, String memberName,
			String boardDate, int comment_count, int boardLike) {
		super();
		this.boardNum = boardNum;
		this.boardTitle = boardTitle;
		this.boardAuthor = boardAuthor;
		this.boardContent = boardContent;
		this.memberName = memberName;
		this.boardDate = boardDate;
		this.comment_count = comment_count;
		this.boardLike = boardLike;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardAuthor() {
		return boardAuthor;
	}

	public void setBoardAuthor(String boardAuthor) {
		this.boardAuthor = boardAuthor;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}

	public int getComment_count() {
		return comment_count;
	}

	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}

	public int getBoardLike() {
		return boardLike;
	}

	public void setBoardLike(int boardLike) {
		this.boardLike = boardLike;
	}

	@Override
	public String toString() {
		return "Board [boardNum=" + boardNum + ", boardTitle=" + boardTitle + ", boardAuthor=" + boardAuthor
				+ ", boardContent=" + boardContent + ", memberName=" + memberName + ", boardDate=" + boardDate
				+ ", comment_count=" + comment_count + ", boardLike=" + boardLike + "]";
	}
	
	
}
