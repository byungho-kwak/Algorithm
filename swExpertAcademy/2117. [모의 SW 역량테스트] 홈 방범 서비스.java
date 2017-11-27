import java.util.Scanner;

public class Solution {
	public static void main(String[] args){	
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int test=1; test<=tc; test++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int ans=1;
			int[][] map = new int[N+1][N+1];
			
			for(int i=1; i<=N; i++)
				for(int j=1; j<=N; j++)
					map[i][j]=sc.nextInt();
			int serviceCnt=0;
			for(int K=2; K<=30; K++){
				int serviceCost = K*K+(K-1)*(K-1);
						serviceCnt=0;
				for(int x=1; x<=N; x++){
					for(int y=1; y<=N; y++) {
						serviceCnt=0;
						for(int j=0; j<=K-1; j++) {
							
							for(int i=0; i<=K-1-j; i++) {
								if(y-j>=1) {
									if(x-i>=1 && map[x-i][y-j]==1)
										serviceCnt++;
									if(i>0 && x+i<=N && map[x+i][y-j]==1)
										serviceCnt++;
								}
								if(j>0 && y+j<=N) {
									if(x-i>=1 && map[x-i][y+j]==1)
										serviceCnt++;
									if(i>0 && x+i<=N && map[x+i][y+j]==1)
										serviceCnt++;
								}
							}
						}
						if(serviceCnt*M - serviceCost>=0 && ans<serviceCnt)
							ans=serviceCnt;
					}
				}
			}
			System.out.println("#"+test+" "+ans);
		}
	}
}


