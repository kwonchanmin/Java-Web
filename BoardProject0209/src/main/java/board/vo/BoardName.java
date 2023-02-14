package board.vo;

public class BoardName {

	private int boardNum;
	private String boardTitle;
	private String boardAuthor;
	private String boardContent;
	private String memberName;
	private String boardDate;
	private int boardLike;
	
	public BoardName() {
		// TODO Auto-generated constructor stub
	}

	public BoardName(int boardNum, String boardTitle, String boardAuthor, String boardContent, String memberName,
			String boardDate, int boardLike) {
		super();
		this.boardNum = boardNum;
		this.boardTitle = boardTitle;
		this.boardAuthor = boardAuthor;
		this.boardContent = boardContent;
		this.memberName = memberName;
		this.boardDate = boardDate;
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

	public int getBoardLike() {
		return boardLike;
	}

	public void setBoardLike(int boardLike) {
		this.boardLike = boardLike;
	}

	@Override
	public String toString() {
		return "BoardName [boardNum=" + boardNum + ", boardTitle=" + boardTitle + ", boardAuthor=" + boardAuthor
				+ ", boardContent=" + boardContent + ", memberName=" + memberName + ", boardDate=" + boardDate
				+ ", boardLike=" + boardLike + "]";
	}

}
