package com.multicampus.mvc0502;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // Spring 4.3이상만 가능
public class MyRestController<E> {

	@GetMapping("/hello.rest")
	public String hello_rest() {
		return "hello_rest";
	}
	
	@GetMapping("/hello_list.rest")
	public ArrayList<String> hello_list_rest() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("홍길동");
		list.add("김길동");
		list.add("박길동");
		return list;
	}
	@GetMapping("/hello_map.rest")
	public HashMap<String, Integer> hello_map_rest() {
		HashMap<String,Integer> map = new HashMap<String, Integer>();
		map.put("홍", 30);
		map.put("김", 40);
		map.put("김", 50);
		return map;
	}
	
	private int com_num = new java.util.Random().nextInt(100)+1;
	@GetMapping("/check_number.ng")
	public HashMap<String, Object> check_number(@RequestParam int no) {
		String msg = no +":";
		int code = -999;
		if(com_num < no) {
			msg += "낮춰주세요";
			code = -1;
		}
		else if(com_num > no) {
			msg += "높여주세요";
			code = 1;
		}
		else {
			msg += "정답입니다";
			code = 0;
			//새로운 난수로 지정
			com_num = new java.util.Random().nextInt(100)+1;
		}
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("msg", msg);
		map.put("code", code);
		return map;
	}

}





