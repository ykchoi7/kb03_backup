package sp0425.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sp0425.aop.service.HelloService;
import sp0425.aop.service.MyCalc;

public class Main02 {
	public static void main(String[] args) {
		String path = "applicationContext_02.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		MyCalc mc = context.getBean(MyCalc.class);
		int r = mc.plus(3,4);
		System.out.println("result="+r);
		//.getName()�� �غ��� ��¥ �̸��� ����� �� ���� - $:inner class�� ������ ������ 
		System.out.println(mc.getClass().getName());
	}
}
