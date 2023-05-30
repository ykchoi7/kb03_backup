import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class WS_Test {
	public static void main(String[] args) {
//		insert();
//		update();
//		selectAll();
//		selectOne();
//		delete();
	}

	private static void delete() {
		UserDto dto = new UserDto();
		dto.setUser_seq(666);
		dto.setName("육길동");
		dto.setEmail("six@gildong@com");
		dto.setPhone("010-6666-6666");
		dto.setIs_sleep(false);
		
		try {
			Connection con = WS_DBManager.getConnection();
			//삭제
			int user_seq = 666;
			String sql = "DELETE USERS where user_seq = ? ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user_seq);
			int count = pstmt.executeUpdate();
			WS_DBManager.releaseConnection(pstmt, con);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("연결실패");
		}
	}

	private static void selectOne() {
		int user_seq = 666;
		UserDto dto = null;
		try {
			Connection con = WS_DBManager.getConnection();
			String sql = "select * from users where user_seq = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user_seq);
			
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new UserDto();
				dto.setUser_seq(user_seq);
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone(rs.getString("phone"));
				dto.setIs_sleep(rs.getBoolean("is_sleep"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("연결실패");
		}
	}

	private static void selectAll() {
		List<UserDto> list = new LinkedList<>();
		try {
			Connection con = WS_DBManager.getConnection();
			String sql = "select * from users order by user_seq desc";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				UserDto dto = new UserDto();
				dto.setUser_seq(rs.getInt("user_seq"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone(rs.getString("phone"));
				dto.setIs_sleep(rs.getBoolean("is_sleep"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("오류발생");
		} for (UserDto userDto : list) {
			System.out.println(userDto);
		}
	}

	private static void update() {
		UserDto dto = new UserDto();
		dto.setUser_seq(666);
		dto.setName("육길동");
		dto.setEmail("six@gildong@com");
		dto.setPhone("010-6666-6666");
		dto.setIs_sleep(false);
		
		try {
			Connection con = WS_DBManager.getConnection();
			//업데이트
			int user_seq = 666;
			String email = "yook@gildong@com";
			String phone = "010-7777-7777";
			Boolean is_sleep = true;
			String sql = "UPDATE USERS SET email = ?, phone = ?, is_sleep = ? where user_seq = ? ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, phone);
			if (dto.getIs_sleep()) {
				pstmt.setString(3, "Y");
			} else {
				pstmt.setString(3, "N");
			}
			pstmt.setInt(4, user_seq);
			int count = pstmt.executeUpdate();
			WS_DBManager.releaseConnection(pstmt, con);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("연결실패");
		}
		
	}

	private static void insert() {
		UserDto dto = new UserDto();
		dto.setUser_seq(666);
		dto.setName("육길동");
		dto.setEmail("six@gildong@com");
		dto.setPhone("010-6666-6666");
		dto.setIs_sleep(false);
		
		try {
			Connection con = WS_DBManager.getConnection();
			
			//삽입
			String sql = "INSERT INTO USERS(user_seq, name, email, phone, is_sleep)";
			sql += "VALUES(?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getUser_seq());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getPhone());
			if (dto.getIs_sleep()) {
				pstmt.setString(5, "Y");
			} else {
				pstmt.setString(5, "N");
			}
			int count = pstmt.executeUpdate();
			WS_DBManager.releaseConnection(pstmt, con);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("연결실패");
		}
	}
}
