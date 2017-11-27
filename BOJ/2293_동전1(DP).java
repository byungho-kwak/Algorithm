import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int Answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] a = new int[101];
		int[] dp = new int[10001];
		int[] coin  = new int[10001];
		
		for(int i=1; i<=n; i++)
			a[i] = sc.nextInt();
		
		Arrays.fill(dp, 0);
		
		dp[0]=1;
		
		for(int i=1; i<=n; i++) 
			for(int j=a[i]; j<=k; j++) 
				dp[j]+=dp[j-a[i]];
		
		System.out.println(dp[k]);
	}
}
