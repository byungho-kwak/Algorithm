import java.util.Scanner;

public class Main {

	static long [][] DP = new long [1001][11];
	static long mod = 10007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int N = sc.nextInt();
		
		for(int i=0; i<=9; i++) {
			DP[1][i] = 1;
			DP[1][10]+=DP[1][i];
		}
		
		for(int i=2; i<=N; i++) {
			DP[i][0] = 1;
			DP[i][10] = 1;
			for(int j=1; j<=9; j++) {
				DP[i][j] = (DP[i][j-1] + DP[i-1][j])%mod;
				DP[i][10]=(DP[i][10]+DP[i][j])%mod;
			}
		}
		
		System.out.println(DP[N][10]);
	}
}
