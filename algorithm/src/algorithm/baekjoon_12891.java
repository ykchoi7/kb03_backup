package algorithm;

import java.util.Scanner;

//DNA 비밀번호
public class baekjoon_12891 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt();   //문자열의 개수 입력 받기
		int P = sc.nextInt();   //부분문자열의 개수 입력 받기
		String str = sc.next(); //전체문자열
		int ans = 0;			//정답횟수
		
		int[] arr = new int[4];  //ACGT의 최소 필요횟수
		
		int sidx = 0; //부분문자열의 시작위치
		int eidx = 0; //부분문자열의 끝위치
		
		int[] cnt = new int[4];  //검색된 ACGT의 횟수,상태
		for (int i = 0; i < P; i++) { //상태 초기화
			if (str.charAt(i) == 'A') {
				cnt[0]++;
			} else if (str.charAt(i) == 'C') {
				cnt[1]++;
			} else if (str.charAt(i) == 'G') {
				cnt[2]++;
			} else {  //arr[i] = 'T'
				cnt[3]++;
			}
		}
		
//		//count 개수 산정하는 파트 - 필요없는 부분
//		int count = 0;
//		for (int i = 0; i < P; i++) {
//			int j = arr[i];
//			if (j==P); count++;
//		}
		
		//숫자와 알파벳 개수가 맞는지 여부를 확인
		boolean isans = true; //검색된 결과가 필요갯수를 만족하나?
		for (int i = 0; i < 4; i++) {
			if (cnt[i] < arr[i]) isans = false; //4개중에 하나라도 횟수가 작으면 false
		}
		if (isans == true) ans++;  //4개 숫자가 모두 최소 횟수를 만족하면 정답 횟수 증가
		
		while (true) {  //무한루프 - 조건만족할 때 끝나도록 설정하기!
			isans = true; //정답조건
			char bf = str.charAt(sidx); //삭제할 문자
			//상태갱신
			if (bf == 'A') {
				cnt[0]--;
			} else if (bf == 'C') {
				cnt[1]--;
			} else if (bf == 'G') {
				cnt[2]--;
			} else {  //bf = 'T'
				cnt[3]--;
			}
			//한칸씩이동
			sidx++;
			eidx++;
			
			if (eidx == str.length()) break;  //종료조건
			char nw = str.charAt(eidx);
			if (nw == 'A') {
				cnt[0]++;
			} else if (nw == 'C') {
				cnt[1]++;
			} else if (nw == 'G') {
				cnt[2]++;
			} else {  //nw = 'T'
				cnt[3]++;
			}
			
			//정답조건확인
			for (int i = 0; i < 4; i++) {
				if(cnt[i] < arr[i]) isans = false;
			}
			if (isans == true) ans++;
		}
		
		//결과 도출
		System.out.println(ans);
	}
}
