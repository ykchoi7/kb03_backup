package java0314;

import java.util.Scanner;

//nCr의 공식을 사용해서 반복문 작성
//nCr = n!/(n-r)!r!
public class 백준_11050_이항계수_단순반복문 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //총 개수
		int k = sc.nextInt(); //선택개수
		int[] D = new int[n+1];  //숫자별 팩토리얼 계산 결과를 담을 배열
		
		//D에 팩토리얼 계산 결과를 저장
		D[0] = 1;
		for (int i = 1; i <= n; i++) {
			D[i] = D[i-1] * i;  //i! 계산결과를 D배열에 저장
		}
		
		//팩토리얼 계산
		int ans = D[n] / (D[n-k]*D[k]);  //nCr 수식을 코드로 표현
		System.out.println(ans);
	} //end main -> 숫자가 커지면 long형 사용하기
}
