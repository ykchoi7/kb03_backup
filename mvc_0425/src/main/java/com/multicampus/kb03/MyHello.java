package com.multicampus.kb03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyHello {
	
	@RequestMapping("/hello.cafe")
	public String hello() { //핸들러 메서드
		return "hello";
	}
	
}
