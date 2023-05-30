package jungol;

import java.util.Random;
import java.util.Scanner;

public class J1707_달팽이사각형 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();	//사각형의 가로
		int y = sc.nextInt();   //사각형의 세로
		System.out.println("사각형의 길이 = " + x +"*" + y);
		int arr[][] = new int[x][y];  //입력받은 크기의 배열 생성
//		int i = 0, j = 0;  //arr[0][0]에 넣기 위해 -1로 초기화
		int num = 0;  //출력할 수 num
		
		for (int i = 0; i < x; i++) {
			for (int j = i; j < y; j++) {
				if (i%4 == 0) {
					x++;
					y++;
				} else if (i%4 == 1) {
					y--;
				} else if (i%4 == 2) {
					x--;
				} else {
					x++;
				}
				arr[x][y] = (num++) %10;
			}
		}
		
		//출력
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				System.out.println(arr[i][j]);
			}
			System.out.println();
		}
	}
}

		
		
//		
//		
//		
//				
//		void fill() {
//			int i;
//			int num = 1;
//			int m = n;		//m이 이동횟수, 처음에는 오른쪽으로 n번 이동
//			int x=1, y=0;
//			
//			while (m>0) {
//				for (int i = 1; i <= arr.length; i++) {
//					y++;
//					arr[x][y] = num++;
//				}
//				
//				m--;
//				for (int i = 1; i <= arr.length; i++) {
//					x++;
//					arr[x][y] = num++;
//				}
//				
//				for (int i = 1; i <= arr.length; i++) {
//					y--;
//					arr[x][y] = num++;
//				}
//				
//				m--;
//				for (int i = 1; i <= arr.length; i++) {
//					x--;
//					arr[x][y] = num++;
//				}
//			}
//		}
//		
//}
