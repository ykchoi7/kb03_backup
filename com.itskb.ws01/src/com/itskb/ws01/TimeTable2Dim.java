package com.itskb.ws01;

public class TimeTable2Dim {

	public static void main(String[] args) {
		int[][] gugu = new int[9][9];
		System.out.println("gugu의 길이 : " + gugu.length);
		System.out.println("gugu의 0번째 요소의 길이 : " + gugu[0].length);
		
		//배열에 구구단 저장
		for (int i = 0; i < gugu.length; i++) {
			for (int j = 0; j < gugu[i].length; j++) {
				gugu[i][j] = (i+1)*(j+1);
				//출력
				System.out.println(gugu[i][j]);
			}
		}
		System.out.println();
	}
}
