import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int map[][], noSandCnt[][];
	static int H, W;
	static int ans;
	static int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		Queue<Point> q;
		
		for(int test_case=1; test_case<=tc; test_case++) {
			q = new LinkedList<>();
			H = sc.nextInt();
			W = sc.nextInt();
			String input;
			map = new int[H][W];
			noSandCnt = new int[H][W];
			ans=0;
			
			sc.nextLine();

			// 입력받기, .인 경우 0으로 그대로 놔둠
			for(int i=0; i<H; i++) {
				input = sc.nextLine();
				for(int j=0; j<W; j++) {
					if(input.charAt(j)!='.') {
						map[i][j] = input.charAt(j)-48;
					}
				}
			}
			
			int x=0,y=0;
			for(int i=1; i<H-1; i++ ) {
				for(int j=1; j<W-1; j++) {
					if(map[i][j]!=0) {
						// 8방면 0 갯수 확인
						for(int k=0; k<8; k++) {
							x=dx[k];
							y=dy[k];
							if(map[i+x][j+y]==0)
								noSandCnt[i][j]++;
						}
						// 0갯수 >= 모래높이 경우
						// 큐에 해당 지점 add
						if(noSandCnt[i][j]>=map[i][j]) {
							q.add(new Point(i,j));
						}
					}
				}
			}
			
			int i=0, j=0;
			// 파도로 인한 주변 좌표의 0갯수 영향을 준 후,
			// 주변 좌표들의 변화가 더이상 없다면 종료.
			while(!q.isEmpty()) {
				for(int cnt=q.size(); cnt>0; cnt--) {
					i=q.peek().x;
					j=q.peek().y;
					q.poll();
					map[i][j]=0;
					for(int k=0; k<8; k++) {
						x=dx[k];
						y=dy[k];
						if(map[i+x][j+y]!=0) {
							noSandCnt[i+x][j+y]++;
							// noSandCnt[i][j]>map[i][j] 경우는 있을 수 없다
							// 위 경우는 처음에 확인 후 add하여 반영 하였고, 이후에 해당 좌표를 0으로 변경하였기 때문
							// 따라서 noSandCnt[i][j]<map[i][j] 인 경우만 남게되고, 파도 횟수에 따라 noSandCnt가 증가하면서 
							// noSandCnt[i][j]==map[i][j]인 경우에 도달하게 된다.
							if(map[i+x][j+y]==noSandCnt[i+x][j+y]) {
								// 해당 지점에 대해 중복 확인 될 수 있기 때문에 해당 좌표를 0으로 만들어, 더는확인 할 일이 없도록 한다.
								map[i+x][j+y]=0;
								q.add(new Point(i+x, j+y));
							}
						}
					}
				}
				ans++;
			}
			
			System.out.println("#"+test_case+" "+ans);
		}
	}
}