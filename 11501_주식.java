import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	static int TC;
	static int[][] input;
	static int[] dayEnd;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		TC = sc.nextInt();
		
		input= new int[TC+1][1000001];
		dayEnd = new int[TC+1];

		for(int t=1; t<=TC; t++) {
			dayEnd[t] = sc.nextInt();
			for(int i=1; i<=dayEnd[t]; i++) 
				input[t][i] = sc.nextInt();
		}
		
		for(int i=1; i<=TC; i++)
			maxBenefit(i);
	
	}
	
	static void maxBenefit(int tcNum) {
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int max=0;
		// int -> long으로 : 정답(큰수) 표현 가능으로 정답 됨
		long total=0;
		
		for(int i=1; i<=dayEnd[tcNum]; i++)
			stack.push(input[tcNum][i]);
		
		while(!stack.isEmpty()) {
			
			if(max < stack.peek())
				max = stack.pop();
			else
				total+=max-stack.pop();	
		}
		
		System.out.println(total);
		
	}
	
}
