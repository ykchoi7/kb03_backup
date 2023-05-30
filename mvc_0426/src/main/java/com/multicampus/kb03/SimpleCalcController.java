package com.multicampus.kb03;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SimpleCalcController {
	
	@RequestMapping(value="/simple_calc", method=RequestMethod.GET)
	public String simple_calc(Model model) {
		return "simple_calc";
	}

	@RequestMapping(value="/simple_calc", method=RequestMethod.POST)
	public String simple_calc_post(
			Model model, 
			@RequestParam("n1") int n1, 
			@RequestParam("opr") String opr,
			@RequestParam("n2") int n2) {
		
		int result = 0;
		if (opr.equals("+"))
			result = n1+n2;
		else if (opr.equals("-"))
			result = n1-n2;
		else if (opr.equals("*"))
			result = n1*n2;
		else if (opr.equals("/"))
			result = n1/n2;
		else if (opr.equals("%"))
			result = n1%n2;
		model.addAttribute("result", n1 + opr + n2 + "=" + result);
		
		return "simple_calc";
	}
	
}
