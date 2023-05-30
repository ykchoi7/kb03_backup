package java01;

import java.util.Scanner;

public class ExamScanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //System.in input를 의미 (사용자 입력)
//		String s1 = sc.next();  //next - 공백 기준 분리하여 문자열 읽기
//		System.out.println("읽은 문자열:" +s1);
//		int s1 = sc.nextInt();  //nextInt - int 읽기
//		System.out.println("읽은 숫자:" +s1);
//		s1 = sc.nextInt();
//		System.out.println("읽은 숫자:" +s1);
		String s1 = sc.nextLine();
		System.out.println("읽은 줄:"+s1);
	}
}
