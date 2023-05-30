package com.multicampus.kb03;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChosunGameController {
	
	final static String[] word = 
		{"국민은행", "은행", "공부", "스터디", "학교", "학생", "교재"};
	final static String[] CHO = 
		{"ㄱ","ㄲ","ㄴ","ㄷ","ㄸ","ㄹ","ㅁ","ㅂ","ㅃ","ㅅ","ㅆ","ㅇ","ㅈ","ㅉ","ㅊ","ㅋ","ㅌ","ㅍ","ㅎ"};
	final static String[] JOONG = 
		{"ㅏ", "ㅐ","ㅑ","ㅒ","ㅓ","ㅔ","ㅕ","ㅖ","ㅗ","ㅘ","ㅙ","ㅚ","ㅛ","ㅜ","ㅝ","ㅞ","ㅟ","ㅠ","ㅡ","ㅣ","ㅢ"};
	final static String[] JONG = 
		{"","ㄱ","ㄲ","ㄳ","ㄴ","ㄵ","ㄶ","ㄷ","ㄹ","ㄺ","ㄻ","ㄼ",
		"ㄽ","ㄾ","ㄿ","ㅀ","ㅁ","ㅂ","ㅄ","ㅅ","ㅆ","ㅇ","ㅈ","ㅊ","ㅋ","ㅌ","ㅍ","ㅎ"};
			
	@RequestMapping(value="/chosun_game")
	public String chosun_game(Model model) {
		return "chosun_game";
	}
	
	@RequestMapping(value="/chosun_game_main", method=RequestMethod.GET)
	public String chosun_game_main(Model model, HttpSession session) {
		double random = Math.random();
		int num = (int)Math.round(random*(word.length-1));
		session.setAttribute("num", num);
		String ans = word[num];
		
		String chosun = "";
		for (int i = 0; i < ans.length(); i++) {
			char uniVal = ans.charAt(i);
			
			if (uniVal >= 0xAC00) {
				uniVal = (char)(uniVal - 0xAC00);
				char cho = (char)(uniVal/28/21);
				chosun  += CHO[cho];
			}
		}
		model.addAttribute("chosun", chosun);
		return "chosun_game_main";
	}
	
	@RequestMapping(value="/chosun_game_main", method=RequestMethod.POST)
	public String chosun_game_main_post(
			Model model,
			HttpSession session,
			@RequestParam("input") String input) {
		
		int num = (Integer) session.getAttribute("num");
		String ans = word[num];
		input = input.trim();
		String result = input + " : ";
		
		//정답 확인
		int count = 0; //몇개 맞췄는지 알려주기 위해 count
		for (int i = 0; i < ans.length(); i++) {
			if (ans.charAt(i) == input.charAt(i))
				count++;
		}
		
		if (ans == input) {
			result += "정답입니다";
		} else {
			result += count +"개 맞춤";
		}
		
		model.addAttribute("result", result);
		return chosun_game_main(model, session);
	}
	
	
}
