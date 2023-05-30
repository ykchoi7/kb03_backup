package java0308;

import java.util.Arrays;

public class ExamSort {

	public static void main(String[] args) {
		//배열정렬
		int[] arr = new int[] {3,7,1,4,5};
		Arrays.sort(arr);			//내림차순 정렬
		System.out.println(arr);	//주소값 출력
//		for (int i : arr) {  		//foreach로 각각 찍어줘야함
//			System.out.println(i);
//		}
		
		//문자열로 변환
		String s = Arrays.toString(arr);
		System.out.println(s);
	}
}
