package java0324.vo;

abstract public class MyShape implements MyDrawable{
//public class MyShape {

	
	private int x1;
	private int y1;

	//생성자
	public MyShape(int x1, int y1) {
		this.x1 = x1;
		this.y1 = y1;
	}
	
	//기본생성자도 만들어두기
	public MyShape() {
		// TODO Auto-generated constructor stub
	}

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
	
	//도형을 그리는 동작 - class도 abstract 여야 abstract 메서드 생성 가능
	abstract public String draw();
	//인터페이스에 draw메서드가 있으면 MyShape 자체에는 메서드 선언 안해줘도 된다

}
