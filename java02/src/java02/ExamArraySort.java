package java02;

import java.util.Arrays;
import java.util.Random;

public class ExamArraySort {
	public static void main(String[] args) {
		// 10개의 난수를 저장, 정렬
		Random r = new Random(100);  //기준 숫자를 지정해주면 나오는 난수도 동일
		// 10개의 난수를 저장
		int[] arr = new int[10];
//		System.out.println(arr.length); //10
		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(100);  //0~99까지의 난수
		}
		//출력
		for (int i:arr) {
			System.out.println(i);
		}
		//오름차순 정렬 (작은수에서 큰수 순으로 정렬) - 다음 숫자랑 비교해서 수가 더 크면 뒤로 오게 표현
//		for (int i = 0; i < arr.length-1; i++) {
//			for (int j = 0; j < arr.length-1-i; j++) {  
										  //매번 다 비교하는 것이 아니라 마지막으로 비교했던 수를 빼주면 비교 횟수를 줄일 수 있음
//				if(arr[j] > arr[j+1]) {   //-> 예를 들어, 2번째 수가 3번째 수보다 크다면
//					int temp = arr[j+1];
//					arr[j+1] = arr[j];
//					arr[j] = temp;
//				}
//			}
//		}
		Arrays.sort(arr);  //정렬시켜주는 메소드 Arrays.sort();
		//출력
		System.out.println("정렬 후");
		for (int i:arr) {
			System.out.println(i);
		}
	} //end main
}
