package java0306;

// /**를 JavaDoc이라고 부름
// <br> 줄바꿈 기호
//설명하고 싶은 클래스 바로 윗 줄에서 /**+enter 누르고 설명 기입
/**
 * 사람에 대한 기본 정보 정의용 <br>
 * 이름, 나이 정의
 * @author student
 *
 */
public class Person {   //VO클래스에 해당
	String name;
	int age;
	
//	private String name;  //private을 설정하면 ExamPerson 클래스에서의 변수에 오류 발생 (클래스가 다르기 때문)
//	private int age;
	
	public Person() {   //기본 생성자 생성
	}
	
	/**
	 * 이름과 나이를 입력받아 초기화
	 * @param name 이름
	 * @param age 나이
	 */
	//클래스명과 동일하면 return 타입을 없애도 된다
	public Person(String name, int age) {  //한 중괄호를 block(영역)이라고 함
		System.out.println("this = " + this);
		//멤버변수 = 값
		this.name = name; //둘다 String name의 name을 가리키기 때문에 값이 저장이 안됨 -> this라는 내장 변수를 붙임
						  //객체마다 자기 자신을 가리킴
		this.age = age;
	}

//	public Person(int a, String n) {
//		age = a;
//		name = n;
//	}
	
	public Person(int age, String name) {
		this(name, age);  //다른 생성자를 호출하는 this
	}
	
	//private으로 변수 설정했을 경우 setAge, setName 정의
	
	public void setAge(int age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
	
	
	//return 타입 - void (리턴값이 없음) / 리턴이 있을 때는 데이터 타입으로 입력해줌 (string, int, double) 
//	void printInfo() {  //제안자
//		System.out.println(name + "의 나이는 " + age);  //검색 - 메서드 내부 변수로, 없으면 멤버변수 검색 -> 없으면 오류
//		
	
	//리턴값이 있는 경우
	public String toString() {	//toString() 앞에 public을 꼭 붙여야함 -> object에서 무조건 상속받기 때문
		return (name + "의 나이는 " + age);
	}
}





