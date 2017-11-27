import java.util.Scanner;
public class Solution {
	static int ans;
	static int N;
	static int K;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		 int tc = sc.nextInt();
		 
		 for(int t=1; t<=tc; t++) {
			 ans=0;
			 N = sc.nextInt();
			 K = sc.nextInt();
			 
			 int[][] map = new int[N+1][N+1];
			 boolean[][] visit = new boolean[N+1][N+1];
			 int max = 0;
			 
			 for(int i=1; i<=N; i++) {
				 for(int j=1; j<=N; j++) {
					map[i][j]=sc.nextInt();
					if(map[i][j]>max)
						max=map[i][j];
				 }
			 }
			 
			 for(int i=1; i<=N; i++) {
				 for(int j=1; j<=N; j++) {
					 if(map[i][j]==max) {
						 find(i,j, map, visit, 1, false, 0);
					 }
				 }
			 }
			 System.out.println("#"+t+" "+ans);
		 }
	}
	
	static void find(int x, int y, int[][] MAP, boolean[][] VISIT, int depth, boolean cutdown, int cutNum) {
		
		// ÃÊ±âÈ­
		int[][] map = new int[N+1][N+1];
		boolean[][] visit = new boolean[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				map[i][j]=MAP[i][j];
				visit[i][j]=VISIT[i][j];
			}
		}
		visit[x][y]=true;
		if(cutdown && cutNum!=0) {
			map[x][y]+=-cutNum;
			cutNum=0;
		}
		
		if(y+1<=N && !visit[x][y+1]) {
			if(map[x][y+1]>=map[x][y] && !cutdown) {
				if(map[x][y+1]-K < map[x][y]) {
					for(int k=K; k>=1; k--) {
						if(map[x][y+1]-k < map[x][y])
							find(x, y+1, map, visit, depth+1, true, k);
						else
							break;
					}
					
				}
			}
			if(map[x][y] > map[x][y+1])
				find(x, y+1, map, visit, depth+1, cutdown, 0);
		}
		
		if(y-1>=1 && !visit[x][y-1]) {
			if(map[x][y-1]>=map[x][y] && !cutdown) {
				if(map[x][y-1]-K < map[x][y]) {
					for(int k=K; k>=1; k--) {
						if(map[x][y-1]-k < map[x][y])
							find(x, y-1, map, visit, depth+1, true, k);
						else
							break;
					}
					
				}
			}
			if(map[x][y] > map[x][y-1])
				find(x, y-1, map, visit, depth+1, cutdown, 0);
		}
		
		if(x+1<=N && !visit[x+1][y]) {
			if(map[x+1][y]>=map[x][y] && !cutdown) {
				if(map[x+1][y]-K < map[x][y]) {
					for(int k=K; k>=1; k--) {
						if(map[x+1][y]-k < map[x][y])
							find(x+1, y, map, visit, depth+1, true, k);
						else
							break;
					}
					
				}
			}
			if(map[x][y] > map[x+1][y])
				find(x+1, y, map, visit, depth+1, cutdown, 0);
		}
		
		if(x-1>=1 && !visit[x-1][y]) {
			if(map[x-1][y]>=map[x][y] && !cutdown) {
				if(map[x-1][y]-K < map[x][y]) {
					for(int k=K; k>=1; k--) {
						if(map[x-1][y]-k < map[x][y])
							find(x-1, y, map, visit, depth+1, true, k);
						else
							break;
					}
					
				}
			}
			if(map[x][y] > map[x-1][y])
				find(x-1, y, map, visit, depth+1, cutdown, 0);
		}
		if(ans<depth)
			ans=depth;
	}
}
