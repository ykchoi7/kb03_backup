package java01;

public class ExamString {
	public static void main(String[] args) {
		String s1 = new String("Hello");  //new -> heap영역에 해당
		String s4 = new String("Hello");  //똑같이 heap영역에 해당
		String s2 = "Hello";  //String Literal (new가 기재되지 않은 것) -> class영역에 해당
		String s3 = "Hello";  //똑같이 class영역에 해당
	}
}
