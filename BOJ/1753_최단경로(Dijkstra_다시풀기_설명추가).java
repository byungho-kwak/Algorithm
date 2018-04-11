import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static final int INF = 200000000;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		for(int t=1; t<=1; t++) {
			
			int V = sc.nextInt();
			int E = sc.nextInt();
			int start = sc.nextInt()-1;
			
			ArrayList<nodeInfo>[] adj = new ArrayList[V];
			PriorityQueue<nodeInfo> pq = new PriorityQueue<>();
			for(int i=0; i<V; i++)
				adj[i] = new ArrayList<>();
			
			int[] dis = new int [V];
			boolean[] visit = new boolean[V];
			boolean[] pqPushCheck = new boolean[V];
			
			
			for(int e=0; e<E; e++) {
				int vertexA = sc.nextInt()-1;
				int vertexB = sc.nextInt()-1;
				int weight = sc.nextInt();
				adj[vertexA].add(new nodeInfo(vertexB, weight));
			}

			
			Arrays.fill(visit, false);
			Arrays.fill(dis, INF);
			dis[start] = 0;
			pq.add(new nodeInfo(start, 0));
			
			while(!pq.isEmpty()) {
				
				// 핵심부분 시작
				// 2) 가지치기 한 노드들이 누적 가중치에 따라 오름차순 정렬 되어있고,
				//  방문 했던 노드들은 skip 하고, 누적 가중치 낮은 것 중 방문하지 않은 노드 선택
				int vertexA = -1;
				while(!pq.isEmpty()) {
					if(visit[pq.peek().node])
						pq.poll();
					else {
						vertexA = pq.peek().node;
						break;
					}
				}
				// 누적 가중치 낮은 것 중 방문하지 않은 노드가 없다면(선택되지 않았다면) 모든 노드 방문 한 것이므로, 루프 탈출
				if(vertexA==-1)
					break;
				// 핵심부분 끝
				
				int minCost = INF;
				visit[vertexA] = true;
				
				for(int j=0; j<adj[vertexA].size(); j++){
					int vertexB = adj[vertexA].get(j).node;
					int weight = adj[vertexA].get(j).dis;
					if(dis[vertexB] > dis[vertexA] + weight) {
						dis[vertexB] = dis[vertexA] + weight;
					}
					// 1) 한 노드에서 접근 가능한 노드 전부 다 큐에 넣고
					pq.add(new nodeInfo(vertexB, dis[vertexB]));
				}
			}

			for(int i=0; i<V; i++) {
				if(dis[i]==INF)
					System.out.println("INF");
				else
					System.out.println(dis[i]);
			}
		}
	}
}

class nodeInfo implements Comparable<nodeInfo>{

	int node;
	int dis;
	
	nodeInfo(int node, int dis) {
		this.node = node;
		this.dis = dis;
	}
	
	@Override
	public int compareTo(nodeInfo o) {
		return this.dis > o.dis? 1 : (this.dis<o.dis? -1 : 0);
	}
}