package sp0425.aop.aspect;

import java.security.Signature;
import org.aspectj.lang.JoinPoint;

public class MyAspect {

	public void printBefore(JoinPoint jp) {
		System.out.println("Before!");
		Signature sig = (Signature) jp.getSignature(); //ȣ�� ��� ���� ���� ����
		String name = ((org.aspectj.lang.Signature) sig).getName();
		System.out.println("Target Name: " + name);
		Object[] args = jp.getArgs();
		System.out.println("Arg����: "+ args.length);
	}
	
	
	public void printAfter(Object rtn) { //� Ÿ������ �𸣱� ������ objectŸ������ �ޱ�
		System.out.println("**After**");
		System.out.println("��ȯ��="+ rtn);
	}
	
}
