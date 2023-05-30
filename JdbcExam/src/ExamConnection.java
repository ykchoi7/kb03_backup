import java.sql.*;

public class ExamConnection {
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
		String sql = "INSERT INTO BBS(no, title1, writer1, content, regdate)";
		sql += "VALUES(BBS_SEQ.NEXTVAL, '3rd', 'u01', '야 3등이다!', sysdate)";
		
		//위에 하나하나의 값 대신 변수를 하나 설정해서 넣고 싶을때
//		String title = "3등";
//		String writer = "u01";
//		String content = "야~3등이다";
//		String sql = "INSERT INTO BBS(no, title1, writer1, content, regdate)";
//		sql += "VALUES(BBS_SEQ.NEXTVAL, '"+title+"', '"+writer+"', '"+content+"', sysdate)";
//		
		Statement stmt = con.createStatement();
		int count = stmt.executeUpdate(sql); //영향을 받는 행의 개수
		stmt.executeUpdate(sql); //조건에 맞춰 update된 행의 개수 반환
		//insert - 등록된 행의 개수 / delete - 조건에 맞춰 삭제된 행의 개수
		System.out.println(count);
		System.out.println("INSERT 성공!");
		stmt.close();
		con.close();
	}
}
