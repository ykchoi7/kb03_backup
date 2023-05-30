package java0320;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//효율적인해킹 - BFS활용
public class 백준_B1325_효율적인해킹 {
	
	static ArrayList<Integer> A[];
	static boolean visited[];
	static int answer[];  //최대 신뢰값의 결과값을 입력받을 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //컴퓨터의 개수 n
		int m = sc.nextInt(); //신뢰관계의 개수 m
		A = new ArrayList[n+1];
		visited = new boolean[n+1];
		answer = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			A[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			A[s].add(e); //신뢰관계는 한방향이기 때문에 양쪽 연결을 하지 않아도 된다
		}
		
		//결과출력
		for (int i = 1; i <= n; i++) {
			visited = new boolean[n+1];
			BFS(i);
		} //각 인덱스값에 대하여 방문배열과 BFS 실행
		
		int maxVal = 0; //최대의 신뢰를 받는 횟수를 카운팅하려는 변수
		for (int i = 1; i <= n; i++) {
			maxVal = Math.max(maxVal, answer[i]); //maxVal와 answer배열의 i번째 값 중에 최대값을 출력하여 maxVal에 저장
		}
		for (int i = 1; i <= n; i++) {
			if (answer[i] == maxVal)  //answer배열에서 maxVal과 같은 값을 가진 index를 정답으로 출력
				System.out.println(i + " ");
		}
	}
	
	//이런 유형의 경우, BFS 너비우선탐색 방법을 사용해야 한다
	private static void BFS(int index) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(index);
		visited[index] = true;  //노드 삽입하면서 visited배열에 true로 반환
		
		while (!queue.isEmpty()) {
			int now_node = queue.poll();
			for (int i : A[now_node]) {
				if (visited[i] = false) {
					visited[i] = true;
					answer[i]++;  //신규 정점인덱스의 정답 배열 값을 증가 시키기 
					queue.add(i);
				}
			}
		}
	}
}
