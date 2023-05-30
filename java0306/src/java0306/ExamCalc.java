package java0306;

public class ExamCalc {
	public static void main(String[] args) {
		//간단한 계산기
		Calc c = new Calc();
		int ans = c.plus(3,5);
		System.out.println(ans);
		int ans2 = c.minus(3,5);
		System.out.println(ans2);
		double ans3 = c.divide(3,5);
		System.out.println(ans3);
	}
}
