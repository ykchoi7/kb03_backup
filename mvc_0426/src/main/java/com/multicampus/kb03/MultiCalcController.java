package com.multicampus.kb03;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.multicampus.kb03.dto.MultiCalcDto;

@Controller
public class MultiCalcController {
	
	@RequestMapping(value="/multi_calc_game")
	public String multi_calc_game(Model model, HttpSession session) {
		long startTime = System.currentTimeMillis();
		session.setAttribute("startTime", startTime);
		session.setAttribute("game_seq", 1);
		return "multi_calc_game";
	}
	
	private int n1;
	private int n2;
	
	@RequestMapping(value="/multi_calc_game_main", method=RequestMethod.GET)
	public String multi_calc_game_main(Model model, HttpSession session) {		
		System.out.println("main GET");
		n1 = new java.util.Random().nextInt(9)+1;
		n2 = new java.util.Random().nextInt(21)+10;
		model.addAttribute("n1", n1);
		model.addAttribute("n2", n2);
		return "multi_calc_game_main";
	}
	
	@RequestMapping(value="/multi_calc_game_main", method=RequestMethod.POST)
	public String multi_calc_game_post(
			Model model,
			HttpSession session,
			MultiCalcDto dto) {
		
		Integer game_seq = (Integer)session.getAttribute("game_seq");
		game_seq += 1;
		session.setAttribute("game_seq", game_seq);
		
		System.out.println("main POST");
		String result = dto.getN1()+"*"+dto.getN2()+"="+dto.getAnswer();
		
		if (dto.getAnswer() == dto.getN1()*dto.getN2()) {
			System.out.println("정답입니다!");
		} else {
			System.out.println("오답입니다. 정답은 " + (dto.getN1()*dto.getN2()));
		}
				
		if (game_seq == 11) {
			long stopTime = System.currentTimeMillis();
			long total_time = stopTime-(Long.valueOf(String.valueOf(session.getAttribute("startTime"))));
			System.out.println((total_time/1000) + "초" + "걸렸습니다");
		}
		
		model.addAttribute("result", result);
		return multi_calc_game_main(model, session);
	}
	
//	@RequestMapping(value="/multi_calc_game_main_old", method=RequestMethod.POST)
//	public String multi_calc_game_post_old(
//			Model model,
//			HttpSession session, //세션 추가 
//			@RequestParam("n1") int n1,
//			@RequestParam("n2") int n2,
//			@RequestParam("answer") int answer) {
//		
//		Integer game_seq = (Integer)session.getAttribute("game_seq");
//		game_seq += 1;
//		session.setAttribute("game_seq", game_seq);
//		
//		System.out.println("main POST");
//		String result = n1+"*"+n2+"="+answer;
////		System.out.println("result =" +result);
//		
//		if (answer == n1*n2) {
//			System.out.println("정답입니다!");
//		} else {
//			System.out.println("오답입니다. 정답은 " + (n1*n2));
//		}
//				
//		if (game_seq == 11) {
//			long stopTime = System.currentTimeMillis();
//			long total_time = stopTime-(Long.valueOf(String.valueOf(session.getAttribute("startTime"))));
//			System.out.println((total_time/1000) + "초" + "걸렸습니다");
//		}
//		
//		model.addAttribute("result", result);
//		return multi_calc_game_main(model, session);
//	}
	
}
