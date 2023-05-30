package java0313;

import java.util.Scanner;

public class Exam병합정렬 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = {2,4,6,8,11,13};
		int[] b = {1,2,3,4,9,16,21};
		int[] c = new int[13];  //a+b 합친 배열
		
		System.out.println("두 배열을 병합");
		merge(a, a.length, b, b.length, c);
	}

	private static void merge(int[] a, int na, int[] b, int nb, int[] c) {
		int pa = 0;
		int pb = 0;
		int pc = 0;
		
		while (pa < na && pb < nb) {
			c[pc++] = (a[pa] <= b[pb]) ? a[pa++] : b[pb++];
		}
		
		
	}
}
