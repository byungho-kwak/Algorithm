import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int N = sc.nextInt();
		int[] input = new int[N+1];
		int[] DP = new int[N+1];
		
		Arrays.fill(DP, 0);
		
		for(int i=1; i<=N; i++)
			input[i] = sc.nextInt();
		DP[0] = 0;
		DP[1] = input[1];
		int MAX = DP[1];
		int maxIdx=0;
		
		for(int i=2; i<=N; i++) {
			for(int j=1; j<i; j++) {
				
				if(input[j] < input[i]) {
					if(DP[j] >= DP[maxIdx])
						maxIdx = j;
				}
			}
		
			if(maxIdx == 0)
				DP[i] = input[i];
			else
				DP[i] = DP[maxIdx]+input[i];
			
			if(MAX < DP[i])
				MAX = DP[i];
			
			maxIdx=0;
		}
	
		System.out.println(MAX);
	}
}
