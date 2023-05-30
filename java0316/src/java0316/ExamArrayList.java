package java0316;

import java.io.CharArrayReader;
import java.util.ArrayList;

public class ExamArrayList {

	public static void main(String[] args) {
		//ArrayList, Wrapper 클래스
		//Wrapper 클래스 -> 기본자료형 (byte, short, int, long, float, double, boolean)
		//기본자료형 -> 객체화시킴 (자료구조에 저장, 형변환 목적)
		//byte->Byte, short->Short, int->Integer
		
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(100); //저장타입 Integer
		//다른 arraylist 자료를 전체 불러오려면 addAll(Collection) 함수 사용
		int i = 100;
		Integer ii = new Integer(i);  //int->Integer : Boxing
		int j = new Integer(200);  //Integer->int : Unboxing (기본자료형으로 바꾸는것)
		
		//String은 wrapper클래스에서 제공이 안되기 때문에 변환하는 메서드가 필요
		//바로 변환은 안되고 아래 두가지 방법으로 가능
		int k = new Integer("100");  //new String("100") 대신 이렇게 표현
		int k2 = Integer.parseInt("200");
		String s = "300";
		//결론, wrapper클래스 사용안하고 바로 String을 ArrayList로 변환하는 방법
		char[] cs = s.toCharArray(); //arraylist로 변환
		
		//값 저장
		arr.add(200);
		arr.add(300);
		System.out.println("저장갯수=" + arr.size());
		System.out.println("arr.get(1)=" + arr.get(1));
//		System.out.println(arr.get(3));  //3번 인덱스는 없기 때문에 IndexOutOfBoundsException 오류 발생
		System.out.println("300의 위치=" + arr.indexOf(300));
		System.out.println("400의 위치=" + arr.indexOf(400));  //-1출력 -> -1이 나오면 값이 없다는 의미
		int rm = arr.remove(1);	//1번 인덱스의 자료 삭제
		System.out.println("삭제된 자료=" + rm);
		System.out.println("저장갯수=" + arr.size());
	}
}
