package java0328;

public class NumberRunnable implements Runnable {

	@Override
	public void run() {
		//숫자출력스레드
		for (int i = 0; i < 10000; i++) {
			System.out.println(i);
		}
	}

}
