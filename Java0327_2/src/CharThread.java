
public class CharThread extends Thread {
	@Override
	public void run() {
		for(char c='가';c<'힣';c++)
			System.out.println(c);
	}
}
