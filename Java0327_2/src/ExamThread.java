
public class ExamThread {
	public static void main(String[] args) {
		
//		Thread nt=new NumberThread();
//		Thread ct=new CharThread(); 상속하지 않은 상황에서
//		nt.start();
//		ct.start();
		
		Runnable nr=new NumberRunnable(); //뭔가를 상속한 경우 필요
		Runnable cr=new CharRunnable();
		Thread t1=new Thread(nr);
		Thread t2=new Thread(cr);
		t1.start();
		t2.start();
		
	}
}
