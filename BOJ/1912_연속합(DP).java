import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int[] input = new int[100001];
	static int[] DP = new int[100001];
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for(int i=1; i<=N; i++)
			input[i] = sc.nextInt();
		
		Arrays.fill(DP, 0);
		
		DP[1] = input[1];
		// DP 값 중 최대 값 선별하기
		int max = DP[1];
		
		for(int i=2; i<=N; i++) {
			// 현재 인덱스 값 포함 기준으로 연속합의 최대 구하기
			// now 인덱스 값 자체 vs now 인덱스 값 자체 + now-1 인덱스 기준 연속합 최대(DP[now-1]) 
			
			DP[i] =  Math.max(input[i], input[i]+DP[i-1]);
			
			if(DP[i] > max)
				max = DP[i];
		}

		System.out.println(max);
	}

}
