package java0316;

import java.util.ArrayList;
import java.util.HashSet;

public class ExamHashSet {

	public static void main(String[] args) {
		//ArrayList - 중복 허용!!
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(100);
		arr.add(100);
		arr.add(100);
		System.out.println(arr);
		
		//HashSet - 중복 배제!!
		HashSet<Integer> hs = new HashSet<>();
		hs.add(100);
		hs.add(100);
		hs.add(100);
		System.out.println(hs);
		
		//중복시켜 저장해둔 arraylist를 가지고 와도 중복 제거시킴
		HashSet<Integer> hs2 = new HashSet<>(arr);
		System.out.println(hs2);
	}
}
