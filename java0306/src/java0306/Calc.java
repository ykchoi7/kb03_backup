package java0306;

// 선언부의 선언
public class Calc {
	
	//기본 생성자 - 클래스명과 동일, 리턴값,파라미터 모두 없어도됨
	public Calc() {
		System.out.println("생성"); //compiler
	}
	
	public int plus(int i , int j) {  //i, j는 로컬변수
		return i+j;
	}
	//int 와 int[]배열은 완전히 다른 타입 (호환 안됨)
	
	public double plus(double x , double y) {
		return x+y;
	}

	//각각의 타입이 다를 경우 -> 순서에 따라 다른 것이 된다
//	public int plus(double x , int y) {  //저장되는 것이 public_int_double_int
//		return int(x+y);
//	}
//	
//	public int plus(int x , double y) { //저장되는 것이 public_int_int_double
//		return int(x+y);
//	}

	public int minus(int i, int j) {
		return i-j;
	}


	public double divide(double i, double j) {
		return i/j;
	}
}