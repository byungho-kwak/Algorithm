
/*
 * 1211. [S/W 문제해결 기본] 2일차 - Ladder2
*/

import java.util.Scanner;

public class Main {
	static final int INF=1000000000;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		for(int T=1; T<=10; T++) {
			int tc = sc.nextInt();
			int[][] map = new int[101][102];
			int x=100, point =0,y=0, move=INF;
			for(int i=1; i<=100; i++) {
				for(int j=1; j<=100; j++) { 
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int yP=1; yP<=100; yP++) {
				y=yP;
				int tmpMove=0;
				x=100;
				// 시작점이 1이어야만 가능
				if(map[x][y]==1) {
					while(x>0) {
						if(map[x][y-1]==1) {
							while(true) {
								y--;
								tmpMove++;
								if(map[x-1][y]==1)
									break;
							}
						}
						else if(map[x][y+1]==1) {
							while(true) {
								y++;
								tmpMove++;
								if(map[x-1][y]==1)
									break;
							}
						}
						x--;
					}
					
					if(tmpMove<move) {
						move=tmpMove;
						point=y;
					}
					else if(tmpMove==move) {
						if(point<y)
							point=y;
					}
				}
			}
			point--;
			System.out.println("#"+tc+" "+point);
		}
	}
}