/*
 * 문제 : BOJ 14500 테트로미노
 * 유형 : DFS
 * 주의점 : 도형 모양에 대해 dfs진행 (ㅗ모양은dfs로 못잡음, 예외적으로 처리해줘야함)
 * 
 */

import java.util.Scanner;
public class Main {
	static int N,M, ans, map[][];
	static boolean visited[][];
	static int dx[] = {0,1,0,-1}, dy[] = {1,0,-1,0};
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		visited = new boolean[N][M];
		ans=0;
		for(int i=0; i<N; i++) 
			for(int j=0; j<M; j++)
				map[i][j] = sc.nextInt();

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				shapeDFS(i, j, 0, map[i][j]);
				visited[i][j] = false;
			}
		}
		System.out.println(ans);
	}
	
	static void shapeDFS(int x, int y, int cnt, int res) {
		visited[x][y] = true;
		if(cnt==3) {
			if(ans<res)
				ans=res;
			return;
		}
		
		//ㅗ 체크
		if(cnt==2) {
			int tmp;
			// ㅗ ㅜ
			if(y-2>=0) {
				if(visited[x][y] && visited[x][y-1] && visited[x][y-2]) {
					if(x-1>=0) {
						tmp = res+map[x-1][y-1];
						if(ans<tmp)
							ans=tmp;
					}
					if(x+1<N) {
						tmp = res+map[x+1][y-1];
						if(ans<tmp)
							ans=tmp;
					}
				}
			}
			// ㅗ ㅜ
			if(y+2<M) {
				if(visited[x][y] && visited[x][y+1] && visited[x][y+2]) {
					if(x-1>=0) {
						tmp = res+map[x-1][y+1];
						if(ans<tmp)
							ans=tmp;
					}
					if(x+1<N) {
						tmp = res+map[x+1][y+1];
						if(ans<tmp)
							ans=tmp;
					}
				}
			}
			// ㅏㅓ
			if(x-2>=0) {
				if(visited[x][y] && visited[x-1][y] && visited[x-2][y]) {
					if(y-1>=0) {
						tmp = res+map[x-1][y-1];
						if(ans<tmp)
							ans=tmp;
					}
					if(y+1<M) {
						tmp = res+map[x-1][y+1];
						if(ans<tmp)
							ans=tmp;
					}
				}
			}
			// ㅏㅓ
			if(x+2<N) {
				if(visited[x][y] && visited[x+1][y] && visited[x+2][y]) {
					if(y-1>=0) {
						tmp = res+map[x+1][y-1];
						if(ans<tmp)
							ans=tmp;
					}
					if(y+1<M) {
						tmp = res+map[x+1][y+1];
						if(ans<tmp)
							ans=tmp;
					}
				}
			}
		}
		
		for(int i=0; i<4; i++) {
			int nextX = x+dx[i];
			int nextY = y+dy[i];
			if(nextX<0 || nextX>=N || nextY<0 || nextY>=M) continue;
			if(visited[nextX][nextY]) continue;
			shapeDFS(nextX, nextY, cnt+1, res+map[nextX][nextY]);
			visited[nextX][nextY] = false;
		}
	}
}