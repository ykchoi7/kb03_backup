package jdbc.app;
import jdbc.dao.IncomeDao;
import jdbc.dao.MemberDao;
import jdbc.dao.OrderDao;
import jdbc.dao.ProductDao;
import jdbc.dto.IncomeDto;
import jdbc.dto.MemberDto;
import jdbc.dto.OrderDto;
import jdbc.dto.ProductDto;

public class Test_REF {
    static MemberDao mDao = new MemberDao();
    static ProductDao pDao = new ProductDao();
    static IncomeDao iDao = new IncomeDao();
    static OrderDao oDao = new OrderDao();

    public static void main(String[] args) throws Exception {
        try {
            //#1. 회원 데이터 등록하기
            insertMembers();
            
            //#2. 제품 데이터 등록하기
            insertProducts();
            
            //#3. 입고 데이터 등록하기
            insertIncomes();
            
            //#4. 주문 데이터 등록하기
            insertOrders();
            
            //#5. 특정회원의 주문정보 상세출력하기
            selectOrderDetail();
            
            //#6. 재고량 기준 top3 제품 목록 상세 출력
            selectProduct재고량Top3();
            
            //#7. 주문량 기준 Top3 사용자 상세정보 출력하기
            selectMember주문량Top3();
            
            
        }catch(Exception e) {
            e.printStackTrace();
        }
    }


    private static void selectMember주문량Top3() {
        // 주문량 기준 Top3 사용자 상세정보 출력하기
        // 출력내용: 회원아이디,회원이름,회원전화,등록일, 총주문액, 총주문갯수
    }

    private static void selectProduct재고량Top3() {
        // 재고량 기준 top3 제품 목록 상세 출력
        // 출력내용: 제품번호, 제품이름, 제조사, 가격(만원), 재고량,등록일, 총주문갯수
    }

    private static void selectOrderDetail() {
        // 특정회원의 주문정보 상세출력하기
        // 홍길동회원의 모든 주문정보 상세 출력
        // 출력내용: 주문번호, 회원아이디,회원이름, 제품번호,제품이름,가격, 수량, 등록일
        
    }

    private static void insertOrders() {
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
        OrderDto[] oDtoArr = new OrderDto[] {
                new OrderDto(10,100, 20, 1,"2023-04-05"),
                new OrderDto(20,200, 10, 1,"2023-04-05"),
                new OrderDto(30,300, 20, 3,"2023-04-05"),
                new OrderDto(40,300, 40, 1,"2023-04-05"),
                new OrderDto(50,300, 30, 1,"2023-04-05"),
                new OrderDto(60,100, 20, 1,"2023-04-05")
        };
        for (OrderDto dto : oDtoArr) {
            if(mDao.selectOne(dto.getUserNo())==null) {
                System.out.println("미등록 회원입니다");
                continue;
            }
            ProductDto findDto = pDao.selectOne(dto.getPrdNo());
            if( findDto == null) {//미등록이면
                System.out.println("미등록 제품번호입니다");
                continue;
            }
            //주문량이 재고량보다 크면 "재고량이 부족합니다" 출력할 것
            if(dto.getQuantity() > findDto.getStock()) {
                System.out.println("재고량이 부족합니다");
                continue;
            }
            //주문등록
            oDao.insert(dto);
            //재고량 수정
            findDto.setStock( findDto.getStock() - dto.getQuantity() );
            pDao.update(findDto);
        }
    }
    private static void insertIncomes() {
        /* 아래의 입고 정보를 등록하세요.
         * 미등록 제품번호이면 "미등록 제품번호입니다" 출력할 것
            (10,10,10,'2023-03-03')
            (20,20,20,'2023-03-03')
            (30,10,10,'2023-04-03')
            (40,40,5,'2023-04-03' )
         */
        IncomeDto[] iDtoArr = new IncomeDto[] {
                new IncomeDto(10,10,10,"2023-03-03"),
                new IncomeDto(20,20,20,"2023-03-03"),
                new IncomeDto(30,10,10,"2023-04-03"),
                new IncomeDto(40,40,5,"2023-04-03" )
        };
        for (IncomeDto dto : iDtoArr) {
            ProductDto findDto = pDao.selectOne(dto.getNo());
            if( findDto == null) {//미등록이면
                System.out.println("미등록 제품번호입니다");
                continue;
            }
            iDao.insert(dto);
            //제품재고량 증가
            findDto.setStock( findDto.getStock()+dto.getQuantity() );
            pDao.update( findDto );
        }
    }

    private static void insertProducts() {
        /* 아래의 제품 정보를 등록하세요.
         * 제품번호가 중복되면 "제품번호중복되어 등록불가합니다" 출력할 것
            (10,'냉장고-30L','LG',200,0,'2023-05-01' )
            (20,'냉장고-30L','삼성',210,0,'2023-05-02')
            (30,'세탁기-10kg','LG',80,0,'2023-05-02' )
            (40,'세탁기-10kg','삼성',70,0,'2023-05-03')
     */        
        ProductDto[] pDtoArr = new ProductDto[] {
                new ProductDto(10,"냉장고-30L","LG",200,0,"2023-05-01"),
                new ProductDto(20,"냉장고-30L","삼성",210,0,"2023-05-02"),
                new ProductDto(30,"세탁기-10kg","LG",80,0,"2023-05-02"),
                new ProductDto(40,"세탁기-10kg","삼성",70,0,"2023-05-03")
        };
        for (ProductDto dto : pDtoArr) {
            if(pDao.selectOne(dto.getNo()) != null) {
                System.out.println("제품번호중복되어 등록불가합니다");
                continue;
            }
            pDao.insert(dto);
        }
    }

    private static void insertMembers() {
        /* 아래의 회원 정보를 등록하세요.
         * 회원아이디가 중복되면 "회원아이디중복되어 등록불가합니다" 출력할 것
            (100,'홍길동','010-111-1111','2023-01-01')
            (200,'김길동','010-111-2222','2023-02-01')
            (300,'이길동','010-111-3333','2023-03-01')
            (400,'박길동','010-111-4444','2023-04-01')
         */        
        MemberDto[] mDtoArr = new MemberDto[] {
                new MemberDto(100,"홍길동","010-111-1111","2023-01-01"),
                new MemberDto(200,"김길동","010-111-2222","2023-02-01"),
                new MemberDto(300,"이길동","010-111-3333","2023-03-01"),
                new MemberDto(400,"박길동","010-111-4444","2023-04-01")
        };
        for (MemberDto dto : mDtoArr) {
            if(mDao.selectOne(dto.getId()) != null) {
                System.out.println("회원아이디중복되어 등록불가합니다");
                continue;
            }
            mDao.insert(dto);
        }
    }
}
    