package java0308;

public class ExamMath {

	public static void main(String[] args) {
		double r = Math.random();  //Math.random() 기입하고 ctrl+1
		System.out.println(r);
		
		//1~100 사이의 난수 생성
		//r: 0.0 ~ 0.99999
		r *= 100;   //0.0 ~ 9.9999
		System.out.println(r);
		
		//정수로 변환 0~99 -> +1을 통해 1~100 생성
		int i = (int)(r+1);
		System.out.println(i);
	}

}
