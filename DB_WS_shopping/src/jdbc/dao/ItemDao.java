package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import jdbc.common.DBManager;
import jdbc.dto.ItemDto;

public class ItemDao {
	public int insert(ItemDto itemDto) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.getConnection();
			String sql = "INSERT INTO item(item_no, item_name, company, price, stock, register_date)";
			sql += "VALUES (?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ItemDto.getItem_no());
			pstmt.setString(2, ItemDto.getItem_name());
			pstmt.setString(3, ItemDto.getCompany());
			pstmt.setInt(4, ItemDto.getPrice());
			pstmt.setInt(5, ItemDto.getStock());
			pstmt.setString(6, ItemDto.getRegister_date());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("제품번호중복되어 등록불가합니다");
		} finally {
			DBManager.releaseConnection(pstmt, con);	
		}
		return 0;
	}
	
	List<ItemDto> selectItem재고량Top3() throws Exception {
		return null;
	}
}
