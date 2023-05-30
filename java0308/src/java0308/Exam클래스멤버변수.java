package java0308;

public class Exam클래스멤버변수 {

	public static void main(String[] args) {
		//클래스멤버변수는 클래스명.j 이렇게 표현하는 것이 좋음 (객체가 아닌 클래스 이름으로 접근하기!)
		AA.j = 300;
		
		AA a1 = new AA();  //new AA() - 새로운 객체를 만들었다 = 새로운 인스턴스를 만들었다
		//클래스변수명.j로 표현하는 것은 비추천
		a1.i = 100;
		a1.j = 400;
		
		AA a2 = new AA();
		a2.i = 200;
		
		System.out.println(AA.j);
	}
}


class AA {
	int i;  		//AA의 인스턴스 변수 -> 인스턴스를 만든 후 사용가능 (여러개 생성 가능)
	static int j;	//클래스 멤버 변수 -> 클래스 영역에 딱 한개만 존재 (AA.j의 형태 / 하나만 생성 가능)
					//static 메서드는 무조건 클래스 안에 있어야 하기 때문에 무관해도 AA안에 있는것
	
	void prn() {	//멤버 메서드 
		System.out.println(i +","+ j);
	}
	
	static void prn2() {
		AA a1 = new AA();
		System.out.println(a1.i +","+ j);
		System.out.println("prn2()");
		//static때문에 i에 오류 발생 -> static prn2()는 클래스 영역에 있고 일반 int i는 stack 영역에 쌓이기 때문에 저장된 공간이 아예 다름
		//prn2()에서 prn() 호출 불가
	}
}
