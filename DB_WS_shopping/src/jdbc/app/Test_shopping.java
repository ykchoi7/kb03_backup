package jdbc.app;

import jdbc.dao.ClientDao;
import jdbc.dao.ItemDao;
import jdbc.dao.OrderDao;
import jdbc.dao.StorageDao;
import jdbc.dto.ClientDto;
import jdbc.dto.ItemDto;
import jdbc.dto.OrderDto;
import jdbc.dto.StorageDto;

public class Test_shopping {
	
	static ClientDao cDao = new ClientDao();
	
	public static void main(String[] args) throws Exception {
        try {
            //#1. 회원 데이터 등록하기
//            insertClient();
            
            //#2. 제품 데이터 등록하기
//            insertItem();
            
            //#3. 입고 데이터 등록하기
//            insertStorage();
            
            //#4. 주문 데이터 등록하기
//            insertOrders();
            
            //#5. 특정회원의 주문정보 상세출력하기
//            selectOrderDetail();
            
            //#6. 재고량 기준 top3 제품 목록 상세 출력
//            selectItem재고량Top3();
            
            //#7. 주문량 기준 Top3 사용자 상세정보 출력하기
//            selectClient주문량Top3();
            
        }catch(Exception e) {
            e.printStackTrace();
        }
    }


    private static void selectClient주문량Top3() {
        // 주문량 기준 Top3 사용자 상세정보 출력하기
        // 출력내용: 회원아이디,회원이름,회원전화,등록일, 총주문액, 총주문갯수
    }

    private static void selectItem재고량Top3() {
        // 재고량 기준 top3 제품 목록 상세 출력
        // 출력내용: 제품번호, 제품이름, 제조사, 가격(만원), 재고량,등록일, 총주문갯수
    }

    private static void selectOrderDetail() {
        // 특정회원의 주문정보 상세출력하기
        // 홍길동회원의 모든 주문정보 상세 출력
        // 출력내용: 주문번호, 회원아이디,회원이름, 제품번호,제품이름,가격, 수량, 등록일
    	
    	
    }

    private static void insertOrders() throws Exception {
        /* 아래의 주문 정보를 등록하세요.
         * 미등록 회원이면 "미등록 회원입니다" 출력할 것
         * 미등록 제품번호이면 "미등록 제품번호입니다" 출력할 것
         * 주문량이 재고량보다 크면 "재고량이 부족합니다" 출력할 것
            (10,100, 20, 1,'2023-04-05')
            (20,200, 10, 1,'2023-04-05')
            (30,300, 20, 3,'2023-04-05')
            (40,300, 40, 1,'2023-04-05')
            (50,300, 30, 1,'2023-04-05')
            (60,100, 20, 1,'2023-04-05')
     */  
    	OrderDto orderDto = new OrderDto();
    	orderDto.setOrder_no(10);
    	orderDto.setClient_id(100);
    	orderDto.setItem_no(20);
    	orderDto.setOrder_quantity(1);
    	orderDto.setRegister_date("2023-04-05");
    	
    	orderDto.setOrder_no(20);
    	orderDto.setClient_id(200);
    	orderDto.setItem_no(10);
    	orderDto.setOrder_quantity(1);
    	orderDto.setRegister_date("2023-04-05");
    	
    	orderDto.setOrder_no(30);
    	orderDto.setClient_id(300);
    	orderDto.setItem_no(20);
    	orderDto.setOrder_quantity(3);
    	orderDto.setRegister_date("2023-04-05");
    	
    	orderDto.setOrder_no(40);
    	orderDto.setClient_id(300);
    	orderDto.setItem_no(30);
    	orderDto.setOrder_quantity(1);
    	orderDto.setRegister_date("2023-04-05");
    	
    	orderDto.setOrder_no(50);
    	orderDto.setClient_id(300);
    	orderDto.setItem_no(30);
    	orderDto.setOrder_quantity(1);
    	orderDto.setRegister_date("2023-04-05");
    	
    	orderDto.setOrder_no(60);
    	orderDto.setClient_id(100);
    	orderDto.setItem_no(20);
    	orderDto.setOrder_quantity(1);
    	orderDto.setRegister_date("2023-04-05");
    	
    	OrderDao dao = new OrderDao();
		dao.insert(orderDto);
		System.out.println("주문등록 성공");
		
//		for (OrderDto dto : oDtoArr) {
//			//미등록 회원인지 확인
//			if(cDao.selectOne(dto.getClient_id() == null)) {  //미등록회원이면
//				System.out.println("미등록회원입니다");
//			}
//			
//			//미등록 제품인지 확인
//			ItemDto findDto = iDao.selectOne(dto.getItem_no()) //item 있는지 itemdao에서 찾고 수량 올려줘야한다
//			if (findDto == null)) {
//				System.out.println("미등록제품입니다");
//				continue;
//			}
//			
//			//주문량이 재고량보다 크면 "재고량이 부족합니다" 출력
//			if (dto.getQuantity() > findDto.getStock()) { //주문량 > 재고량
//				System.out.println("재고량이 부족합니다");
//				continue;
//			}
//			
//			//주문등록
//			oDao = insert(dto);
//			//재고량 수정
//			findDto.setStock(findDto.getStock() - dto.getQuantity);
//			iDao.update(findDto);
//		}
    }
    
    
    private static void insertStorage() throws Exception {
        /* 아래의 입고 정보를 등록하세요.
         * 미등록 제품번호이면 "미등록 제품번호입니다" 출력할 것
            (10,10,10,'2023-03-03')
            (20,20,20,'2023-03-03')
            (30,10,10,'2023-04-03')
            (40,40,5,'2023-04-03')
         */
    	StorageDto storageDto = new StorageDto();
    	storageDto.setStorage_no(10);
    	storageDto.setItem_no(10);
    	storageDto.setQuantity(10);
    	storageDto.setRegister_date("2023-03-03");
    	
    	storageDto.setStorage_no(20);
    	storageDto.setItem_no(20);
    	storageDto.setQuantity(20);
    	storageDto.setRegister_date("2023-03-03");
    	
    	storageDto.setStorage_no(30);
    	storageDto.setItem_no(10);
    	storageDto.setQuantity(10);
    	storageDto.setRegister_date("2023-04-03");
    	
    	storageDto.setStorage_no(40);
    	storageDto.setItem_no(40);
    	storageDto.setQuantity(5);
    	storageDto.setRegister_date("2023-04-03");
    	
    	StorageDao dao = new StorageDao();
		dao.insert(storageDto);
		System.out.println("입고등록 성공");
		
		//미등록 제품 - 제품no가 있는지 확인하기 위해서 item dao를 뒤져야한다
//		for (StorageDto dto : sDtoArr) {
//			ItemDto findDto = iDao.selectOne(dto.getItem_no()) //item 있는지 itemdao에서 찾고 수량 올려줘야한다
//			if (findDto == null) {
//				System.out.println("미등록제품입니다");
//				continue;
//			}
//			//null이 아니고 값이 정상적이면 iDao에 삽입
//			iDao.insert(dto);
//			
//			//제품재고량 증가
//			findDto.setStock(findDto.getStock() + dto.getQuantity());
//			pDao.update(findDto);
//		}
    }

