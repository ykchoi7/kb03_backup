package java02;

public class ExamArray {

	public static void main(String[] args) {
		int [] arr;    //int 배열 선언
		String [] r; //string 배열 선언
		
		arr = new int[3];
		System.out.println(arr);
		
		int[] arr2 = new int[3]; //초기화
		System.out.println(arr2); //debug할 때 행숫자 더블클릭하면 여기를 breakpoint로 지정한다는 것
		arr2[0] = 100;
		arr2[1] = 200;
		arr2[2] = 300;
		System.out.println("arr2의 길이는 " +arr2.length);
		
		//선언하고 아무것도 정의하지 않았을 때
		int [] arr3 = null;
//		System.out.println(arr3);  -> arr3 오류 발생 (초기화되지 않았다) / 그래서 보통 처음엔 null값 입력
		System.out.println(arr3);

	}

}
