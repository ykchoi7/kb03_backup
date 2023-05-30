package 워크샵;

public class IsbnExistException extends Exception {
	
	private int isbn;

	public IsbnExistException() {
		super("ISBN 중복"); //부모클래스인 exception 가져옴
	}

	@Override
	public String getMessage() {
		return "ISBN 중복: isbn= " + isbn;
	}
}
