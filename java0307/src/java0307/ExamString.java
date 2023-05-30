package java0307;

public class ExamString {
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "abc";
		String s3 = new String("abc");
		String s4 = new String("abc");
		
		System.out.println(s1 == s2);  //주소값 비교 -> true 출력 (기존에 있던 abc 주소값을 반환하기 때문에 동일)
		System.out.println(s1 == s3);  //주소값 비교 -> false 출력
		System.out.println(s3 == s4);  //주소값 비교 -> false 출력 (new로 새로 만들었기 때문에 주소값 다름)
		
		//문자열 값을 비교 -> 어떤 데이터 타입이든 .equals() 메소드 사용
		System.out.println(s1.equals(s3));  //내용 비교 -> true 출력
		System.out.println(s3.equals(s4));  //내용 비교 -> true 출력
		
		
		s1 = s1+s1;
		System.out.println(s1);  //한번 할당하면 지워지지도 않고 남아있음 -> 너무 많은 연산을 하면 메모리 과용이 심함
	}
}
