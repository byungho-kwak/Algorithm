import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int max = 0;
		Scanner sc = new Scanner(System.in);
		
		String a = sc.nextLine();
		String b = sc.nextLine();
		
		int[][] dp = new int[a.length()+1][b.length()+1];
		
		for(int i=1; i<=a.length(); i++) {
			for(int j=1; j<=b.length(); j++) {
				if(a.charAt(i-1)==b.charAt(j-1)) {
					if(dp[i-1][j-1]==0)
						dp[i][j]=1;
					else
						dp[i][j]=dp[i-1][j-1]+1;
				}
				if(dp[i][j]>max)
					max=dp[i][j];
			}
		}
		
		System.out.println(max);
	}	
}
