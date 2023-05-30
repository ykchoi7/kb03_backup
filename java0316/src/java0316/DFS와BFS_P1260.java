package java0316;

//DFS와 BFS 프로그램
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//**DFS와 BFS 구현 방법 외우기** debug - breakpoint걸고 하나씩 점검하면 보기(f6) 
//코딩테스트 교재 p.164
public class DFS와BFS_P1260 {
	static boolean[] visited;
	static ArrayList<Integer>[] A;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //노드 개수
		int m = sc.nextInt(); //에지 개수
		int start = sc.nextInt(); //시작점
		A = new ArrayList[n+1];  //인덱스1부터 사용하기 위해 n+1의 리스트 생성
		
		//배열 초기화
		for (int i = 1; i <= n; i++) { //0번 인덱스는 사용안하므로 1번부터 n까지만 초기화 
			A[i] = new ArrayList<Integer>();
		}
		
		//입력받은 엣지 수들을 서로 연결해주는 작업
		for (int i = 0; i < m; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			A[s].add(e); 
			A[e].add(s);
			//=>예를 들어, 1에도 2를 넣고 2에도 1을 넣음
		}
		
		//번호가 작은 것을 먼저 방문하기 위해 정렬
		for (int i = 1; i <= n; i++) {
			Collections.sort(A[i]);  //정점 정보를 정렬하는 부분
									 //배열을 정렬할 때는 Arrays.sort() / 리스트 정렬할 때는 Collections.sort()
		}
		visited = new boolean[n+1]; //DFS 방문배열 초기화
		DFS(start);
		System.out.println();
		visited = new boolean[n+1]; //BFS 방문배열 초기화
		BFS(start);
		System.out.println();
	}

	//BFS구현
	private static void BFS(int node) {
		Queue<Integer> queue = new LinkedList<Integer>(); //list형태로 묶은 값을 queue의 각 인덱스에 넣기
		queue.add(node);
		visited[node] = true;
		
		while (!queue.isEmpty()) { //큐가 채워져있는 동안은 계속 반복
			int now_node = queue.poll(); //poll():queue의 맨 앞 요소를 now_node에 반환하고 삭제 / 비어있는 경우 null 반환
			System.out.print(now_node + " "); 
			for (int i : A[now_node]) { //A의 첫번째에 들어가는 수를 확인
				if (!visited[i]) {
					visited[i] = true; //방문하고 나면 true로 바꿔줌
					queue.add(i); //queue에 i를 하나씩 넣어줌
				}
			}
		}
	}
	
	//DFS구현
	private static void DFS(int node) {
		System.out.print(node + " ");
		visited[node] = true; //DFS 진행한 인덱스는 visited배열을 true로 바꿔줌
		for (int i : A[node]) { //A의 1번 노드에는 2,3,4가 담겨있음
			if(!visited[i]) {  //visited[2]이 T,F인지 확인하기 -> false이면 DFS 실행
				DFS(i);
			}
		}
	}
}
