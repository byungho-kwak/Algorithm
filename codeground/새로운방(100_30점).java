import java.awt.Point;
import java.util.Scanner;

public class Main {
	static int Answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			Answer = 0;
				
			int N = sc.nextInt();
			int input;
			Point[][] map = new Point[N+1][N+1];
			Point[][] dp = new Point[N+1][N+1];
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					input = sc.nextInt();
					map[i][j] = new Point(divTwo(input), divThree(input));
				}
			}
			
			for(int i=1; i<=N; i++) {
				map[i][0] = new Point(0,0);
				map[0][i] = new Point(0,0);
				
				dp[i][0] = new Point(0,0);
				dp[0][i] = new Point(0,0);
			}
			
			dp[1][1] = map[1][1];
			
			Point temp1;
			Point temp2;
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					
					temp1=new Point(dp[i-1][j].x + map[i][j].x, dp[i-1][j].y + map[i][j].y);
					temp2=new Point(dp[i][j-1].x + map[i][j].x, dp[i][j-1].y + map[i][j].y);
					
					int A = Math.min(temp1.x, temp1.y);
					int B = Math.min(temp2.x, temp2.y);
					
					if(A>B)
						dp[i][j] = temp1;
					else
						dp[i][j] = temp2;
				}
			}
			
			Answer = Math.min(dp[N][N].x, dp[N][N].y);
		
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}

	}
	
	static int divTwo(int num) {
		int twoCnt = 0;
		
		while(num%2==0) {
			twoCnt++;
			num=num/2;
		}
		return twoCnt;
	}
	
	static int divThree(int num) {
		int threeCnt = 0;
		
		while(num%3==0) {
			threeCnt++;
			num=num/3;
		}
		return threeCnt;
	}
}

