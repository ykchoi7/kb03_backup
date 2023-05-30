package java0328;

public class NumberThread extends Thread {
	
	@Override
	public void run() {
		//숫자출력스레드
		for (int i = 0; i < 10000; i++) {
			System.out.println(i);
		}
	}
}
