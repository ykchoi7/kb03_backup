package web0418.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web0418.dto.BbsDto;
import web0418_dbcp.common.DBManager;

public class BbsDao {

	public void insert(BbsDto bbs) throws Exception {
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

	public List<BbsDto> selectAll() throws Exception {
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

	public BbsDto selectOne(int bno) throws Exception {
		Connection con = null;  //선언
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "SELECT * FROM bbs where no="+bno;
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				BbsDto dto = new BbsDto();
				dto.setNo(rs.getInt("no"));
				dto.setWriter_id(rs.getString("writer_id"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setDate(rs.getDate("regdate"));
				//dto.setRegdate(rs.getDate("regdate"));
				return dto;
			}
		} finally {
			DBManager.releaseConnection(pstmt, con);
		}
		return null;
	}

	public void update(BbsDto dto) throws Exception{
		Connection con = null;  //선언
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "UPDATE bbs SET writer_id=?, title=?, content=?";
			sql += "where no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter_id());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setInt(4, dto.getNo());
			pstmt.executeUpdate();
		} finally {
			DBManager.releaseConnection(pstmt, con);	
		}
		
	}

	public void delete(int no) throws Exception {
		Connection con = null;  //선언
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "DELETE bbs where no="+no;
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
		} finally {
			DBManager.releaseConnection(pstmt, con);	
		}
		
	}

}
