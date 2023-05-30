package 비디오도서대여점관리;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

//해시맵으로 만드는 방법! (교재 p.529)
public class BookManager_해시맵사용 {
	
//	private HashMap<Integer, MyBook> map = new HashMap<>();
//	
//	public void add(MyBook mb1) throws NumberExistException {
//		MyBook myBook = map.get(mb1.getNumber());
//		if (myBook != null)
//			throw new NumberExistException();
//		map.put(mb1.getNumber(), mb1);
//	}
//	
//	
//	public int getCount2() {
//		Collection<MyBook> values = map.values();
//		int bookCount = 0;
//		for (MyBook myBook : values) {
//			if (myBook instanceof MyBook)
//				bookCount++;
//		}
//		return bookCount;
//	}
//	
//	//검색
//	public MyBook findByNumber(int number) throws NumberNotFoundException {
//		MyBook mb1 = map.get(number);
//		if (mb1 == null)
//			throw new NumberNotFoundException(number);
//		//비디오 타입이면 예외처리 시켜줘야 함
//		return (MyBook)mb1;
//	}	
//	
//	//전체출력
//	public void printAll() {
//		System.out.println("**전체출력**");
//		Collection<MyBook> values = map.values();
//		for (MyBook myBook : values) {
//			System.out.println(myBook);
//		}
//	}
	
	
	public ArrayList<MyBook> arr1 = new ArrayList<>(); 
	
	//등록
	public void add(MyBook mb1) throws NumberExistException {
		//중복검사
		for (MyBook myBook : arr1) {
			if (myBook.getNumber() == mb1.getNumber())
				throw new NumberExistException();
		}
		arr1.add(mb1);
	}
	
	//검색
	public MyBook findByNumber(int number) throws NumberNotFoundException {
		//중복검사
		for (MyBook myBook : arr1) {
			if (myBook.getNumber() == number)
				return myBook;
		}
		throw new NumberNotFoundException(number);
	}

	public int getCount() {
		return arr1.size();
	}

	//대여 수정
	public void update(MyBook mb1) throws NumberNotFoundException {
		MyBook findBook = findByNumber(mb1.getNumber());
		for (int i = 0; i < arr1.size(); i++) {
			mb1.getStatus();
			if (findBook.getStatus() == "대여가능")
				mb1.setStatus("대여중");
		}
	}
	
	//전체출력
	public void printAll() {
		System.out.println("**전체출력**");
		for (MyBook myBook : arr1) {
			System.out.println(myBook.toString());
		}
	}
}
