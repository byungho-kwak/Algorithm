import java.util.Scanner;

public class Main {

	static int N;
	static int[][] map;
	static long[][] DP;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		map = new int[101][101];
		DP = new long[101][101];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				map[i][j] = sc.nextInt();
				DP[i][j] = 0;
			}
		}
		
		find(1,1);
		System.out.println(DP[1][1]);
	
	}
	static long find(int i, int j) {
		
		long moveRight=0;
		long moveDown=0;
		
		if(i==N && j==N)
			return 1;
		
		if(i+map[i][j]<=N) {
			// 방문하지 않았던 곳이면
			if(DP[i+map[i][j]][j]==0) { 
				moveDown = find(i+map[i][j], j);
			}
			//방문했었는데 길이 없는 곳이면
			else if(DP[i+map[i][j]][j]==-1)
				moveDown = -1;
			// 방문했었고 정답으로 가는 길이면
			else
				moveDown = DP[i+map[i][j]][j];
		}
			
		if(j+map[i][j]<=N) {
			if(DP[i][j+map[i][j]]==0) 
				moveRight = find(i, j+map[i][j]);
			else if(DP[i][j+map[i][j]]==-1)
				moveRight = -1;
			else
				moveRight = DP[i][j+map[i][j]];
		}
		
		if(moveDown <= 0 && moveRight <= 0)
			return DP[i][j] = -1;
		else if(moveDown > 0 && moveRight <=0)
			return DP[i][j] = moveDown;
		else if(moveDown <= 0 && moveRight > 0)
			return DP[i][j] = moveRight;
		else
			return DP[i][j] =  moveDown + moveRight;
	}
}
