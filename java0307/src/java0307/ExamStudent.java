package java0307;

public class ExamStudent {
	public static void main(String[] args) {
		//학생
		Student st1 = new Student("김학생", 20, "컴공");
		System.out.println(st1);
		
		//직원
		Emp e1 = new Emp("김대리", 32, "영업부");
		System.out.println(e1);  //name:김대리, 나이:32, 부서-영업부
		
		//다형성 - 객체의 다형성, 메서드의 다형성
		//부모는 하나지만 여기에 자식인 st1를 넣건, e1을 넣건 모두 출력 가능하다
		Person p = st1;  //st1의 주소값을 p에 넣을 수 있다
		p = e1;			 //e1의 주소값을 p에 넣을 수 있다
		p.getAge();		 //p.변수타입내 멤버들까지만 가능
		p.getName();
//		p.getJeongong(); //이건 불가능 -> why? p는 Person의 속성들에만 접근 가능하기 때문
		
		//상속을 진행하는 이유 - 부모 클래스에 통합된 배열로 만들어서 관리가 용이하도록 만들기 위해, 하위 클래스는 다 섞어도 출력 가능
		Person[] pa = new Person[5];
		pa[0] = new Student("김", 20, "컴공");
		pa[1] = new Student("박", 20, "사회학");
		pa[2] = new Emp("김대리", 32, "영업");
		pa[3] = new Emp("박과장", 35, "개발");
		pa[4] = new Student("황", 21, "SW공학");
		System.out.println(pa[0].toString());
		System.out.println(pa[1].toString());
		System.out.println(pa[3].toString());
	}
}
