package sp0425.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component 
//component�� �ؾ� bean�� ��ϵ�
public class MyAspect2 {
	
	//*      sp0425.aop..MyCalc.*(..)
	//����Ÿ��  ��Ű����/��� (..)�����  Ŭ������  .*(..)�޼����  
	@Before(value="execution(* sp0425.aop..MyCalc.*(..))")  //MyCalc�ȿ� �ִ� ��� �Ű����� �ҷ��ͼ� �����Ŵ
	public void before() {
		System.out.println("������..");
	}
	
}
