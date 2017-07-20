import java.util.Arrays;
import java.util.Scanner;

import java.util.Stack;

public class Main {
	static int[] input = new int [125251];
	static int[] DP = new int [125251];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int totalCnt = (size*(size+1))/2;
		
		for(int i=1; i<=totalCnt; i++)
			input[i] = sc.nextInt();
		
		int idx = totalCnt;
		int subSize = size;
		
		for(;idx>=totalCnt-subSize+1; idx--)
			DP[idx] = input[idx]; 
		
		subSize--;
		
		while(subSize >= 1) {
			
			for(int i=subSize; i>=1; i--) {
				DP[idx] = input[idx] + Math.max(DP[idx+subSize], DP[idx+subSize+1]);
				idx--;
			}
			subSize--;
		}
		
		System.out.println(DP[1]);
	}
}
