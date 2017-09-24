import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int v = sc.nextInt();
		long[] dp = new long[n+1];
		boolean[] vip = new boolean[n+1];
		Arrays.fill(vip, false);
		for(int i=1; i<=v; i++)
			vip[sc.nextInt()]=true;
		
		dp[0]=1;
		dp[1]=1;

		for(int i=2; i<=n; i++) {
			if(vip[i] || vip[i-1])
				dp[i]=dp[i-1];
			else if(vip[i-2])
				dp[i]=dp[i-1]*2;
			else
				dp[i]=dp[i-1]+dp[i-2];
		}
		
		System.out.println(dp[n]);
	}
}
