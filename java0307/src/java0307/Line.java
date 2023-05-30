package java0307;

public class Line extends Shape {

	private int x2;
	private int y2;

	public Line(int x1, int y1, int x2, int y2) {
		super(x1, y1);
		this.x2 = x2;
		this.y2 = y2;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	@Override
	public String toString() {
		return super.toString() + ", x2=" + x2 + ", y2=" + y2;
	}
	
	//ctrl + space 눌러서 실행
	
	public void draw() {
		System.out.println("선그리기");  //draw()라는 메서드가 부모한테도 있지만 자식에서 재정의
	}

}
