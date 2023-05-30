package java0308;

public class Circle extends Shape {

	private int radius;

	public Circle(int x1, int y1, int radius) {
		super(x1, y1);
		this.radius = radius;
	}

	//getter/setter
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
	
}
