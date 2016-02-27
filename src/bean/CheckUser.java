package bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import bean.CtlSql;
import bean.Userbean;

public class CheckUser { 
	public boolean checkUser(Userbean user) {
	    ResultSet rs=null;  
	    CtlSql db=new CtlSql();  
		boolean valid = false;
		String sql = "select * from user where user_name='"+
		user.getUserName()+"' and password='"+user.gerUserPassword()+"'";
		db.con();
		rs = db.qurey(sql);
		try {
			if(rs.next()) {
				valid = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return valid;
	}
}
