import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int L;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		L = sc.nextInt();
		int ans=0;
		
		map = new int[N+1][N+1];
		boolean[] slope = new boolean[N+1];
		
		for(int i=1; i<=N; i++) 
			for(int j=1; j<=N; j++)
				map[i][j] = sc.nextInt();

		for(int i=1; i<=N; i++) {
			Arrays.fill(slope, false);
			for(int j=1; j<=N; j++) {
				if(j==N) {
					ans++;
					break;
				}
				if(map[i][j]==map[i][j+1]) {
					continue;
				}
				// 내리막
				else if(map[i][j]-map[i][j+1]==1) {
					if(j+L<=N && roadCheck(1, i, j+1, j+L, slope)) {
						for(int k=j+1; k<=j+L; k++)
							slope[k]=true;
						j=j+L-1;
						continue;
					}
					else
						break;
				}
				// 오르막
				else if(map[i][j]-map[i][j+1]==-1) {
					if(j-L+1>=1 && roadCheck(1, i, j-L+1, j, slope)) {
						for(int k=j; k>=j-L+1; k--)
							slope[k]=true;
						continue;
					}
					else
						break;
				}
				else
					break;
			}
		}
		
		for(int j=1; j<=N; j++) {
			Arrays.fill(slope, false);
			for(int i=1; i<=N; i++) {
				if(i==N) {
					ans++;
					break;
				}
				if(map[i][j]==map[i+1][j]) {
					continue;
				}
				// 내리막
				else if(map[i][j]-map[i+1][j]==1) {
					if(i+L<=N && roadCheck(2, j, i+1, i+L, slope)) {
						for(int k=i+1; k<=i+L; k++)
							slope[k]=true;
						i=i+L-1;
						continue;
					}
					else
						break;
				}
				// 오르막
				else if(map[i][j]-map[i+1][j]==-1) {
					if(i-L+1>=1 && roadCheck(2, j, i-L+1, i, slope)) {
						for(int k=i; k>=i-L+1; k--)
							slope[k]=true;
						continue;
					}
					else
						break;
				}
				else
					break;
			}
		}

		System.out.println(ans);
	}
	
	static boolean roadCheck(int direction, int roadNum, int start, int end, boolean[] slope ) {
		// row : 1, column : 2
		if(slope[start])
			return false;
		
		if(direction==1) {
			for(int i=start; i<end; i++) {
				if(map[roadNum][i]!=map[roadNum][i+1] || slope[i])
					return false;
			}
		}
		else {
			for(int i=start; i<end; i++) {
				if(map[i][roadNum]!=map[i+1][roadNum] || slope[i])
					return false;
			}
		}
		return true;
	}
}
