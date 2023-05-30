package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.common.DBManager;
import jdbc.dto.CourseRegDto;
import jdbc.dto.TeacherDto;

public class CourseRegDao {
	public void insert(CourseRegDto dto) throws Exception {
		Connection con = null;  //선언
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "INSERT INTO coursereg(coursereg_no, course_no, student_id, regdate)";
			sql += "VALUES (?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getCoursereg_no());
			pstmt.setInt(2, dto.getCourse_no());
			pstmt.setInt(3, dto.getStudent_id());
			pstmt.setString(4, dto.getRegdate());
			pstmt.executeUpdate();
		} catch (Exception e) {
			
		}
		finally {
			DBManager.releaseConnection(pstmt, con);	
		}
	}
	
	public void update(CourseRegDto dto) throws Exception {
		Connection con = null;  //선언
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "UPDATE coursereg SET course_no=?, student_id=?, regdate=? where coursereg_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getCourse_no());
			pstmt.setInt(2, dto.getStudent_id());
			pstmt.setString(3, dto.getRegdate());
			pstmt.setInt(4, dto.getCoursereg_no());
			pstmt.executeUpdate();
		} finally {
			DBManager.releaseConnection(pstmt, con);	
		}
	}
	
	public void delete(Integer coursereg_no) throws Exception {
		Connection con = null;  //선언
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "DELETE coursereg where coursereg_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, coursereg_no);
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
            String sql = "select count(*) as cnt FROM coursereg";
            pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            count = rs.getInt("cnt");
        } finally {
        	DBManager.releaseConnection(pstmt, con);
        }
		return count;
	}
	
	public CourseRegDto selectOne(Integer coursereg_no) throws Exception {
		CourseRegDto dto = null;
		Connection con = null; 
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
            String sql = "select * FROM coursereg where coursereg_no=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, coursereg_no);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
            	dto = new CourseRegDto();
            	dto.setCoursereg_no(coursereg_no);
            	dto.setCourse_no(rs.getInt("course_no"));
            	dto.setStudent_id(rs.getInt("student_id"));
            	dto.setRegdate(rs.getString("regdate"));
            } 
		} finally {
            DBManager.releaseConnection(pstmt, con);
        }
		return dto; //찾는 값이 null이든지 값이든지 그 결과를 반환해준다
	}
	
	public List<CourseRegDto> selectAll() throws Exception {
		List<CourseRegDto> list = new ArrayList<>();
		Connection con = null; 
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "select * from coursereg";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CourseRegDto dto = new CourseRegDto();
				dto.setCoursereg_no(rs.getInt("coursereg_no"));
            	dto.setCourse_no(rs.getInt("course_no"));
            	dto.setStudent_id(rs.getInt("student_id"));
            	dto.setRegdate(rs.getString("regdate"));
				list.add(dto);
			}
		} finally {
        	DBManager.releaseConnection(pstmt, con);
		} 
		return list;
	}
	
	
	public List<CourseRegDto> select수강신청상세정보출력() throws Exception{
		List<CourseRegDto> list = new ArrayList<>();
		Connection con = null; 
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "select a.coursereg_no, a.course_no, b.coursename, b.teach_id, b.teachername, a.student_id, a.name, a.regdate\r\n"
					+ "from (select *\r\n"
					+ "    from coursereg c and student s\r\n"
					+ "        where c.student_id = s.student_id\r\n"
					+ "    ) as a\r\n"
					+ "    and\r\n"
					+ "    (select c.course_no as course_no, c.name as coursename, t.teach_id as teach_id, t.name as teachername\r\n"
					+ "    from course c and teacher t\r\n"
					+ "        where c.teach_id = t.teach_id\r\n"
					+ "    ) as b\r\n"
					+ "    where a.course_no = b.course_no";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				//출력형식: 신청번호,과목번호,과목이름,교수번호,교수이름,학생번호,학생이름,등록일시
				CourseRegDto dto = new CourseRegDto();
				dto.setCoursereg_no(rs.getInt("coursereg_no"));
				dto.setCoursereg_no(rs.getInt("course_no"));
				dto.setCoursename(rs.getString("coursename"));
				dto.setTeach_id(rs.getInt("teach_id"));
            	dto.setTeachername(rs.getString("teachername"));
            	dto.setStudent_id(rs.getInt("student_id"));
            	dto.setStudentname(rs.getString("studentname"));
            	dto.setRegdate(rs.getString("regdate"));
				list.add(dto);
			}
		} catch (Exception e) {
			
		}
		finally {
	    	DBManager.releaseConnection(pstmt, con);
		}
		return list;
	}
}
