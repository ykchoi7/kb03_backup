package jdbc0404.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBManager {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "spring100";
		String password = "spring";
		return DriverManager.getConnection(url, user, password);
	}

	public static void releaseConnection(PreparedStatement pstmt, Connection con) {
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
			}
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
			}	
	} //end releaseConnection
}
