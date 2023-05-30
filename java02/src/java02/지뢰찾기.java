package java02;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class 지뢰찾기 {

	public static void main(String[] args) {
		//지뢰정보저장 2차원 배열
		int[][] mineMap = new int [12][12];
		//임의의 좌표에 지뢰 지정 (5개)
		Random r = new Random(100);
		for (int i = 0; i < 5; i++) {
			int x = r.nextInt(10)+1;   //x행,y열
			int y = r.nextInt(10)+1;
			mineMap[x][y] = 9;     //9는 지뢰위치
			
			//지뢰 주위 8개 좌표값을 1씩 증가
			mineMap[x-1][y]++;  //북쪽으로 바로 위
			mineMap[x-1][y+1]++; //상우
			mineMap[x][y+1]++;
			mineMap[x+1][y+1]++;
			mineMap[x+1][y]++;
			mineMap[x][y-1]++;  //가장자리에 있으면 그 위에 있는 좌표는 debug할 수 없음 
								//=> 해결책) 그 위에 빈 박스를 하나더 덧대자
			mineMap[x-1][y-1]++;
			mineMap[x+1][y-1]++;
		}
//		for (int[] mm : mineMap) {
//			for (int i:mm) {
//				System.out.print(i + " ");
//			}
//			System.out.println();  //빈줄 출력
//		}
		
		//사용자 입력 좌표 표시 배열
		boolean[][] userMap = new boolean[12][12];  //boolean이기 때문에 기본은 False
		
		//게이머로부터 좌표 입력받아 열어주기
		Scanner sc = new Scanner(System.in);
		int 찾은지뢰수= 0;
		while (true) {
			System.out.println("X좌표 입력하세요 (1~10)");
			int ux = sc.nextInt();
			System.out.println("Y좌표 입력하세요 (1~10)");
			int uy = sc.nextInt();
			userMap[ux][uy] = true; //게이머가 입력한 좌표		
			//게이머가 입력한 결과 좌표를 표시
			for (int i = 0; i < userMap.length; i++) {
				for (int j = 0; j < userMap.length; j++) {
					if (userMap[i][j] == true) //게이머가 오픈한 좌표
						System.out.print(mineMap[i][j] + " ");
					else //게이머가 오픈 안한 좌표
						System.out.print("X ");
				}
				System.out.println();
			} //end for i (찾았으면 찾은 지뢰 수 
			if(mineMap[ux][uy] >= 9) {
				 찾은지뢰수++;
				 if (찾은지뢰수 == 5) break;  //반복종료
			}
		} //end while
	} //end main
}
