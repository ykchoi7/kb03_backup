package java02;

public class ExamArray4 {

	public static void main(String[] args) {
		//가변배열
		int[][] arr = new int [3][]; //3행은 정해졌지만 몇 열인지는 정해지지 않음 (가변)
		arr[0] = new int [2];  //0번째 행에는 2개짜리 열을 가짐 & 지금은 모두 0으로 채워져있음
		arr[1] = new int [3];
		arr[2] = new int [4];
		System.out.println(arr.length);
		System.out.println(arr[0].length);
		
		/*
		각 배열에 값을 넣어주고 싶을 때
		arr[0] = new int [] {10,20};
		arr[1] = new int [] {30,40,50};
		arr[2] = new int [] {60,70,80,90};
		*/
	}
}
