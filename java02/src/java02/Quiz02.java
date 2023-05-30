package java02;

public class Quiz02 {

	public static void main(String[] args) {
		int jumsu = 100;
		
//		String jikup = "sw" //사원 "dr" 대리 등등 한국어를 발음하는 영어 그대로 작성
		switch (jumsu/10) {
		case 10:
		case 9:
			System.out.print("A");  //break가 없기 때문에 아래 결과가 계속 출력됨
		case 8:
			System.out.print("B");
		case 7:
			System.out.print("C");
		default:
			System.out.print("F");
			
		}
	}
}
