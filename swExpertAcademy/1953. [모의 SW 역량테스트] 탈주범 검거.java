import java.awt.Point;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int[][] map = new int[50][50];
	static int[][] visit = new int[50][50];
	static int ans;
	public static void main(String[] args){	
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int test=1; test<=tc; test++) {
			ans=1;
			int column = sc.nextInt();
			int row = sc.nextInt();
			
			Point startPoint = new Point(sc.nextInt(), sc.nextInt());
			int escapeTime = sc.nextInt();
			
			for(int i=0; i<column; i++) {
				for(int j=0; j<row; j++) {
					map[i][j] = sc.nextInt();
					visit[i][j]=0;
				}
			}
			
			visit[startPoint.x][startPoint.y]=1;
			
			checkConnect[] checkConnect = new checkConnect[8];
			checkConnect[1] = new checkConnect();
			for(int i=2; i<=7; i++) {
				checkConnect[i] = new checkConnect();
				checkConnect[i].Unused(i);
			}

			Queue<Point> q = new LinkedList<>();
			q.add(startPoint);
			int qSize=0;
			while(!q.isEmpty() && escapeTime>1) {
				qSize = q.size();
				while(qSize>0) {
					// up check
					if(q.peek().x-1>=0 && map[q.peek().x-1][q.peek().y]>0) {
						if(visit[q.peek().x-1][q.peek().y]==0) {
							for(int i=0; i<4; i++) {
								if(checkConnect[map[q.peek().x][q.peek().y]].up[i]==map[q.peek().x-1][q.peek().y]) {
									q.add(new Point(q.peek().x-1, q.peek().y));
									visit[q.peek().x-1][q.peek().y]=1;
									ans++;
									break;
								}
							}
						}
					}
					// down
					if(q.peek().x+1<column && map[q.peek().x+1][q.peek().y]>0) {
						if(visit[q.peek().x+1][q.peek().y]==0) {
							for(int i=0; i<4; i++) {
								if(checkConnect[map[q.peek().x][q.peek().y]].down[i]==map[q.peek().x+1][q.peek().y]) {
									q.add(new Point(q.peek().x+1, q.peek().y));
									visit[q.peek().x+1][q.peek().y]=1;
									ans++;
									break;
								}
							}
						}
					}
					// left
					if(q.peek().y-1>=0 && map[q.peek().x][q.peek().y-1]>0) {
						if(visit[q.peek().x][q.peek().y-1]==0) {
							for(int i=0; i<4; i++) {
								if(checkConnect[map[q.peek().x][q.peek().y]].left[i]==map[q.peek().x][q.peek().y-1]) {
									q.add(new Point(q.peek().x, q.peek().y-1));
									visit[q.peek().x][q.peek().y-1]=1;
									ans++;
									break;
								}
							}
						}
					}
					// right
					if(q.peek().y+1<row && map[q.peek().x][q.peek().y+1]>0) {
						if(visit[q.peek().x][q.peek().y+1]==0) {
							for(int i=0; i<4; i++) {
								if(checkConnect[map[q.peek().x][q.peek().y]].right[i]==map[q.peek().x][q.peek().y+1]) {
									q.add(new Point(q.peek().x, q.peek().y+1));
									visit[q.peek().x][q.peek().y+1]=1;
									ans++;
									break;
								}
							}
						}
					}
					q.poll();
					qSize--;
				}
				escapeTime--;
			}
			
			System.out.println("#"+test+" "+ans);
		}
	}
}

class checkConnect {
	int[] up = new int[4];
	int[] down = new int[4];
	int[] right = new int[4];
	int[] left = new int[4];
	
	checkConnect() {
		up[0] = 1; up[1] = 2; up[2] = 5; up[3] = 6;
		down[0] = 1; down[1] = 2; down[2] = 4; down[3] = 7;
		right[0] = 1; right[1] = 3; right[2] = 6; right[3] = 7;
		left[0] = 1; left[1] = 3; left[2] = 4; left[3] = 5;
	}
	
	void Unused(int pipe) {
		switch (pipe) {
		case 2:
			Arrays.fill(right, -1);
			Arrays.fill(left, -1);
			break;
		case 3:
			Arrays.fill(up, -1);
			Arrays.fill(down, -1);
			break;
		case 4:
			Arrays.fill(left, -1);
			Arrays.fill(down, -1);
			break;
		case 5:
			Arrays.fill(up, -1);
			Arrays.fill(left, -1);
			break;
		case 6:
			Arrays.fill(up, -1);
			Arrays.fill(right, -1);
			break;
		case 7:
			Arrays.fill(right, -1);
			Arrays.fill(down, -1);
			break;
		}
	}
}


