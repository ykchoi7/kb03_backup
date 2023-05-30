package sp0425.aop.service;

import org.springframework.stereotype.Component;

@Component
public class HelloService {
	
	public String sayHello() {
		return "Hello";
	}

	public String sayHello(String name) {
		return "Hello" + name;
	}
	
}
