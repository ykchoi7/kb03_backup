package com.itskb.ws01;

import java.util.Arrays;

public class ZigZag2 {

	public static void main(String[] args) {
		int [][] arr = new int [][]{
			{1,2,3,4,5},
			{6,7,8,9,10},
			{11,12,13,14,15},
			{16,17,18,19,20},
		};
		
		for (int j = 0; j < arr.length; j++) {
			int num = 1 + j;
			for (int i = 0; i < arr.length; i++) {
				arr[j][i] = num;
				num += 5;
				System.out.print(arr[j][i] +" ");
			}
			System.out.println();
		}
	}
}
