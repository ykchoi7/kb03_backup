package java0328;

public class CharRunnable implements Runnable {

	@Override
	public void run() {
		//문자출력스레드
		for (char c = '가'; c < '힣'; c++) {
			System.out.println(c);
		}
	}

}
