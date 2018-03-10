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

			// �Է¹ޱ�, .�� ��� 0���� �״�� ����
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
						// 8��� 0 ���� Ȯ��
						for(int k=0; k<8; k++) {
							x=dx[k];
							y=dy[k];
							if(map[i+x][j+y]==0)
								noSandCnt[i][j]++;
						}
						// 0���� >= �𷡳��� ���
						// ť�� �ش� ���� add
						if(noSandCnt[i][j]>=map[i][j]) {
							q.add(new Point(i,j));
						}
					}
				}
			}
			
			int i=0, j=0;
			// �ĵ��� ���� �ֺ� ��ǥ�� 0���� ������ �� ��,
			// �ֺ� ��ǥ���� ��ȭ�� ���̻� ���ٸ� ����.
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
							// noSandCnt[i][j]>map[i][j] ���� ���� �� ����
							// �� ���� ó���� Ȯ�� �� add�Ͽ� �ݿ� �Ͽ���, ���Ŀ� �ش� ��ǥ�� 0���� �����Ͽ��� ����
							// ���� noSandCnt[i][j]<map[i][j] �� ��츸 ���Եǰ�, �ĵ� Ƚ���� ���� noSandCnt�� �����ϸ鼭 
							// noSandCnt[i][j]==map[i][j]�� ��쿡 �����ϰ� �ȴ�.
							if(map[i+x][j+y]==noSandCnt[i+x][j+y]) {
								// �ش� ������ ���� �ߺ� Ȯ�� �� �� �ֱ� ������ �ش� ��ǥ�� 0���� �����, ����Ȯ�� �� ���� ������ �Ѵ�.
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