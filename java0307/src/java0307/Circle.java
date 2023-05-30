package java0307;

public class Circle extends Shape {

	private int radius;

	public Circle(int x1, int y1, int radius) {
		super(x1, y1);
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return super.toString() + ", radius=" + radius;
	}

	@Override
	public void draw() {
		System.out.println("원그리기");
	}
}
