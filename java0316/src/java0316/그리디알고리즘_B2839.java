package java0316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//설탕배달
public class 그리디알고리즘_B2839 {
	public static void main(String[] args) throws Exception, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int ans = -1; //끝까지 반복해도 못찾으면 -1
        //5kg씩 줄여나가면서 3kg으로 만들수 있는지 확인
        for(int i=N/5; i>=0; i--) {// 5kg 0봉지까지 계산
            // i는 5kg짜리 봉지 갯수
            int weight = N - 5*i; // 22 - 4*5 : 2
            // 3kg으로 만들수 있으면 정답
            if(weight % 3==0) {
                //5kg짜리 봉지갯수+3kg짜리 봉지갯수
                ans = i+(weight/3); //찾았으면 계산중지
                break;
            }
        }//end for
        System.out.println( ans );//원하는 조합을 못찾으면 -1
    }//end main
	
	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt(); //총 설탕 무게
//		int[] A = new int[] {5, 3}; //설탕 무게 5kg, 3kg 있음
//		
//		주어진 결과는 나오지만 반례가 존재함,,
//		//n을 5로 나눈 나머지가 3으로 나누어떨어지게 하면 조건 만족
//		int num = n%A[0]; //n을 5로 나눴을 때 나머지 = num
//		if(num%A[1] != 0 & (n%A[1]) != 0 & (num%A[0] != 1)) {
//			System.out.println(-1);
//		} else {
//			int count = 0; //봉지의 개수 count
//			if ((n%A[1]) == 0) {
//				count += (n/3);
//				System.out.println(count);
//			} else if (num%A[1] == 0) {
//				count += (n/5);
//				n = n%5;
//				count += (n/3);
//				System.out.println(count);
//			} else { //num%A[1] == 1
//				count += (n/5);
//				count += 1;
//				System.out.println(count);
//			}
//		}
//	}
}
