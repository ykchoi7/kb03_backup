package java0307;

public class Person {

	private String name;
	private int age;

	public Person(String name, int age) {  //name 누르고 ctrl+1 -> all parameters 하면 자동으로 생성됨
										   //기본생성자를 만들지 말지 정해야함 Person()와 같이 변수 딱히 정하지 않는 생성자
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "name=" + name + ", age=" + age;
	}
	
}
