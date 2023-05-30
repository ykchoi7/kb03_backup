package sp0425.aop.aspect;

import java.security.Signature;
import org.aspectj.lang.JoinPoint;

public class MyAspect {

	public void printBefore(JoinPoint jp) {
		System.out.println("Before!");
		Signature sig = (Signature) jp.getSignature(); //호출 대상에 대한 정보 추출
		String name = ((org.aspectj.lang.Signature) sig).getName();
		System.out.println("Target Name: " + name);
		Object[] args = jp.getArgs();
		System.out.println("Arg갯수: "+ args.length);
	}
	
	
	public void printAfter(Object rtn) { //어떤 타입일지 모르기 때문에 object타입으로 받기
		System.out.println("**After**");
		System.out.println("반환값="+ rtn);
	}
	
}
