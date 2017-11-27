import java.awt.Point;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static int find(int[][] map, boolean[] v, Point start, int x, int y, int cnt, int curve) {
		int n = map.length-1;
		
		if(cnt!=0 && start.x==x && start.y==y)
			return cnt;
		
		if(v[map[x][y]])
			return -1;
		
		cnt++;
		boolean[] visit = Arrays.copyOf(v, v.length);
		visit[map[x][y]]=true;
		
		// 대각선 좌우위아래 체크 가능 확인 후 호출
		int temp=-1;
		
		if(curve==1) {
			if((x+1<=n && y+1<=n) && !visit[map[x+1][y+1]])
				temp = Math.max(temp, find(map, visit, start, x+1, y+1, cnt, curve));
			if((x-1>=1 && y+1<=n) && !visit[map[x-1][y+1]])
				temp = Math.max(temp,find(map, visit, start, x-1, y+1, cnt, curve+1));
		}
		else if(curve==2) {
			if((x-1>=1 && y+1<=n) && !visit[map[x-1][y+1]])
				temp = Math.max(temp, find(map, visit, start, x-1, y+1, cnt, curve));
			if((x-1>=1 && y-1>=1) && !visit[map[x-1][y-1]])
				temp = Math.max(temp,find(map, visit, start, x-1, y-1, cnt, curve+1));
		}
		else if(curve==3) {
			if((x-1>=1 && y-1>=1) && !visit[map[x-1][y-1]])
				temp = Math.max(temp,find(map, visit, start, x-1, y-1, cnt, curve));
			if((x+1<=n && y-1>=1) && (x+1==start.x && y-1==start.y))
				temp = Math.max(temp,find(map, visit, start, x+1, y-1, cnt, curve+1));
			if((x+1<=n && y-1>=1) && !visit[map[x+1][y-1]])
				temp = Math.max(temp,find(map, visit, start, x+1, y-1, cnt, curve+1));
		}
		else if(curve==4) {
			if((x+1<=n && y-1>=1) && (x+1==start.x && y-1==start.y))
				temp = Math.max(temp,find(map, visit, start, x+1, y-1, cnt, curve));
			if((x+1<=n && y-1>=1) && !visit[map[x+1][y-1]])
				temp = Math.max(temp,find(map, visit, start, x+1, y-1, cnt, curve));
		}
		return temp;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=0; t<T; t++) {
			int Answer=-1;
			
			int N = sc.nextInt();
			
			int[][] map = new int[N+1][N+1];
			
			for(int i=1; i<=N; i++)
				for(int j=1; j<=N; j++)
					map[i][j] = sc.nextInt();
			
			boolean[] visit = new boolean[101];
			
			Arrays.fill(visit, false);
			
			for(int i=2; i<=N-1; i++) {
				for(int j=1; j<=N-2; j++) {
					Point start = new Point(i,j);
					Answer=Math.max(Answer, find(map, visit, start, i,j, 0, 1));
				}
			}
			
			System.out.println("#"+(t+1)+" "+Answer);
		}
	}
}
