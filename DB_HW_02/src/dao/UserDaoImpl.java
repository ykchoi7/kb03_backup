package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.UserDto;
import common.DBManager;

// 아래 각 메소드를 구현하세요.
public class UserDaoImpl implements UserDao{

	@Override
	public int insertUser(UserDto userDto) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.getConnection();
			String sql = "INSERT INTO users(user_seq, name, email, phone, is_sleep)";
			sql += "VALUES (?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userDto.getUserSeq());
			pstmt.setString(2, userDto.getName());
			pstmt.setString(3, userDto.getEmail());
			pstmt.setString(4, userDto.getPhone());
			if (userDto.isSleep()) {
				pstmt.setString(5, "Y");
			} else {
				pstmt.setString(5, "N");
			}
//			pstmt.setBoolean(5, dto.isSleep());
			pstmt.executeUpdate();
		} finally {
			DBManager.releaseConnection(pstmt, con);	
		}
		return 0;
	}

	@Override
	public int updateUser(UserDto userDto) throws Exception {
		Connection con = null;  //선언
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "UPDATE USERS SET name=?, email = ?, phone = ?, is_sleep = ? where user_seq = ? ";
			pstmt = con.prepareStatement(sql);			
			pstmt.setString(1, userDto.getName());
			pstmt.setString(2, userDto.getEmail());
			pstmt.setString(3, userDto.getPhone());
			if (userDto.isSleep()) {
				pstmt.setString(4, "Y");
			} else {
				pstmt.setString(4, "N");
			}
			pstmt.setInt(5, userDto.getUserSeq());
			pstmt.executeUpdate();
		} finally {
			DBManager.releaseConnection(pstmt, con);	
		}
		return 0;
	}

	@Override
	public int deleteUser(int userSeq) throws Exception {
		Connection con = null;  //선언
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "DELETE users where user_seq=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userSeq);
			pstmt.executeUpdate();
		} finally {
			DBManager.releaseConnection(pstmt, con);	
		}
		return 0;
	}

	@Override
	public List<UserDto> selectAll() throws Exception {
		// 고객 전체 목록 조회 코드를 완성하세요
		List<UserDto> list = new ArrayList<>();
		Connection con = null; 
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "select * from users";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				UserDto dto = new UserDto();
				dto.setUserSeq(rs.getInt("user_seq"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone(rs.getString("phone"));
				dto.setSleep(rs.getBoolean("is_sleep"));
				list.add(dto);
			}
		} finally {
        	DBManager.releaseConnection(pstmt, con);
		} 
		return list;
	}

	@Override
	public UserDto selectOne(int userSeq) throws Exception {
		// 고객 1건 조회 코드를 완성하세요.
		UserDto dto = null;
		Connection con = null; 
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
            String sql = "select * FROM users where user_seq=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, userSeq);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
            	dto = new UserDto();
            	dto.setUserSeq(rs.getInt("user_seq"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone(rs.getString("phone"));
				dto.setSleep(rs.getBoolean("is_sleep"));
            } 
		} finally {
            DBManager.releaseConnection(pstmt, con);
        }
		return dto;
	}

}
