import java.util.Scanner;

public class kb3반_알고리즘3번_최윤경 {
	public static int r, c;
    public static int count;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt(); //행의 개수
        c = sc.nextInt(); //열의 개수
        
        for(int i = 0; i < r; i++) {
            int[] row = new int[r];
            // 시작점은 1열의 각 행에서 가능 -> i행 1열에 개미를 놓는다
            row[0] = i;
            // i행 1열에 개미를 놓았을 경우 가능한 횟수를 dfs로 구한다.
            dfs(row, 0);
        }
        System.out.println(count);
    }

    
    public static void dfs(int[] row, int col) {
        if(col == c) {
            count++;
        }else {
            // 1열 부터 c 열까지 반복하면서 (row+1, i)에 개미를 놓을 수 있는지 확인
            // 있으면 다음행의 dfs를 호출
            for(int i = 1; i <= r; i++) {
                row[col+1] = i;
                if(isPossible(row, col+1)) {
                    dfs(row, col+1);
                }
            }
        }
    }
    
    public static boolean isPossible(int[] row, int col) {
        // 1열부터 col열까지 지나간 적이 있거나 돌이 있는지 확인
        for(int i=0; i < col; i++) {
        	int num = 0; //지나간 횟수 카운트해줘야 간 곳은 피할 수 있음
            // row의 열에 x가 존재하면 반환할 수 없음
            if(row[i] == 'x') return false;
            else num++;
            //지나간 횟수가 1회면 지나갈 수 없음
            if (num == 1) return false;
        }
        return true;
    }
}
