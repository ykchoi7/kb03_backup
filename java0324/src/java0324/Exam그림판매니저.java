package java0324;

import java.util.ArrayList;

import java0324.vo.MyShape;

public class Exam그림판매니저 {
	public static void main(String[] args) {
		//MyShapeManager : 도형 객체를 저장, 검색, 수정, 삭제, 리스트, 갯수 정보 제공
		
		//등록
		MyShapeManager msm = new MyShapeManager();
		MyLine ml1 = new MyLine(3,5,4,5); //x1,y1, x2,y2
		msm.add(ml1); //선객체 저장
		
		//매니저클래스가 없다면 각 타입별 리스트를 따로 만들어어야 함, 타입별 갯수도 따로 관리해야한다
		//도형 검사할 때 타입별 따로 검사
		
		//선 객체 저장
		ml1 = new MyLine(5,5,6,6); //x1,y1, x2,y2
		msm.add(ml1); //선객체 저장
		
		//사각형 객체 저장
		MyRect mr1 = new MyRect(5,7,10,15); //x1,y1, width, height
		msm.add(mr1); //add가 존재하지만 아직 데이터타입이 myline까지밖에 없어서 에러 발생 -> 다른 데이터타입을 저장해주는 오버로딩 필요
		
		//서클 객체 저장
		MyCircle mc1 = new MyCircle(3,10,5); //x1,y1, radius
		msm.add(mc1);

		int count = msm.getCount();
		System.out.println("저장갯수=" + count);
		
		//저장된 전체 객체의 정보를 출력
		msm.printAll();
		
		//좌표 검색 x=3, y=4인 도형 추출
		MyShape m = msm.findByPosition(3,4);
		//좌표가 있는지, 없는지 확인하려면 어떤 조건으로 작성해야하나?
		if (m == null) 
			System.out.println("없음");
		else
			System.out.println("있음");
		
		//arraylist 결과 추출
//		ArrayList<MyShape> list = msm.findByPosition(3, 4);
//		if (list.size() == 0) 
//			System.out.println("없음");
//		else
//			System.out.println("있음");
		
	}
}
