package java0328;

public class ExamThread2 {
	public static void main(String[] args) throws InterruptedException {
		//3초 후 메시지 출력
		//3초 대기하는 동안 숫자 출력
//		System.out.println("3초 전");
//		Thread.sleep(1000); //1000밀리초 동안 실행 중단 
//							//InterruptedException 선언 필요 - 쉬는 동안 강제 깨우기를 할 경우
//		System.out.println("3초 지남"); //3초 지나고 출력됨
		
		Thread t = new Thread() {
			@Override
			public void run() {
				//오버라이딩 시 부모보다 예외가 더 많거나, 부모예외타입이면 안됨
				System.out.println("3초 전");
				try {
					Thread.sleep(3000);
				} catch (Exception e) {}
				System.out.println("3초 지남");
			}
		};
		t.start();

		for (int i = 0; i < 10; i++) {
			System.out.println(i); //3초가 지난 후 "3초 지남"과 같이 출력
									//-> 하나의 스레드로 묶어줘야 한다
		}
	}
}
