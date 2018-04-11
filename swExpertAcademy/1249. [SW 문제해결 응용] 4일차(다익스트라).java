
/*
 * ���� : 1249. [S/W �����ذ� ����] 4����
 * ���� : ���ͽ�Ʈ��(A��忡�� B������ �ִܰŸ�)
 */

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int[][] map, weight;
	static boolean[][] visited;
	static final int INF = 299999999;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			map = new int[N][N];
			weight = new int[N][N];
			visited = new boolean[N][N];
			
			PriorityQueue<NextNode> pq = new PriorityQueue<>();
			
			sc.nextLine();
			for(int i=0; i<N; i++) {
				String arr = sc.nextLine();
				for(int j=0; j<N; j++) {
					map[i][j] = arr.charAt(j)-48;
					visited[i][j]=false;
					weight[i][j]=INF;
				}
			}
			
			// ������ �Ÿ��� 0
			weight[0][0]=0;
			pq.add(new NextNode(0, 0, 0));
			
			while(!pq.isEmpty()) {
				
				NextNode nextNode=null;
				
				while(!pq.isEmpty()) {
					nextNode = pq.poll();
					
					// �湮�� ���� ���� ��� ����(���õ� ���� ���� ����ġ�� ���� ���� ���)
					if(!visited[nextNode.i][nextNode.j]) {
						break;
					}
					else {
						nextNode=null;
					}
				}
				
				// �湮�� �� ���� ��尡 ���ٸ�(��� ��带 �湮�ߴٸ�) ����
				if(nextNode==null) {
					break;
				}
				
				visited[nextNode.i][nextNode.j]=true;
				int nowI = nextNode.i;
				int nowJ = nextNode.j;
				int nowWeight = nextNode.weight;
				
				// �� ��忡�� �̵� ������ ������� ���(�����¿�)�� ���� 
				for(int i=0; i<4; i++) {
					if(nowI+dx[i]>=0 && nowI+dx[i]<N && nowJ+dy[i]>=0 && nowJ+dy[i]<N) {
						// ���� ���� ��ο� ���� ����ġ���� �۴ٸ� ���� ��� ����ġ ����
						if(weight[nowI+dx[i]][nowJ+dy[i]] > nowWeight + map[nowI+dx[i]][nowJ+dy[i]]) {
							weight[nowI+dx[i]][nowJ+dy[i]] = nowWeight + map[nowI+dx[i]][nowJ+dy[i]];
						}
						// �湮 �����ߴ� ��� ���� pq�� push�Ѵ�. ������ �湮�ߴ� ���̶��, �ɷ����� �� Ž�� �ȵǰ�, �������� pop�� �� ����
						pq.add(new NextNode(nowI+dx[i], nowJ+dy[i], weight[nowI+dx[i]][nowJ+dy[i]]));
					}
				}
			}
			System.out.println("#"+t+" "+weight[N-1][N-1]);
		}
	}
}

class NextNode implements Comparable<NextNode> {

	int i;
	int j;
	int weight;
	
	public NextNode(int vertexB_i, int vertexB_j, int weight) {
		this.i = vertexB_i;
		this.j = vertexB_j;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(NextNode o) {
		
		return weight>o.weight ? 1 : -1;
	}
}

