/*
 * 4012. [모의 SW 역량테스트] 요리사
 * 유형 : dfs(완전탐색) + 비트마스크 활용
 */

import java.util.Scanner;

public class Main {
	static int[][] map;
	static int N, ans;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			ans=244444444;
			N = sc.nextInt();
			map=new int[N+1][N+1];
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			// 재료 체크 비트마스크, 재료 사용 갯수, 재료 체크하려는 현재 인덱스
			dfs(0, 0, 0);
			System.out.println("#"+t+" "+ans);
		}
	}
	static void dfs(int visited, int cnt, int idx) {
		// N/2개 재료 체크 다 되었다면
		if(cnt==N/2) {
			// visite : 체크한 재료들
			// ~visited : 체크하지 않은 재료들
			if(ans>Math.abs(calc(visited) - calc(~visited)))
				ans = Math.abs(calc(visited) - calc(~visited));
			return;
		}
		// N/2개 자료 사용이 안되었지만, 재료 확인 인덱스가 끝가지 간 경우 
		if(idx==N)
			return;
		
		// 현재 idx의 재료를 사용하는 경우
		dfs((1<<idx+1)|visited, cnt+1, idx+1);
		// 현재 idx의 재료를 사용하지 않는 경우
		dfs(visited, cnt, idx+1);
	}
	
	static int calc(int visited) {
		int taste=0;
		// 사용된 재료에 대해서 시너지 값 구하기
		for(int i=1; i<N; i++) {
			if(((visited>>i)&1)==1) {
				for(int j=i+1; j<=N; j++) {
					if(((visited>>j)&1)==1) {
						taste+=map[i][j]+map[j][i];
					}
				}
			}
		}
		return taste;
	}
}

