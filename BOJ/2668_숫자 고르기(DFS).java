
/*
 * BOJ 2688 숫자고르기 17.01.04
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
	
		int N = sc.nextInt();
		int max=0;
		int[] arr = new int[N+1];
		int[] ans=new int[N+1];
	
		for(int i=1; i<=N; i++) 
			arr[i] = sc.nextInt();

		boolean[] mapA = new boolean[N+1];
		boolean[] mapB = new boolean[N+1];
		
		int cnt=0;
		int idx;
		
		for(int i=1; i<=N; i++) {
			int[] temp = new int[N+1];
			Arrays.fill(mapA, true);
			Arrays.fill(mapB, true);
			idx=i;
			cnt=0;
			if(ans[i]==1)
				continue;
			while(true) {
				// 사이클 성공
				if(!mapA[idx]) { 
					max+=cnt;
					for(int j=1; j<=N; j++) {
						if(temp[j]==1)
							ans[j]=1;
					}
					break;
				} 
				// 들린곳이라면 (싸이클 실패)
				else if(!mapB[arr[idx]]){ 
					break;
				} 
				// 들리지 않은 곳이라면
				else{
					temp[idx]=1;
					mapA[idx]=false;
					mapB[arr[idx]]=false;
					idx=arr[idx];
					cnt++;
				}
			}
		}
		
		System.out.println(max);
		for(int i=1; i<=N; i++) {
			if(ans[i]==1) 
				System.out.println(i);
		}
	}
}