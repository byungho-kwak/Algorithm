import java.util.Arrays;
import java.util.Scanner;
public class Solution {
	static int ans;
	static int D, W, K;
	static int[][] map = new int[14][21];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {

			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			ans = D;			 
			for(int i=1; i<=D; i++)
				for(int j=1; j<=W; j++)
					map[i][j]=sc.nextInt();
			 
			if(check(map))
				ans=0;
			else {
				for(int i=1; i<=D; i++)
					BFS(i, map, 1);
			}
			 
			System.out.println("#"+t+" "+ans);
		}
	}
	static void BFS(int d, int[][] MAP, int injectNum) {
		int[][] film = new int[14][21];
		int[][] filmA = new int[14][21];
		int[][] filmB = new int[14][21];
		for(int i=1; i<=D; i++) {
			for(int j=1; j<=W; j++) {
				film[i][j] = MAP[i][j];
				filmA[i][j]=film[i][j];
				filmB[i][j]=film[i][j];
			}
		}
		Arrays.fill(filmA[d], 0);
		Arrays.fill(filmB[d], 1);
		if(check(filmA)){
			if(ans>injectNum)
				ans=injectNum;
			return;
		}
		else if(check(filmB)) {
			if(ans>injectNum)
				ans=injectNum;
			return;
		}
		for(int i=d+1; i<=D; i++) {
			if(injectNum+1<ans)
				BFS(i, filmA, injectNum+1);
			if(injectNum+1<ans)
				BFS(i, filmB, injectNum+1);
		}
	}
	
	static boolean check(int[][] film) {
		int eql;
		boolean test=false;
		
		for(int j=1; j<=W; j++) {
			for(int i=1;i<=D-K+1;i++) {
				eql=0;
				test=false;
				for(int k=i; k<i+K-1; k++) {
					if(film[k][j]==film[k+1][j])
						eql++;
				}
				if(eql==K-1) {
					test=true;
					break;
				}
			}
			if(!test)
				return false;
		}
		return true;
	}
}
