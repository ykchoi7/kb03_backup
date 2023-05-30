package common;

import java.sql.*;

public class DBManager {
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String user = "HR";
	private static String password = "HR";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//throw.s 할지, try~catch할지 고민될때?
		//try~catch : 내부처리 / throws : 오류 뜨면 알려줄게
		//여기서 try~catch로 처리를 하면 test클래스에서 따로 검증이 안되고 여기서 이미 처리된 다음에 넘어가기 때문에
		//test클래스에서 무조건 연결 성공이 뜬다 => 오류 발생하면 test에 값을 넘겨줘야하기 때문에 throws 진행한다!
		return DriverManager.getConnection(url, user, password);
	}

	public static void releaseConnection(Statement pstmt, Connection con) {
		if (pstmt != null) 	//pstmt가 null이면 오류 발생
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
