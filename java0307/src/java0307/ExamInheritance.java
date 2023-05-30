package java0307;

public class ExamInheritance {
	public static void main(String[] args) {
		S s1 = new S("홍", 20, "컴공");  //내부 생성자를 만들어서 간편하게 표현
//		s1.name = "홍";
//		s1.age = 20;
//		s1.jeongong = "컴공";
		System.out.println(s1);
	}
}  //end class


//부모클래스 P - name, age 가지고 있음
class P{
	private String name;
	private int age;
	//private - 부모클래스에서 private을 설정하면 다른 클래스들에서 접근을 못함 (자식 클래스도)
	//protected - 상속관계의 클래스에서는 접근을 허용하고 외부 클래스에서 접근을 못하게 하고 싶은 경우 사용
	
	//private일 때는 접근이 안되기 때문에 생성자 메서드를 만들어서 접근 가능하게 함
	public P(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
		return name + "," + age;
	}
}


//자식클래스 S - jeongong 가지고 있음
class S extends P{  //P는 S를 상속받는다 (최상위 부모까지도 받을 수 있음), 그러나 상속 중에 빼는 건 안됨
	String jeongong;
	
	public S(String name, int age, String jeongong) {
		super(name, age);
		this.jeongong = jeongong;
	}

	public String toString() {
//		부모클래스에 접근 가능할 때(public)는 아래와 같이 작성
//		return "name = " + name + ",age = "+ age + ",jeongong = "+ jeongong;
		//자식클래스에 name이 없는지 메서드에서 찾기 -> 클래스 단위에서 찾기 -> 부모클래스에서 찾기 -> 부모의 부모클래스에서 찾기 ...
		return super.toString() + "," + jeongong;
		//super. -> 부모의 toString을 불러온다는 의미
	}
}
