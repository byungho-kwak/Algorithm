import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();	// 가로
		int N = sc.nextInt();	// 세로
		
		int[][] map = new int[N+1][M+1];
		Queue<Point> q = new LinkedList<>();
		
		boolean ripeAll = false;
		boolean empty = true;
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==1)
					q.add(new Point(i,j));
				if(map[i][j]==0)
					ripeAll = false;
				if(map[i][j]!=-1)
					empty=false;
			}
		}
		if(ripeAll) {
			System.out.println(0);
			return;
		}
		if(empty) {
			System.out.println(-1);
			return;
		}
		Point temp;
		int size=0;
		int day=-1;
		while(!q.isEmpty()) {
			size=q.size();
			for(int i=1; i<=size; i++) {
				temp=q.poll();
				if(temp.x-1>=1 && map[temp.x-1][temp.y]==0){
					map[temp.x-1][temp.y]=1;
					q.add(new Point(temp.x-1, temp.y));
				}
				if(temp.x+1<=N && map[temp.x+1][temp.y]==0){
					map[temp.x+1][temp.y]=1;
					q.add(new Point(temp.x+1, temp.y));
				}
				if(temp.y-1>=1 && map[temp.x][temp.y-1]==0){
					map[temp.x][temp.y-1]=1;
					q.add(new Point(temp.x, temp.y-1));
				}
				if(temp.y+1<=M && map[temp.x][temp.y+1]==0){
					map[temp.x][temp.y+1]=1;
					q.add(new Point(temp.x, temp.y+1));
				}
			}
			day++;
		}
		
		boolean ripe=true;
		// while 나와서 전체 1 됐는지 확인 해야함
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++)
				if(map[i][j]==0)
					ripe=false;
		}
		
		if(ripe)
			System.out.println(day);
		else
			System.out.println(-1);
	}
}
