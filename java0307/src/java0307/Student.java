package java0307;

public class Student extends Person{  //extends + 부모클래스 -> 확장
	
	private String jeongong;

	public Student(String name, int age, String jeongong) {
		super(name, age);	//부모클래스의 생성자를 호출 (기본생성자가 없어서 처음에는 오류 뜸)
							//super Person이라는 부모 클래스에서 호출시키기
		this.jeongong = jeongong;  //jeongong 클릭하고  ctrl+1 누르기 -> assign parameter
	}	
	
	public String getJeongong() {
		return jeongong;
	}
	
	public void setJeongong(String jeongong) {
		this.jeongong = jeongong;
	}
	
	@Override
		public String toString() {
			return super.toString() + ", jeongong="+ jeongong;  
			//Person(부모클래스)의 toString을 불러온다
		}
} //end class