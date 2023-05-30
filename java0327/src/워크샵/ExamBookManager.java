package 워크샵;

public class ExamBookManager {

	public static void main(String[] args) {
		BookManager bm = new BookManager();
		
		//등록
		try {
			bm.add(new MyBook("자바", 0000, 20000, "새빛출판사"));
			bm.add(new MyBook("코딩", 1111, 21000, "한빛출판사"));
			bm.add(new MyMagazine("IT", 2222, 15000, "매일경제", 1, 15));
			bm.add(new MyMagazine("글로벌", 3333, 17000, "매일경제", 3, 21));
			System.out.println("등록갯수 = " + bm.getCount());
		} catch (IsbnExistException e1) {
			e1.printStackTrace();
			System.out.println("등록오류: " + e1.getMessage());
		}
		
		//검색
		MyBook b = null;
        try {
            b = bm.findByIsbn(0000);
            System.out.println("검색성공;"+b.toString());
        } catch (IsbnNotFoundException e1) {
            e1.printStackTrace();
        }
        try {
            b = bm.findByIsbn(1111);
            System.out.println("검색성공:"+b.toString());
        } catch (Exception e) {
            System.out.println("미등록 도서:"+e.getMessage());
        }
        
        //수정
        try {
            b.setPrice(22000);
            bm.update( b );
        } catch (Exception e) {
            System.out.println("미등록 도서:"+e.getMessage());
        }
        
        //삭제
        try {
            b = bm.findByIsbn(2222);
            System.out.println("검색성공:"+b.toString());
            bm.delete(b.getIsbn());
            System.out.println("삭제성공:"+b.toString());
        } catch (Exception e) {
            System.out.println("미등록 도서:"+e.getMessage());
            //오류 발생할 때, getMessage()를 통해 오류 메세지 출력
        }
	}

}
