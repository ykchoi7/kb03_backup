import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;

public class WS_DBManager {
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String user = "HR";
	private static String password = "HR";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(url, user, password);
	}
	
	public static void releaseConnection(Statement pstmt, Connection con) {
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
