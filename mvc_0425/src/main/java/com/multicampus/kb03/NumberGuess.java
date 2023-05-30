package com.multicampus.kb03;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NumberGuess {
	
	private int com_num = new java.util.Random().nextInt(100)+1;
	
	@RequestMapping("/number_guess")
	//requestmapping으로 인해 url 마지막에 /number_guess 로 끝나야한다
	public String number_guess(
			@RequestParam(value="n1", required=false, defaultValue="-1") int n1, 
			Model model) {
		
		//필수파라미터를 false로 둠으로써 url에 n1의 값을 기입하지 않아도 사용가능
		if (n1==-1) {
			model.addAttribute("msg", "숫자를 입력하세요");
			return "number_guess";
		}
		
		String msg = n1 + " : "; //local 변수이기 때문에 초기화 필수!
		if (com_num < n1)
			msg = "낮춰주세요";
		else if (com_num > n1)
			msg = "높여주세요";
		else
			msg = "정답입니다";
		
		model.addAttribute("msg", msg); //model을 통해 request에 전달
		
		return "number_guess";
		
	}
}
