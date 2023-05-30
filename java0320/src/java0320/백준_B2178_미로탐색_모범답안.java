package java0320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//BFS-2차원배열
public class 백준_B2178_미로탐색_모범답안 {
    static int[][] map;
    static int N, M;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        visited = new boolean[N][M];
        visited[0][0] = true;
        System.out.println(bfs(0,0));
        
    }
    
    public static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});
        
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nextX = temp[0] + dx[i];
                int nextY = temp[1] + dy[i];
                
                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                
                if(!visited[nextX][nextY] && map[nextX][nextY] == 1) {
                    visited[nextX][nextY] = true;
                    map[nextX][nextY] = map[temp[0]][temp[1]] + 1;
                    q.add(new int[] {nextX, nextY});
                }
            }
        }
        return map[N - 1][M - 1];
    }
}
