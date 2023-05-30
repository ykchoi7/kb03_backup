package java01;

import java.util.Random;
import java.util.Scanner;

public class ExamUtilFor {
	public static void main(String[] args) {
		Random random = new Random();
		int r = random.nextInt(100);  // 0~99 이하의 난수 생성한 후 local변수로 만들어줌 (ctrl+1)
		System.out.println("난수는 " +r);
		
		Scanner sc = new Scanner(System.in);
		int ans = -1;
		for (; r != ans;) {
			System.out.println("0~99 사이의 숫자를 입력하세요 >> ");
			ans = sc.nextInt();
			
			if (r == ans) {
				System.out.println("정답입니다.");
			}else if (r < ans) {
				System.out.println("숫자를 낮춰주세요");
			}else {
				System.out.println("숫자를 높여주세요");
			}
		}
	}
}
