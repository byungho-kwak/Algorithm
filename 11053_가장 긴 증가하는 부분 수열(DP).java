import java.util.*;

public class Test {  
	static int N;
	static int[] input = new int[1001]; 
	static int[] DP = new int[1001];
	static int MAX =0;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		input[0] = 0;
		DP[0] = 0;
		DP[1] = 1;
		
		for(int i=1; i<=N; i++)
			input[i] = sc.nextInt();
		
		
		for(int i=2; i<=N; i++) {
			DP[i] = DP[find(i)]+1;
		}
		
		
		for(int i=1; i<=N; i++) {
			if(DP[i] > MAX)
				MAX = DP[i];
		}
		
		System.out.println(MAX);
		
	}
	
	static int find(int index) {
		int max = 0;
		
		for(int i=1; i<index; i++) {
			if(input[i] < input[index]) {
				//if(input[max] <= input[i])
				if(DP[max] <= DP[i])
					max = i;
			}
		}
		
		return max;
	}

}