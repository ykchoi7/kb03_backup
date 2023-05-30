package 비디오도서대여점관리;

public class ExamRentManager {
	public static void main(String[] args) {
		
//		RentProduct rp = new RentProduct(1234, "제목", 8000, "대여상태");
//		System.out.println(rp);
//		
//		MyVideo mv1 = new MyVideo(1234, "제목", 8000, "대여상태", "제작사", "상영시간");
//		System.out.println(mv1);
//		
//		MyBook mb1 = new MyBook(1234, "제목", 8000, "대여상태", "저자", "100p");
//		System.out.println(mb1);
		
//		RentManager rm = new RentManager();
		VideoManager vm = new VideoManager();
		BookManager_해시맵사용 bm = new BookManager_해시맵사용();
		
		//등록
		try {
			vm.add(new MyVideo(1234, "Titanic", 10000, "대여중", "showbox", "160분"));
			vm.add(new MyVideo(1222, "Fast&Furious", 8000, "대여가능", "showbox", "150분"));
			bm.add(new MyBook(2345, "소녀", 4000, "대여가능", "홍길동", "100p"));
			bm.add(new MyBook(2222, "영웅", 5000, "대여가능", "장길동", "150p"));
			System.out.println("비디오 등록 갯수: " + vm.getCount());
			System.out.println("도서 등록 갯수: " + bm.getCount());
			System.out.println("총 등록 갯수: " + (vm.getCount() + bm.getCount()));
		} catch (NumberExistException ne) {
			ne.printStackTrace();
			System.out.println("관리번호 중복: " + ne.getMessage());
		}
		
		//대여
		//비디오
		try {
			MyVideo v = vm.findByNumber(2222);
            System.out.println("검색성공:"+v.toString());
            v.setStatus("대여중");
            vm.update(v);
            System.out.println("대여상태 업데이트:"+v.toString());
		} catch (NumberNotFoundException nf) {
			nf.printStackTrace();
			System.err.println("관리번호 찾을 수 없음: " + nf.getMessage());
			//err을 하면 error 빨간색으로 출력
		}
		
		//도서
		try {
			MyBook b = bm.findByNumber(2222);
            System.out.println("검색성공:"+b.toString());
            b.setStatus("대여중");
            bm.update(b);
            System.out.println("대여상태 업데이트:"+ b.toString());
		} catch (NumberNotFoundException nf) {
			nf.printStackTrace();
			System.out.println("관리번호 찾을 수 없음: " + nf.getMessage());
		}
		
		//전체출력
		vm.printAll();
		bm.printAll();
		
	}
}
