
public class Exam예외2 {

	public static void main(String[] args) {
//		int[] arr = {1,3,5};
//		System.out.println("arr[3] = " + arr[3]);
//		System.out.println("OK");
		
		//NullPointerException 만드는 코드
		int[] arr2 = null;
		System.out.println(arr2.length);
		//null값이 들어가 있는 것은 길이를 구할 수 없다 - 컴파일 시 오류는 없기 때문에 실행할 때 오류 발생 확인 가능

		
		String s = null;
		if (s != null)
			System.out.println(s.length());
	}
}
