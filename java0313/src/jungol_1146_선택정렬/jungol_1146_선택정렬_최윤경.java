package jungol_1146_선택정렬;

import java.util.Scanner;

public class jungol_1146_선택정렬_최윤경 {

	private static void swap(int[] arr, int i, int min) {
		int temp = arr[i];
		arr[i] = arr[min];
		arr[min] = temp;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i < n-1; i++) {  //마지막 값은 끝까지 계산하지 않아도 자연 정렬됨
			int min = i;
			for (int j = i+1; j < n; j++) {
				if (arr[j] < arr[min])
					min = j;
			}
			swap(arr, i, min); //swap은 list에서도 사용가능
			for (int idx : arr) {
				System.out.print(idx + " ");
			}
			System.out.println();
		}
	}
}
		
		//각 실행마다 결과 출력
//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < arr.length; i++) {
//			sb.append(arr[i] + " ");
//		}
//		System.out.println(sb.toString());
		
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + " ");
//		}
//		System.out.println();
