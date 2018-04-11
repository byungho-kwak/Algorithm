import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static LinkedList<Integer> list;
	static int[][] map;
	static int[] dx = {0,-1,0,1}, dy = {-1,0,1,0};
	
	public static void main(String... msg) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int x=1; x<=tc; x++) {
			list = new LinkedList<>();
			map = new int[4][4];
			
			for(int i=0; i<4; i++)
				for(int j=0; j<4; j++)
					map[i][j] = sc.nextInt();
			
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					dfs(i,j,0, map[i][j]);
				}
			}
			System.out.println("#"+x+" "+list.size());
		}
	}
	static void dfs(int x, int y, int cnt, int res) {
		if(cnt==6) {
			// List 내 res 존재 유무 확인
            if(!list.contains(res)) {
                list.add(res);
            }
            return;
		}
		for(int i=0; i<4; i++) {
			if(x+dx[i]<0 || x+dx[i]>=4 || y+dy[i]<0 || y+dy[i]>=4)
				continue;
			dfs(x+dx[i],y+dy[i], cnt+1, res*10 + map[x+dx[i]][y+dy[i]]);
		}
	}
}