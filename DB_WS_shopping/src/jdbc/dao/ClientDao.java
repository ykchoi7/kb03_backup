package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.common.DBManager;
import jdbc.dto.ClientDto;

public class ClientDao {
	public int insert(ClientDto clientDto) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.getConnection();
			String sql = "INSERT INTO client(client_id, name, tel, register_date)";
			sql += "VALUES (?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, clientDto.getClient_id());
			pstmt.setString(2, clientDto.getName());
			pstmt.setString(3, clientDto.getTel());
			pstmt.setString(4, clientDto.getRegister_date());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("아이디중복되어 등록 불가합니다");
		}
		finally {
			DBManager.releaseConnection(pstmt, con);	
		}
		return 0;
	}
	
	List<ClientDto> selectClient주문량Top3() throws Exception {
//		List<ClientDto> list = new ArrayList<>();
//		Connection con = null; 
//		PreparedStatement pstmt = null; //선언
//		try {
//			con = DBManager.getConnection();
//			String sql = "select * \r\n"
//					+ "from (\r\n"
//					+ "    select * \r\n"
//					+ "    from account \r\n"
//					+ "    order by balance desc\r\n"
//					+ ") \r\n"
//					+ "where rownum <= 3";
//			pstmt = con.prepareStatement(sql);
//			ResultSet rs = pstmt.executeQuery();
//			while (rs.next()) {
//				AccountDto dto = new AccountDto();
//				dto.setAccountSeq(rs.getInt("account_seq"));
//				dto.setAccountNumber(rs.getString("account_number"));
//            	dto.setBalance(rs.getInt("balance"));
//            	dto.setUserSeq(rs.getInt("user_seq"));
//				list.add(dto);
//			}
//		} finally {
//        	DBManager.releaseConnection(pstmt, con);
//		} 
		return null;
	}
}
