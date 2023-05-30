import java.io.FileNotFoundException;
import java.io.FileReader;

public class Exam예외 {

	public static void main(String[] args) throws Exception{
		int[] arr = {1,3,5};
		try {
			System.out.println(arr[3]);
			//한꺼번에 정상적으로 실행해야할 코드 묶음 = 트랜잭션
			new FileReader("hello.txt"); //FilenotFoundException -> main에 throws Exception 진행
			System.out.println("파일열기 성공"); //위에 코드가 실행되지 않으면 이 코드도 실행되지 않음
			String s = null;
			System.out.println(s.length());
		//다중 Exception인 경우 (위에서부터 자식 -> 부모)
		} catch(ArrayIndexOutOfBoundsException ae) {
			System.out.println("배열접근 실패: " + ae.getMessage());
			ae.printStackTrace();
		} catch(FileNotFoundException fe) {
			System.out.println("배열접근 실패: " + fe.getMessage());
			fe.printStackTrace();
		} catch(Exception e) {
			arr[2] = 5;
			System.out.println("기타예외: " + e.getMessage());
		}
		
		//Exception이 하나인 경우
//		catch(Exception e) {
//			//try 이하 실행 중 예외 발생 시 실행할 코드 블록
//			System.out.println("파일열기 실패" + e.getMessage());
//			e.printStackTrace();
//		}
		
		System.out.println("프로그램 종료");
		//try~catch / throws 중에 하나만 사용해야 한다
		//정상 작동이면 -> 파일열기 성공 + 프로그램 종료
		//작동되지 않으면 -> 파일열기 실패 + 프로그램 종료
	}
}