    private static void insertItem() throws Exception {
        /* 아래의 제품 정보를 등록하세요.
         * 제품번호가 중복되면 "제품번호중복되어 등록불가합니다" 출력할 것
            (10,'냉장고-30L','LG',200,0,'2023-05-01')
            (20,'냉장고-30L','삼성',210,0,'2023-05-02')
            (30,'세탁기-10kg','LG',80,0,'2023-05-02')
            (40,'세탁기-10kg','삼성',70,0,'2023-05-03')
     */   
    	ItemDto itemDto = new ItemDto();
    	itemDto.setItem_no(10);
    	itemDto.setItem_name("냉장고-30L");
    	itemDto.setCompany("LG");
    	itemDto.setPrice(200);
    	itemDto.setStock(0);
    	itemDto.setRegister_date("2023-05-01");
    	
    	itemDto.setItem_no(20);
    	itemDto.setItem_name("냉장고-30L");
    	itemDto.setCompany("삼성");
    	itemDto.setPrice(210);
    	itemDto.setStock(0);
    	itemDto.setRegister_date("2023-05-02");
    	
    	itemDto.setItem_no(30);
    	itemDto.setItem_name("세탁기-10kg");
    	itemDto.setCompany("LG");
    	itemDto.setPrice(80);
    	itemDto.setStock(0);
    	itemDto.setRegister_date("2023-05-03");
    	
    	itemDto.setItem_no(40);
    	itemDto.setItem_name("세탁기-10kg");
    	itemDto.setCompany("삼성");
    	itemDto.setPrice(70);
    	itemDto.setStock(0);
    	itemDto.setRegister_date("2023-05-04");
    	
		ItemDao dao = new ItemDao();
		dao.insert(itemDto);
		System.out.println("제품등록 성공");
		
//		for (ItemDto dto : iDtoArr) {
//			if (iDao.selectOne(dto.getItem_no() != null)) {
//				System.out.println("제품번호가 중복되어 등록 불가합니다");
//				continue;
//			}
//			pDao.insert(dto);
//		}
    	
    }

    private static void insertClient() throws Exception {
        /* 아래의 회원 정보를 등록하세요.
         * 회원아이디가 중복되면 "회원아이디중복되어 등록불가합니다" 출력할 것
            (100,'홍길동','010-111-1111','2023-01-01')
            (200,'김길동','010-111-2222','2023-02-01')
            (300,'이길동','010-111-3333','2023-03-01')
            (400,'박길동','010-111-4444','2023-04-01')
         */   
    	
    	ClientDto clientDto = new ClientDto();
    	clientDto.setClient_id(100);
    	clientDto.setName("홍길동");
    	clientDto.setTel("010-111-1111");
    	clientDto.setRegister_date("2023-01-01");
    	
    	clientDto.setClient_id(200);
    	clientDto.setName("김길동");
    	clientDto.setTel("010-111-2222");
    	clientDto.setRegister_date("2023-02-01");
    	
    	clientDto.setClient_id(300);
    	clientDto.setName("이길동");
    	clientDto.setTel("010-111-3333");
    	clientDto.setRegister_date("2023-03-01");
    	
    	clientDto.setClient_id(400);
    	clientDto.setName("박길동");
    	clientDto.setTel("010-111-4444");
    	clientDto.setRegister_date("2023-04-01");
		
		ClientDao dao = new ClientDao();
		dao.insert(clientDto);
		System.out.println("회원등록 성공");
        
		//arr로 값을 저장하는 방법
//		ClientDao mDao = new ClientDao();
//		ClientDto[] mDtoArr = new ClientDto[] {
//	        new ClientDto(100,"홍길동","010-111-1111","2023-01-01"),
//	        new ClientDto(200,"김길동","010-111-2222","2023-02-01"),
//	        new ClientDto(300,"이길동","010-111-3333","2023-03-01"),
//	        new ClientDto(400,"박길동","010-111-4444","2023-04-01")
//	    };
//		for (ClientDto dto : cDtoArr) {
//			if(cDao.selectOne(dto.getId() != null)) {
//				System.out.println("회원아이디가 중복되어 등록불가합니다");
//				continue;
//    		}
//    		cDao.insert(dto);
//		}
		//dao에 필요한 insert/selectOne만 코딩하기
		
    }
}
