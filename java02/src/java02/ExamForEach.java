package java02;

public class ExamForEach {

	public static void main(String[] args) {
		// 자주 사용되는 for each문
		int[] arr = new int[] {100,200,300};
		
		//기존 for문
		for(int i = 0; i < arr.length; i++) {
			int j = arr[i];
			System.out.println(j);
		}
		
		//for each문으로 표현
		for (int i : arr) {
			System.out.println(i);
		}
	} //end main
}
