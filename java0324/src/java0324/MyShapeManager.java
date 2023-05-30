package java0324;

import java.util.ArrayList;
import java0324.vo.MyShape;
//MyLine이 다른 패키지에 있으면 MyLine import 해줘야 함

public class MyShapeManager {
	
	private ArrayList<MyShape> arr = new ArrayList<>();
	//대표타입 MyShape으로 저장해야 다형성이 허용됨 (MyLine, MyRect 등으로 데이터 타입이 바뀌어도 계속 추가 가능)
	
	//각 타입별로 저장하는게 오버로딩
	public void add(MyLine ml1) {
		arr.add(ml1);
	}
	
	public void add(MyRect mr1) {
		arr.add(mr1);
	}
	
	public void add(MyCircle mc1) {
		arr.add(mc1);
	}

	public int getCount() {
		return arr.size();
	}

	public void printAll() {
		System.out.println("**전체출력**");
		for (MyShape myShape : arr) {
			System.out.println(myShape.toString()); //자식클래스의 모든 것을 불러온다
		}
	}
	
	//하나의 타입을 반환할 때
	public java0324.vo.MyShape findByPosition(int x1, int y1) {
		
		for (MyShape myShape : arr) {
			if (myShape.getX1() == x1 && myShape.getY1() == y1)
				//equals 연산을 사용하는 건 객체와 비교할 때, int타입은 연산자를 사용
				return myShape;
		}
		return null; //못 찾았을 때 null 호출
	}
	
	//arraylist 형태로 반환할 때 (여러개 타입 반환할 때)
//	public ArrayList<java0324.vo.MyShape> findByPosition(int x1, int y1) {
//		ArrayList<MyShape> answer = new ArrayList<>();
//		
//		for (MyShape myShape : arr) {
//			if (myShape.getX1() == x1 && myShape.getY1() == y1)
//				//equals 연산을 사용하는 건 객체와 비교할 때, int타입은 연산자를 사용
//				answer.add(myShape);  //arraylist형태가 아니라면 그냥 return myShape;
//		}
//		return null; //못 찾았을 때 null 호출
//	}
}
