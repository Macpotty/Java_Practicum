package bean;

public class ListInfoBean {
	private int id;
	private String bookName;
	private String bookAuthor;
	private String bookType;
	private String status;
	private String showInfo;
	private int userID;

	public int getId() {
		return id;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public String getBookType() {
		return bookType;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public void setShowInfo(String showInfo) {
		this.showInfo = showInfo;
	}
	public String getShowInfo() {
		return showInfo;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getUserID() {
		return userID;
	}
}
