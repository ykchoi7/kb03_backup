package java0313;

import java.util.HashMap;

public class ExamHash {

	public static void main(String[] args) {
		// Collection에는 크게 2가지의 부류가 있음
		// 1. Collection - 값만 저장 (순서지원-list, 미지원-set)
		// 2. Map - 키와 값을 저장 (종류 - Hashtable / LinkedHashMap / HashMap)
		//HashMap<K, V>  //key, value (예시 - 이름, 점수)
		HashMap<String, Integer> scores = new HashMap<>(); //뒤쪽 data type은 없어도 됨		
		scores.put("홍", 90);
		scores.put("김", 80);
		scores.put("박", 85);
		System.out.println(scores); //자동으로 형성되는 값 {김=80, 박=85, 홍=90}
		
		//검색
		System.out.println(scores.get("강")); //없는걸 찾으면 null -> 연산 불가 
		System.out.println(scores.getOrDefault("강", 0)); //없으면 두번째 값을 반환 -> 연산 가능
	
		//수정 - put(K, V);
		
		//삭제
		scores.remove("홍");
		System.out.println(scores);
	}
}
