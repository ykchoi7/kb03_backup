import java.sql.*;

public class ExamSelect2 {
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
		String sql = "SELECT * FROM bbs WHERE no = 22";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		//rs커서는 실제 데이터 이전에 위치
		if (rs.next()) {  //pk로 검색했기 때문에 있거나 없거나 둘중 하나
			int no = rs.getInt("no"); //칼럼 호출
			String title = rs.getString("title1");
			System.out.println(no + ": " + title);
		} else {
			System.out.println("삭제된 게시물입니다.");
		};
		stmt.close();
		con.close();
	}
}
