import java.awt.Point;
import java.util.*;
import java.util.Arrays;

public class Test {  
	
	static int N;
	static int [] T = new int [16];
	static int [] P = new int [16];
	static int MAX = 0;
	
	static int[] DP = new int[16];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Arrays.fill(DP, -1);
		
		N = sc.nextInt();
		
		for(int i=1; i<=N; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		
		System.out.println(MaxFind(1));
	}
	
	static int MaxFind(int day) {
		
		if(day == N+1)
			return 0;
		
		if(day > N+1)
			return -1000000;
		
		if(DP[day]!=-1)
			return DP[day];
		
		return DP[day] = Math.max(MaxFind(day+1), MaxFind(day+T[day])+P[day]);
	}

}