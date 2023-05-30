package java0317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_회의실배정_Meeting클래스활용 {
    public static int getSchedule(Meeting[] m) {

        Arrays.sort(m); // 회의 종료시간(오름) 순서대로 정렬
        int beforeEnd = m[0].end; // 첫번째 회의 확정
        int cnt = 1;
        for (int j = 1; j < m.length; j++) {
            // 확정된 앞 회의의 종료시간이 다음 회의시작보다 같거나 크다면 회의 확정
            if (beforeEnd <= m[j].start) {
                ++cnt;
                beforeEnd = m[j].end;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine().trim());
        Meeting m[] = new Meeting[count];

        StringTokenizer st = null;
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            m[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        System.out.println(getSchedule(m)); //위에 getSchedule static 메서드로 이동
    }
    
    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;
        
        public Meeting(int start, int end) {
            super();
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            
        	if (this.end == o.end)  //종료시간이 같으면
        		return this.start - o.start; //두개의 시작시간을 비교
        	return this.end - o.end;
        	
//            int value = Integer.compare(end , o.end); 
//            if(value != 0){ // 종료시간이 다르다면
//                return value;
//            }
//            return Integer.compare(start, o.start); // 종료시간이 같을 경우 시작시간이 빠른 순으로 정렬되도록 한다.
        }
    }
}

//class Meeting { 
//	같은 패키지 안에서 같은 클래스명이 두 개 있으면 오류 발생 -> 클래스명 변경해주거나, 이번 클래스명 안에서 선언
//}
