package java0306;

public class ExamArray {
	public static void main(String[] args) {
		int[] arr = new int[3];
		arr[0] = 100;
		arr[1] = 200;
		arr[2] = 300;
		System.out.println("arr의 길이는 = " +arr.length);
		
		int[] arr2 = new int[] {100,200,300};
		for (int is : arr2) {  //arr2의 모든 값을 변수에 저장하여 추출
			System.out.println(is);
		}
		
		//2차원 배열
		int[][] arr3 = new int[][] {{1,2,3}, {4,5,6}};
		System.out.println("arr3의 길이는 = " +arr3.length); //2차원배열의 길이
		System.out.println(arr3[0].length);  //1차원배열의 길이
		
		//가변배열
		int[][] arr4 = new int[][] {{1,2}, {3,4,5}};
		
	}
}
