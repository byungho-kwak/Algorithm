import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int TC;
	static int[][] input;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TC = sc.nextInt();
		
		input = new int[TC+1][3];
		
		for(int i=1; i<=TC; i++) {
			input[i][1] = sc.nextInt();
			input[i][2] = sc.nextInt();
		}
		
		for(int i=1; i<=TC; i++) 
			System.out.println(dp(input[i][1], input[i][2]));
		
	}
	
	static int dp(int n, int m) {
		int[][] DP = new int[n+1][m+1];
		
		for(int i=1; i<=m; i++)
			DP[1][i] = i;
			
		for(int i=2; i<=n; i++) {
			DP[i][i] = 1;
			for(int j=i+1; j<=m; j++) {
				DP[i][j] = DP[i][j-1] +DP[i-1][j-1];
			}
		}
		
		return DP[n][m];
	
	}
	
	

}
