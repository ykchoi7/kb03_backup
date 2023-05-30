package java0317;

import java.util.ArrayList;
import java.util.Scanner;

//친구관계 파악하기 ABCDE
public class 인접리스트_B13023 {
	
	static ArrayList<Integer>[] A;
	static boolean[] visited;
	static boolean arrived;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //참여하는 사람 수 n
		int m = sc.nextInt(); //친구관계의 수 m
		A = new ArrayList[n];
		visited = new boolean[n]; //방문확인 함수
		arrived = false; //5개까지 다 돌았는지 확인하는 함수(최종으로 구해야하는 값), 5개까지 다 돌았으면 그 뒤에 더 있어도 돌 필요가 없음
						 //arrived 초기값 false로 세팅, 도착하고 나면 true로 변환
		
		for (int i = 0; i < n; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < m; i++) { //친구관계 수 주어진 개수(m개)만큼 저장
			int s = sc.nextInt();
			int e = sc.nextInt();
			A[s].add(e); // 각 엣지를 start, end에 각각 더해줌
			A[e].add(s);
		}
		
		//결과출력 부분 - 끝까지 돌아서 5개 여부 확인해서 1 또는 0 출력
		for (int i = 0; i < n; i++) {
			DFS(i,1); //depth 1부터 탐색 시작 (i부분 현재 위치, 1은 depth가 어디인지)
			if (arrived) break;
		}
		if (arrived) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
	
	//**이 부분 어려움**//
	//depth가 끝에 도달하면 종료, 아니면 계속 돌기
	private static void DFS(int now, int depth) { //now 현재 위치, depth 노드의 깊이
//		for (int i = 0; i < A.length; i++) {
		if (depth ==5 || arrived) {
			arrived = true; //arrived부분을 꼭 true로 바꿔주어야 한다!!!
			return;
		} //깊이가 5까지 갔고 모든 노드를 다 돌아서 arrived 했으면 종료시켜줌
//		}
		visited[now] = true;
		for (int i : A[now]) {
			if (!visited[i]) { //아직 방문을 하지 않았다면
//				visited = true;
				DFS(i, depth+1); //재귀호출될 때마다 깊이가 1씩 증가
			}
		}
		visited[now] = false;
	}
}

