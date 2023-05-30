import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class kb3반_알고리즘2번_최윤경 {
	
	static int[][] A;
	static int m, n; //행, 열의 개수
	static int x, y; //시작좌표
	static boolean[][] visited;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		//2차원 배열에 값 저장
		A = new int[m][n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for (int j = 0; j < n; j++) {
				A[i][j] = Integer.parseInt(line.substring(j, j+1));
			}
		}

//		
//		A = new int[m][n];
//        for(int i = 0; i < m; i++) {
//            String s = br.readLine();
//            for(int j = 0; j < n; j++) {
//                A[i][j] = s.charAt(j) - '0';
//            }
//        }
		
		//시작좌표 읽기
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		//결과 출력
		visited = new boolean[m][n];
		visited[x][y] = true;
		
		int day = 0; //퇴소일자 count 하기 위한 변수
		for (int i = 0; i < m; i++) {
			BFS(x,y);
			day++; //bfs 실행하고 day는 1일씩 추가
			System.out.println(day);
		}
		
		int num = 0; //감염되지 않는 사람의 수 구하기 위해서 교실에 온 전체 학생수를 구해야 함
		for (int i = 0; i < m; i++) {
			for (int j = 1; j < n; j++) {
				num += A[i][j]*1; //교실에 있는 전체 인원을 구하기 위해 각 배열의 값에 1을 곱해서 더한다
				System.out.println(num - BFS(x,y)); //전체인원 - 감염된 사람의 수
			}
		}
	}

	private static int BFS(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {a,b});
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            for(int i = 0; i < 4; i++) {
            	//기준점 (x,y)를 기준으로 i만큼씩 이동하는 것
                int nx = now[x] + dx[i];
                int ny = now[y] + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                
                if(!visited[nx][ny] && A[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    A[nx][ny] = A[now[0]][now[1]] + 1;
                    q.add(new int[] {nx, ny});
                }
            }
        }
        return A[m-1][n-1];
	}
}
