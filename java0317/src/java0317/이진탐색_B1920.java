package java0317;

import java.util.Arrays;
import java.util.Scanner;

//원하는 정수 찾기
public class 이진탐색_B1920 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //정렬한 수 개수
		int[] A = new int[n]; //주어진 정수 입력받을 배열
		
		//배열에 저장
		for (int i = 0; i < n; i++) {
			A[i] = sc.nextInt();
		}
		Arrays.sort(A); //배열 정렬
		
		//m개의 수 입력받기
		int m = sc.nextInt(); //찾으려는 수의 개수
		int[] S = new int[m];
		for (int i = 0; i < m; i++) {
			boolean find = false; //찾았는지 아니었는지 확인하는 배열 (false로 초기값 설정)
			S[i] = sc.nextInt(); //있는지 없는지 확인해야하는 값들을 새로운 배열로 받아줌
			
			//이진탐색 시작
			int start = 0;
			int end = A.length-1; //end인덱스는 마지막수에서 하나뺀 인덱스로 표시해줘야 한다
			
			while (start <= end) { //start값이 end보다 작거나 같을 때까지 반복
				int midi = (start+end)/2;
				int midv = A[midi]; //midi도 결국 인덱스의 값을 나타내기 때문에 원래 배열의 midi번째 값을 새로운 변수에 넣어줘야 한다
				if (S[i] < midv) { //midi보다 왼쪽에 위치하면
					end = midi-1;
				} else if (S[i] > midv) { //midi보다 오른쪽에 위치하면
					start = midi+1;
				} else {
					find = true;
					break;
				}
			}
			
			if (find) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}		
	}
}
