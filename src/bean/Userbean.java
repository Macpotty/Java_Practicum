package bean;

public class Userbean {
	private int userID;
	private String userName;
	private String userPassword;
	private String userEmail = null;
	private String showInfo = null;
	private String realName;
	private boolean loginState;
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String gerUserPassword() {
		return userPassword;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setShowInfo(String showInfo) {
		this.showInfo = showInfo;
	}
	public String getShowInfo() {
		return showInfo;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getRealName() {
		return realName;
	}
	public void setLoginState(boolean loginState) {
		this.loginState = loginState;
	}
	public boolean getLoginState() {
		return loginState;
	}
}
