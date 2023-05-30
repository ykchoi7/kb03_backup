import java.sql.*;

public class ExamInsert2 {
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
		//PreparedStatement로 삽입하기
		String title = "3등";
		String writer = "u01";
		String content = "야~3등이다";
		String sql = "INSERT INTO BBS(no, title1, writer1, content, regdate)";
		sql += "VALUES(BBS_SEQ.NEXTVAL, ?, ?, ?, sysdate)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, writer);
		pstmt.setString(3, content);
		//preparedstatement 주의사항 - ?가 3개인데 값을 2개만 주면 오류 발생
		
		int count = pstmt.executeUpdate(); //영향을 받는 행의 개수 - executeUpdate() 안에 sql 넣을 필요 없음!!
		System.out.println(count);
		System.out.println("INSERT 성공!");
		pstmt.close();
		con.close();
	}
}
