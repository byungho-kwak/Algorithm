import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] input = new int[1001];
		int[] DP = new int[1001];
		
		Arrays.fill(DP, 0);
		
		int N = sc.nextInt();
		
		for(int i=1; i<=N; i++)
			input[i] = sc.nextInt();
		
		int MAX = 0;
		
		int totalMax = 0;
		
		DP[N] = 1;

		
		for(int i=N-1; i>=1; i--) {
			for(int j=N; j>i; j--) {
				
				if(input[i] > input[j]) {
					if(DP[j] > MAX) {
						MAX = DP[j];
					}
				}
			}
			
			if(MAX == 0)
				DP[i] = 1;
			else
				DP[i] = MAX+1;
			
			if(totalMax < DP[i])
				totalMax = DP[i];
			
			MAX = 0;
		}
		System.out.println(totalMax);
	}
}
