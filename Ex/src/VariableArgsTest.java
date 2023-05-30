
public class VariableArgsTest {
	public double calc(double a, double b, char oper) {
		if (oper == '+') {
			return a+b;		//조건별 결과값 반환
		} else if (oper == '-') {
			return a-b;
		} else {
			return 0;
		}	
	}

	//출력
	public static void main(String[] args) {
		VariableArgsTest va = new VariableArgsTest();
		System.out.println(va.calc(1.0, 2.0, '+'));
	}
}
