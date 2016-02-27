package inter;

import java.sql.Connection;
import java.sql.ResultSet;

public interface CtlSqlInter {
	public Connection con();
	public ResultSet query(String sql);
	public void update(String sql);
}
