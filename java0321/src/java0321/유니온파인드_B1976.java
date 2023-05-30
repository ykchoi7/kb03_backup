package java0321;

import java.util.Scanner;

//여행계획 짜기 p.286
public class 유니온파인드_B1976 {
	
	public static int[] route;
	public static int[] parent;


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //도시의 개수
		int m = sc.nextInt(); //여행루트의 개수
				
		//연결된 도시를 2차원 배열에 저장
		int[][] arr = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		//route 배열 초기화
		route = new int[m+1];
		for (int i = 1; i <= m; i++) {
			route[i] = sc.nextInt();
		}
		
		//parent 배열 초기화
		parent = new int[n+1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		
		//2차원 배열에서 좌표의 값이 1이면 연결되는 도시 union 진행
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n ; j++) {
				if (arr[i][j] == 1) {
					union(i, j);
				} 
			}
		}
		
		//**이 부분을 잘 몰랐음** 루트와 여행계획에 속한 도시들이 잘 연결되어있는지 확인하는 부분
		int index = find(route[1]); //index는 1의 대표번호
		for (int i = 1; i <= n; i++) {
			if (index != find(route[i])) { //2의 대표번호, 3의 대표번호와 1의 대표번호를 비교하여 모두 같아야만 yes
				System.out.println("NO");
				return; // 종료조건
			}
		}
		System.out.println("YES");
	} //main 구간 끝
	
//	필요없음	
//	private static boolean checkSame(int i, int j) {
//		i = find(i);
//		j = find(j);
//		if (i == j)
//			return true;
//		else
//			return false;
//	}


	private static void union(int i, int j) {
		i = find(i);
		j = find(j);
		if (i != j) {
			parent[j] = i;
		}
	}

	private static int find(int i) {
		if (parent[i] == i)
			return i;
		else 
			return parent[i] = find(parent[i]); //재귀함수 형태로 구현 - 경로 압축
	}
	
}
