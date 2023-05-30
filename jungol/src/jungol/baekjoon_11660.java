package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_11660 {

	//Scanner가 하나씩 읽기 때문에 현저히 느림
	//bufferedreader로 해야 훨씬 빠름
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//StringTokenizer - 공백을 기준으로 잘라주는 기능
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] A = new int[N+1][N+1]; //배열 저장용 2차원 배열
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//부분합 구하기
		int[][] D = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				D[i][j] = D[i-1][j] + D[i][j-1] - D[i-1][j-1] + A[i][j];
			}
		}
		
//		for (int[] is : D) {
//			System.out.println(Arrays.toString(is));
//		}
		
		//마지막에 질문 m개 받아서 출력하는 코드 기입
		 for (int i = 0; i < M; i++) {
	            st = new StringTokenizer(br.readLine());
	            int x1 = Integer.parseInt(st.nextToken());
	            int y1 = Integer.parseInt(st.nextToken());
	            int x2 = Integer.parseInt(st.nextToken());
	            int y2 = Integer.parseInt(st.nextToken());
	            //  부분 합 배열을 이용한 질의 답변하기
	            int result = D[x2][y2] - D[x1 - 1][y2] - D[x2][y1 - 1] + D[x1 - 1][y1 - 1];
	            System.out.println(result);
	          }
	}
}
		
		
		
//		내 코드,,
//		
//		int x1, y1, x2, y2 = sc.nextInt();
//		int[][] a = new int[x1][y1];
//		int[][] b = new int[x2][y2];
//				
////		첫 번째 좌표 [x1][y1];
////		두 번째 좌표 [x2][y2];
//		
//		for (int i = x1; x1 <= x2; x1++) {
//			int sum = 0;
//			i = x1;
//			sum += i;
//		}
//		
//		for (int j = x1; j <= y2; j++) {
//			int sum1 = 0;
//			j = y1;
//			sum1 += j;
//		}
//		
//		System.out.println();
//	}

