package jdbc.dao;

import java.util.List;

import jdbc.dto.AccountDto;
import jdbc.dto.UserAccountCntDto;

public interface AccountDao {
	int insert(AccountDto accountDto)throws Exception;
	int update(AccountDto accountDto)throws Exception;
	int delete(int accountSeq)throws Exception;
	
	List<AccountDto> selectAll()throws Exception;
	AccountDto selectOne(int accountSeq)throws Exception;
	
	List<AccountDto> selectBalanceDescTop3()throws Exception;
	List<AccountDto> selectUsersAccountByName(String searchName)throws Exception;
	List<UserAccountCntDto> selectUserAccountCnt()throws Exception;
}
