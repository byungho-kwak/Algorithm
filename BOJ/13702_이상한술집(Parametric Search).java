import java.util.Scanner;
public class Main {
	static int N;
	static int K;
	static long ans;
	static long max;
	static long[] capacity;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ans=0;
		N = sc.nextInt();
		K = sc.nextInt();
		capacity = new long[N+1];
		max=0;
		
		for(int i=1; i<=N; i++) {
			capacity[i] = sc.nextInt();
			if(max<capacity[i])
				max = capacity[i];
		}
		binSearch();
		System.out.println(ans);
	}
	
	static void binSearch() {
		long left = 1;
		long right = max;
		long mid=0;
		long divided=0;
		
		while(left<=right) {
			divided=0;
			mid = (left+right)/2;
			for(int i=1; i<=N; i++)
				divided+=capacity[i]/mid;
			if(divided>=K) {
				if(mid>ans)
					ans=mid;
				left = mid+1;
			}
			else 
				right = mid-1;
		}
	}
}