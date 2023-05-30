package java0307;

//추상 클래스
public class ExamShape {
	public static void main(String[] args) {
		//자바로 그림판 제작한다고 가정
		//관리 대상은 도형 정보 - 선, 사각형, 원형
		
//		선
//		Line(x1, y1, x2, y2)
//		사각형
//		Rect(x1, y1, width, height)
//		원
//		Circle(x1, y1, radius반지름)
		
		Shape[] sarr = new Shape[3];
		sarr[0] = new Line(1,1,3,3);
		sarr[1] = new Circle(2,2,5);
		
		Line l = new Line(1,1,3,3);
		l.draw(); //draw() 라는 기능도 모든 클래스에 있어야하기 때문에 Shape클래스에서 정의해줌
		
		Shape l1 = new Line(1,1,3,3);
		l1.draw();
		//실제 객체(Line)를 구현하는 draw()로 오버라이딩되기 때문에 Line의 draw가 작동함
		//추상 메서드를 하는 이유는 부모, 자식의 오타를 방지하고 표준name을 지정해주기 위함
		
	}

}
