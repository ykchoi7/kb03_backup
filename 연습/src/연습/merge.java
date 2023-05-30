package 연습;

import java.util.Arrays;
import java.util.Scanner;

public class merge {
	static int[] buff;
	
	static void merge(int[] a,int left,int right) {
		if(left< right) {
			int i;
			int center=(left+right)/2;
			int p=0;
			int j=0;
			int k=left;
			
			merge(a,left,center);
			merge(a,center+1,right);
			
			for (i = left; i <=center; i++) {
				buff[p++]=a[i];
			}
			while(i<=right&&j<p) {
				a[k++]=(buff[j]<=a[i])?buff[j++]:a[i++];
			}
			while(j<p) a[k++]=buff[j++];
		}
	}
	
	static void mergesort(int[] a, int n) {
		buff =new int[n];
		merge(a,0,n-1);
		
		buff=null; //초기화
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int[] x =new int[n];
		
		for (int i = 0; i < x.length; i++) {
			x[i]=sc.nextInt();
		}
		mergesort(x,n);
		
		System.out.println("정렬 끝");
		
			System.out.print(Arrays.toString(x));
		
	}
}
