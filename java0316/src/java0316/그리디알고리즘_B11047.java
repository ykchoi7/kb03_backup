package java0316;

import java.util.Scanner;

//동전 개수의 최소값 구하기
public class 그리디알고리즘_B11047 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //동전수
		int k = sc.nextInt(); //목표금액
		int[] A = new int[n]; //동전 저장할 배열 생성
		
		for (int i = 0; i < n; i++) {
			A[i] = sc.nextInt(); //입력받은 동전 금액을 배열에 저장
		}
		
		int count = 0; //동전갯수 count
		for (int i = n-1; i >= 0; i--) { //큰 수의 동전 금액부터 살펴봐야하기 때문에 역행으로 진행
			if (A[i] <= k) {
				count += (k/A[i]); //count에 목표금액을 i번째 요소로 나눈 몫을 넣어줌
				k = k%A[i]; //그리고 k에는 k를 나눈 나머지를 넣어줌
			}
		}
		System.out.println(count);
	}
}
