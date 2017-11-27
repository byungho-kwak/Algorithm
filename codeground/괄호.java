import java.awt.Point;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;


public class Main {
	static int Answer;
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		sc.nextLine();	// 개행 안넣어줘서 웹상에서 계속 틀렸음
		for(int test_case = 0; test_case < T; test_case++) {
			Answer=0;
			
			Stack<Point> s = new Stack<>();
			
			String a = sc.nextLine();
			boolean[] dp = new boolean[a.length()];
			int[] result = new int[a.length()];
			Arrays.fill(dp, false);
			Arrays.fill(result, 0);
			
			for(int i=0; i<a.length(); i++) {
				if(a.charAt(i)=='(') 
					s.push(new Point('(', i));
				else if(a.charAt(i)=='{')
					s.push(new Point('{', i));
				else if(a.charAt(i)=='[')
					s.push(new Point('[', i));
				else if(s.isEmpty())
						continue;
				else if((int)a.charAt(i)==s.peek().x+1 || (int)a.charAt(i)==s.peek().x+2) {
						dp[i]=true;
						dp[s.peek().y]=true;
						s.pop();
				}
				else
					s.pop();
			}
			
			
			if(a.length()>0) {
				if(dp[0]) 
					result[0]=1;
				else
					result[0]=0;
				
				for(int i=1; i<dp.length; i++) {
					if(!dp[i]) // false면
						result[i]=0;
					else 
						result[i] = result[i-1]+1;
					
					// 연속하는 최대값 저장
					if(result[i] > Answer)
						Answer = result[i];
				}
			}
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}

	}
}
