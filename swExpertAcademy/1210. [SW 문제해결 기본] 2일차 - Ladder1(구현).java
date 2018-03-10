import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int T=1; T<=10; T++) {
			int tc = sc.nextInt();
			int[][] map = new int[101][102];
		
			int x=100, y =0;
			for(int i=1; i<=100; i++) {
				for(int j=1; j<=100; j++) { 
					map[i][j] = sc.nextInt();
					if(map[i][j]==2) {
						y=j;
					}
				}
			}
			
			while(x>0) {
				if(map[x][y-1]==1) {
					while(true) {
						y--;
						if(map[x-1][y]==1)
							break;
					}
				}
				else if(map[x][y+1]==1) {
					while(true) {
						y++;
						if(map[x-1][y]==1)
							break;
					}
				}
				x--;
			}
			y--;
			System.out.println("#"+tc+" "+y);
		}
	}
}