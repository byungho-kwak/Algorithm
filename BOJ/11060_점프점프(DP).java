/*
 * 11060 점프점프
 * 유형 : DP
 * 설명 : 2017 상반기 삼성전자 문제와 동일. 당시 greedy로 생각했으나 DP 문제였음 
 *
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, ans;
	static final int INF = 293492394;
	public static void main(String... msg) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int dp[] = new int[N];
		int r[] = new int[N];

		for (int i = 0; i < N; i++)
			r[i] = sc.nextInt();

		Arrays.fill(dp, INF);
		dp[0] = 0;
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j <= r[i]; j++) {
				if (i + j < N) {
					dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
				}
			}
		}
		ans = dp[N-1]==INF ? -1 : dp[N-1];
		System.out.println(ans);
	}
}
