import java.util.Arrays;
import java.util.Scanner;

import java.util.Stack;

public class Main {

	static long[][] DP = new long [101][10];
	public static void main(String[] args) {
		long mod = 1000000000;
		Scanner sc = new Scanner(System.in);
		
		int stairNum = sc.nextInt();
		long sum=0;
		
		DP[1][0] = 0;
		for(int i=1; i<=9; i++)
			DP[1][i] = 1;
		
		for(int i=2; i<=stairNum; i++) {
			DP[i][0] = DP[i-1][1]%mod;
			DP[i][9] = DP[i-1][8]%mod;
			
			for(int j=1; j<=8; j++) {
				DP[i][j] = DP[i-1][j-1]+DP[i-1][j+1];
				DP[i][j] = DP[i][j]%mod;
			}
		}
		
		for(int i=0; i<=9; i++) {
			sum+= DP[stairNum][i];
			sum = sum%mod;
		}
	
		System.out.println(sum);
	}
}
