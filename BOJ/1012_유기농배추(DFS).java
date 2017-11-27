/*
 	문제 : 유기농 배추(1012)
 	유형 : DFS (단순 재귀) 
  
*/

import java.util.Scanner;

public class Main {
	static int Answer;
	
	static void check(int x, int y, int[][] map, boolean [][]visit, int N, int M) {
		
		visit[x][y]=true;
		
		if(x+1<N && map[x+1][y]==1 && !visit[x+1][y])
			check(x+1, y, map, visit, N, M);
		if(x-1>=0 && map[x-1][y]==1 && !visit[x-1][y])
			check(x-1, y, map, visit, N, M);
		if(y+1<M && map[x][y+1]==1 && !visit[x][y+1])
			check(x, y+1, map, visit, N, M);
		if(y-1>=0 && map[x][y-1]==1 && !visit[x][y-1])
			check(x, y-1, map, visit, N, M);
	}
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			Answer=0;
			
			int M = sc.nextInt(); //가로
			int N = sc.nextInt(); // 세로
			int K = sc.nextInt();
			
			int[][] map = new int[N][M];
			boolean[][] visit = new boolean[N][M];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					map[i][j]=0;
					visit[i][j]=false;
				}
			}
			
			int x=0;
			int y=0;
			
			for(int i=0; i<K; i++) {
				y=sc.nextInt();
				x=sc.nextInt();
				map[x][y]=1;
			}
		
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]==1 && !visit[i][j]){
						check(i,j,map,visit, N, M);
						Answer++;
					}
				}
			}
			System.out.println(Answer);
		}
	}	
}
