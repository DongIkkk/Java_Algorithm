package baekjoon.basic;

import java.util.Scanner;

public class Sol10807 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int result = sc.nextInt();
		int count = 0;
		for(int num:arr) {
			if(result==num) {
				count++;
			}
		}
		System.out.println(count);
	}
}