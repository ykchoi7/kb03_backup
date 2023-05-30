package java0308;

public class ExamShape {

	public static void main(String[] args) {
		//자바로 그림판 작성
		//만든 도형 정보를 저장하는 클래스
		//Line(x1, y1, x2, y2), Circle(x1, y1, radius)
		//공통 정보는 Shape(x1, y1)
		//Line extends Shape
		//Circle extends Shape
		Line l1 = new Line(1,1,3,3);
		System.out.println(l1);  //x1, y1 -> Line에서 toString을 재정의하기 전에는 부모클래스에 있는 toString만 불러온다
		
		
		//(오버라이딩)부모 변수에 자식 객체가 할당될 때 -> l1.Shape()
		Shape l2 = new Line(1,1,3,3);
		l2 = new Circle(2,2,5);
		System.out.println(l2);
		
		
		//객체의 다형성 활용을 왜 하는걸까?
		//삼각형, 사각형, 원을 다 따로 생성하면 일일히 수정 및 관리하기도 어렵고, 순서도 찾기가 어려움
		//데이터를 찾으려고 해도 삼각형클래스 돌리고, 사각형클래스 돌리고 하나하나 찾아야함
		//Shape이라는 같은 형태의 타입으로 만들어서 Shape에서만 for문 돌려서 찾고 수정, 관리하기가 쉬움!
		
		//메서드의 다형성
		//오버로딩 - 
		//오버라이딩 - 
	}

}
