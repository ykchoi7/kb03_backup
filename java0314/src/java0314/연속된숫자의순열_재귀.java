package java0314;

//**이 알고리즘은 외우는 것을 추천**//
import java.util.Arrays;

public class 연속된숫자의순열_재귀 {
	private static int n, m;
    private static int[] arr; // 원소를 저장할 배열
    private static boolean[] visited; // 중복을 제거하기 위한 방문 처리

    public static void main(String[] args) {
        n = 4; //전체 숫자 갯수
        m = 2; //선택 숫자 갯수
        arr = new int[m]; //선택 숫자 저장용
        visited = new boolean[n + 1];
        permutation(0);
    }
    	//**visited - 중복 방지를 위해 방문했는지 여부를 true, false로 반환하는 boolean형태의 배열이 필요
    	//visited에 선택된 숫자에 대한 true, false 여부 저장
    
        //**permutation() 메소드 - nPr을 계산하는 함수
        //작성방법 - permutation(int[] arr, int depth, int n, int r) {}
        //arr 대상 배열, depth 단계, n 총 숫자 갯수, r 선택 가짓수

    
    // 순열
    private static void permutation(int cnt) { //permutation은 가장 depth 깊은 곳까지 들어가서 역순으로 추출되는 형식
        //종료조건검사
    	if (cnt == m) { //cnt는 선택된 수들을 넣을 때 각 인덱스 값 -> cnt==m일 때, 즉 2개 뽑아야하는 상황에서 다 뽑히면 종료
            System.out.println(Arrays.toString(arr));  //종료조건 - 리스트에 담아서 출력
            return;
        }
    	//로직처리
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) { //i번째 방문여부가 false일때 
                visited[i] = true; //이제 방문을 했기 때문에 true로 바꿔주고
                arr[cnt] = i;	//i의 값을 arr배열 cnt번째에 넣어줌
                //같은메서드 호출
                permutation(cnt + 1); //다음 cnt로 옮기기
                visited[i] = false; //조건을 만족한 다음에 depth에 내려왔을 때 문자를 교체시켜주기 위해 기존꺼를 false로 바꿔줌
            }
        }
    }
}
