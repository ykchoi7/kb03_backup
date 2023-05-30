package algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon_17608 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //막대기 개수
//		int h = sc.nextInt(); //막대기 높이
		
		//list 생성
		ArrayList<Integer> li = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			li.add(sc.nextInt()); //하나씩 읽은걸 list에 add
		}
		
		//마지막 막대기와 비교하여 각 막대기의 높이가 높으면 count++
		int count = 0;  //마지막 막대기는 무조건 보이니까 1부터 시작
		int a = 0;	    //막대기의 높이
		
		for (int i = n-1; i >= 0; i--) {
			if (li.get(i) > a) {
				a = li.get(i);  //**기준값보다 큰 막대기를 만나면 기준값이 큰 값으로 변경
				count++;
			}
		}	
		System.out.println(count);
	}

}



//배열로 푸는 방법

