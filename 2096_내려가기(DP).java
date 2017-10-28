import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] map = new int[N+1][4];
		int[][] dMax = new int[N+1][4];
		int[][] dMin = new int[N+1][4];
		
		for(int i=1; i<=N; i++) {
			map[i][1] = sc.nextInt();
			map[i][2] = sc.nextInt();
			map[i][3] = sc.nextInt();
			if(i==1) {
				for(int j=1; j<=3; j++) {
				dMax[i][j] = map[i][j];
				dMin[i][j] = map[i][j];
				}
			}
		}
		
		for(int i=2; i<=N; i++) {
			dMax[i][1] = Math.max(dMax[i-1][1], dMax[i-1][2]) + map[i][1];
			dMax[i][2] = Math.max(Math.max(dMax[i-1][1], dMax[i-1][2]), dMax[i-1][3]) + map[i][2];
			dMax[i][3] = Math.max(dMax[i-1][2], dMax[i-1][3]) + map[i][3];
			
			dMin[i][1] = Math.min(dMin[i-1][1], dMin[i-1][2]) + map[i][1];
			dMin[i][2] = Math.min(Math.min(dMin[i-1][1], dMin[i-1][2]), dMin[i-1][3]) + map[i][2];
			dMin[i][3] = Math.min(dMin[i-1][2], dMin[i-1][3]) + map[i][3];
		}
		
		System.out.println(Math.max(Math.max(dMax[N][1], dMax[N][2]), dMax[N][3])+" "+
							Math.min(Math.min(dMin[N][1], dMin[N][2]), dMin[N][3]));
		
	}
}
