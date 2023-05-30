package java0308;

public class Line extends Shape {

	private int x2;
	private int y2;

	public Line(int x1, int y1, int x2, int y2) {
		super(x1, y1);
		this.x2 = x2;
		this.y2 = y2;
	}

	
	//getter/setter
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
		return super.toString() + ", x2=" + x2 + ", y2=" + y2;  //부모꺼까지 끌어오기 위해 super.toString() 꼭 기입해주기
	}
	
}
