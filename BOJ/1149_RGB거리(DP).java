import java.util.Scanner;

public class Main {
	static int N;
	static int[][] input = new int[1001][1001];
	static int[][] cache = new int[1001][1001];
	static int[] DP = new int[1001];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=3; j++) {
				input[i][j] = sc.nextInt();
			}
		}

		cache[1][1] = input[1][1];
		cache[1][2] = input[1][2];
		cache[1][3] = input[1][3];
		
		DP[1] = Math.min(cache[1][3],Math.min(cache[1][1], cache[1][2]));
		
		for(int i=2; i<=N; i++) {
			cache[i][1] = input[i][1] + Math.min(cache[i-1][2], cache[i-1][3]);
			cache[i][2] = input[i][2] + Math.min(cache[i-1][1], cache[i-1][3]);
			cache[i][3] = input[i][3] + Math.min(cache[i-1][1], cache[i-1][2]);
			
			DP[i] =  Math.min(cache[i][1],Math.min(cache[i][2], cache[i][3]));
		}
		
		System.out.println(DP[N]);
	}

}
