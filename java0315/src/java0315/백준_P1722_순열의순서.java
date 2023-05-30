package java0315;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_P1722_순열의순서 {
	public static void main(String[] args) throws IOException {
		int n, q;  //n=순열의 자릿수, q=출력되는 임의의 수들
		long F[] = new long[21]; //입력받은 n개의 숫자를 저장하는 배열공간 - n의 범위가 1~20이기 때문에 배열 21까지 생성
		int S[] = new int[21];  //순열을 담는 배열
		boolean visited[] = new boolean[21]; //각 수에 방문했는지 안 했는지 true, false를 출력하는 배열
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		
		F[0] = 1;
		for (int i = 1; i <= n; i++) {  //팩토리얼 초기화 -> 각 자릿수에서 만들 수 있는 경우의 수
			F[i] = F[i-1] *i;
		}
		
		if (q == 1) {
			long k = Long.parseLong(st.nextToken()); //k - q가 1일 때 입력받는 숫자
			for (int i = 1; i <= n; i++) {
				int cnt = 1;  //cnt - k가 속한 그룹의 순번
				for (int j = 1; j <= n; j++) { 
					if (visited[j])
						continue;
					if (k <= cnt * F[n-i]) {
						k -= ((cnt-1)*(F[n-i]));
						S[i] = j;
						visited[j] = true;
						break;
					}
					cnt++;
				}
			}
			//q=1일 때의 결과 출력
			for (int i = 1; i <= n; i++) {
				System.out.println(S[i] + " ");
			}
		} else {
			long k =1;
			for (int i = 1; i <= n; i++) {
				S[i] = Integer.parseInt(st.nextToken());
				long cnt = 0;
				for (int j = 1; j <= n; j++) {
					if (visited[j] = false) {
						cnt++;
					}
				}
				k += cnt * F[n-1]; //자릿수에 따라 순서를 더함
				visited[S[i]] = true;
			}
			System.out.println(k);
		}
	}
}
