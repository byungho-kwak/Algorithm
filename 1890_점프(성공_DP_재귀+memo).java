import java.util.Scanner;

public class Main {

	static int[][] a = new int[101][101];
	static long[][] dp = new long[101][101];
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				a[i][j] = sc.nextInt();
				dp[i][j]=-1;
			}
		}
		
		dp[n][n]=1;
		a[n][n]=1;
		
		System.out.println(find(1,1));
	}
	
	static long find(int i, int j) {
		
		if(a[i][j]==0 || dp[i][j]==0) {
			dp[i][j]=0;
			return 0;
		}
			
		if(dp[i][j]>0)
			return dp[i][j];

		// 한 번도 안들렸던 곳이면
		dp[i][j]=0;
		if(i+a[i][j]<=n)
			dp[i][j]+=find(i+a[i][j], j);
		
		if(j+a[i][j]<=n)
			dp[i][j]+=find(i, j+a[i][j]);

		//System.out.println(i+","+j+" dp ="+dp[i][j]);
		return dp[i][j];
	}
}
