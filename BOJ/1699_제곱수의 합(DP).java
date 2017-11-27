import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		final int INIT = 100001;
		int[] D = new int [INIT];
		
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Arrays.fill(D, 0);
		
		int idx=1;
		for(int i=2; idx<=N; i++) {
			D[idx] = 1;
			idx = i*i;
		}
		
		int n = 1;
		int m=0;
		D[0] = 0;

		int min=INIT;
		
		for(int i=1; i<=N;) {
			
			m = (2*n)+1;
			//3, 5, 7, 9...
			for(int j=1; j<=m; j++) {
				if(D[i]==0) {
					for(int k=1; k<=n; k++) {
						if(min > D[k*k]+D[i-k*k])
							min = D[k*k]+D[i-k*k];
					}
					D[i] = min;
				}
				if(i>N)
					break;
				i++;
				min = INIT;
			}
			n++;
		}
		System.out.println(D[N]);
		
	}
}
