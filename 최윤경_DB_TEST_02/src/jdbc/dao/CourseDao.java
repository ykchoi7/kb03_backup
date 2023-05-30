package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.common.DBManager;
import jdbc.dto.CourseDto;
import jdbc.dto.CourseRegDto;

public class CourseDao {
	public void insert(CourseDto dto) throws Exception {
		Connection con = null;  //선언
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "INSERT INTO course(course_no, name, teach_id, total, regnum)";
			sql += "VALUES (?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getCourse_no());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getTeach_id());
			pstmt.setInt(4, dto.getTotal());
			pstmt.setInt(5, dto.getRegnum());
			pstmt.executeUpdate();
		} catch (Exception e) {
		
		}
		finally {
			DBManager.releaseConnection(pstmt, con);	
		}
	}
	
	public void update(CourseDto dto) throws Exception {
		Connection con = null;  //선언
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "UPDATE course SET name=?, teach_id=?, total=?, regnum=? where course_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getTeach_id());
			pstmt.setInt(3, dto.getTotal());
			pstmt.setInt(4, dto.getRegnum());
			pstmt.setInt(5, dto.getCourse_no());
			pstmt.executeUpdate();  //여기서 오류 발생하면 exception 오류 알려주고 releaseconnection이 진행이 안됨
		} finally {
			DBManager.releaseConnection(pstmt, con);	
		}
	}
	
	public void delete(Integer course_no) throws Exception {
		Connection con = null;  //선언
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "DELETE course where course_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, course_no);
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
            String sql = "select count(*) as cnt FROM course";
            pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            count = rs.getInt("cnt");
        } finally {
        	DBManager.releaseConnection(pstmt, con);
        }
		return count;
	}
	
	public CourseDto selectOne(Integer course_no) throws Exception {
		CourseDto dto = null;
		Connection con = null; 
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
            String sql = "select * FROM course where course_no=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, course_no);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
            	dto = new CourseDto();
            	dto.setCourse_no(course_no);
            	dto.setName(rs.getString("name"));
            	dto.setTeach_id(rs.getInt("teach_id"));
            	dto.setTotal(rs.getInt("total"));
            	dto.setRegnum(rs.getInt("regnum"));
            } 
		} finally {
            DBManager.releaseConnection(pstmt, con);
        }
		return dto; //찾는 값이 null이든지 값이든지 그 결과를 반환해준다
	}
	
	public List<CourseDto> selectAll() throws Exception {
		List<CourseDto> list = new ArrayList<>();
		Connection con = null; 
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "select * from course";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CourseDto dto = new CourseDto();
            	dto.setCourse_no(rs.getInt("course_no"));
            	dto.setName(rs.getString("name"));
            	dto.setTeach_id(rs.getInt("teach_id"));
            	dto.setTotal(rs.getInt("total"));
            	dto.setRegnum(rs.getInt("regnum"));
				list.add(dto);
			}
		} finally {
        	DBManager.releaseConnection(pstmt, con);
		} 
		return list;
	}
	
	public List<CourseDto> select수강인원미달과목상세출력() throws Exception{
		List<CourseDto> list = new ArrayList<>();
		Connection con = null; 
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "select *\r\n"
					+ "from course c \r\n"
					+ "    join teacher t\r\n"
					+ "    on c.teach_id = t.teach_id";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				//출력형식: 출력형식: 과목번호,과목이름,교수번호,교수이름,정원,신청수
				CourseDto dto = new CourseDto();
				dto.setCourse_no(rs.getInt("course_no"));
				dto.setName(rs.getString("name"));
				dto.setTeach_id(rs.getInt("teach_id"));
            	dto.setTeachername(rs.getString("name_1"));
            	dto.setTotal(rs.getInt("total"));
            	dto.setRegnum(rs.getInt("regnum"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	    	DBManager.releaseConnection(pstmt, con);
		}
		return list;
	}
	
}

