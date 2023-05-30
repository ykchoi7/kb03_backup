import java.sql.*;

public class ExamCount {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	//throws의 역할 - 오류가 발생하면 알려주겠다
		
		//jdbc driver를 로드
		//실행 중에 클래스를 찾아 메모리에 로딩하는 메서드
		//동적 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("오라클 드라이버 로딩!");
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "HR";
		String password = "HR";
		Connection con = 
				DriverManager.getConnection(url, user, password);
		System.out.println("오라클 연결 성공!");
		
		//SQL 전송
		String sql = "SELECT count(*) as cnt FROM bbs";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		int count = rs.getInt(1);
//		int count = rs.getInt("cnt");
		System.out.println("저장갯수 = " + count);
		stmt.close();
		con.close();
	}
}
