package sp0425.aop.service;

import org.springframework.stereotype.Component;

@Component
public class MyCalc {

	public int plus(int i, int j) {
		return i+j;
	}
	
}
