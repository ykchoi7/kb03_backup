package java01;

public class ExamFor2 {
	public static void main(String[] args) {
		System.out.println("***구구단***");

		//이중for문
		for (int dan = 2; dan <= 9; dan++) {
			System.out.println("**"+dan+"단**");
			for (int i = 1; i <= 9; i++) {
				System.out.println(dan+"*"+i+"="+(dan*i));
			}
		}
		
	}
}
