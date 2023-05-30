package java0317;

import java.util.Arrays;
import java.util.Comparator;

public class ExamComparable {
	public static void main(String[] args) {
		Meeting[] ma = new Meeting[3]; //객체는 new의 갯수에 따라 하나씩 생성, 타입은 Meeting[]
		ma[2] = new Meeting(1,4);  //생성자를 만들어야 함
		ma[1] = new Meeting(3,5);
		ma[0] = new Meeting(0,6);
		System.out.println(Arrays.toString(ma)); //값을 입력하지 않은 부분은 default null로 출력
		Arrays.sort(ma); //끝나는 시간 기준으로 정렬됨
		System.out.println(Arrays.toString(ma));
		//사용자정의정렬기 - Comparator는 인터페이스
		Comparator<Meeting> ct = new StartTimeComparator();
		ct = new Comparator<Meeting>() {  //익명클래스 정의
			@Override
			public int compare(Meeting o1, Meeting o2) {
				return o1.start - o2.start;
			}
		};
		Arrays.sort(ma, ct);
		System.out.println(Arrays.toString(ma));
		//
		A a1 = new B();
		a1 = new A() { //메서드 재정의
			int prn() {
				return 200;
			}
		};
		System.out.println(a1.prn()); //100 -> 내부적으로 재정의하면 재정의한 값인 200을 출력
		System.out.println("클래스명은 " + a1.getClass().getName()); //클래스명+$1은 "임의의 클래스명 첫번째꺼라는 의미"
	}
}


//익명클래스 - Anonymous Class
//상속, 인터페이스 구현 시 생성할 클래스의 이름을 부여하는게 정상
//구현한 메서드가 1개이거나, 부모 타입의 모든 메서드들 재정의할 때 클래스 이름 생략할 수 있다.
class A {
	int prn() {
		return 1;
	}
}
class B extends A{
	int prn() {
		return 100;
	}
}


//Comparator 실행
class StartTimeComparator implements Comparator<Meeting> {

	@Override
	public int compare(Meeting o1, Meeting o2) {
		return o1.start - o2.start;  //start time 기준으로 오름차순 정렬
	}
}


//Comparable 실행
/** 회의정보) start=시작시간, end=종료시간 */
class Meeting implements Comparable<Meeting> { //compareTo메서드를 overriding 안하면 Meeting에 오류 보임
	int start, end;

	public Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Meeting o) {
		return this.end - o.end; //결과가 음수면 this 앞, 결과가 양수면 this 뒤
	}

	@Override
	public String toString() {
		return start +"-"+ end;
	}
} //한번 생성 후에는 수정이 안됨 -> 그래서 따로 Comparator로 정렬기를 만들어주는 것
