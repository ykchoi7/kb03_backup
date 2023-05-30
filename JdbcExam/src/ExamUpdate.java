import java.sql.*;

public class ExamUpdate {
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
		
		//SQL update
		String sql = "UPDATE BBS SET content = '우와 나 3등이야!'";
		sql += "WHERE no=21";
		Statement stmt = con.createStatement();
		int count = stmt.executeUpdate(sql);  //영향을 받는 행의 개수
		System.out.println(count);
		System.out.println("UPDATE 성공!");
		stmt.close();
		con.close();
		
//		boolean isResult = stmt.execute(sql);
//		if (isResult) {
//			ResultSet rs = stmt.getResultSet();
//			while (rs.next()) {
//				System.out.println("seq : "+ rs.getInt("no"));
//			}
//		} else {
//			int count = stmt.getUpdateCount();
//			System.out.println("row count : "+ count);
//		}
//		System.out.println("UPDATE 완료!");
////		sql += "VALUES(BBS_SEQ.NEXTVAL, '3rd', 'u01', '야 3등이다!', sysdate)";
//		stmt.close();
//		con.close();
	}
}
