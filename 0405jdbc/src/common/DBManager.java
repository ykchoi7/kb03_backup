package common;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBManager {
	
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String user = "HR";
	private static String pwd = "HR";
	
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver") ;
		return DriverManager.getConnection(url, user, pwd);
	}
	
	public static void releaseConnection(PreparedStatement pstmt, Connection con) {

		try {
			if(pstmt != null ) { pstmt.close(); }
			if(con != null ) { con.close(); }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void releaseConnection(ResultSet rs, PreparedStatement pstmt, Connection con) {

		try {
			if(rs != null ) { rs.close(); }
			if(pstmt != null ) { pstmt.close(); }
			if(con != null ) { con.close(); }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// ... 표현식 사용
	public void releaseConnection(AutoCloseable... params) {
		for(AutoCloseable c: params) {
			if (c != null) {
				try {
					c.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
