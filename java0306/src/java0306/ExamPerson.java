//test용
package java0306;

public class ExamPerson {

	public static void main(String[] args) {
		Person p = new Person();  // = 등호가 있으면 오른쪽 항이 먼저 실행되고 그걸 왼쪽 변수에 저장
		p.name = "홍길동";
		p.age = 30;
		//p.printInfo();  //Person 클래스에서 printInfo()를 정의해줬기 때문에 여기서 따로 sysout할 필요 없음
		//System.out.println(p.name + "의 나이는 " + p.age);
		
		//Person class에서 private으로 변수가 설정되었을 경우
//		Person p = new Person();
//		p.setName("홍길동");
//		p.setAge(30);
//		p.printInfo();
//		
//		System.out.println(p.getName()+"의 나이는 "+p.getAge());
		
		System.out.println(p);
		System.out.println(p.toString());
		//-> 같은 결과값이 나옴 (printInfo()와 달리 p만 넣어주면 리턴값이 나온다)
		
		
		//----------------------------------
		
		Person p2 = new Person();  // string literal은 heap공간에 만들어지는게 아님
		p2.name = "김길동";
		p2.age = 32;
		System.out.println(p2.name + "의 나이는 " + p2.age);
		
		//private으로 변수가 설정되었을 경우
//		Person p2 = new Person();
//		p2.setName("김길동");
//		p2.setAge(32);
//		p2.printInfo();
//		System.out.println(p2.getName() + "의 나이는 " + p2.getAge());
	}
}
