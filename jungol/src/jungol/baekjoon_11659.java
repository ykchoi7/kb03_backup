package jungol;

import java.util.Scanner;

public class baekjoon_11659 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
//		int[] arr = new int[N];
//		int[] d = new int[M];
		
		int[] arr = new int[N+1];
		int sum = 0;
		for (int i=1; i<=N; i++) {
			sum += sc.nextInt();
			arr[i] = sum;
			//nextInt는 공백 기준으로 다음 수로 넘어감
			//새로운 sum 1번째 방에 5 들어감 -> 5+다음수4 가 2번째 방에 들어감 -> 9+다음수3 가 3번째방에 들어감
			//=> 이렇게 arr배열이 생성됨
		}
		
		for (int i = 0; i < M; i++) {
			int answer = 0;
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(arr[b] - arr[a-1]);
		}
	}
}
		
//		int i = 1;
//		int j = 1;
//		int sum = 0;
//			
//		for (int i1=1; i1<arr.length; i1++) {
//			for (int j1 = 1; j1 < arr.length; j1++) {
//				sum += i1 + (i1+j1);
//				if (i1 == j1) sum++;
//				}
//			}
//		
//		System.out.println(sum);
//	}
//}