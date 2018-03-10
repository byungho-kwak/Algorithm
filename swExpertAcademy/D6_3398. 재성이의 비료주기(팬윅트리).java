import java.util.Scanner;

public class Main {
	static int N, D;
	static long s,a,b;
	static int[] tree, C, K, ans;
	static int[] sumTree;
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int T=1; T<=tc; T++) {
			N = sc.nextInt();
			D = sc.nextInt();
			s = sc.nextLong();
			a = sc.nextLong();
			b = sc.nextLong();
			
			tree = new int[N+1];
			sumTree = new int[N+1];
			C = new int[D+1];
			K = new int[D+1];
			int ans=0;
			
			for (int i=1; i<=D; i++) {
			    C[i] = (int)s % N + 1;
			    s = (s * a + b) % 1000000007;
			    K[i] = (int)s % N + 1;
			    s = (s * a + b) % 1000000007;
			}
			
			int start=1;
			int end=1;
			for(int d=1; d<=D; d++) {
				end=start+C[d]-1;
				if(end>N)
					end=end%N;

				int endRight = end+1;
				if(endRight>5)
					endRight=1;
				
				
				if(start<end) {
					add(start, d);
					if(end<N) {
						add(end+1, -d);
					}
				}
				else {
					add(1, d);
					if(end+1<5 && end+1!=start) {
						add(end+1, -d);
						add(start, d);
					}
				}
				
				int findAns = end+K[d];
				if(findAns>N)
					findAns-=N;
				
				ans += sum(findAns);
				
				start = end+1;
				if(start>N)
					start=1;
			}
			
			System.out.println("#"+T+" "+ans);
		}

	}
	
	static void add(int idx, int val) {
		while(idx<=N) {
			tree[idx] += val;
			idx += (idx & -idx);
		}
	}
	
	static int sum(int idx) {
		int s = 0;
		while(idx>0) {
			s += tree[idx];
			idx -= (idx & -idx);
		}
		return s;
	}
}