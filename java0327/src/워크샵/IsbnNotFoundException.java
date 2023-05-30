package 워크샵;

public class IsbnNotFoundException extends Exception {

	private int isbn;

	public IsbnNotFoundException(int isbn) {
		this.isbn = isbn;
	}

	@Override
	public String getMessage() {
		return "책 찾을 수 없음: isbn= " + isbn;
	}

}
