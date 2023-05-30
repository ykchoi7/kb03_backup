package java0306;

import java.util.Date;

public class ExamPerson2 {
	public static void main(String[] args) {
		Person p1 = new Person("홍길동", 30);
		//p1.printInfo();			//class Person에서 정의해준대로 "이름 의 나이는 나이 이다"로 나옴
		System.out.println(p1); //저장위치 값이 나옴

		Person p2 = new Person(32, "김길동");
		//p2.printInfo();
		System.out.println(p2);
		
//		//import를 하기 전
//		java.util.Date d = new java.util.Date();
//		java.util.Date d2 = new java.util.Date();
//		
//		//import를 한 후
//		Date d = new Date();
//		Date d2 = new Date();
	}
}
