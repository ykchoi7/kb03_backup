package java0324;

import java0324.vo.MyShape;

public class MyRect extends MyShape {

	private int width;
	private int height;

	public MyRect(int x1, int y1, int width, int height) {
		super(x1, y1);
		this.width = width;
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return super.toString() + ", width=" + width + ", height=" + height;
	}
	
	//그리기 동작을 위한 부분
	public String draw() {
		return "Rect: " + toString();
	}
	
}
