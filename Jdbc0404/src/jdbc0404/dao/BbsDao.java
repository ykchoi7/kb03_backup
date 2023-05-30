package jdbc0404.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc0404.common.DBManager;
import jdbc0404.dto.BbsDto;
import jdbc0404.dto.BbsNameDto;

public class BbsDao {

	public void insert(BbsDto bbs) throws SQLException, ClassNotFoundException {
		Connection con = null;  //선언
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "INSERT INTO bbs(no, writer_id, title, content, regdate)";
			sql += "VALUES (BBS_SEQ.NEXTVAL, ?,?,?, sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bbs.getWriter_id());
			pstmt.setString(2, bbs.getTitle());
			pstmt.setString(3, bbs.getContent());
			pstmt.executeUpdate();  //여기서 오류 발생하면 exception 오류 알려주고 releaseconnection이 진행이 안됨
		} finally {
			DBManager.releaseConnection(pstmt, con);	
		}
	}

	public List<BbsDto> selectAll() throws SQLException, ClassNotFoundException {
		List<BbsDto> list = new ArrayList<>();
		Connection con = null;  //선언
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "SELECT * FROM bbs order by no desc";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				BbsDto dto = new BbsDto();
				dto.setNo(rs.getInt("no"));
				dto.setWriter_id(rs.getString("writer_id"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getDate("regdate"));
				list.add(dto);
			}
		} finally {
			DBManager.releaseConnection(pstmt, con);
		}
		return list;
	}
	
	public List<BbsNameDto> selectAllName() throws Exception {
        List<BbsNameDto> list = new ArrayList<>();
        Connection con = null;//선언
        PreparedStatement pstmt = null;//선언
        try {
            con = DBManager.getConnection();
            String sql = "Select bbs.*,member.name \r\n"
                    + "from bbs , member\r\n"
                    + "where bbs.writer_id = member.id \r\n"
                    + "order by no DESC";
            pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                BbsNameDto dto = new BbsNameDto();
                dto.setNo(rs.getInt("no"));
                dto.setWriter_id(rs.getString("writer_id"));
                dto.setTitle(rs.getString("title"));
                dto.setContent(rs.getString("content"));
                dto.setDate(rs.getDate("regdate")); //"" 안에 있는 컬럼명은 sql 컬럼명으로
                dto.setWriter_name(rs.getString("name"));
                list.add(dto);
            }
        } finally {
            DBManager.releaseConnection(pstmt, con);
        }
        return list;
    }
}
