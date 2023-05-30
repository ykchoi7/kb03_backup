package assignment;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//그리디알고즘 - 냉장고 
public class HW2_J1828_최윤경 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //화학물질의 개수
		int[][] arr = new int [n][2]; //온도는 2개 이므로 1번째 배열 공간 2로 지정 
		
		for (int i = 0; i < n; i++) {
			arr[i][0] = sc.nextInt(); //최저온도 arr[i][0]에 저장 
			arr[i][1] = sc.nextInt(); //최고온도 arr[i][1]에 저장 
		}
		
		//최고온도 오름차순 정렬 & 두 개의 온도 비교 
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
			
		});
		
		//첫번째 냉장고를 최대온도로 세팅하고 순차적으로 검사하면서 max온도 갱신 
		int count = 1; //냉장고 개수 구하기 위해 변수 설정 (하나는 무조건 있어야하기 때문에 초기값 1로 세팅) 
		int max = arr[0][1];
		
		for (int i = 1; i < n; i++) {
			if (max < arr[i][0]) { //최저온도가 기존 max보다 크면 
				max = arr[i][1]; //max를 그 배열의 최대온도로 갱신해주고 
				count++; //냉장고 수 추가 
			}
		}
		System.out.println(count);
	}
}
