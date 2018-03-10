import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, S;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		
		Picture[] picture = new Picture[N+1];
		// sorting시 채워주기 위함
		picture[0] = new Picture(0, 0);
		int[] dp = new int[N+1];
		for(int i=1; i<=N; i++) {
			picture[i] = new Picture(sc.nextInt(), sc.nextInt());
		}
		
		Arrays.sort(picture);
		
		dp[1] = picture[1].c;
		int l, r, mid=0;
		int maxidx=0;
		
		// 이진탐색으로 찾을 가장 큰 idx
		int max=0;
		for(int i=2; i<=N; i++) {
			if(picture[i].h>picture[i-1].h)
				maxidx=i-1;
			l=0;
			r=maxidx;
			max=0;
			while(l<=r) {
				mid = (l+r)/2;
				if(picture[i].h-picture[mid].h < S)
					r = mid-1;
				else {
					if(max<mid)
						max=mid;
					l = mid+1;
				}
			}
			
			dp[i] = Math.max(dp[i-1], dp[max]+picture[i].c);
		}
		System.out.println(dp[N]);
	}
	
	static class Picture implements Comparable<Picture> {
		int h,c;
		public Picture(int h, int c) {
			this.h = h;
			this.c = c;
		}
		@Override
		public int compareTo(Picture o) {
			
			if(this.h == o.h)
				return this.c - o.c;
			else
				return this.h - o.h;
		}
	}
}