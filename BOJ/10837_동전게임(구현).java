import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		int C = sc.nextInt();
		int[][] a = new int[C+1][3];
		int[][] map = new int[1001][1001];  
		
		for(int i=1; i<=C; i++) {
			a[i][1] = sc.nextInt();
			a[i][2] = sc.nextInt();
		}
		for(int i=0; i<=K; i++) {
			for(int j=0; j<=K; j++) {
				if(i==j)
					map[i][j]=1;
				else if(i>j) {
					if(K+j>=2*i-2)
						map[i][j]=1;
					else
						map[i][j]=0;
				}
				else {
					if(K+i>=2*j-1)
						map[i][j]=1;
					else
						map[i][j]=0;
				}
			}
		}
		
		for(int i=1; i<=C; i++){
			System.out.println(map[a[i][1]][a[i][2]]);
		}
	}
}
