/*
 * 문제 : BOJ	13458 시험 감독
 * 유형 : DP
 * 주의사항 : 총감독관은 반드시 방에 1명씩 꼭 들어가 있어야 함
 * 			 ans값이 int 초과 가능. 그러므로, ans 변수 타입은 long 이상! 
 */

import java.util.Scanner;
public class Main {
	static int b,c;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int a[] = new int[n];
		int dp[] = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		long ans=0;
		b = sc.nextInt();
		c = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			if(b-a[i]>=0) {
				dp[i] =0;
			}
			else {
				dp[i] = -(b-a[i]); 
			}
			
			if(dp[i]==0) {
				dp[i] = 1;
			}
			else {
				dp[i] = 1+cal(dp[i]);
			}
			ans+=dp[i];
		}
		System.out.println(ans);
	}
	static int cal(int remain) {
		if(remain <=c)
			return 1;
		if(remain%c==0)
			return remain/c;
		else
			return (remain/c) + 1;
	}
}