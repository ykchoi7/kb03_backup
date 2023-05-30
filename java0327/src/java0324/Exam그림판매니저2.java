package java0324;

import java0324.vo.MyDrawable;

public class Exam그림판매니저2 {

	public static void main(String[] args) {
		MyLine ml1 = new MyLine(3,5,4,5); //x1,y1, x2,y2
		MyDrawable md = (MyDrawable) ml1;
		System.out.println(md.draw());
		md = new MyCarPicture(); //인터페이스를 implements하는 클래스 mycarpicture
		System.out.println(md.draw());
		
		//한번에 출력
		MyDrawable[] mdarr = new MyDrawable[2];
		mdarr[0] = ml1;
		mdarr[1] = md;
		for (MyDrawable mdr : mdarr) {
			System.out.println(mdr.draw());
		}
	}
}
