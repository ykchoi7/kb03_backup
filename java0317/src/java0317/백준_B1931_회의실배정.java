package java0317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

//회의실배정
public class 백준_B1931_회의실배정 {
		
	public static void main(String[] args) throws Throwable, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //회의의 개수
        int[][] arr = new int[n][2]; //시작시간과 끝시간이 들어간 2차 배열로 만들어야 함
        
        for (int i = 0; i < n; i++) {
			arr[i][0] = Integer.parseInt(br.readLine()); //시작시간을 0번째 인덱스에 넣어주고
			arr[i][1] = Integer.parseInt(br.readLine()); //끝시간을 1번째 인덱스에 넣어준다
		}
        
        //comparator - 두 객체를 비교할 수 있도록 하는 인터페이스
        //Comparable - compareTo(T o) : 매개변수 1개, 자기자신과 매개변수 1개를 비교
        //Comparator - compare(T o1, T 02) : 매개변수 2개, 두 매개변수 객체를 비교
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] S, int[] E) {
              if (S[1] == E[1]) { // 종료 시간이 같을 경우
                return S[0] - E[0]; //start와 end를 비교
              }
              return S[1] - E[1];
            }
          });
          int count = 0;
          int end = -1;
          for (int i = 0; i < n; i++) {
            if (arr[i][0] >= end) { // 겹치지 않는 다음 회의가 나온경우
              end = arr[i][1]; // 그 다음 들어온 배열의 종료시간으로 업데이트
              count++;
            }
          }
          System.out.println(count);          
	}
}
