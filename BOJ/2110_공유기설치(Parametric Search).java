
/*
 * BOJ 2667 단지번호붙이기 17.01.05
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N, C;
	static int[] arr;
	static int ans;
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		ans=0;
		N = sc.nextInt();
		C = sc.nextInt();
		
		arr = new int[N];
		
		for(int i=0; i<N; i++)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		int left = arr[0];
		int right = arr[N-1];
		int mid = arr[N-1] - arr[0];
		int hubNum;
		if(N==2) {
			ans=mid; 
		}
		else {
			while(left<=right) {
				mid = (left+right)/2;
				hubNum = find(mid);
				if(hubNum >=C) {
					if(ans < mid)
						ans=mid;
					left = mid+1;
				}
				else {
					right = mid-1;
				}
			}
		}
		System.out.println(ans);
	}
	
	static int find(int gap) {
		int gapCnt=1;
		int now=0;
		int next=1;
		int nowGap=0;
		while(next<N) {
			nowGap = arr[next] - arr[now];
			if(nowGap>=gap) {
				now = next;
				gapCnt++;
			}
			next++;
		}
		return gapCnt;
	}
	
}