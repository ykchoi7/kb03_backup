package java0308;
/** 도형들의 공통 시작좌표 정의용 */
public class Shape {
	private int x1, y1; //변수 만들기
	//생성자 (Constructor)
	public Shape(int x1, int y1) {  //파라미터의 생성자
		this.x1 = x1;
		this.y1 = y1;
//		super(); //부모클래스의 기본생성자 호출
	}
	
	
	//getter, setter 메서드
	public int getX1() {
		return x1;
	}
	public void setX1(int x1) {
		this.x1 = x1;
	}
	public int getY1() {
		return y1;
	}
	public void setY1(int y1) {
		this.y1 = y1;
	}
	
	@Override
	public String toString() {
		return "x1=" + x1 + ", y1=" + y1;
	}
	
	
}
