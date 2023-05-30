package java0313;

import java.util.Arrays;

public class Exam연산자 {

	public static void main(String[] args) {
		int a = 1;
//		int b = a++ + 1;  //a+1을 연산한 후에 ++처리 => a=2, b=2
//		int b = ++a + 1;  //반면, ++a +1 이라면 ++처리를 먼저 한 후 +1을 진행 => a=2, b=3
		//System.out.println(a + "," + b);
		int c = a++ + ++a + a++ + ++a;
		System.out.println(a + "," + c);
		
		//
		int[] arr = {100,200,300};
		System.out.println(Arrays.toString(arr));
	}
}
