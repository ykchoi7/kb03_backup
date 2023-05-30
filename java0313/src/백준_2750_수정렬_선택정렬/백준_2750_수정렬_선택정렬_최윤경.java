package 백준_2750_수정렬_선택정렬;

import java.util.Scanner;

public class 백준_2750_수정렬_선택정렬_최윤경 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i < n-1; i++) {  //범위가 n-1인 이유? 가장 작은 수를 찾아서 배치를 완료했기 때문에 맨 마지막 숫자는 굳이 비교할 필요없음
			int min = i;	//??? 아직 정렬되지 않은 부분에서 가장 작은 요소의 인덱스를 min에 저장 (swap부분까지 연결되어서 계산한 결과)
			
			//최솟값을 갖고있는 인덱스 찾기
			for (int j = i+1; j < n; j++) { //0보다 큰 인덱스에 있는 값을 모두 비교
				if (arr[j] < arr[min]) //나머지 인덱스에 있는 값들 중에서 j번째 값보다 큰 min값이 있다면
									   //예를 들어, arr[1] < arr[0] 이면
					min = j;  //j를 min에 넣어줌 -> min=1이 됨, arr[0] < arr[1]이면 변화 없음
			}
			
			//i번째 값과 찾은 최솟값을 서로 교환
			swap(arr, i, min); //아직 정렬되지 않은 나머지 부분에서 첫 요소와 가장 작은 요소를 교환
		}
		
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}
		System.out.println();
	}

	private static void swap(int[] arr, int i, int min) {
		int temp = arr[i];
		arr[i] = arr[min];
		arr[min] = temp;
	}
}
