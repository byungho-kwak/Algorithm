import java.util.Scanner;

public class Main {
	static int commbination(int[][] dp, int n, int r) {
		if(dp[n][r]!=0)
			return dp[n][r];
		else if(r==1) 
			dp[n][r]=n;
		else if(n==r || r==0)
			dp[n][r]=1;
		else 
			dp[n][r]=(commbination(dp, n-1, r-1) + commbination(dp, n-1, r))%10007;
		
		return dp[n][r];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		
		int[][] dp = new int[n+1][r+1];
		
		System.out.println(commbination(dp, n, r));
	}
}
