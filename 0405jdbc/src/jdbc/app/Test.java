package jdbc.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import dao.customerdao;
import dao.productdao;
import dto.*;

public class Test {

    public static void main(String[] args) throws Exception {
        try {
            //#1. 회원 데이터 등록하기
//            insertMembers();
            
            //#2. 제품 데이터 등록하기
//            insertProducts();
            
            //#3. 입고 데이터 등록하기
            insertIncomes();
            
            //#4. 주문 데이터 등록하기
//            insertOrders();
            
            //#5. 특정회원의 주문정보 상세출력하기
//            selectOrderDetail();
            
            //#6. 제고량 기준 top3 제품 목록 상세 출력
//            selectProduct제고량Top3();
            
            //#7. 주문량 기준 Top3 사용자 상세정보 출력하기
//            selectMember주문량Top3();
            
            
            
        }catch(Exception e) {
            e.printStackTrace();
        }
    }


    private static void selectMember주문량Top3() {
        // 주문량 기준 Top3 사용자 상세정보 출력하기
        // 출력내용: 회원아이디,회원이름,회원전화,등록일,총주문액,총주문갯수
    }

    private static void selectProduct제고량Top3() {
        // 제고량 기준 top3 제품 목록 상세 출력
        // 출력내용: 제품번호, 제품이름, 제조사, 가격(만원), 제고량,등록일, 총주문갯수
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
         * 주문량이 제공량보다 크면 "제공량이 부족합니다" 출력할 것
            (10,100, 20, 1,'2023-04-05')
            (20,200, 10, 1,'2023-04-05')
            (30,300, 20, 3,'2023-04-05')
            (40,300, 40, 1,'2023-04-05')
            (50,300, 30, 1,'2023-04-05')
            (60,100, 20, 1,'2023-04-05')
     */        
   
    	for(orderdto dto:odtoarr) {
    		if(udao.selectone(dto.getuserno())==null)
    	}
    	
    	
    }
    private static void insertIncomes() {
        /* 아래의 입고 정보를 등록하세요.
         * 미등록 제품번호이면 "미등록 제품번호입니다" 출력할 것
            (10,10,10,'2023-03-03')
            (20,20,20,'2023-03-03')
            (30,10,10,'2023-04-03')
            (40,40,5,'2023-04-03')
         */
    	
//    	
//    	 productdto finddto = pdao.selectone(dto.geno())
//    	    		if(finddto==null) {
//    	    			System.out.println("미등록");
//    	    		}
//    	    idao.insert(idto)
//    	    finddto.setJego(finddto.getJego()+idto.get입고량);
//    	    pdao.update(finddto)
    }

    private static void insertProducts() throws Exception {
        /* 아래의 제품 정보를 등록하세요.
         * 제품번호가 중복되면 "제품번호중복되어 등록불가합니다" 출력할 것
            (10,'냉장고-30L','LG',200,0,'2023-05-01')
            (20,'냉장고-30L','삼성',210,0,'2023-05-02')
            (30,'세탁기-10kg','LG',80,0,'2023-05-02')
            (40,'세탁기-10kg','삼성',70,0,'2023-05-03')
     */        
    	productdto dto=new productdto();
    	int pid=10;
    	dto.setPid(10);
    	dto.setPname("냉장고-30L");
    	dto.setFirm("LG");
    	dto.setPrice(200);
    	dto.setJego(0);
    	dto.setPdate("2023-05-03");
    	
    	productdao dao=new productdao();
    	if(dao.selectOne(pid)==null) dao.insert(dto);
    	else System.out.println("제품번호중복되어 등록불가합니다");
    }

    private static void insertMembers() throws Exception {
        /* 아래의 회원 정보를 등록하세요.
         * 회원아이디가 중복되면 "회원아이디중복되어 등록불가합니다" 출력할 것
            (100,'홍길동','010-111-1111','2023-01-01')
            (200,'김길동','010-111-2222','2023-02-01')
            (300,'이길동','010-111-3333','2023-03-01')
            (400,'박길동','010-111-4444','2023-04-01')
         */        
    	 customerdto[] cdtoArr = new customerdto[] {
    		        new customerdto(100,"홍길동","010-111-1111","2023-01-01"),
    		        new customerdto(200,"김길동","010-111-2222","2023-02-01"),
    		        new customerdto(300,"이길동","010-111-3333","2023-03-01"),
    		        new customerdto(400,"박길동","010-111-4444","2023-04-01")
    		    };
    	
    	
    	customerdto dto=new customerdto();
    	int userid=100;
    	dto.setUserid(100);
    	dto.setName("홍길동");
    	dto.setPhone("010-111-1111");
    	dto.setPdate("2023-01-01");
    	
    	
    	customerdao dao=new customerdao();
    	if(dao.selectOne(userid)==null) dao.insert(dto);
    	else System.out.println("회원아이디중복되어 등록불가합니다");
    		
    	
        
    }
    
    
}
