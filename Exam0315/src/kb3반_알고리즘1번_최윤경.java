import java.util.Scanner;

public class kb3반_알고리즘1번_최윤경 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();  //배열은 입력받은 수로 생성
		}
		
		//선택정렬
		for (int i = 0; i < n; i++) {
			int max = i;
			for (int j = i+1; j < n; j++) {
				if (arr[j] > arr[max])
					max = j;
			}
			swap(arr, i, max);
			System.out.println(arr[i]);
		}
		System.out.println();
	}

	private static void swap(int[] arr, int i, int max) {
		int temp = arr[i];
		arr[i] = arr[max];
		arr[max] = temp;
	}
}
