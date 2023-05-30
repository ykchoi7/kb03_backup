package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.common.DBManager;
import jdbc.dto.AccountDto;
import jdbc.dto.UserAccountCntDto;

public class AccountDaoImpl implements AccountDao {

	@Override
	public int insert(AccountDto accountDto) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBManager.getConnection();
			String sql = "INSERT INTO account(account_seq, account_number, balance, user_seq)";
			sql += "VALUES (?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, accountDto.getAccountSeq());
			pstmt.setString(2, accountDto.getAccountNumber());
			pstmt.setInt(3, accountDto.getBalance());
			pstmt.setInt(4, accountDto.getUserSeq());
			pstmt.executeUpdate();
			//여기에서 return = pstmt.executeUpdate()를 진행하면 
			//아래 return은 없어도 되고 connection release하고 반환을 마지막으로 진행
		} finally {
			DBManager.releaseConnection(pstmt, con);	
		}
		return 0;
	}

	@Override
	public int update(AccountDto accountDto) throws Exception {
		Connection con = null;  //선언
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "UPDATE account SET account_seq=?, account_number=?, balance=? where account_seq=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, accountDto.getAccountSeq());
			pstmt.setString(2, accountDto.getAccountNumber());
			pstmt.setInt(3, accountDto.getBalance());
			pstmt.setInt(4, accountDto.getAccountSeq());
			pstmt.executeUpdate();
		} finally {
			DBManager.releaseConnection(pstmt, con);	
		}
		return 0;
	}

	@Override
	public int delete(int accountSeq) throws Exception {
		Connection con = null;  //선언
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "DELETE account where account_seq=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, accountSeq);
			pstmt.executeUpdate();  //여기서 오류 발생하면 exception 오류 알려주고 releaseconnection이 진행이 안됨
		} finally {
			DBManager.releaseConnection(pstmt, con);	
		}
		return 0;
	}

	@Override
	public List<AccountDto> selectAll() throws Exception {
		List<AccountDto> list = new ArrayList<>();
		Connection con = null; 
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "select * from account";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				AccountDto dto = new AccountDto();
				dto.setAccountSeq(rs.getInt("account_seq"));
				dto.setAccountNumber(rs.getString("account_number"));
            	dto.setBalance(rs.getInt("balance"));
            	dto.setUserSeq(rs.getInt("user_seq"));
				list.add(dto);
			}
		} finally {
        	DBManager.releaseConnection(pstmt, con);
		} 
		return list;
	}

	@Override
	public AccountDto selectOne(int accountSeq) throws Exception {
		AccountDto dto = null;
		Connection con = null; 
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
            String sql = "select * FROM account where account_seq=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, accountSeq);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
            	dto = new AccountDto();
            	dto.setAccountSeq(rs.getInt("account_seq"));
            	dto.setAccountNumber(rs.getString("account_number"));
            	dto.setBalance(rs.getInt("balance"));
            	dto.setUserSeq(rs.getInt("user_seq"));
            } 
		} finally {
            DBManager.releaseConnection(pstmt, con);
        }
		return dto;
	}

	@Override
	public List<AccountDto> selectBalanceDescTop3() throws Exception {
		List<AccountDto> list = new ArrayList<>();
		Connection con = null; 
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "select * \r\n"
					+ "from (\r\n"
					+ "    select * \r\n"
					+ "    from account \r\n"
					+ "    order by balance desc\r\n"
					+ ") \r\n"
					+ "where rownum <= 3";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				AccountDto dto = new AccountDto();
				dto.setAccountSeq(rs.getInt("account_seq"));
				dto.setAccountNumber(rs.getString("account_number"));
            	dto.setBalance(rs.getInt("balance"));
            	dto.setUserSeq(rs.getInt("user_seq"));
				list.add(dto);
			}
		} finally {
        	DBManager.releaseConnection(pstmt, con);
		} 
		return list;
	}

	@Override
	public List<AccountDto> selectUsersAccountByName(String searchName) throws Exception {
		List<AccountDto> list = new ArrayList<>();
        Connection con = null;//선언
        PreparedStatement pstmt = null;//선언
        try {
            con = DBManager.getConnection();
            String sql = "Select account.*, users.name \r\n"
                    + "from account , users\r\n"
                    + "where account.user_seq = users.user_seq and name like ? \r\n";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, '%'+searchName);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
            	AccountDto dto = new AccountDto();
            	dto.setAccountSeq(rs.getInt("account_seq"));
				dto.setAccountNumber(rs.getString("account_number"));
            	dto.setBalance(rs.getInt("balance"));
            	dto.setUserSeq(rs.getInt("user_seq"));
            	dto.setName(rs.getString("name"));
                list.add(dto);
            }
        } finally {
            DBManager.releaseConnection(pstmt, con);
        }
        return list;
    }

	@Override
	public List<UserAccountCntDto> selectUserAccountCnt() throws Exception {
		List<UserAccountCntDto> list = new ArrayList<>();
		Connection con = null; 
		PreparedStatement pstmt = null; //선언
		try {
			con = DBManager.getConnection();
			String sql = "select u.user_seq, u.name, (select count(*) from account a where a.user_seq=u.user_seq) cnt \r\n"
					+ "from users u ";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				UserAccountCntDto dto = new UserAccountCntDto();
				dto.setUserSeq(rs.getInt("user_seq"));
            	dto.setName(rs.getString("name"));
            	dto.setAccountCnt(rs.getInt("cnt"));
				list.add(dto);
			}
		} finally {
        	DBManager.releaseConnection(pstmt, con);
		}
		return list;
	}
}
