import java.util.Random;

public class Exam가위바위보 {

	public static void main(String[] args) {
		Random r = new java.util.Random();
		//정수 난수 0,1,2 중 하나 출력
		int rnd = r.nextInt(3);
		System.out.println(rnd);
		
		//0,1,2를 가위, 바위, 보로 변환하기. if문 사용하지 않고
		//=> 배열로 변환해서 출력하기
		String[] rsp = new String[] {"가위", "바위", "보"};
		System.out.println(rsp[rnd]);
//		rsp[0] = "가위";
//		rsp[1] = "바위";
//		rsp[2] = "보";
	}
}

