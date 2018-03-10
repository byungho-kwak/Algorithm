import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
	
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[] setA = new boolean[N+1]; 
		boolean[] setB = new boolean[N+1];
		Arrays.fill(setB, true);
		int[][] map = new int[N+1][3];

		for(int i=1; i<=N; i++) {
			int C = sc.nextInt();
			for(int c=0; c<C; c++) 
				map[i][c] = sc.nextInt();
		}
		
		int notRelate;
		int enemy=0;
		while(true) {
			notRelate=0;
			for(int i=1; i<=N; i++) {
				enemy=0;
				if(setA[i]) {
					for(int j=0; j<3; j++) {
						if(map[i][j]>0 && setA[map[i][j]]) {
							enemy++;
						}
					}
					if(enemy>1) {
						setB[i]=true;
						setA[i]=false;
						notRelate++;
					}
				}
				else {
					for(int j=0; j<3; j++) {
						if(map[i][j]>0 && setB[map[i][j]]) {
							enemy++;
						}
					}
					if(enemy>1) {
						setB[i]=false;
						setA[i]=true;
						notRelate++;
					}
				}

			}
			if(notRelate==0)
				break;
		}
		
		int setACnt=0;
		for(int i=1; i<=N; i++) {
			if(setA[i])
				setACnt++;
		}
		System.out.print(setACnt);
		for(int i=1; i<=N; i++) {
			if(setA[i])
				System.out.print(" "+i);
		}
		System.out.println();
		System.out.print(N-setACnt);
		for(int i=1; i<=N; i++) {
			if(setB[i])
				System.out.print(" "+i);
		}
	}
}