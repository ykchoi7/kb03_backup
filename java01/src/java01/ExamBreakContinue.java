package java01;

public class ExamBreakContinue {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			if (i==2)
				continue;  //조건 만족할 때 continue 나오면 아래 공식 다 스킵하고 첫 선언문으로 돌아감 -> i++에 들어감 
			if (i==5)
				break;   //break 나오면 바로 for선언문을 빠져나옴
			System.out.println(i);
		}
	}
}
