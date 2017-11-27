import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int ans=0;
		int n = sc.nextInt();
		int[] a = new int[n+1];
		for(int i=1; i<=n; i++)
			a[i]=sc.nextInt();
		
		boolean[] prime = new boolean[1001];
		Arrays.fill(prime, true);
		
		for(int i=2; i<=Math.sqrt(1000); i++) {
			int idx=2;
			if(prime[i]) {
				while(i*idx<=1000) {
					prime[i*idx]=false;
					idx++;
				}
			}
		}
		
		for(int i=1; i<=n; i++) {
			if(a[i]==1)
				continue;
			else {
				if(prime[a[i]])
					ans++;
			}
		}
		
		System.out.println(ans);
	}
}
