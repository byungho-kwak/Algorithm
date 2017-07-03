import java.awt.Point;
import java.util.*;

public class Test {  
	static int N;
	static int M;
	static int TC;
	static int[][] input; 
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		input = new int[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				input[i][j] = sc.nextInt();
			}
		}
		
		TC = sc.nextInt();
		
		Point [] sPoint = new Point[TC+1];
		Point [] ePoint = new Point[TC+1];
		
		for(int i=1; i<=TC; i++) {
			sPoint[i] = new Point(sc.nextInt(),sc.nextInt());
			ePoint[i] = new Point(sc.nextInt(),sc.nextInt());
		}
		
		for(int i=1; i<=TC; i++)
			System.out.println(arraySum(sPoint[i], ePoint[i]));
		
		
	}
	
	static int arraySum(Point start, Point end) {
		
		int[][] DP = new int[N+1][M+1];
		for(int i=0; i<=N; i++)
			for(int j=0; j<=M; j++)
				DP[i][j] = 0;
		
		for(int i=start.x; i<=end.x; i++) {
			for(int j=start.y; j<=end.y; j++) {
				DP[i][j] = DP[i][j-1] + input[i][j];
				
				if(j == end.y)
					DP[i][j] += DP[i-1][j];
			}
		}
		
		return DP[end.x][end.y];
	}
	
}