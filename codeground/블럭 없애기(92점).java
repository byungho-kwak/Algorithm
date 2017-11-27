import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 	오답노트 정리하기
 *  아래 코드로는 시간초과로 인하여 만점 불가(92/100)
 *  1. 동치로 변환(블럭수 차이 1 이내)
 *  2. MAX값 선별
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