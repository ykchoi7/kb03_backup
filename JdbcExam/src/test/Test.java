package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DBManager;
import dto.BbsDto;

public class Test {
	public static void main(String[] args) {
		insert();
		update();
		count();
		selectOne();
		selectAll();
	}

	private static void selectAll() {
		//arraylist에 담기 - size를 통해서 갯수 확인
		List<BbsDto> list = new ArrayList<>();
		try {
			Connection con = DBManager.getConnection();
			String sql = "select * from BBS order by no desc";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				BbsDto dto = new BbsDto();
				dto.setNo(rs.getInt("no"));
				dto.setTitle(rs.getString("title1"));
				dto.setWriter(rs.getString("writer1"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getDate("regdate"));
				list.add(dto);
			}
			DBManager.releaseConnection(pstmt, con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (BbsDto bbsDto : list) {
			System.out.println(bbsDto);
		}
		
	}

	private static void selectOne( ) {
		int no = 24;
		BbsDto dto = null;
		try {
			Connection con = DBManager.getConnection();
			String sql = "select * from bbs where no = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) { //pk로 검색이 성공하면 
				dto = new BbsDto();
				dto.setNo(no);
				dto.setTitle(rs.getString("title1"));
				dto.setWriter(rs.getString("writer1"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getDate("regdate"));
			}
			DBManager.releaseConnection(pstmt, con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void count() {
		int count = -1;
		try {
            Connection con = DBManager.getConnection();
            String sql = "select count(*) as cnt FROM bbs";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            count = rs.getInt("cnt");
            DBManager.releaseConnection(pstmt, con);
            System.out.println("count="+count);
        }catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	private static void update() {
		//저장할 데이터를 객체에 담는다
		BbsDto dto = new BbsDto();
		dto.setNo(24);
		dto.setTitle("6등");
		dto.setWriter("u01");
		dto.setContent("야~6등이다");
		try {
			Connection con = DBManager.getConnection();
			//업데이트할때
			String sql = "UPDATE BBS SET content= ? where no = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getContent());			
			pstmt.setInt(2, dto.getNo());	
			int count = pstmt.executeUpdate();
			
			DBManager.releaseConnection(pstmt, con);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace(); //예외발생된 메시지와 모든 메서드 경로를 출력
			System.out.println("연결 실패");
		}
	}
		
		
	private static void insert() { 
		//여기서는 오류 발생 시 내부처리를 해야하기 때문에 try~catch 진행
		try {
			
			//저장할 데이터를 객체에 담는다
			BbsDto dto = new BbsDto();
			dto.setNo(24);
			dto.setTitle("6등");
			dto.setWriter("u01");
			dto.setContent("야~6등이다");
			
			Connection con = DBManager.getConnection();
			//test 클래스 내부적으로는 연결 성공, 실패 여부를 확인할 수 없기 때문에 DBManager를 통해 확인
//			System.out.println("연결 성공!"); -- 보통 중간 sysout은 삭제
			
//			String title = "5등";
//			String writer = "u01";
//			String content = "야~5등이다";
			
			//삽입할때
			String sql = "INSERT INTO BBS(no, title1, writer1, content, regdate)";
            sql += "VALUES(BBS_SEQ.NEXTVAL, ?, ?, ?,sysdate)";
            PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());			
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getContent());
			int count = pstmt.executeUpdate();
			
			DBManager.releaseConnection(pstmt, con);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace(); //예외발생된 메시지와 모든 메서드 경로를 출력
			System.out.println("연결 실패");
		}
	}
	
}
