package 비디오도서대여점관리;

public class NumberExistException extends Exception {
	
	public NumberExistException() {
	}
	
	@Override
	public String toString() {
		return "관리번호 중복";
	}
}
