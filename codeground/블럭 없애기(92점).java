import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 	�����Ʈ �����ϱ�
 *  �Ʒ� �ڵ�δ� �ð��ʰ��� ���Ͽ� ���� �Ұ�(92/100)
 *  1. ��ġ�� ��ȯ(���� ���� 1 �̳�)
 *  2. MAX�� ����
 * 
 */

class Main {
	static int Answer;
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 0; test_case < T; test_case++) {
			Answer=0;
			int N = sc.nextInt();
			
			int[] arr = new int[100002];
			int[] temp = new int[100002];
			Arrays.fill(arr, 0);
			Arrays.fill(temp, 0);
			for(int i=1; i<=N; i++)
				arr[i] = sc.nextInt();
			
			boolean zero = false;	
			int size=N;
			int start=1;
			int end = 100000;
			
			while(!zero) {
				zero = true;
				for(int j=1; j<=size; j++) {
					if(arr[j-1]==0 || arr[j+1]==0 || arr[j]==0) 
						temp[j]= 0;
					else if(arr[j] <= arr[j-1] && arr[j] <=arr[j+1]) 
						temp[j] = arr[j]-1;
					else 
						arr[j-1] = Math.min(arr[j-1], arr[j+1]);
					
					if(temp[j]!=0)
						zero = false;
				}
				Answer++;
				
				for(int i=1; i<size; i++) {
					if(temp[i]!=0) {
						start = i;
						break;
					}
				}
				
				for(int i=size-1; i>0; i--) {
					if(temp[i]!=0) {
						end = i;
						break;
					}
				}
				int k=0;
				Arrays.fill(arr, 0);
				for(int i=start; i<=end; i++)
					arr[k++] = temp[i];
				size=k;
				Arrays.fill(temp, 0);
			}
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
}