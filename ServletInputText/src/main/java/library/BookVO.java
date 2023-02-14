package library;

public class BookVO {
	private String btitle;
	private String bauthor;
	private Integer bprice;
	
	public BookVO() {
		// TODO Auto-generated constructor stub
	}

	public BookVO(String btitle, String bauthor, Integer bprice) {
		super();
		this.btitle = btitle;
		this.bauthor = bauthor;
		this.bprice = bprice;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBauthor() {
		return bauthor;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	public Integer getBprice() {
		return bprice;
	}

	public void setBprice(Integer bprice) {
		this.bprice = bprice;
	}

	@Override
	public String toString() {
		return (btitle + " /t" + bauthor + "/t" + bprice) ;
	}
	
	
	
	
}
