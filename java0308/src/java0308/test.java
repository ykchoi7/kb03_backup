package java0308;

//가장 헷갈렸던 문제

//1. 배열에서 각 위치마다 값을 지정해주지 않았을 때 -> 따로 오류없이 값 입력해준것만 출력됨
public class test {
	public static void main(String[] args) {
		int points[];
		points = new int[3];
		points[1] = 0;
		System.out.println(points[0] + points[1]);
	}
}


//2. str만 입력하면 출력이 될까? -> 오류 발생
//public class test {
//	public static void main(String[] args) {
//		String str;
//		System.out.println(str);
//	}
//}