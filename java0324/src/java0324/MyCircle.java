package java0324;

import java0324.vo.MyShape;

public class MyCircle extends MyShape {

	private int radius;

	public MyCircle(int x1, int y1, int radius) {
		super(x1,y1);
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

}

