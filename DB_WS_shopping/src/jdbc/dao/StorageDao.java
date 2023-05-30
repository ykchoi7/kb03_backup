package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jdbc.common.DBManager;
import jdbc.dto.StorageDto;

public class StorageDao {
	public int insert(StorageDto storageDto) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.getConnection();
			String sql = "INSERT INTO storage(storage_no, item_no, quantity, register_date)";
			sql += "VALUES (?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, storageDto.getStorage_no());
			pstmt.setInt(2, storageDto.getItem_no());
			pstmt.setInt(3, storageDto.getQuantity());			
			pstmt.setString(4, storageDto.getRegister_date());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("미등록 제품번호입니다");
		} finally {
			DBManager.releaseConnection(pstmt, con);	
		}
		return 0;
	}
}
