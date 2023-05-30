package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.common.DBManager;
import jdbc.dto.CourseDto;
import jdbc.dto.TeacherDto;

public class TeacherDao {
	public void insert(TeacherDto dto) throws Exception {
		Connection con = null;  //선언
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "INSERT INTO teacher(teach_id, name, major)";
			sql += "VALUES (?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getTeach_id());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getMajor());
			pstmt.executeUpdate();
		} finally {
			DBManager.releaseConnection(pstmt, con);	
		}
	}
	
	public void update(TeacherDto dto) throws Exception {
		Connection con = null;  //선언
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "UPDATE teacher SET name=?, major=? where teach_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getMajor());
			pstmt.setInt(3, dto.getTeach_id());
			pstmt.executeUpdate();
		} finally {
			DBManager.releaseConnection(pstmt, con);	
		}
	}
	
	public void delete(Integer teach_id) throws Exception {
		Connection con = null;  //선언
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "DELETE teacher where teach_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, teach_id);
			pstmt.executeUpdate();
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
            String sql = "select count(*) as cnt FROM teacher";
            pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            count = rs.getInt("cnt");
        } finally {
        	DBManager.releaseConnection(pstmt, con);
        }
		return count;
	}
	
	public TeacherDto selectOne(Integer teach_id) throws Exception {
		TeacherDto dto = null;
		Connection con = null; 
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
            String sql = "select * FROM teacher where teach_id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, teach_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
            	dto = new TeacherDto();
            	dto.setTeach_id(teach_id);
            	dto.setName(rs.getString("name"));
            	dto.setMajor(rs.getString("major"));
            } 
		} finally {
            DBManager.releaseConnection(pstmt, con);
        }
		return dto; //찾는 값이 null이든지 값이든지 그 결과를 반환해준다
	}
	
	public List<TeacherDto> selectAll() throws Exception {
		List<TeacherDto> list = new ArrayList<>();
		Connection con = null; 
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "select * from teacher";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				TeacherDto dto = new TeacherDto();
				dto.setTeach_id(rs.getInt("teach_id"));
            	dto.setName(rs.getString("name"));
            	dto.setMajor(rs.getString("major"));
				list.add(dto);
			}
		} finally {
        	DBManager.releaseConnection(pstmt, con);
		} 
		return list;
	}
	
	public List<TeacherDto> select교수별개설과목수() throws Exception{
		List<TeacherDto> list = new ArrayList<>();
		Connection con = null; 
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "select t.teach_id, t.name, (select count(*) from course c where c.teach_id = t.teach_id) cnt\r\n"
					+ "from teacher t";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				TeacherDto dto = new TeacherDto();
				dto.setTeach_id(rs.getInt("teach_id"));
            	dto.setName(rs.getString("name"));
            	dto.setCnt(rs.getInt("cnt"));
				list.add(dto);
			}
		} finally {
	    	DBManager.releaseConnection(pstmt, con);
		}
		return list;
	}
}
