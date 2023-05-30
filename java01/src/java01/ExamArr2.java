package java01;

public class ExamArr2 {
	public static void main(String[] args) {
		int[] points = {100,200,300};  // 초기화 방식1
		int[] points2 = new int[] {100,200,300};  //초기화 방식2
		//방식1은 변수 선언할 때만 (int[] points) 사용 가능
		//방식2는 선언과 재할당 시 언제나 사용 가능
		points = new int[]{300,400,500}; // points에 새로운 변수를 할당하고 싶을 때
		System.out.println(points[2]);
		System.out.println(points2[2]);
	}
}
