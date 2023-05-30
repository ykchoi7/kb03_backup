package java02;

public class ExamArray2 {

	public static void main(String[] args) {
		//2차원 배열 생성
		int [][] arr = new int[2][3];  //2행x3열 행렬이 만들어짐
		arr[0][0] = 100;  //0행 0열에 100 할당
		arr[0][1] = 200;  //0행 1열에 200 할당
		arr[0][2] = 300;  //0행 2열에 300 할당
//		System.out.println(arr[0][0]);
		System.out.println(arr.length); //2차원 배열의 length는 행의 갯수인 2
		System.out.println(arr[0].length); //그렇다면 0번째 행렬의 length는 0번째 행이 가지고 있는 열의 갯수인 3
	}

}
