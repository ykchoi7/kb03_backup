package java0324;

import java0324.vo.MyShape;

public class Exam그림판 {

	public static void main(String[] args) {
		//공통 변수 부모클래스 생성 MyShape - (x1, y1)
//		MyShape ms1 = new MyShape(3,5); //x1,y1
//		//생성자가 있으면 기본생성자인 MyShape()을 제공하지 않아서 값이 없으면 오류 발생, 의미가 없다고 생각하기 때문
//		System.out.println(ms1);
		
		//선 클래스
		MyLine ml1 = new MyLine(3,5,4,5); //x1,y1, x2,y2
		System.out.println(ml1);
		
		MyRect mr1 = new MyRect(5,7,10,15); //x1,y1, width, height
		System.out.println(mr1);
		
		MyCircle mc1 = new MyCircle(3,10,5); //x1,y1, radius
		System.out.println(mc1);
		
		//다각형 MyPolygon을 만들고 싶을 때
		//다각형 사용 샘플코드는?
//		//1) 배열에 넣어서 점마다 묶기
//		MyPolygon mp1 = new MyPolygon(3, int[] {1,1}, int[] {3,3}, int[] {2,4});
//		//2) 첫번째 좌표를 시작으로 한 점씩 add하는 방식
//		MyPolygon mp1 = new MyPolygon(1,1);
//		map.add(2,3);
//		map.add(4,7);
	}
}
