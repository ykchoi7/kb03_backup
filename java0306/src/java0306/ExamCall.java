//**중요**//

package java0306;

public class ExamCall {
	public static void main(String[] args) {
		int a = 100;
		change(a);  // ctrl+ . -> ctrl+1 메서드 정의 생성
		System.out.println("a = " + a);  //답은 100 -> 왜 change했는데 200이 아닌 100이 나올까?
										// 자바에서는 기본값은 고정이고 a에 저장된 값이 복사되어 넘어간 것 -> 기본 a는 변하지 않음
		
		int[] arr = new int[] {100,200,300};	//arr에는 저장된 주소가 들어가 있음
		change2(arr);
		System.out.println(arr);  //[I@626b2d4a
		System.out.println("arr[1] = " + arr[1]);	//답은 900 -> 왜 얘는 값이 바뀌었을까? 
													//arr 주소의 첫번째 방을 가리켜서 이 안에 값을 재부여 -> 그래서 결과가 바뀌어서 나옴
	}

	private static void change2(int[] arr) {
		arr[1] = 900;
	}

	private static void change(int a) {
		a = 200;
	}
}
