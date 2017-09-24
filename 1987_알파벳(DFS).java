/*
	문제: 알파벳(1987)
	접근법 : DFS
*/
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int Answer;
	
	static int find(int x, int y, int moveCnt, int[][] map, boolean[] visit) {
		boolean[] v = Arrays.copyOf(visit, visit.length);
		v[map[x][y]]=true;
		
		int move=0;
		
		if(x-1>0 && !v[map[x-1][y]])
			move+=find(x-1, y, moveCnt+1, map, v);
		if(x+1 <map.length && !v[map[x+1][y]])
			move+=find(x+1, y, moveCnt+1, map, v);
		if(y-1 >0 && !v[map[x][y-1]])
			move+=find(x, y-1, moveCnt+1, map, v);
		if(y+1 < map[0].length && !v[map[x][y+1]])
			move+=find(x, y+1, moveCnt+1, map, v);
		
		if(move==0) {
			if(Answer < moveCnt)
				Answer=moveCnt;
			return 1;
		}
		else
			return move;
	}
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);

		Answer=0;
		int R= sc.nextInt();
		int C= sc.nextInt();
		sc.nextLine();

		int[][] map = new int[R+1][C+1];
		boolean[] visit = new boolean[27];
		Arrays.fill(visit, false);
		
		for(int i=0; i<R; i++) {
			String temp = sc.nextLine();
			for(int j=0; j<C; j++) {
				map[i+1][j+1] = temp.charAt(j)-64;
			}
		}
		find(1,1,1,map,visit);
		System.out.println(Answer);
	}
}
