package jdbc0404.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import jdbc0404.common.DBManager;
import jdbc0404.dto.MemberDto;
//import jdbc0404.test.MemberCountDto;

public class MemberDao {
	
	//항상 기입해야하는 DAO 기본 형식
	public void insert(MemberDto dto) throws Exception {
		//try~catch구문 밖에서 선언해야 모든 구문에서 사용 가능하다
		Connection con = null;  //선언
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "INSERT INTO member(id, password, name, intro)";
			sql += "VALUES (?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getIntro());
			pstmt.executeUpdate();  //여기서 오류 발생하면 exception 오류 알려주고 releaseconnection이 진행이 안됨
		} finally {
			//releaseConnection을 밑으로 내려줌
			DBManager.releaseConnection(pstmt, con);	
		}
		
		//**catch구문을 사용하지 않는 이유 - catch를 하면 오류 발생 보고하지 않고 처리하고 끝 -> 이렇게 오류 넘어가면 안된다!
//		  catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
	
	public void update(MemberDto dto) throws Exception {
		Connection con = null;  //선언
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "UPDATE member SET name=?, password=?, intro=? where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getIntro());
			pstmt.setString(4, dto.getId());
			pstmt.executeUpdate();  //여기서 오류 발생하면 exception 오류 알려주고 releaseconnection이 진행이 안됨
		} finally {
			DBManager.releaseConnection(pstmt, con);	
		}
	}
	
	public void delete(String id) throws Exception {
		Connection con = null;  //선언
		PreparedStatement pstmt = null; //선언
		try {
			id = "user01";
			con = DBManager.getConnection();
			String sql = "DELETE member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();  //여기서 오류 발생하면 exception 오류 알려주고 releaseconnection이 진행이 안됨
		} finally {
			DBManager.releaseConnection(pstmt, con);	
		}
	}
	
	public int count() throws Exception {
		int count = -1;
		Connection con = null;  //선언
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
            String sql = "select count(*) as cnt FROM member";
            pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            count = rs.getInt("cnt");
        } finally {
        	DBManager.releaseConnection(pstmt, con);
        }
		return count;
	}
	
	public MemberDto selectOne(String id) throws Exception {
		MemberDto dto = null;
		Connection con = null; 
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
            String sql = "select * FROM member where id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
            	dto = new MemberDto();
            	dto.setId(id);
            	dto.setPassword(rs.getString("password"));
            	dto.setName(rs.getString("name"));
            	dto.setIntro(rs.getString("intro"));
            } 
		} finally {
            DBManager.releaseConnection(pstmt, con);
        }
		return dto; //찾는 값이 null이든지 값이든지 그 결과를 반환해준다
	}
	
	public List<MemberDto> selectAll() throws Exception {
		List<MemberDto> list = new ArrayList<>();
		Connection con = null; 
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "select * from member";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberDto dto = new MemberDto();
				dto.setId(rs.getString("id"));
				dto.setPassword(rs.getString("password"));
            	dto.setName(rs.getString("name"));
            	dto.setIntro(rs.getString("intro"));
				list.add(dto);
			}
		} finally {
        	DBManager.releaseConnection(pstmt, con);
		} 
		return list;
	}

	public List<jdbc0404.dto.MemberCountDto> selectCountAll() throws Exception {
		List<jdbc0404.dto.MemberCountDto> list = new ArrayList<>();
		Connection con = null; 
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "select m.*, (select count(*) from bbs where writer_id=m.id)\r\n"
					+ "from member m";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				jdbc0404.dto.MemberCountDto dto = new jdbc0404.dto.MemberCountDto();
				dto.setId(rs.getString("id"));
				dto.setPassword(rs.getString("password"));
            	dto.setName(rs.getString("name"));
            	dto.setIntro(rs.getString("intro"));
            	dto.setCount(rs.getInt("count"));
				list.add(dto);
			}
		} finally {
        	DBManager.releaseConnection(pstmt, con);
		} 
		return list;
	}

}
