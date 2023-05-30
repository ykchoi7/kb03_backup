package java0328;

import java.util.HashMap;

public class ExamHashMap {

	public static void main(String[] args) {
		//학생들의 이름을 기준으로 점수 저장. 
		HashMap<String, Integer> scoreMap = new HashMap<>();
		scoreMap.put("홍", 90); //저장
		scoreMap.put("박", 80); //저장
		scoreMap.put("김", 70); //저장
		scoreMap.put("박", 80); //저장 - 키가 중복되면 덮어쓴다***
		System.out.println(scoreMap);
		
		Integer sc = scoreMap.get("홍");
		//없는 키를 넣으면 null을 출력
		System.out.println(sc);
		scoreMap.remove("박");
		System.out.println(scoreMap);
	}
}
