package 워크샵;

import java.util.ArrayList;

public class BookManager {

	public ArrayList<MyBook> arr = new ArrayList<>();
		
	//등록
	public void add(MyBook mb1) throws IsbnExistException{
		//isbn 중복검사
		for (MyBook myBook : arr) {
			//같은 ISBN이 있으면 예외 발생
			if (myBook.getIsbn() == mb1.getIsbn())
				throw new IsbnExistException();
		}
		//등록된 모든 도서의 ISBN과 중복되지 않는다면 등록
		arr.add(mb1);
	}
		
	public void add(MyMagazine mm1) throws IsbnExistException{
		arr.add(mm1);
	}
		
	//검색
	public int getCount() {
		return arr.size();
	}

	public MyBook findByIsbn(int isbn) throws IsbnNotFoundException {
		for (MyBook myBook : arr) {
			if (myBook.getIsbn() == isbn) //isbn 찾으면 주소반환
				return myBook;
		}
		
		throw new IsbnNotFoundException(isbn); //isbn 못 찾으면 예외 발생
	}
	
	//수정
	public void update(MyBook mb1) throws IsbnNotFoundException {
		MyBook findBook = findByIsbn(mb1.getIsbn());
		findBook.setPrice(mb1.getPrice());
		findBook.setTitle(mb1.getTitle());
		findBook.setChulpansa(mb1.getChulpansa());
		if (findBook instanceof MyMagazine) { //잡지 타입이면 아래 코드를 추가로 실행해야 한다
			MyMagazine j = (MyMagazine) findBook;
			MyMagazine bj = (MyMagazine) mb1;
			j.setTerm(bj.getTerm());
			j.setNumber(bj.getNumber());
		}
	}
	
//	public void update(MyMagazine mm1) {
//		arr.update(mm1);
//	}
//	위에 수정에서 다 설정해두었기 때문에 따로 안 만들어도 됨
	
	//삭제
	public void delete(int isbn) throws IsbnNotFoundException {
		MyBook findBook = findByIsbn(isbn);
		int index = -1;
		for (int i = 0; i < arr.size(); i++) {
			MyBook book = arr.get(i);
			if (book.getIsbn() == isbn) {
				index = i;
				break;
			}
		} //end for
		
		if (index == -1)
			throw new IsbnNotFoundException(isbn); //없는 isbn이면 예외발생
		arr.remove(index);
	}
}
