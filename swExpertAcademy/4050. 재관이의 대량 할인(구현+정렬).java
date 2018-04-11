/*
 * ���� : 4050. ������� �뷮 ����
 * ���� : ���� + ����(������������ �迭 ����ؾ���)
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			int sum=0, minSum=0, idx=N-1;
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
				sum+=arr[i];
			}
			
			Arrays.sort(arr);
			while(true) {
				if(idx<0 || idx-2<0)
					break;
				minSum+= Math.min(arr[idx], Math.min(arr[idx-1], arr[idx-2]));
				idx-=3;
			}
			System.out.println("#"+t+" "+(sum-minSum));
		}
	}
}

