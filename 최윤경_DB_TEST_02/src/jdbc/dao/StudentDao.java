package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.common.DBManager;
import jdbc.dto.StudentDto;
import jdbc.dto.TeacherDto;

public class StudentDao {
	public void insert(StudentDto dto) throws Exception {
		Connection con = null;  //선언
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "INSERT INTO student(student_id, name, major, grade)";
			sql += "VALUES (?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getStudent_id());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getMajor());
			pstmt.setInt(4, dto.getGrade());
			pstmt.executeUpdate();
		} finally {
			DBManager.releaseConnection(pstmt, con);	
		}
	}
	
	public void update(StudentDto dto) throws Exception {
		Connection con = null;  //선언
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "UPDATE student SET name=?, major=?, grade=? where student_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getMajor());
			pstmt.setInt(3, dto.getGrade());
			pstmt.setInt(4, dto.getStudent_id());
			pstmt.executeUpdate();
		} finally {
			DBManager.releaseConnection(pstmt, con);	
		}
	}
	
	public void delete(Integer student_id) throws Exception {
		Connection con = null;  //선언
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "DELETE student where student_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, student_id);
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
            String sql = "select count(*) as cnt FROM student";
            pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            count = rs.getInt("cnt");
        } finally {
        	DBManager.releaseConnection(pstmt, con);
        }
		return count;
	}
	
	public StudentDto selectOne(Integer student_id) throws Exception {
		StudentDto dto = null;
		Connection con = null; 
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
            String sql = "select * FROM student where student_id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, student_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
            	dto = new StudentDto();
            	dto.setStudent_id(student_id);
            	dto.setName(rs.getString("name"));
            	dto.setMajor(rs.getString("major"));
            	dto.setGrade(rs.getInt("grade"));
            } 
		} finally {
            DBManager.releaseConnection(pstmt, con);
        }
		return dto; //찾는 값이 null이든지 값이든지 그 결과를 반환해준다
	}
	
	public List<StudentDto> selectAll() throws Exception {
		List<StudentDto> list = new ArrayList<>();
		Connection con = null; 
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "select * from student";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				StudentDto dto = new StudentDto();
				dto.setStudent_id(rs.getInt("student_id"));
            	dto.setName(rs.getString("name"));
            	dto.setMajor(rs.getString("major"));
            	dto.setGrade(rs.getInt("grade"));
				list.add(dto);
			}
		} finally {
        	DBManager.releaseConnection(pstmt, con);
		} 
		return list;
	}
	
	public List<StudentDto> select학생별신청과목수출력() throws Exception{
		List<StudentDto> list = new ArrayList<>();
		Connection con = null; 
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "select s.student_id, s.name, s.major, s.grade, (select count(*) from coursereg cr where cr.student_id = s.student_id) cnt\r\n"
					+ "from student s";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				StudentDto dto = new StudentDto();
				dto.setStudent_id(rs.getInt("student_id"));
            	dto.setName(rs.getString("name"));
            	dto.setMajor(rs.getString("major"));
            	dto.setGrade(rs.getInt("grade"));
            	dto.setCnt(rs.getInt("cnt"));
				list.add(dto);
			}
		} finally {
	    	DBManager.releaseConnection(pstmt, con);
		}
		return list;
	}
}
