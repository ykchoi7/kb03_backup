import java.sql.*;

public class ExamSelect {
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
		String sql = "SELECT * FROM bbs";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		//rs커서는 실제 데이터 이전에 위치
		//왜 while문을 써야할까? (if대신) -> 커서가 이동하면서 데이터 존재여부를 파악해야하기 때문
		while (rs.next()) {  //커서를 아래로 한칸 이동. 데이터 존재여부 반환 (존재하면 계속 진행, 없으면 끝)
			int no = rs.getInt("no"); //칼럼 호출
			String title = rs.getString("title1");
			System.out.println(no + ": " + title);
		};
		stmt.close();
		con.close();
	}
}
