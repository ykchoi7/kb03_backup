package web0418_dbcp.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBManager {
	
	public static Connection getConnection() throws Exception {
  		Context init = new InitialContext();
  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/ora");
  		return ds.getConnection();
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
	}
}
