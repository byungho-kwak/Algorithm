/*
 * ���� : 1824. �������� ���α׷� ����
 * ���� : DFS(stack Ȱ��) + �湮���� Ȯ�� 3���� �迭 ��� 
 */


import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int R, C;
	static char map[][];
	static boolean visited[][][];
	
	// ���� 
	// ������ : 0,  �Ʒ�:1,  ����:2. ��:3
	static int[] dx = {0,1,0,-1}, dy= {1,0,-1,0};
	static int x,y=0;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			x=0; y=0;
			Stack<Info> s = new Stack<>();
			R = sc.nextInt();
			C = sc.nextInt();
			map = new char[R][C];

			// �湮�ߴ� �� �ٽ� �湮���� �ʱ� ����
			// ���� ������� �ϴ��� ����(visited[][][4])�� �ٸ��� �湮 ������ �ٸ���
			visited = new boolean[R][C][4];
			sc.nextLine();
			for(int i=0; i<R; i++) {
				String tmp = sc.nextLine();
				for(int j=0; j<C; j++) {
					map[i][j] = tmp.charAt(j);
				}
			}
			
			boolean ans=false;
			int mem=0, direct=0, cnt=0;
			while(true) {
				visited[x][y][direct] = true;
				char signal = map[x][y];
				
				if(signal == '@') {
					ans=true;
					break;
				}
				
				if(!s.isEmpty() && cnt>400) {
					Info i = s.pop();
					cnt = i.cnt;
					x = i.x;
					y = i.y;
					direct = i.dir;
					mem = i.mem;
					continue;
				}
				
				if(s.isEmpty() && cnt>=400) {
					break;
				}
				else if(signal=='<' || signal == '>') {
					direct = signal=='<'? 2 : 0;
				} 
				else if(signal == '^' || signal == 'v') {
					direct = signal=='^'? 3 : 1;
				} 
				else if(signal == '_') {
					direct = mem==0 ? 0 : 2;
				} 
				else if(signal == '|') {
					direct = mem==0 ? 1 : 3;
				} 
				else if(signal == '?') {
					for(int i=0; i<4; i++) {
						if(direct!=i) {
							int tmpX = x+dx[i];
							int tmpY = y+dy[i];
							if(tmpX==-1) tmpX = R-1;
							else if(tmpX==R) tmpX = 0;
							else if(tmpY==-1) tmpY = C-1;
							else if(tmpY==C) tmpY = 0;
							if(!visited[tmpX][tmpY][i]) {
								s.push(new Info(cnt+1, x, y, i, mem));
								visited[tmpX][tmpY][i] = true;
							}
						}
					}
				} 
				else if(signal-48 >=0 && signal-48<=9) {
					mem =signal-48;
				} 
				else if(signal == '+') {
					mem+=1;
					if(mem==16) mem=0;
				}
				else if(signal == '-') {
					mem-=1;
					if(mem==-1) mem=15;
				} 
				move(direct);
				cnt++;
			}
			String result = ans==true ? "YES" : "NO";
			System.out.println("#"+t+" "+result);
		}
	}
	
	static void move(int dir) {
		x +=dx[dir];
		y +=dy[dir];
		if(x==-1) x = R-1;
		else if(x==R) x = 0;
		else if(y==-1) y = C-1;
		else if(y==C) y = 0;
	}
}

// '?'�� ��, 4���� ���� ������� ���� Ŭ���� (stack�� ����)
class Info {
	int cnt, x, y, dir, mem, signal;
	public Info(int cnt, int x, int y, int dir, int mem) {
		this.cnt = cnt;
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.mem = mem;
	}
}
