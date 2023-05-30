package java0322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소신장트리_P1414_불우이웃돕기 {
	  static int[] parent; //노드별 대표노드번호
	  static int N; //전체 커퓨터 댓수
	  static int sum; // 총 랜선의 길의 저장
	  static PriorityQueue<lEdge> queue; //노드간 연결 가중치를 저장.오름차순
	  
	  public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    queue = new PriorityQueue<>();
	    for (int i = 0; i < N; i++) { // 행갯수
	      st = new StringTokenizer(br.readLine()); // 1개행 읽기
	      char[] tempc = st.nextToken().toCharArray();
	      //"abc" -> ['a','b','c'] 문자열 한 단위씩 쪼개기
	      for (int j = 0; j < N; j++) {
	        int temp = 0; //알파벳을 숫자로 변환한 값
	        if (tempc[j] >= 'a' && tempc[j] <= 'z')//소문자 알파벳이면
	          temp = tempc[j] - 'a' + 1;
	        else if (tempc[j] >= 'A' && tempc[j] <= 'Z')//대문자 알파벳이면
	          temp = tempc[j] - 'A' + 27;
	        sum = sum + temp; // 총 랜선의 길의 저장
	        if (i != j && temp != 0)queue.add(new lEdge(i, j, temp));
	      }
	    }
	    
	    parent = new int[N];
	    for (int i = 0; i < parent.length; i++)
	        parent[i] = i;
	    
	    int useEdge = 0;
	    int result = 0;
	    while (!queue.isEmpty()) { // 최소 신장 트리 알고리즘을 수행하여 줍니다.
	      lEdge now = queue.poll();//큐의 맨앞 요소 삭제및 반환
	      if (find(now.s) != find(now.e)){ // 같은 부모가 아니라면 -> 연결 가능
	        union(now.s, now.e);
	        result = result + now.v;
	        useEdge++;
	      }
	    }
	    if (useEdge == N - 1) System.out.println(sum - result);
	    else System.out.println(-1);
	  }
	  public static void union(int a, int b) { // union 연산 : 대표 노드끼리 연결하여 줌
	    a = find(a); b = find(b);
	    if (a != b) parent[b] = a;
	  }
	  public static int find(int a) { // find 연산
	    if (a == parent[a]) return a;
	    else return parent[a] = find(parent[a]); // 재귀함수의 형태로 구현 -> 경로 압축 부분
	}
	}
	class lEdge implements Comparable<lEdge> {
	  int s, e, v;
	  lEdge(int s, int e, int v) {
	    this.s = s;
	    this.e = e;
	    this.v = v;
	  }
	  @Override
	  public int compareTo(lEdge o) {
	    return this.v - o.v;
	  }
}

