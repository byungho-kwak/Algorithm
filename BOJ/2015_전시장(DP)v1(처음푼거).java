import java.util.Scanner;

public class Main {
	static int N, S;
	static int ans;
	static final int H = 0;
	static final int C = 1;
	public static void main(String args[]) {
	
		Scanner sc = new Scanner(System.in);
		ans=0;
		N = sc.nextInt();
		S = sc.nextInt();
		
		int[][] value = new int[2][N+1];
		int[][] input = new int[2][20000001];
		int[] dp = new int[N+1];
		int h,c;
		for(int i=1; i<=N; i++) {
			h = sc.nextInt();
			c = sc.nextInt();
			if(input[0][h]>0) {
				if(input[0][h]<c)
					input[0][h]=c;
			}
			else
				input[0][h]=c;
		}
		
		int n=1;
		input[1][0] = 0;
		for(int i=1; i<20000001; i++) {
			if(input[0][i]>0) {
				value[H][n] = i;
				value[C][n] = input[0][i];
				input[1][i]=n;
				n++;
			}
			else {
				input[1][i] = input[1][i-1];
			}
				
		}
		
		dp[1] = value[C][1];
		for(int i=2; i<=N; i++) {
			if(value[H][i]-value[H][i-1]>=S) {
				dp[i] = dp[i-1]+value[C][i];
			}
			else {
				int x;
				if(value[H][i]-S>=0)
					x = input[1][value[H][i]-S];
				else
					x=0;
				dp[i] = Math.max(dp[i-1], dp[x]+value[C][i]);

			}
		}
		for(int i=1; i<=N; i++) {
			if(ans<dp[i])
				ans=dp[i];
		}
		System.out.println(ans);
	}
}