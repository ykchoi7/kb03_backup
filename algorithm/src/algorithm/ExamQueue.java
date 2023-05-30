package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class ExamQueue {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>(); //Integer - Queue안에 저장할 타입 지정
		//같은 LinkedList라도 Queue에 넣어지냐, List에 넣어지냐에 따라 조회되는 메소드 종류가 달라진다
		//객체 자체는 LinkedList, 그러나 메서드는 Queue꺼만 사용 가능
		q.offer(100); //100이라는 값 추가
		q.offer(200);
		q.offer(300);
		q.offer(400);
		q.offer(500);
		
		//.poll()/.remove() => 큐 맨 앞에 있는 것부터 삭제
		int front = q.poll();
		System.out.println("front= " + front);
		System.out.println("queue= " + q);
		//.peek() => 맨 앞에 있는 값 조회
		System.out.println("맨앞값= " + q.peek());
		
		//큐가 빌 때까지 값을 삭제하고 출력
		while (!q.isEmpty()) {
			q.poll();
			System.out.println("queue = " + q);
		}
	}
}
