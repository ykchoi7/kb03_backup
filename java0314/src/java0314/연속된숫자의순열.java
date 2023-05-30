package java0314;

//문제
//[1,2,3] 입력
//결과
//[1,2,3]
//[1,3,2]
//[2,1,3]
//[2,3,1]
//[3,1,2]
//[3,2,1]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 연속된숫자의순열 {
	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt(); //입력 숫자 개수 n개
//		ArrayList<Integer> li1 = new ArrayList<Integer>();
//		
//		for (int i = 0; i < n; i++) {
//			int k = sc.nextInt();
//			li1.add(k);
//			System.out.println(li1);
//		}
//		
//		for (int i = 0; i < args.length; i++) {
//			Collections.swap(li1, i+1, i+2);
//			System.out.println(li1);
//		}

		//배열 - 스왑활용
		for (int i = 0; i <= 2; i++) {
			int[] arr = new int[] {1,2,3};
			int temp = arr[0];
			arr[0] = arr[0+i];
			arr[0+i] = temp;
			System.out.println(Arrays.toString(arr));
			temp = arr[1];
			arr[1] = arr[2];
			arr[2] = temp;
			System.out.println(Arrays.toString(arr));
		}
	}
}
