package java0307;

public class ExamPerson {
	public static void main(String[] args) {
		Person p1 = new Person("홍길동", 30);  //실행할 것을 먼저 작성하는게 편함
		Person p2 = new Person("김길동", 32);
		//먼저 실행값 입력하고 빨간줄 나오는 부분 누르고 ctrl+. -> ctrl+1
		System.out.println(p1);
		System.out.println(p2);
		
		//person을 여러개 담는 배열로
		Person[] pa = new Person[5];  //이렇게만 두면 만들어진 객체 0개 / 배열 객체만 만든 것
		System.out.println(pa[0]);    //null
		pa[0] = new Person("홍", 30);
		pa[1] = new Person("김", 32);
		System.out.println(pa[0]);
	}
}



/*
public class ExamPerson {
	public static void main(String[] args) {
		Person[] pa = new Person[5];
		pa[0] = new Person("홍",30);
		System.out.println(pa[0]);
	}
}
*/