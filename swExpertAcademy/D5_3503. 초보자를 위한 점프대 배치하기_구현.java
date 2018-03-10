
/*
	3503. �ʺ��ڸ� ���� ������ ��ġ�ϱ�
	
	* �ֺ������� �������� ���� ���ؼ��� �Ʒ��� ���� ���� �� ��ġ�ϸ� �ȴ�.
	1) �Է°� ����
	2) ���� ū �� �߰��� �ΰ�
	3) ���ĵ� ���� ū ������ ���ʴ�� �ӽ� �迭�� mid+j, mid-j������ ��ġ�Ѵ�.
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