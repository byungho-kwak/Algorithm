import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	static int Answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			Answer = 0;
			
			int classNum = sc.nextInt();
			int maxCredit = sc.nextInt();
			
			int[] credit = new int[classNum];
			int[] dp = new int[classNum];

			for(int i=0; i<classNum; i++)
				credit[i] = sc.nextInt();
			
			Arrays.sort(credit);
			Arrays.fill(dp, 0);
			dp[0] = credit[0];
			
			for(int i=1; i<classNum; i++) {
				
				for(int j=i-1; j>=0; j--){
					if(credit[i]+dp[j]<=maxCredit) {
						dp[i] = credit[i]+dp[j];
						break;
					}
				}
				if(Answer < dp[i])
					Answer=dp[i];
			}
			
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
		
	}
}

