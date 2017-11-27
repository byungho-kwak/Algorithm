import java.util.Arrays;
import java.util.Scanner;


/*
 * 	오답노트 정리하기
 *  x+y+z = A[i], (단, x,y,z < i)
 *  x+y = A[i]-z 로 변환해서 풀기
 *  시간복잡도 : O(N^2)
 * 
 */



class Main {
	static int Answer;
	
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 0; test_case < T; test_case++) {
			int offset = 200000;
			Answer=0;
			int[] input = new int[5001];
			boolean[] check = new boolean[500000];
			int N = sc.nextInt();
			
			for(int i=1; i<=N; i++) 
				input[i] = sc.nextInt();
			
			for(int i=1; i<=N; i++) {
				int now = input[i];
				for(int j=1; j<i; j++) 
					check[input[i-1]+input[j]+offset]=true;
				
				for(int j=1; j<i; j++){
					if(check[now-input[j]+offset]) {
						Answer++;
						break;
					}
				}
			}
		
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
}