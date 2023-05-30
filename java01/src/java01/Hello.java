package java01;

public class Hello {

	public static void main(String[] args) {
		System.out.println("Hello 자바");  //ctrl+d : 줄 삭제
										  //sysout(작성)+(ctrl+space)
		char c1 = '가';
		System.out.println(c1);
		System.out.println((int)c1);  		//ctrl+alt+아래 화살표 (아래에 같은 줄 복사)
		System.out.println((char)(c1+1));  //alt+화살표 위/아래 (위, 아래로 줄 이동)
		System.out.println((char)(c1+2));
		System.out.println((char)(c1+3));  //숫자 앞에 타입을 기재해줌으로써 그 타입으로 변환
		
		System.out.println(99/10);  // 정수/정수 = 정수 (정수부만 남음)
		System.out.println(99/10.0); // 정수/실수 = 실수 (소수 이하 보존)
	}

}
