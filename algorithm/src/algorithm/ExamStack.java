package algorithm;

import java.util.Stack;

public class ExamStack {

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		st.push(100);
		st.push(200);
		st.push(300);
		st.push(400);
		st.push(500);
		System.out.println(st);
		
		//꼭대기에 있는 값 제거하고 그 값을 반환
		Integer top = st.pop();
		System.out.println("top = " + top);
		System.out.println("Stack = " + st);
		
		//꼭대기에 있는 값이 무엇인지 조회
		System.out.println("peek = " + st.peek());
		
		//while 반복문으로 스택의 모든 값을 제거하고 값이 하나씩 제거될 때마다 스택 출력
		while (!st.isEmpty()) {
			st.pop();
			System.out.println(st);
		}
	}
}
