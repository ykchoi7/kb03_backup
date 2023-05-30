package java0324;

//생성하고자 하는 Exception의 멤버 변수를 지정
public class ShapeNotFoundException extends Exception {

	private int x1;
	private int y1;

	public ShapeNotFoundException(int x1, int y1) {
		this.x1 = x1;
		this.y1 = y1;
	}
	@Override
	public String getMessage() { //오류 메시지 표시
		return "도형없음: x1=" + x1 + ", y1=" + y1; //직접 입력
	}
}

/*
 * 사용자 정의 예외를 반드시 처리하도록 하려면 Exception 상속
 * 사용자 정의 예외를 처리하지 않아도 되도록 하려면 RuntimeException 상속
 */