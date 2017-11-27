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
			int temp;
			
			for(int i=1; i<=N; i++) {
				temp = sc.nextInt();
				Answer = Answer^temp;
			}
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
			
		}
	}
		
}

