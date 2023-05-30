package java0314;

import java.util.Arrays;

public class 연속된숫자의조합_재귀 {
	private static int n, m;
    private static int[] arr; // 원소를 저장할 배열
    private static boolean[] visited; // 중복을 제거하기 위한 방문 처리
    
    //조합에서는 [1,2]와 [2,1]을 동일하게 여긴다
    public static void main(String[] args) {
        n = 4; // 전체숫자갯수
        m = 2; // 선택숫자갯수
        arr = new int[m]; //선택숫자저장용
        combination(0, 1); // combination(시작인덱스번호, 시작숫자번호)
    }
    
    //조합 (n개 중에 r개 선택, 순서 상관없이 하나로 간주)
    //기본형식 void combination(int arr[], int index, int n, int r, int target);
    private static void combination(int cnt, int start) { //cnt 저장된 갯수, 시작숫자
        if (cnt == m) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = start; i <= n; i++) {
            arr[cnt] = i;
            combination(cnt + 1, i + 1); // 오름차순으로 구하면 중복 체크하지 않아도 됨
        }
    }
}
