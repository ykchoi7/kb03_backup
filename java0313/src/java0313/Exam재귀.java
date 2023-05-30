package java0313;

public class Exam재귀 {
	
	//재귀호출 - 훨씬 복잡한 로직의 반복이 가능
	public static void main(String[] args) {
		// 팩토리얼 = 5*4*3*2*1
		int ans = factorial(5);
		System.out.println(ans);
	}

	private static int factorial(int i) {
		int ans = 0;
	
		if (i>0) {
			ans = i * factorial(i-1);
		} else {  //i==0
			ans = 1;  //0! =1
		}
		return ans;
	}
	
//	
//	//*재귀함수의 기본 구조 작성 TIP
//	private static int factorial(int i) {
//		//종료조건 검사 -> true일 때 return값 기입
//		if(i == 0) return 1; //if문에 return값이 없으면 else로 꼭 써줘야하지만, return이 있는 경우 else 쓸 필요 없음
//		//종료 아니면 로직처리, 재귀함수 실행
//		return i * factorial(i-1);
//	}
}
