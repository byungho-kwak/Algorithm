import java.awt.Point;
import java.util.*;
import java.util.Arrays;

public class Test {  
	static int T;
	static int N;
	static int[][] input = new int[3][100001];
	static int[][] cache = new int[3][100001];
	static int[] result;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		T = sc.nextInt();
		result = new int[T+1];
		
		for(int i=1; i<=T; i++)
			DP(i);
		
		for(int i=1; i<=T; i++)
			System.out.println(result[i]);

	}
	static void DP(int T) {
		
		N = sc.nextInt();
		
		for(int i=1; i<=2; i++)
			for(int j=1; j<=N; j++)
				input[i][j] = sc.nextInt();
		
		cache[1][1] = input[1][1];
		cache[2][1] = input[2][1];
		
		cache[1][2] = cache[2][1]+input[1][2];
		cache[2][2] = cache[1][1]+input[2][2];

		for(int i=3; i<=N; i++) {
			cache[1][i] = Math.max(cache[2][i-1], cache[2][i-2])+input[1][i];
			cache[2][i] = Math.max(cache[1][i-1], cache[1][i-2])+input[2][i];
		}
		
		result[T] = Math.max(cache[1][N], cache[2][N]);
		
	}
}