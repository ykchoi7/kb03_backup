package 연습;
import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
	static void swap(int[] a,int idx1, int idx2 ) {
		int t=a[idx1];
		a[idx1]=a[idx2];
		a[idx2]=t;
	}
	 static void quicksort(int[] a,int left, int right) {
		 int pl=left;
		 int pr=right;
		 int x=a[(pl+pr)/2];
		 
		 do {
			 while(a[pl]<x)pl++;
			 while(a[pr]>x)pr--;
			 if(pl<=pr) swap(a,pl++,pr--);
		 }while(pl<=pr);
		 
		 if(left<pr) quicksort(a, left, pr);
		 if(pl<right) quicksort(a, pl, right);
	 }
	 
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("퀵 정렬");
		System.out.print("요솟수: ");
		int nx=sc.nextInt();
		int[] x=new int[nx];
		
		for (int i = 0; i < nx; i++) {
			System.out.println("x["+i+"]: ");
			x[i]=sc.nextInt();
		}
		quicksort(x, 0, nx-1);
		
		System.out.println("정렬");
		System.out.println(Arrays.toString(x));
	}
}
