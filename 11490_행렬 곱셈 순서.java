import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] input = new int[N][2];
		int[] d = new int[N+1];
		int[][] DP = new int[N+1][N+1];
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<2; j++)
				input[i][j] = sc.nextInt();
			d[i] = input[i][0];
		}
		d[N] = input[N-1][1];
		
		for(int diagonal=0; diagonal<N; diagonal++){
			for(int i=1; i<=N-diagonal; i++) {
				int j=i+diagonal;
				
				if(i==j) {
					DP[i][j]=0;
					continue;
				}
				//DP[i][j] = 10000000 : upper bound°¡ ³Ê¹« ³·À½
				DP[i][j] = 987654321;
				
				for(int k=i; k<=j-1; k++) 
					DP[i][j] = Math.min(DP[i][j], DP[i][k] + DP[k+1][j] + d[i-1]*d[k]*d[j]);
			}
		}
		
		System.out.println(DP[1][N]);
	}

}
