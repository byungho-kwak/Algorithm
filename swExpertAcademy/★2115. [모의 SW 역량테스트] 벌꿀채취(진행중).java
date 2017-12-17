import java.util.Arrays;
import java.util.Scanner;
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V4A46AdIDFAWu&categoryId=AV5V4A46AdIDFAWu&categoryType=CODE
public class Main {
	static int N;
	static int M;
	static int C;
	static int[][] map;
	static int[][] sum;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			ans=0;
			N = sc.nextInt();
			M = sc.nextInt();
			C = sc.nextInt();
			
			map = new int[N+1][N+1];
			sum = new int[N+1][N+1];
			for(int i=1; i<=N; i++)
				for(int j=1; j<=N; j++)
					map[i][j] = sc.nextInt();
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N-M+1; j++) {
					for(int k=0; k<M; k++) {
						sum[i][j]+=map[i][j+k];
					}
				}
			}
			int maxA;
			int profitA;
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N-M+1; j++) {
					profitA=0;
					if(sum[i][j]<=C) {
						for(int k=0; k<M; k++) 
							profitA+=map[i][j+k]*map[i][j+k];
					}
					else 
						profitA=returnMax(i, j);
						
					find(profitA, i, j+M);
				}
			}
			System.out.println("#"+t+" "+ans);
		}
	}
	
	static void find(int profitA, int x, int y) {
		int profitB=0;
		if(y+M-1<=N) {
			for(int j=y; j<=N-M; j++) {
				profitB = returnMax(x, j);
				if(ans<profitA+profitB)
					ans=profitA+profitB;
			}
		}
		
		x+=1;
		if(x>N)
			return;
		
		for(int i=x; i<=N; i++) {
			for(int j=1; j<=N-M+1; j++){
				profitB=0;
				if(sum[i][j]<=C) {
					for(int k=0; k<M; k++) 
						profitB+=map[i][j+k]*map[i][j+k];
				}
				else 
					profitB=returnMax(i, j);
				if(ans<profitA+profitB)
					ans=profitA+profitB;
			}
				
		}
	}
	static int returnMax(int x, int y) {
		
		int[] temp = new int[M];
		int profit=0;
		int volume=0;
		for(int i=0; i<M; i++) 
			temp[i] = map[x][y+i];
		
		Arrays.sort(temp);
		
		
		// 5개 중 C 안넘고 최댓값 되는게 오류라 #9, #10 답이 안맞음
		for(int i=0; i<M; i++) {
			if(volume+temp[i]<=C) {
				profit+=temp[i]*temp[i];
				volume+=temp[i];
			}
			else{
				if(profit<temp[i]*temp[i]) {
					profit = temp[i]*temp[i];
					volume = temp[i];
					for(int j=i-1; j>=0; j--){ 
						if(volume+temp[j]<=C) {
							profit+= temp[j]*temp[j];
							volume+= temp[j];
						}
					}
				}
			}
		}
		return profit;
	}
}