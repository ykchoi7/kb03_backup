package java0307;

public class ExamStringBuilder {
	public static void main(String[] args) {
		String s = "0123456789";
		//5000번 연결
		String s1 = s;
		long start = System.currentTimeMillis();  //millisecond 단위로 시간을 재는 메서드
		for (int i = 0; i < 10000; i++) {
			s1 += s; //문자열 연결
		}
		long end = System.currentTimeMillis();
		System.out.println("걸린 시간 : " + (end-start));  //148ms
		
		
		//더 빠르게 연산하고 싶을 때 -> StringBuffer, StringBuiler 사용 (100배 이상 빠름)
		StringBuilder sb = new StringBuilder("0123456789");
		long start2 = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			sb.append(s);
		}
		String s2 = sb.toString();
		long end2 = System.currentTimeMillis();
		System.out.println("걸린 시간 : " + (end2-start2));  //0ms
		
	} //end main
}
