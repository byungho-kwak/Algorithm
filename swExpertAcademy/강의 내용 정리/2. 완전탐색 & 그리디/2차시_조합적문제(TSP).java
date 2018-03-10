import java.util.Scanner;

public class Main {
	static int N;
	static int[][] Graph;
	static int[][] memo;
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Graph = new int[N][N];
		memo = new int[N][1<<N];
		for(int i=0; i<N; i++)
			for(int j=1; j<N; j++)
				Graph[i][j] = sc.nextInt();
			
		System.out.println(solve(0, 0));
		
	
	}
	static int solve(int pos, int visited) {
		// 모든 비트에 불이 다 켜져 있다면(모두 방문했다면)
		if(visited == (1<<N)-1)
			return 0;
		// 현 시작점에서 현재까지 방문했던 곳까지의 최솟값이 계산되어 있다면 재귀 안나가고 반환
		if(memo[pos][visited]>0)
			return memo[pos][visited]; 
		
		int ret = 999999999;
		for(int next=0; next<N; next++) {
			// 해당 비트에 불이 꺼져 있다면 (해당 비트에 불이 꺼져있다면)
			if((visited&(1<<next))==0) {
				// 재귀 진행
				// visited|1<<next : 다음 방문할 곳을 비트에 불 켜기
				int tmp = Graph[pos][next] + solve(next, visited|1<<next);
				if(ret>tmp)
					ret = tmp;
			}
		}
		// 경로 최솟값 구한거 메모이제이션
		memo[pos][visited]=ret;
		return ret;
	}
}