import java.util.Scanner;

public class Main {
	static int N;
	static int a[];
	static int M;
	static int ans;
	public static void main(String args[]) {
	
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ans=0;
		a = new int[N];
		int l=1;
		int r=0;
		for(int i=0; i<N; i++) {
			a[i] = sc.nextInt();
			if(a[i]>r)
				r = a[i];
		}
		M = sc.nextInt();
		int mid = r;
		while(l<=r) {
			if(check(mid)) {
				if(ans<mid)
					ans = mid;
				l = mid+1;
			}
			else {
				r = mid-1;
			}
			mid=(l+r)/2;
		}
		System.out.println(ans);
	}
	static boolean check(int max) {
		int sum=0;
		for(int i=0; i<N; i++) {
			if(a[i]<=max) {
				sum+=a[i];
			}
			else {
				sum+=max;
			}
		}
		if(sum>M)
			return false;
		else
			return true;
	}
}