
/*
	3503. 초보자를 위한 점프대 배치하기
	
	* 주변값과의 높이차가 낮기 위해서는 아래와 같이 정렬 및 배치하면 된다.
	1) 입력값 정렬
	2) 가장 큰 값 중간에 두고
	3) 정렬된 값은 큰 값부터 차례대로 임시 배열에 mid+j, mid-j순으로 배치한다.
*/

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int[] arr;
		int[] temp;
		int N, ans;
		for(int t=1; t<=tc; t++) {
			ans=0;
			N = sc.nextInt();
			arr = new int[N];
			temp = new int[N];
			
			for(int i=0; i<N; i++)
				arr[i] = sc.nextInt();
			
			Arrays.sort(arr);
			
			int mid = N/2;
			temp[mid] = arr[N-1];
			
			int j=1;
			for(int i=N-2; i>=0; i--, j++) {
				 temp[mid-j] = arr[i--];
				 if(i>=0)
					 temp[mid+j] = arr[i];
			}
			
			ans = Math.abs(temp[0]-temp[N-1]);
			for(int i=0; i<N-1; i++) {
				if(ans<Math.abs(temp[i] - temp[i+1]))
						ans = Math.abs(temp[i] - temp[i+1]);
			}
			System.out.println("#"+t+" "+ans);
		}
	}
}