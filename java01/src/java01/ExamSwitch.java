package java01;

import java.util.Scanner;

public class ExamSwitch {
	public static void main(String[] args) {
		//학점 받아서 등급 출력 (학점 >= 90 A, 80:B, 70:C, 60:D, F)
		Scanner sc = new Scanner(System.in);
		System.out.println("학점을 입력하세요: ");
		int ans = sc.nextInt();
		
		switch(ans/10) {				//모든 경우의 수를 기입할 수 없기 때문에 10으로 나눈 정수값으로 계산하기
		case 10:
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		case 6:
			System.out.println("D");
			break;
		default:
			System.out.println("F");
		}
	}
}
