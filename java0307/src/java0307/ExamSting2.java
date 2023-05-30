package java0307;

//String클래스의 주요 메서드 확인
public class ExamSting2 {
	public static void main(String[] args) {
		String s1 = new String("Hello Java");
		System.out.println(s1);
		System.out.println(s1.length());
		System.out.println(s1.charAt(1));		//1번째 인덱스의 값을 리턴 -> e
		System.out.println(s1.indexOf("Ja"));	//Ja가 있는 인덱스 번호를 리턴, 찾는 글자가 없으면 -1 반환
		System.out.println(s1.replace("a", "o")); //a를 o로 교체 (java -> jovo)
		System.out.println(s1.substring(6,8));	//인덱스 번호 6-7번째 값 추출 (endindex-1 까지만 출력)
		System.out.println(" abc123 ".trim());	//앞뒤 공백 제거
	}
}