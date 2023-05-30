import java.sql.*;

public class ExamUpdate2 {
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
		
		//SQL update - preparedstatement로 업데이트하기
		String content = "우와 나 3등이야!";
		Integer no = 21;
		String sql = "UPDATE BBS SET content=? where no = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, content);
		pstmt.setInt(2, no);
		int count = pstmt.executeUpdate();  //영향을 받는 행의 개수
		System.out.println(count);
		System.out.println("UPDATE 성공!");
		pstmt.close();
		con.close();
	}
}
