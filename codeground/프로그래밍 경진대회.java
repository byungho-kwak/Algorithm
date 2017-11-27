import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int Answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			Answer = 0;
			int N = sc.nextInt();
			int[] input = new int[N];
			int Max=0;
			int temp;
			
			for(int i=0; i<N; i++)
				input[i] = sc.nextInt();
			
			// 입력값 오름차순 정렬
			Arrays.sort(input);
			
			
			// 최소 우승 점수 구하기
			for(int i=0; i<N; i++) {
				temp = input[i]+N-i;
				if(temp > Max)
					Max = temp;
			}
			
			// 우승 가능 응시자 선별
			for(int i=0; i<N; i++) {
				if(input[i]+N >= Max)
					Answer++;
			}
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
			
		}
	}
		
}

