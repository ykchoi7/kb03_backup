package java0320;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//미로탐색하기 p.169 - 2차배열 BFS
public class 백준_B2178_미로탐색 {
	
	static int n,m;
	static int[][] A; //2차원배열로 생성
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //행의 개수
		m = sc.nextInt(); //열의 개수
		A = new int[n+2][m+2]; //경계검사 피하기 위해 테두리용으로 좌우, 위아래 1칸씩 추가해야 함
		visited = new boolean[n+2][m+2]; //경계검사 피하기 위해 테두리용으로 좌우, 위아래 1칸씩 추가해야 함
		
		//데이터 입력받아서 배열에 저장
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				A[i+1][j+1] = sc.nextInt();				
			}
		}
		
		//결과출력
		BFS(1,1);
		System.out.println(A[n][m]);
//		for (int i = 1; i <= n; i++) {
//			visited = new boolean[n+2][m+2];
//			BFS(0,0);
//		}
	}

	private static void BFS(int x, int y) { //x,y좌표를 bfs로 처리하는 코드
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		visited[x][y] = true;
		
		int[] dx = {-1, +1, 0, 0};
		int[] dy = {0, 0, -1, +1};
		
		while (!queue.isEmpty()) {
			int[] now = queue.poll(); //큐의 첫번째 값을 반환하고 삭제
			for (int k = 0; k < 4; k++) {
				int nx = now[0] + dx[k];
				int ny = now[1] + dy[k];
				if (nx >= 0 && ny >=0 && nx < n && ny < m) {
					if (A[nx][ny] != 0 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						A[nx][ny] = A[now[0]][now[1]] +1;
						queue.add(new int[] {nx, ny});
					}
				}
			}
		}
	}
}
