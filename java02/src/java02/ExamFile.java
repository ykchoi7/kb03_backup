package java02;

import java.io.File;

public class ExamFile {

	public static void main(String[] args) {
		File f = new File(".");  // . => 현재 폴더를 의미
		System.out.println(f.getAbsolutePath());  //현재 폴더의 경로는 어디인지 확인 가능
		String[] list = f.list();
		for (String string : list) {
			System.out.println(string);
		}
	}

}
