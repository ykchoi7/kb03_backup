package 백준_2750_수정렬_버블정렬;

import java.util.Scanner;

public class 백준_2750_수정렬_버블정렬_최윤경 {
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i < n-1; i++) {
			for (int j = n-1; j > i; j--) {
				if(arr[j-1] > arr[j]) //배열순서상 1번째 값이 2번째 값보다 크다면
					swap(arr, j-1, j); //1번째값과 2번째 값을 교체
			}
		}
		
		//결과출력
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}
		System.out.println();
	}
}	
//	private static void swap(int[] arr, int i, int j) {
//		int temp = arr[i];
//		arr[i] = arr[j];
//		arr[j] = temp;
//	}

