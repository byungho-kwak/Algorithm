/*
 * ���� : BOJ	13458 ���� ����
 * ���� : DP
 * ���ǻ��� : �Ѱ������� �ݵ�� �濡 1�� �� �� �־�� ��
 * 			 ans���� int �ʰ� ����. �׷��Ƿ�, ans ���� Ÿ���� long �̻�! 
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