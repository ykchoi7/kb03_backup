package java0328;

public class ExamThread {
	public static void main(String[] args) {
		
		Thread nt = new NumberThread();
		Thread ct = new CharThread();
		nt.start();
		ct.start();
		// => 숫자와 문자가 섞여서 출력 / 상속하지 않은 상황에서 활용
		
		Runnable nr = new NumberRunnable();
		Runnable cr = new CharRunnable();
		Thread t1 = new Thread(nr);
		Thread t2 = new Thread(cr);
		t1.start();
		t2.start();
		//뭔가를 상속한 경우에서 활용
		
//		//숫자출력스레드 -> 새로운 클래스로 옮김
//		for (int i = 0; i < 10000; i++) {
//			System.out.println(i);
//		}
		
//		//문자출력스레드
//		for (char c = '가'; c < '힣'; c++) {
//			System.out.println(c);
//		}
		
		//원래는 앞에꺼가 먼저 실행되고 그 다음꺼가 실행됨
		//-> 동시에 실행하고 싶을 때 스레드를 생성해서 수행한다
		
	}
}

