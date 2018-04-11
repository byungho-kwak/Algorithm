/*
 * 2115. [모의 SW 역량테스트] 벌꿀채취
 * 유형 : dfs
 * 접근법 : 행별 최댓값 중 2개 선택 vs 한개 행 내 2개 선택 중 최댓값
 */

import java.util.Arrays;
import java.util.Scanner;
public class Main {
	static int N, M, C;
	static int map[][];
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			C = sc.nextInt();

			map = new int[N][N];
			int[] rowMax = new int[N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
				for(int j=0; j<=N-M; j++) {
					int temp = calHoneyMax(i,j,0,0,0);
					if(rowMax[i]<temp)
						rowMax[i] = temp;
				}
			}
			int ans=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<=N-M; j++) {
					int temp1 = calHoneyMax(i,j,0,0,0);
					int temp2=0;
					int visited=0;
					for(int k=0; k<M; k++) {
						visited+=1<<j+k;
					}
					
					for(int k=0; k<=N-M; k++) {
						if(((visited>>k)&1)==1 || ((visited>>k+M)&1)==1) continue;
						temp2 = calHoneyMax(i,k,0,0,0);
					}
					if(ans<temp1+temp2)
						ans=temp1+temp2;
				}
			}
			
			Arrays.sort(rowMax);
			if(rowMax[N-1]+rowMax[N-2] > ans)
				ans = rowMax[N-1]+rowMax[N-2];
			System.out.println("#"+t+" "+ans);
		}
	}

	static int calHoneyMax(int x, int y, int idx, int nowHoney, int revenue) {
		if(idx>=M)
			return revenue;
		
		int max=0;
		if(nowHoney+map[x][y+idx]<=C)
			max = calHoneyMax(x, y, idx+1, nowHoney+map[x][y+idx], revenue+map[x][y+idx]*map[x][y+idx]);
		
		if(max < calHoneyMax(x, y, idx+1, nowHoney,revenue))
			max = calHoneyMax(x, y, idx+1, nowHoney, revenue);
		
		return max;
	}
}