package bean;

public class Userbean {
	public String userName;
	public String userPassword;
	public String userEmail = null;
	public String showInfo = null;
	public Userbean() {
	
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
}
