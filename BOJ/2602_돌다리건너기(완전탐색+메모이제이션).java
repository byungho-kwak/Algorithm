/*
 * 문제 : 2602 돌다리 건너기
 * 유형 : 완전탐색 + memoization
 */


import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int str[], dp[][], b[][];
	static int strLen, bLen, ans;
	static final int DEVEL = 0, ANGEL = 1;

	public static void main(String... msg) {
		Scanner sc = new Scanner(System.in);
		ans = 0;

		String t = sc.nextLine();
		strLen = t.length();
		str = copy(str, strLen, t);

		t = sc.nextLine();
		bLen = t.length();
		b = new int[2][bLen];
		b[0] = copy(b[0], bLen, t);

		t = sc.nextLine();
		b[1] = copy(b[1], bLen, t);

		dp = new int[strLen][bLen];
		for(int i=0; i<strLen; i++) {
			for(int j=0; j<bLen; j++) {
				Arrays.fill(dp[i], -1);
			}
		}
		// 악마부터 시작
		ans = dfs(0, 0, 0);
		
		for(int i=0; i<strLen; i++) {
			for(int j=0; j<bLen; j++) {
				Arrays.fill(dp[i], -1);
			}
		}		
		// 천사부터 시작
		ans += dfs(1, 0, 0);

		System.out.println(ans);
	}

	static int dfs(int road, int bIdx, int strIdx) {
		int sum=0;
		int next = bIdx;
		
		// 인덱스 초과시 
		if(bIdx>=bLen)
			return 0;
		
		// 방문했던 곳 
		if(dp[strIdx][bIdx]>-1)
			return dp[strIdx][bIdx];
		
		if(str[strIdx]==b[road][next]) {
			// 입력 문자열 끝까지 도달했을 경우
			if(strIdx==strLen-1) {
				sum=1;
			}
			else {
				if(road==ANGEL)
					sum = dfs(DEVEL, next+1, strIdx+1);
				else
					sum = dfs(ANGEL, next+1, strIdx+1);
			}
		}
		sum += dfs(road, next+1, strIdx);
		
		dp[strIdx][bIdx] = sum;
		return sum;
	}

	static int[] copy(int[] arr, int len, String t) {
		arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = t.charAt(i) - 48;
		}
		return arr;
	}
}
