import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class kb3반_알고리즘1번_최윤경 {

	static ArrayList<Integer>[] A;
	static boolean[] visited;
	static boolean arrived;
	static int result[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //총 마을 사람의 수
		int m = sc.nextInt(); //관계의 수
		A = new ArrayList[n+1];
		visited = new boolean[n+1];
		result = new int[n+1];
		arrived = false; //디폴트값을 false로 지정
		
		//배열을 새로 만들기
		for (int i = 1; i <= n; i++) {
			A[i] = new ArrayList<>();
		}
		
		//배열에 값을 저장
		for (int i = 1; i <= n; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			A[s].add(e);
			A[e].add(s); //친구 사이는 양쪽으로 형성되기 때문에 양 끝 점 연결
		}
		
		//결과출력 BFS 활용
		for (int i = 1; i <= n; i++) {
			visited = new boolean[n+1];
			BFS(i);
		}
		
		int maxVal = 0; //1과 연결된 친구의 수 최댓값을 구하면 그게 철수를 통한 친구관계 최댓값
		for (int i = 1; i <= n; i++) {
			maxVal = Math.max(maxVal, result[i]);
		}
		for (int i = 1; i <= n; i++) {
			if (result[i] == maxVal) {
				System.out.println(maxVal);
			} else {
				System.out.println(0);
			}
		}
	}

	private static void BFS(int i) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(i);
		visited[i] = true;
		while (!queue.isEmpty()) {
			int now_node = queue.poll();
			for (int j : A[now_node]) {
				if (visited[j] = false)
					visited[j] = true;
					result[j]++;
					queue.add(j);
			}
		}	
	}
}
