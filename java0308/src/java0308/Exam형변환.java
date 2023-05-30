package java0308;

public class Exam형변환 {

	public static void main(String[] args) {
		byte b = (byte)200;   //127 ~ -128 까지만 byte로 저장 가능
		byte a = 127;  		 //-> 127초과의 수는 (byte)로 직접 형변환 필요
							//0으로 시작->양수, 1로 시작->음수
		
		String s = Integer.toBinaryString(200);
		System.out.println(s);  //200을 2진수로 표현한 것 11001000
		System.out.println(b);  //첫번째 값이 1이면 음수로 표현 -56
		System.out.println(a);
		
		
		short sh = b;  //sh -> 16진수, b -> 8진수
		b = (byte)sh;
		System.out.println(b);
		
		//문자형 -> 정수형 변환 가능
		char c = '가';
		int i = c;
		System.out.println((int)c);
		System.out.println(i);
		
//		boolean boo = (boolean) 0;  //boolean은 유일하게 형변환이 안됨
		
		
		//글자를 숫자로 변환하는 방법
		String s1 = "350";
//		System.out.println(int(s1));  //String 전체를 바로 int로 변환시킬 수 없음 -> 한 char 문자씩 변환해줘야함
//		char d = s1.charAt(0);
//		System.out.println(int(d));
		int diff = s1.charAt(0) - '0';
		System.out.println(diff);
		diff *= 10;
		diff += (s1.charAt(1) - '0');
		System.out.println(diff);
		diff += (s1.charAt(2) - '0');
		diff *= 10;
		System.out.println(diff);
		
	}

}
