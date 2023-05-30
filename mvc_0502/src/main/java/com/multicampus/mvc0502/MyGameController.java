package com.multicampus.mvc0502;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyGameController {
	
	@GetMapping("/number_guess")
	public String number_guess() {
		return "number_guess";
	}
	
}

