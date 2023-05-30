package java0315;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_9742_순열_참고답안2 {
    static char[] arr; //처음에 입력받은 배열
    static char[] arr2; //새로 만들어지는 수들 저장

    static int loc,cnt;
    //loc는 몇번째 수를 찾는건지, cnt는 그걸 카운팅 하기 위한 변수
    static boolean[] isUsed;
    private static void func(char[] arr, int k) { //현재까지 k개의 글자 선택
        if(k==arr.length) { //글자하나가 완성되었다면
            cnt++; //몇번째 배열인치 찾기
            if(cnt==loc) { //만약 찾아야하는 배열과 같다면
                for(int i=0;i<arr.length;i++) { //출력
                    System.out.print(arr2[i]);
                }
                System.out.println();
            }
        }
        else { //글자하나가 아직 완성되지 않은 경우
            for(int i=0;i<arr.length;i++) { 
                if(!isUsed[i]) { //사용한 글자인지 확인
                    isUsed[i] = true; //사용안했다면 사용했다고 체크
                    arr2[k] = arr[i]; //k번째 글자에 i번째 글자를 저장
                    func(arr,k+1); //k+1번째 글자 저장
                    isUsed[i] = false; //다음 글자 생성을 위해 사용 안함으로 바꿔주기
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String l = null;
        while((l=br.readLine())!=null) { //테케 갯수가 정해져 있지 않기에 읽은 라인이 null일때까지 반복
            cnt = 0; //카운팅 초기화
            StringTokenizer st = new StringTokenizer(l);
            String s = st.nextToken();
            arr = s.toCharArray();
            loc = Integer.parseInt(st.nextToken());
            isUsed=new boolean[arr.length];
            arr2 = new char[arr.length];
            System.out.print(s+" "+loc+" = "); //입력받은 것 출력
            func(arr,0); //함수 호출
            if(loc>cnt) { //없는 경우 출력문구
                System.out.println("No permutation");
            }
        }
    }
}
