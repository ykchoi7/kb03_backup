package java0316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

//스택 활용한 연결요소 개수 파악 - 처음에 배열에 저장해두고 새로운 것을 스택에 저장
public class DFS_연결요소의개수_스택 {
	static int N, M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        
        //스택을 DFS 실행할 때 사용
        int answer = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                answer++;
                s.push(i);
                while (!s.empty()) {
                    int u = s.pop();
                    visited[u] = true;
                    for (int v : graph[u]) {
                        if (!visited[v]) {
                            visited[v] = true;
                            s.push(v);
                        }
                    }
                }                
            }
        }
        System.out.println(answer);
    }
}
