package comment.vo;

public class Comment {

	private int commentNum;
	private int boardNum;
	private String commentId;
	private String memberName;
	private String commentContent;
	private String commentDate;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(int commentNum, int boardNum, String commentId, String memberName, String commentContent,
			String commentDate) {
		super();
		this.commentNum = commentNum;
		this.boardNum = boardNum;
		this.commentId = commentId;
		this.memberName = memberName;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
	}

	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	

	
	
}
