package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.common.DBManager;
import jdbc.dto.OrderDto;

public class OrderDao {
	public int insert(OrderDto orderDto) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.getConnection();
			String sql = "INSERT INTO orders(order_no, client_id, item_no, order_quantity, register_date)";
			sql += "VALUES (?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, orderDto.getOrder_no());
			pstmt.setInt(2, orderDto.getClient_id());
			pstmt.setInt(3, orderDto.getItem_no());
			pstmt.setInt(4, orderDto.getOrder_quantity());		
			pstmt.setString(5, orderDto.getRegister_date());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("미등록 회원입니다");
		} finally {
			DBManager.releaseConnection(pstmt, con);	
		}
		return 0;
	}
	
	
//	List<OrderDto> selectOrderDetail() throws Exception {
//		List<OrderDto> list = new ArrayList<>();
//        Connection con = null;//선언
//        PreparedStatement pstmt = null;//선언
//        try {
//            con = DBManager.getConnection();
//            String sql = "Select c.client_id, c.name, orders.*, users.name \r\n"
//                    + "from client c , users\r\n"
//                    + "where account.user_seq = users.user_seq and name like ? \r\n";
//            pstmt = con.prepareStatement(sql);
//            pstmt.setString(1, '%'+searchName);
//            ResultSet rs = pstmt.executeQuery();
//            while(rs.next()) {
//            	AccountDto dto = new AccountDto();
//            	dto.setAccountSeq(rs.getInt("account_seq"));
//				dto.setAccountNumber(rs.getString("account_number"));
//            	dto.setBalance(rs.getInt("balance"));
//            	dto.setUserSeq(rs.getInt("user_seq"));
//            	dto.setName(rs.getString("name"));
//                list.add(dto);
//            }
//        } finally {
//            DBManager.releaseConnection(pstmt, con);
//        }
//        return list;
//	}
//	}
}
