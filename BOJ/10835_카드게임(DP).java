import java.awt.Point;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] dp = new int[N+1][N+1];
		int[] a = new int[N+1];
		int[] b = new int[N+1];
		
		for(int i=N; i>=1; i--)
			a[i] = sc.nextInt();
		for(int i=N; i>=1; i--)
			b[i] = sc.nextInt();
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				dp[i][j]=dp[i-1][j];		// 왼쪽만 버리기
				dp[i][j]=Math.max(dp[i][j],dp[i-1][j-1]);	// 둘 다 버리기
				if(a[i]>b[j])
					dp[i][j]=Math.max(dp[i][j],dp[i][j-1]+b[j]); // 오른쪽만 버리기
			}
		}
		System.out.println(dp[N][N]);
		
	}
}
