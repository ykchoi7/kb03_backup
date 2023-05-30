import java.util.Arrays;
import java.util.Scanner;

public class kb3반_알고리즘2번_최윤경 {
	private static int n, m;
    private static int[] arr; // 원소를 저장할 배열
    private static boolean[] visited; // 중복을 제거하기 위한 방문 처리

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	//n은 주어지는 숫자 개수
		int num = sc.nextInt(); //num은 불러주는 숫자
		int[] arr = new int[n];
		combination(0, 5);
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		//세 개의 수 합을 구하는 식
		for (int i = 0; i < arr.length; i++) {
			int m = arr[0] + arr[1] + arr[2];
			if (m <= num) {
				System.out.println(num);
				//합을 따로 구하지 말고 if (m <= num)인 동안 max=m을 하면서 max를 갱신시켜주면 됨
			}
		}
	}

	//조합
	private static void combination(int cnt, int start) {
		if (cnt == 3) {
	        System.out.println(Arrays.toString(arr));
	        return;
	       }
		for (int i = start; i <= n; i++) {
	        arr[cnt] = i;
	        combination(cnt + 1, i + 1); // 오름차순으로 구하면 중복 체크하지 않아도 됨
	    }
	}
}
	

		
