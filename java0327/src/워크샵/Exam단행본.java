package 워크샵;

public class Exam단행본 {

	public static void main(String[] args) {
		MyBook mb1 = new MyBook("책제목", 0000, 20000, "출판사");
		System.out.println(mb1);
		
		MyMagazine mm1 = new MyMagazine("책제목", 0000, 20000, "출판사", 1, 13);
		System.out.println(mm1);
	}

}
