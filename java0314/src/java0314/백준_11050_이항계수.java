package java0314;

import java.util.Scanner;

public class 백준_11050_이항계수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //총 개수
		int k = sc.nextInt(); //선택개수
		int[][] D = new int[n+1][n+1];	//왜 n+1일까?
										//n+1로 크기를 정하면, 인덱스 값을 n까지 사용 가능 
										//인덱스를 원하는대로 출력하기 위해 배열을 n+1 크기로 만들어주는것
		
		for (int i = 0; i <= n; i++) {	//왜 n보다 같거나 작아야할까?
			D[i][1] = i;				//배열을 int[n]으로 설정했다면 기본적으로는 인덱스 번호 0~n-1까지 반복하는게 맞음 -> i<n으로 표시
			D[i][0] = 1;				//그러나, 배열을 int[n+1]로 설정했을 경우 인덱스 번호가 0~n까지 존재 -> i<=n으로 표시
			D[i][i] = 1;
		}
		
		for (int i = 2; i <= n; i++) {		//등호랑 시작점에 대한 이해 필수!
			for (int j = 1; j < i; j++) {
				D[i][j] = D[i-1][j] + D[i-1][j-1];
			}
		}
		System.out.println(D[n][k]);
	}
}
