package 비디오도서대여점관리;

public class NumberNotFoundException extends Exception {

	private int number;

	public NumberNotFoundException(int number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return "number 중복" + number;
	}

}
