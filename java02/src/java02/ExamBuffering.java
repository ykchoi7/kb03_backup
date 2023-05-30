package java02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//보통 timeout이 발생했을 때 buffering 실행 필요!
public class ExamBuffering {

	public static void main(String[] args) throws Throwable {
//		Scanner sc = new Scanner(System.in);
		//InputStream (1 byte 단위 전송) -> 
		//InputStreamReader (1 byte -> 2 byte로 모아서 전송) -> 
		//BufferedReader (2 byte씩 8K 버퍼링) -> 
		//br.readLine() (한 줄씩 읽어들임) ==> 속도 훨씬 빨라짐
		InputStreamReader isr = new InputStreamReader(System.in);  //isr이 약자
		BufferedReader br = new BufferedReader(isr);
		String line = br.readLine();   //throws IOException - 오류가 날 수도 있음을 나타냄
		System.out.println("line =" +line);
		//공백기준 글자 분할 (토크닝, 파싱(Parsing))
		StringTokenizer st = new StringTokenizer(line); //line 기준으로 나누기
		String s1 = st.nextToken();  //공백으로 나누어진 글자
		System.out.println("s1=" + s1);
		s1 = st.nextToken();  //공백으로 나누어진 글자
		System.out.println("s1=" + s1);
		s1 = st.nextToken();  //공백으로 나누어진 글자
		System.out.println("s1=" + s1);
	}
}
