import java.awt.Point;
import java.util.*;
import java.util.Arrays;

public class Test {  
	
	static int N;

	static int[] DP = new int[1001];
	static int[] P = new int[10001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Arrays.fill(DP, -1);
		
		N = sc.nextInt();
		
		for(int i=1; i<=N; i++) {
			P[i] = sc.nextInt();
		}
		
		DP[0] = 0;
		DP[1] = P[1];
		
		System.out.println(MaxFind(N));
	}
	
	// MaxFind(N) :  N°³ÀÇ ºØ¾î»§À» ÆÈ¾ÒÀ» ¶§ ÃÖ´ë ºñ¿ë
	// DP[N] :  N°³ÀÇ ºØ¾î»§À» ÆÈ¾ÒÀ» ¶§ ÃÖ´ë ºñ¿ë
	static int MaxFind(int num) {
		int subResult = 0;
		
		if(num == 1)
			return DP[1];
		
		if(DP[num]!=-1)
			return DP[num];
		
		for(int i=1; num-i>=i; i++) {
			subResult = Math.max(subResult, MaxFind(num-i)+MaxFind(i));
		}

		return DP[num] = Math.max(P[num], subResult);
	}

}