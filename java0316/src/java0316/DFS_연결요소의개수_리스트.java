package java0316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DFS_연결요소의개수_리스트 {
	
	static ArrayList<Integer>[] A;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//stringbuilder와 stringtokenizer의 차이는..?
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		A = new ArrayList[n+1];
		visited = new boolean[n+1];
		
		for (int i = 1; i <= n; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		//각 엣지의 수들을 연결시켜주는 작업
		for (int i = 0; i < m; i++) { //엣지의 개수는 m개*
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			A[s].add(e);
			A[e].add(s);
		}
		
		//방문했는지 여부를 확인하는 부분
		int count = 0; //요소의 개수를 세주는 변수
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) { //visited배열에 false일 때
				count++;
				DFS(i);
			}
		}
		System.out.println(count);
	}
	
	//DFS 구현
	private static void DFS(int v) {
		if (visited[v]) { //방문을 했으면 
			return;		  //그냥 반환
		}
		visited[v] = true; //true로 바꿔줌
		for (int i : A[v]) { //A배열의 1번째 칸에 들어있는 리스트 i
			if (visited[i] == false) { //i번째가 아직 방문한 적이 없어 false라면
				DFS(i);	//DFS를 다시 실행
			}
		}	
	}
}
