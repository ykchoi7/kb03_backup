import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kb3반_알고리즘3번_최윤경 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] S = new int[20][20]; //입력값을 저장할 2차원배열
    }
        
    static int loc,cnt;
    //loc는 몇번째 수를 찾는건지, cnt는 그걸 카운팅 하기 위한 변수
    static boolean[] isUsed;
    private static void func(char[] arr, int k) { 
    	int[][] W = new int[20][20]; //승부결과를 저장할 2차원배열
        if(k==arr.length) { 
            cnt++; 
            if(cnt==loc) { 
                for(int i=0;i<arr.length;i++) { //출력
                    System.out.print(W[i]);
                }
                System.out.println();
            }
        }
        else { 
            for(int i=0;i<arr.length;i++) { 
                if(!isUsed[i]) { 
                    isUsed[i] = true;
                    W[k] = W[i]; 
                    func(arr,k+1); 
                    isUsed[i] = false;
                }
            }
        }
    }
}
