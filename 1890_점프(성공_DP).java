import java.awt.Point;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	static int[][] map;
	static long[][] DP;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		map = new int[N+1][N+1];
		DP = new long[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				map[i][j] = sc.nextInt();
				DP[i][j] = 0;
			}
		}
		
		DP[1][1] = 1;
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==N && j==N)
					break;
				
				if(DP[i][j] != 0) {
					if(i+map[i][j] <=N) 
						DP[i+map[i][j]][j]+=DP[i][j];
					
					if(j+map[i][j] <=N)
						DP[i][j+map[i][j]]+=DP[i][j];
				}
			}
		}
		System.out.println(DP[N][N]);
	
	}
}
