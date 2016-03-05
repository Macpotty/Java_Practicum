package bean;

public class PlanInfoBean {
	private int id;
	private String bookName;
	private String startTime;
	private String status;
	private String showInfo;
	private String thoughts;
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
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
    public String getThoughts() {
        return thoughts;
    }
    public void setThoughts(String thoughts) {
        this.thoughts = thoughts;
    }
	public String getStartTime() {
		return startTime;
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
