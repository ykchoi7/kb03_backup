package java0315;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_9742_순열 {
	
    static int cnt, num, totalCnt;
    public static char[] arr;
    public static boolean[] visited;
    public static String answer;
	
    //순열 : n개 중에 r개를 순서있게 뽑기 (재귀)
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        while((input = br.readLine())!= null) { //입력받는 갯수가 따로 정해져있지 않기 때문에 읽어들이는 수가 null이 아닐 때까지 반복
            StringTokenizer st = new StringTokenizer(input);
            String s = st.nextToken();
            num = Integer.parseInt(st.nextToken());

            totalCnt = 0;
            arr = new char[s.length()];
            visited = new boolean[s.length()];
            
            DFS(s, 0);
            
            //해당하는 수열이 없는 경우의 조건식을 먼저 작성
            if(totalCnt < num) answer = "No permutation";
            System.out.println(s + " " + num + " = "+answer);
        }
    }

	public static void DFS(String str, int cnt) {
    
    if(cnt == str.length()) {
        totalCnt++;
        if(totalCnt == num) answer = new String(arr);
        return;
    }
    
    for(int i = 0; i < str.length(); i++) {
        if(!visited[i]) {
            visited[i] = true;
            arr[cnt] = str.charAt(i);
            DFS(str, cnt + 1);
            visited[i] = false;
        }
    }
	}
}
	
