package java01;

public class ExamArr {
	public static void main(String[] args) {
		int[] points;  //선언
		points = new int[3];  //생성 및 points에 할당
//		points = null //할당할게 없으면 null을 입력해서 아무것도 없음을 드러낼 수 있음
		System.out.println(points);
		points[0] = 100;
		points[1] = 200;
		points[2] = 300;
//		points[3] = 400; //배열 갯수를 초과해서 기입할 경우 오류 발생
		System.out.println(points);  //값을 직접 넣어도 가리키는 곳은 동일
		System.out.println(points[0]);
		System.out.println(points[1]);
		System.out.println(points[2]);
		
		for (int i = 0; i < points.length; i++) {
			System.out.println(points[i]);
		}
	}
}
