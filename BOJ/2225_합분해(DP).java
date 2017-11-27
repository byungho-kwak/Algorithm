import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		int[][] D;
		int mod = 1000000000;
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		D = new int[N+1][K+1];
		
		for(int i=0; i<=N; i++) {
			D[i][0] = 0;
			D[i][1] = 1;
		}
		
		for(int i=2; i<=K; i++) {
			for(int j=0; j<=N; j++) {
				for(int k=0; k<=j; k++)
					D[j][i] = (D[j][i]+D[j-k][i-1])%mod;
			}
		}
		System.out.println(D[N][K]);
	}
}
