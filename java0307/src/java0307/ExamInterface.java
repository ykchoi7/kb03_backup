package java0307;

public class ExamInterface {
	public static void main(String[] args) {
		SwimStudent s1 = new SwimStudent("김평형", 21, "체육과");
		System.out.println(s1);
		s1.swim();	//swim이라는 메소드를 아래에서 정의해준대로 출력됨
		
		SwimCar c1 = new SwimCar("소나타 2022", "승용");
		c1.swim();
		
		//수영할 수 있는 모든 애들을 부르기 (배열로)
		Swimmable[] sarr = new Swimmable[2];
		sarr[0] = s1;
		sarr[1] = c1;
		for (int i = 0; i < sarr.length; i++) {
			sarr[i].swim();
		}
		
//		sarr[1].swim(); // .뒤에 swim메서드만 뜨는 이유? sarr이 Swimmable 이라는 데이터타입이기 때문에 그 안에 있는 swim() 메서드만 뜨는 것!
//		//다른 메서드 쓰고 싶다면? -> 강제 형변환 시키기!
//		Car cc = (Car)sarr[1];
//		cc.model;
//		cc.type;
//		//결국, 모든 메서드를 쓰고 싶다면? -> SwimCar로 변환해주기
//		SwimCar cc1 = (SwimCar)sarr[1];
//		cc1.model;
//		cc1.type;
//		cc1.swim();

	}
}

interface Swimmable {   //수영 할 수 있는 객체가 가져햐하는 타입
	void swim();
}


//수영가능한 차
class Car {
	String model, type;	//model = 소나타, 제네시스 등 / type = 승용, 화물, 버스
	public Car(String model, String type) {
		this.model = model;
		this.type = type;
	}
}

//차가 수영가능하다를 정의 -> 위에 SwimCar를 먼저 정의하기!!
class SwimCar extends Car implements Swimmable {
	public SwimCar(String model, String type) {
		super(model, type);
	}

	@Override
	public void swim() {
		System.out.println("수중 프로펠러 가동");
	}
}

//=> 차를 정의하고, 차가 수영가능하다를 추가 정의하기 위해 implements Swimmable 도 정의를 하는것



//수영가능한 학생
//빨간줄 나오는 곳에 커서 대고 있으면 add implements 뜬다
class SwimStudent extends Student implements Swimmable {
//implements Swimmable 까지 작성하는 이유? -> 수영 가능한 사람들만 다 뽑을 수 있어서
	
	public SwimStudent(String name, int age, String jeongong) {
		super(name, age, jeongong);
	}

	@Override  //Annotation - 있어도 되고 없어도 되고
	public void swim() {
		System.out.println("평형으로 수영하기");
	}
	
}