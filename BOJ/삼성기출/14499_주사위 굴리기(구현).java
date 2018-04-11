import java.util.Scanner;
public class Main {
	static int N, M, x,y,r, map[][], rec[], die[];
	static int dx[] = {0, 0,0,-1,1}, dy[] = {0, 1,-1,0,0};
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		r = sc.nextInt();
		
		map = new int[N][M];
		rec = new int[r];
		die = new int[7];
		
		for(int i=0; i<N; i++)
			for(int j=0; j<M; j++)
				map[i][j] = sc.nextInt();
		
		for(int i=0; i<r; i++)
			rec[i] = sc.nextInt();

		for(int i=0; i<r; i++) {
			int nextX = x+dx[rec[i]];
			int nextY = y+dy[rec[i]];
			
			if(nextX>=N || nextX<0 || nextY>=M || nextY<0) continue;
			
			x=nextX;
			y=nextY;
			
			int tmp;
			switch (rec[i]) {
			case 1:
				tmp = die[6];
				die[6] = die[3];
				die[3] = die[1];
				die[1] = die[4];
				die[4] = tmp;
				break;
			case 2:
				tmp = die[3];
				die[3] = die[6];
				die[6] = die[4];
				die[4] = die[1];
				die[1] = tmp;
				break;
			case 3:
				tmp = die[5];
				die[5] = die[6];
				die[6] = die[2];
				die[2] = die[1];
				die[1] = tmp;
				break;
			default:
				tmp = die[1];
				die[1] = die[2];
				die[2] = die[6];
				die[6] = die[5];
				die[5] = tmp;
				break;
			}
			
			if(map[x][y]==0) {
				map[x][y] = die[6];
			}
			else {
				die[6] = map[x][y];
				map[x][y]=0;
			}
			System.out.println(die[1]);
		}
	}
}