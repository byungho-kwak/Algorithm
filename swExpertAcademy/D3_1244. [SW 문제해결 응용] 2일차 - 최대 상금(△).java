/* 1244. [S/W 문제해결 응용] 2일차 - 최대 상금
 * 접근법 : 완전탐색(조합) + DP
 */
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int max;
	static int len, changeCnt;
	static int[][] memo = new int[1000000][12];
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			max=0;
			int input = sc.nextInt();
			changeCnt = sc.nextInt();
			
			String str = Integer.toString(input);
			len = str.length();
			int[] arr = new int[len];
			for(int i=0; i<str.length(); i++)
				arr[i] = str.charAt(i)-48;
			
			for(int i=0; i<1000000; i++) {
				for(int j=0; j<12; j++) {
					memo[i][j]=0;
				}
			}
			
			change(arr, 0);
			System.out.println("#"+t+" "+max);
		}
	}
	static void change(int[] num, int cnt) {
		int result=0;
		for(int i=0; i<len; i++)
			result=result*10+num[i];
		
		if(memo[result][cnt]>0)
			return;
		
		
		if(cnt==changeCnt) {
			if(result > max) 
				max = result;
			return;
		}
		
		memo[result][cnt]=1;
		for(int i=0; i<len-1; i++) {
			for(int j=i+1; j<len; j++) {
				int[] change = Arrays.copyOf(num, len);
				int temp = change[i];
				change[i] = change[j];
				change[j] = temp;
				
				change(change, cnt+1);
			}
		}
	}
}