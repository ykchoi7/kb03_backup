package java0308;

import java.util.ArrayList;
import java.util.Collections;

public class ExamSort2 {

	public static void main(String[] args) {
		// 내가 만든 클래스 정렬
		//1. 클래스가 Comparable 인터페이스 구현
		//2. Comparator 구현체 생성
		ArrayList<Person> pa = new ArrayList<>();
		pa.add(new Person("홍", 32));
		pa.add(new Person("김", 30));
		pa.add(new Person("박", 35));
		
		Collections.sort(pa);
		System.out.println(pa); //나이순으로 정렬되어 정렬 (List형태)
	}
}

class Person implements Comparable<Person>{  //implements comparable 기입하고, ctrl+space
											 //Person 빨간줄일 때 커서 대로 unimplement 클릭
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "name=" + name + ", age=" + age;
	}

	@Override
	public int compareTo(Person o) {
//		return this.age - o.getAge();	//(나의 나이 - o의 나이) 반환
		//오름차순 작성공식: this.변수 - 파라미터.변수
		return o.getAge() - this.age;
		//내림차순 작성공식: 파라미터.변수 - this.변수
	}	
}
