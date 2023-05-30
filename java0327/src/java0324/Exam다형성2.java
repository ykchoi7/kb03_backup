package java0324;

public class Exam다형성2 {

	public static void main(String[] args) {
		D d1 = new D();
		System.out.println(d1 instanceof A); //T
		System.out.println(d1 instanceof B); //T
//		System.out.println(d1 instanceof C); //F(컴파일오류) - 직속 상속관계가 아니므로 false 출력
		System.out.println(d1 instanceof D); //T
	}
}

abstract class A{} //부모타입을 객체화하지 못하기 때문에 추상화를 진행
class B extends A{}
class C extends A{}
class D extends B{}


