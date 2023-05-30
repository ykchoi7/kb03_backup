package java01;

public class ExamString2 {
	public static void main(String[] args) {
		String s1 = "1";
		String s2 = s1 + 100;
		System.out.println(s2); //1100
		char c1 = 'A';
		int i = c1 +100;
		System.out.println(i); //줄바꿈 있는 상태로 다음꺼 출력
		System.out.print(i);  //줄바꿈 없이 다음꺼 출력
		System.out.print(i);
	}
}
