
/*
 * 문제 : 1249. [S/W 문제해결 응용] 4일차
 * 유형 : 다익스트라(A노드에서 B노드까지 최단거리)
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
			
			// 시작점 거리는 0
			weight[0][0]=0;
			pq.add(new NextNode(0, 0, 0));
			
			while(!pq.isEmpty()) {
				
				NextNode nextNode=null;
				
				while(!pq.isEmpty()) {
					nextNode = pq.poll();
					
					// 방문한 적이 없는 노드 선택(선택된 노드는 누적 가중치가 가장 작은 노드)
					if(!visited[nextNode.i][nextNode.j]) {
						break;
					}
					else {
						nextNode=null;
					}
				}
				
				// 방문한 적 없는 노드가 없다면(모든 노드를 방문했다면) 종료
				if(nextNode==null) {
					break;
				}
				
				visited[nextNode.i][nextNode.j]=true;
				int nowI = nextNode.i;
				int nowJ = nextNode.j;
				int nowWeight = nextNode.weight;
				
				// 현 노드에서 이동 가능한 다음경로 경로(상하좌우)에 대해 
				for(int i=0; i<4; i++) {
					if(nowI+dx[i]>=0 && nowI+dx[i]<N && nowJ+dy[i]>=0 && nowJ+dy[i]<N) {
						// 기존 다음 경로에 대한 가중치보다 작다면 다음 노드 가중치 갱신
						if(weight[nowI+dx[i]][nowJ+dy[i]] > nowWeight + map[nowI+dx[i]][nowJ+dy[i]]) {
							weight[nowI+dx[i]][nowJ+dy[i]] = nowWeight + map[nowI+dx[i]][nowJ+dy[i]];
						}
						// 방문 가능했던 모든 노드는 pq에 push한다. 어차피 방문했던 곳이라면, 걸러져서 재 탐색 안되고, 상위에서 pop만 될 것임
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

