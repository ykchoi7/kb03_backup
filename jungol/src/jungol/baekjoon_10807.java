package jungol;

import java.util.Scanner;

//백준_B10807_개수세기
//백준_B10807_개수세기_최윤경

public class baekjoon_10807 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();   //첫째줄 정수의 개수 N 입력
		int[] arr = new int[N]; //int의 배열을 따로 만드는게 좋음 -> 값 저장용
		//System.out.println(N);
		
		//
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int v = sc.nextInt();  //찾으려고 하는 정수 v 입력
		
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			int j = arr[i];
			if (j==v) count++;
		//++j / j++ 의 차이
		//++j는 연산하기 전에 +1
		}
		
		System.out.println(count);
	}
}
