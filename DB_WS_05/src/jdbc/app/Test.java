package jdbc.app;

import java.util.List;

import jdbc.dao.AccountDao;
import jdbc.dao.AccountDaoImpl;
import jdbc.dto.AccountDto;
import jdbc.dto.UserAccountCntDto;

public class Test {

	public static void main(String[] args) throws Exception {
		try {

			// #1. account table 에 insert 1건 처리를 위해 insert() 를 완성한다.
//			insert();
			// #2. account table 에 update 1건 처리를 위해 update() 를 완성한다.
//			update();
			// #3. account table 을 전체 조회, 출력하는 selectAll() 를 완성한다.
			selectAll();
//			// #4. account table 을 account_seq 로 1건  조회, 출력하는 selectOne() 를 완성한다.
			selectOne();
//			// #5. account table 을 account_seq 로 1건  삭제하는 delete() 를 완성한다.
//			delete();
//						
//			// #6. account table 에서 balance 기준 내림차순으로 정렬한 후 상위 3개만 조회, 출력하는 selectBalaceDescTop3() 를 완성한다.
			selectBalanceDescTop3();
//			// #7. users table 을 고객 이름으로 검색해서  해당되는 고객의 고객 번호, 고객명, 계좌 번호, 잔고를 출력하는 selectUsersAccountByName() 를 완성한다.
			selectUsersAccountByName();
//			// #8. users table 에서 user_seq, name 조회하되, name 뒤에 account 의 개수도 account_cnt 로 함께 보여 준다. 계좌가 없는 user 는 account_cnt 를 0 으로 보여준다.
//			//     위  내용을 조회, 출력하는 selectUserAccountCnt() 를 완성한다.
			selectUserAccountCnt();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 아래의 모든 메소드는 AccountDao 를 이용해서 DB Access 를 수행한다.
	
	// #1
	static void insert() throws Exception {
		
		AccountDto accountDto = new AccountDto();
		accountDto.setAccountSeq(80);
		accountDto.setAccountNumber("00800808008008");
		accountDto.setBalance(8000);
		accountDto.setUserSeq(333);
		
		// 이 곳에 AccountDao 를 이용해서 계좌 데이터을 1건 등록하는 코드를 작성한다.
		// 계좌 정보는  AccountDto 객체를 이용한다.
		
		//AccountDao 이용하는 방법 - 타입을 인터페이스로 사용 / 뒤에 클래스를 사용
		//수정이 필요할 때 인터페이스명은 변경할 필요 없이, 클래스명만 수정하면 된다
		AccountDao dao = new AccountDaoImpl();
		dao.insert(accountDto);
		System.out.println("계좌등록 성공");
	}
	
	// #2
	static void update() throws Exception {
		
		AccountDto accountDto = new AccountDto();
		accountDto.setAccountSeq(80);
		accountDto.setAccountNumber("00800808008008");
		accountDto.setBalance(5000);
		accountDto.setUserSeq(333);
		
		// 이 곳에 AccountDao 를 이용해서 계좌 데이터을 1건 수정하는 코드를 작성한다.
		// 수정되는 고객 정보는 UserDto 객체를 이용한다. 
		AccountDao dao = new AccountDaoImpl();
		dao.update(accountDto);
		System.out.println("계좌수정 성공");
	}
	
	// #3
	static void selectAll() throws Exception {
		
		AccountDao dao = new AccountDaoImpl();
		List<AccountDto> accountList = dao.selectAll();
		for (AccountDto accountDto : accountList) {
			System.out.println(accountDto);
		}
		// 이 곳에 AccountDao 를 이용해서 account table 을 전체 조회하고 각각을 AccountDto 객체로 생성한 후 accountList 담는다.
		// accountList 를 순회하면서 각 AccountDto 객체의 내용을 출력하는 코드를 작성한다.
	}
	
	// #4
	static void selectOne() throws Exception {
		AccountDao dao = new AccountDaoImpl();
		AccountDto accountDto = new AccountDto();
		int accountSeq = 80;
		
		accountDto = dao.selectOne(accountSeq);
		// 이 곳에 AccountDao 를 이용해서 account table 을 1건 조회하여 AccountDto 객체를 만들고 객체의 내용을 출력하는 코드를 작성한다.
		// 위 accountSeq 를 이용해서 1건  조회한다.
		if (accountDto == null) 
			System.out.println("미등록계좌");
		else
			System.out.println(accountDto);
	}
	
	// #5
	static void delete() throws Exception {
		
		AccountDto accountDto = new AccountDto();
		int accountSeq = 80;
		
		// 이 곳에 AccountDao 를 이용해서 account table 을 1건 삭제하는 코드를 작성한다.
		// 위 accountSeq 를 이용해서 1 건을 삭제한다.
		AccountDao dao = new AccountDaoImpl();
		dao.delete(accountSeq);
		System.out.println("계좌삭제 성공");
	}
	
	// #6
	static void selectBalanceDescTop3() throws Exception {

		AccountDao dao = new AccountDaoImpl();
		List<AccountDto> accountList = dao.selectBalanceDescTop3();
		for (AccountDto accountDto : accountList) {
			System.out.println(accountDto);
		}
		// 이 곳에 AccountDao 를 이용해서 account table 에서 balance 기준 내림차순으로 정렬한 후 상위 3개만 조회하고, 각각을 AccountDto 객체로 생성한 후 accountList 담는다.
		// accountList 를 순회하면서 각 AccountDto 객체의 내용을 출력하는 코드를 작성한다.	
	}
	
	// #7
	static void selectUsersAccountByName() throws Exception {
		
		String searchName = "길동"; // 고객 이름 변수
		
		// 이 곳에 AccountDao 를 이용해서 users table 을 고객 이름으로 LIKE 검색해서  해당되는 고객의 고객 번호, 고객명, 계좌 번호, 잔고를 조회하고, 각각을 AccountDto 객체로 생성한 후 accountList 담는다.
		// accountList 를 순회하면서 각 AccountDto 객체의 내용을 출력하는 코드를 작성한다.
		// 검색하는 고객 이름은 임의로 작성한다.			
		AccountDao dao = new AccountDaoImpl();
		List<AccountDto> accountList = dao.selectUsersAccountByName(searchName);
		for (AccountDto accountDto : accountList) {
			System.out.println(accountDto);
		}
	}
	
//	// #8
	static void selectUserAccountCnt() throws Exception {
		
		// 이 곳에 AccountDao 를 이용해서 users table 에서 user_seq, name 을 조회하되, name 뒤에 account 의 개수도 account_cnt 로 함께 조회하고, 각각을 UserAccountCntDto 객체로 생성한 후 userAccountCntList 담는다.
		// userAccountCntList 를 순회하면서 각 UserAccountCntDto 객체의 내용을 출력하는 코드를 작성한다.	
		AccountDao dao = new AccountDaoImpl();
		List<UserAccountCntDto> useraccountList = dao.selectUserAccountCnt();
		for (UserAccountCntDto userAccountCntDto : useraccountList) {
			System.out.println(userAccountCntDto);
		}
	}
}
