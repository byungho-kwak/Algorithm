import java.util.Scanner;

public class Main {

	static int N, M;
	static int[][] map;
	static int[][] DP;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N+1][M+1];
		DP = new int[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				map[i][j] = sc.nextInt();
				DP[i][j] = 0;
			}
		}
		
		DP[1][1] = 1;
		
		System.out.println(find(N,M));
	}
	static int find(int i, int j) {
		
		if(DP[i][j]>0)
			return DP[i][j];
		
		if(DP[i][j]<0)
			return 0;
		
		if(i-1>=1 && map[i-1][j]>map[i][j]) {
			DP[i][j]+=find(i-1, j);
		}
		if(i+1<=N && map[i+1][j]>map[i][j])
			DP[i][j]+=find(i+1, j);
		
		if(j-1>=1 && map[i][j-1]>map[i][j])
			DP[i][j]+=find(i, j-1);
		
		if(j+1<=M && map[i][j+1]>map[i][j])
			DP[i][j]+=find(i, j+1);
		
		if(DP[i][j] == 0) {
			DP[i][j] = -1;
			return 0;
		}
		
		return DP[i][j];
		
	}
	
}
