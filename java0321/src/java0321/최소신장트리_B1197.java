package java0321;

import java.util.PriorityQueue;
import java.util.Scanner;

//최소신장트리 p.370
public class 최소신장트리_B1197 {

	static int[] parent;
	static PriorityQueue<pEdge> queue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //노드의 개수
		int M = sc.nextInt(); //에지의 개수
		
		//에지 정보를 priorityqueue에 저장
		queue = new PriorityQueue<>(); //priorityqueue 자동정렬 큐
		for (int i = 0; i < M; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int v = sc.nextInt();
//			queue.add(new pEdge(s, e, v)); //pedge클래스로 관리
		}
		
		parent = new int[N+1];
		for (int i = 0; i < N; i++) {
			parent[i] = i; //각 인덱스 번호의 값으로 초기화
		}
		
		int useEdge = 0; //사용한 엣지 개수 카운트하는 변수 (n-1동안 계산해야하기 때문)
		int result = 0; //가중치 합
		while (useEdge < N-1) {
			pEdge now = queue.poll(); //큐의 맨 앞 삭제, 반환 (가중치가 가장 작은 것부터)
			if (find(now.s) != find(now.e)) {
				union(now.s, now.e); //노드 연결
				result += now.v; //가중치 누적
				useEdge++; //사용한 엣지 개수 증가
			}
		}
		System.out.println(result);
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			parent[b] = a;
		}
	}
	
	public static int find(int a) {
		if (a == parent[a]) 
			return a;
		else 
			return parent[a] = find(parent[a]);
	}
	
	class pEdge implements Comparable<pEdge> {
		int s;
		int e;
		int v;
		pEdge(int s, int e, int v) {
			this.s = s;
			this.e = e;
			this.v = v;
		}
		@Override
		public int compareTo(pEdge o) {
			return this.v - o.v;
		}
	}
	
}
