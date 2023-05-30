package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//요세푸스 문제
public class baekjoon_1158 {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();  //사람수 총 n명
		int k = sc.nextInt();  //k번째 사람 제거
		
		//n까지의 요소들을 q에 먼저 저장
		for (int i = 1; i <= n; i++) { //q.size()는 i 증가할수록 더 늘어나기 때문에 이걸로 설정하면 안됨
									   //무한루프 걸림
			q.offer(i); 
		}
		
		//제거되는 값을 저장할 새로운 큐를 생성
		Queue<Integer> qnew = new LinkedList<>();
		int count = 0; 			  //몇 번 제거하는지 카운드할 변수 0으로 초기화
		while (!q.isEmpty()) {    //q에 있는 수가 모두 사라질 때까지 진행
			if (count == (k-1)) { 	  //(k-1)값이 count랑 동일할 때
				qnew.offer(q.poll()); //제거한 값을 qnew에 저장
			} else {
				count++;		  //카운트는 계속 1씩 증가
				q.offer(q.poll()); // 제거한 값 저장
			}
		}
		
		//출력
		System.out.print("<");
		while (qnew.size() != 1) {
			System.out.print(qnew.poll() + ",");
		}
		System.out.print(">");
	}
}
