package java02;

public class Exam구구단배열 {

	public static void main(String[] args) {
		// 2차원배열 arr에 구구단 결과값을 저장하는 코드를 작성하세요.
		// 단, 단번호와 인덱스를 동일하게 하세요.
		// 예를 들어, arr[2][1]->2, arr[2][2]->4
		// 생성 따로, for문으로 값을 저장하세요.
		
		int [][] arr = new int [10][10];
			for (int dan=2; dan <= 9; dan++) {
				for (int i=1; i <= 9; i++) {
					System.out.println(arr[dan][i] = dan*i);
				}
		};
		System.out.println();
	}

}
