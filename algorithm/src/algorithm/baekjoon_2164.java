package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon_2164 {
//큐를 활용한 알고리즘(카드2)
	
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		
		//큐의 길이 n - 입력받기
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//n까지 있는 요소들을 q에 먼저 저장
		for (int i = 1; i <= n; i++) {
			q.offer(i); //q에 저장하는 메서드 .offer() = .add()
		}
		
		//길이가 1개가 아닐때까지 위에꺼 제거, 큐에 저장
		//문제에서는 밑으로 옮긴다고 하지만 제거를 해도 마지막에 남는 건 같은 숫자 -> poll()로 삭제하자!
		for (int i = 0; i < n-1; i++) {
			q.poll();
			int front = q.poll();
			q.offer(front);
		}
//			if (q.size() == 1) {
//				int result = q.poll();
//				System.out.println(result);
//				break;
//			}
		System.out.println(q.peek());
	}
}
