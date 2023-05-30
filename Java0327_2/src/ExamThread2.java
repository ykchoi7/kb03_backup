import java.util.Iterator;

public class ExamThread2 {
	public static void main(String[] args) throws InterruptedException {
		//3초 후 메시지 출력
		//3초 대기하는 동안 숫자 출력
		
		Thread t=new Thread() {
			public void run() {
				//오버라이딩 시 부모보다 예외가 더 많거나,
				//부모보다 부모 타입 예외은 안됨.
				System.out.println("3초 전");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
				System.out.println("3초 후");
				
			}
		};//annonymous class
		t.start();
		
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
	}
}
