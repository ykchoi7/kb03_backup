package sp0425.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component 
//component를 해야 bean에 등록됨
public class MyAspect2 {
	
	//*      sp0425.aop..MyCalc.*(..)
	//리턴타입  패키지명/경로 (..)모든경로  클래스명  .*(..)메서드명  
	@Before(value="execution(* sp0425.aop..MyCalc.*(..))")  //MyCalc안에 있는 모든 매개변수 불러와서 실행시킴
	public void before() {
		System.out.println("실행전..");
	}
	
}
