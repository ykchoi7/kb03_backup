package java0320;

public class Exam재귀 {
	static int max = 10;
	public static void main(String[] args) {
		// 1~10까지의 합을 재귀함수를 통해 계산
		// 1+2+...+10
		// 10+9+...+1
		int sum = sumRecursive(1, 10);  //(start, end)
		System.out.println(sum);
		//파라미터를 1개만 이용한 재귀호출함수 (1~10까지의 합)
		int sum2 = sumRecursive2(10);
		System.out.println(sum2);
		//0~10 사이 짝수의 합을 구하는 재귀함수를 작성
		int sum3 = sumRecursive3(10);
		System.out.println(sum3);
		//0~10까지 짝수의 합, 또는 홀수의 합을 구하는 재귀함수
//		int sum4 = sumRecursive4(10,2,0);
//		int sum4 = sumRecursive4(10,2,1);
		int sum4 = sumRecursive4(10, 3, 0); //3의 배수의 합
		System.out.println(sum4);
	}
	
	//기본형식
//	메서드() {
//		if 조건 return xx;
//		if 조건 return xx; --else문 따로 쓸 필요 없음
//		return ; 
//	}
	
	private static int sumRecursive4(int start, int i, int num) { //target, num, mod로 변수설정
		if (start == 0) return 0;  //종료조건 - 어디까지 내려갈지 멈춰주는 조건, 5에서 멈추고 싶으면 start==5라는 종료 조건 설정
		if (start%i == num)
			return start + sumRecursive4(start-1, i, num);
		return sumRecursive4(start-1, i, num);
	}
	
	private static int sumRecursive3(int i) {
		//종료조건
		if (i==0) return 0; 
		if (i%2 == 0) //짝수일때
			return i + sumRecursive3(i-2);
		return i + sumRecursive3(i-1);
	}

	private static int sumRecursive2(int end) {
		// 종료조건
		if (end == 0)
			return end;
		return end + sumRecursive2(end-1);
	}

	private static int sumRecursive(int start, int end) {
		// 종료조건
		if (start == end)
			return start; //10 반환
		
		//start가 end가 될 때까지 증가
		return start + sumRecursive(start+1, end);
	}
}
