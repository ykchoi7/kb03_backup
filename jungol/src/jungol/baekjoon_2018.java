package jungol;

import java.util.Scanner;

public class baekjoon_2018 {

	public static void main(String[] args) {
		//N -> 목표 합
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
//		int[] arr = new int[N];
//		
//		int s = sc.nextInt();
//		int e = sc.nextInt();
		
		int s = 1;
		int e = 1;
		int sum = 1;
		int count = 1;
		
		while (s != N) {		//s로 해도 되고 e로 해도 된다!
			if (sum == N) {
				count++;
				e++;
				sum = sum + e;
			} else if (sum < N) {
				sum = sum + e;
				e++;
			} else if (sum > N) {
				sum = sum - s;
				s++;
			}
		}
		System.out.println(count);
	}
}
		
		
//		내 코드
//		while (arr[s] == N) {
//			if (sum == N) {
//				sum = sum - arr[s];
//				count++; s++; e++;
//			} else if (sum < N) {
//				sum = sum + arr[e];
//				e++;
//			} else if (sum < N) {
//				sum = sum - arr[s];
//				s++;
//			}
//		}
//		System.out.println(count);
//	}
//}
