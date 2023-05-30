package 비디오도서대여점관리;

import java.util.ArrayList;

public class VideoManager {
	public ArrayList<MyVideo> arr = new ArrayList<>(); 
	
	//등록
	public void add(MyVideo mv1) throws NumberExistException {
		//중복검사
		for (MyVideo myVideo : arr) {
			if (myVideo.getNumber() == mv1.getNumber())
				throw new NumberExistException();
		}
		arr.add(mv1);
	}
	
	//검색
	public MyVideo findByNumber(int number) throws NumberNotFoundException {
		//중복검사
		for (MyVideo myVideo : arr) {
			if (myVideo.getNumber() == number)
				return myVideo;
		}
		throw new NumberNotFoundException(number);
	}

	public int getCount() {
		return arr.size();
	}

	//수정
	public void update(MyVideo mv1) throws NumberNotFoundException {
		MyVideo findVideo = findByNumber(mv1.getNumber());
		for (int i = 0; i < arr.size(); i++) {
			mv1.getStatus(); //대여가능여부 수정
			mv1.getCost(); //대여료 수정
			//대여
			if (findVideo.getStatus() == "대여가능")
				mv1.setStatus("대여중");
			//반납
			if (findVideo.getStatus() == "대여중")
				mv1.setStatus("대여가능");
			//대여료 수정
			mv1.setCost(2000);
		}
	}
	
	//삭제
	public void delete(MyVideo mv1) throws NumberNotFoundException {
		MyVideo findVideo = findByNumber(mv1.getNumber());
		int index = -1;
		for (int i = 0; i < arr.size(); i++) {
			MyVideo video = arr.get(i);
			if (video.getNumber() == mv1.getNumber())
				index = i;
				break;
		}
		if (index == -1)
			throw new NumberNotFoundException(index);
		arr.remove(index);
	}

	//전체출력
	public void printAll() {
		System.out.println("**전체출력**");
		for (MyVideo myVideo : arr) {
			System.out.println(myVideo.toString());
		}
	}

}
