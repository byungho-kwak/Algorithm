
/*
 * BOJ 2667 단지번호붙이기 17.01.05
 */

import java.util.Scanner;

public class Main {
	
	static int[][] map;
	static int N;
	static int ans;
	static int[] houseTotal = new int[1376];
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N+1][N+1];
		String input;
		sc.nextLine();
		for(int i=1; i<=N; i++) {
			input = sc.nextLine();
			for(int j=0; j<N; j++) { 
				map[i][j+1] = input.charAt(j)-48;
			}
		}
		
		int moveCnt=0;
		for(int i=1; i<=N; i++) { 
			for(int j=1; j<=N; j++) {
				moveCnt=dfs(i, j, 0);
					if(moveCnt>0) {
						houseTotal[moveCnt]++;
						ans++;
					}
			}
		}
		
		System.out.println(ans);
		for(int i=1; i<=1375; i++) {
			if(houseTotal[i]>0) {
				for(int j=1; j<=houseTotal[i]; j++)
					System.out.println(i);
			}
		}
	}
	
	static int dfs(int x, int y, int houseCnt) {
		int move =0;
		if(map[x][y]==1) {
			houseCnt++;
			map[x][y]=2;
			
			if(y-1>=1) {
				move+= dfs(x, y-1, 0);
			}
			if(y+1<=N) {
				move+= dfs(x, y+1, 0);
			}
			if(x-1>=1) {
				move+= dfs(x-1, y, 0);
			}
			if(x+1<=N) {
				move+= dfs(x+1, y, 0);
			}
		}
		return move+houseCnt;
	}
}