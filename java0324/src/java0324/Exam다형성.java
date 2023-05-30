package java0324;

import java0324.vo.MyShape;

public class Exam다형성 {

	public static void main(String[] args) {
		// 부모타입 변수 = new 자식타입1();
		// 부모타입 변수 = new 자식타입2();
		MyShape ms1 = new MyLine(1,1,2,2);
		
		//타입확인
		System.out.println(ms1 instanceof MyRect); //ms1이 MyRect타입인지 물어보는 것 -> False
		System.out.println(ms1 instanceof MyLine); //True -> True여야지만 casting했을 때 문제없이 진행
		
		if (ms1 instanceof MyLine) {
			MyLine ml1 = (MyLine) ms1;
			System.out.println("x2=" + ml1.getX2());
		}  //upcasting은 무조건 가능하지만 downcasting할 때는 꼭 같은 타입이어야 한다!!!
		
//		MyLine ml1 = (MyLine) ms1; //MyLine타입이라고 명시적인 형 변환을 해주어야 한다
//		int x2 = ml1.getX2();
//		System.out.println(x2);
//		=> compile오류는 없지만 실행하면 오류 발생, 타입이 다를 때 downcasting이 안되기 때문
		
		MyShape ms2 = new MyLine(1,1,2,2);
		System.out.println(ms2 instanceof MyRect); //false
		System.out.println(ms2 instanceof MyLine); //true
		System.out.println(ms2 instanceof MyShape); //Up-Casting이기 때문에 항상 true

	}
}
