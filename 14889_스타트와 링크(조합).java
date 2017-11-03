import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int ans=1000000000;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N+1][N+1];
		boolean[] check = new boolean[N+1];
		Arrays.fill(check, false);
		check[1]=true;
		
		for(int i=1; i<=N; i++)
			for(int j=1; j<=N; j++)
				map[i][j]=sc.nextInt();
		
		for(int i=1; i<=N-1; i++)
			for(int j=i+1; j<=N; j++)
				map[i][j]+=map[j][i];
		
		combination(check,N, (N/2)-1, 2);
		System.out.println(ans);
			
	}
	
	static void combination(boolean[] check, int n, int r, int idx) {
		boolean[] chk = Arrays.copyOf(check, N+1);
		if(r==0) 
			resultCal(chk);
		else if(idx>n)
			return;
		else {
			combination(chk, n, r, idx+1);
			chk[idx] = true;
			combination(chk, n, r-1, idx+1);
		}
	}
	static void resultCal(boolean[] check) {
		
		int teamA=0;
		int teamB=0;
		
		for(int i=1; i<=N-1; i++) {
			if(check[i]) {
				for(int j=i+1; j<=N; j++) {
					if(check[j]) {
						teamA+=map[i][j];
					}
				}
			}
			else {
				for(int j=i+1; j<=N; j++) {
					if(!check[j]) {
						teamB+=map[i][j];
					}
				}
			}
		}
		if(Math.abs(teamA-teamB)<ans)
			ans = Math.abs(teamA-teamB);
	}
}
