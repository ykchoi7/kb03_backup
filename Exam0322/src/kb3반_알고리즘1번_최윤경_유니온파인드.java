import java.util.Scanner;

public class kb3반_알고리즘1번_최윤경_유니온파인드 {

	private static int[] parent;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt(); //총 마을 사람의 수
	    int m = sc.nextInt(); //관계의 수
	    parent = new int[n + 1]; //노드를 저장하는 변수
	    
	    //친구 관계 상세 정보를 2차원 배열에 저장
//		int[][] arr = new int[n+1][2];
//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= 2; j++) {
//				arr[i][j] = sc.nextInt();
//			}
//		}
//		
//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= n ; j++) {
//				if (arr[i][j] == 1) {
//					union(i, j);
//				} 
//			}
//		}
		
	    for (int i = 0; i <= n; i++) { // 대표 노드를 자기 자신으로 초기화 하기
	      parent[i] = i;
	    }
	    
//	    int index = 0;
//		for (int i = 1; i <= n; i++) {
//			if (index != find(i)) { //2의 대표번호, 3의 대표번호와 1의 대표번호를 비교하여 모두 같아야만 yes
//				index++;
//				return; // 종료조건
//			}
//		}
//		System.out.println(index);
	    
		
	    for (int i = 0; i < m; i++) {
	      int question = sc.nextInt();
	      int a = sc.nextInt();
	      int b = sc.nextInt();
	      int count = 0;
	      if (question == 0) { // 집합합치기
	        union(a, b);
	      } else { // 같은 집합의 원소인지 확인하기
	        if (checkSame(parent[1], b)) {
	        	count++;
	        	System.out.println(count);
	        } break;
	      }
	    }
	  }


	public static void union(int a, int b) { // union 연산 : 바로 연결이 아닌 대표 노드끼리 연결하여 줌
	    a = find(a);
	    b = find(b);
	    if (a != b) {
	      parent[b] = a;
	    }
	}
	
	public static int find(int a) { // find 연산
	    if (a == parent[a])
	      return a;
	    else
	      return parent[a] = find(parent[a]); // 재귀함수의 형태로 구현
	}
	
	public static boolean checkSame(int a, int b) { // 두 원소가 같은 집합인지 확인
	    a = find(a);
	    b = find(b);
	    if (a == b) {
	        return true;
	    }
	    return false;
	}
}

