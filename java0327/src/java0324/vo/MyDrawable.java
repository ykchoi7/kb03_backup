package java0324.vo;

//인터페이스는 형용사를 쓴다
public interface MyDrawable {
	
//	public static final String name = "MyDrawable";
//	public static final 생략해도 된다. 모든 변수가 이 형태이기 때문
	String NAME = "MyDrawable";
	
	//인터페이스 내 모든 메서드는 자동으로 추상메서드로 선언된다, public abstract
	public String draw();
}
